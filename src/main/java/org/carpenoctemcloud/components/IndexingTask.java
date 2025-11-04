package org.carpenoctemcloud.components;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import org.carpenoctemcloud.indexing.IndexingListener;
import org.carpenoctemcloud.indexing.IndexingListenerImpl;
import org.carpenoctemcloud.indexing.ServerIndexer;
import org.carpenoctemcloud.indexing.ServerIndexerSMB;
import org.carpenoctemcloud.remote_file.RemoteFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DurationFormat;
import org.springframework.format.datetime.standard.DurationFormatterUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Class which embodies the indexing task.
 * It runs periodically to make sure the database is up to date.
 */
@Component
public class IndexingTask {
    private final Logger logger = LoggerFactory.getLogger(IndexingTask.class);

    private final RemoteFileService remoteFileService;

    /**
     * Constructor for the indexing task, Requires remoteFileService to save the indexed files.
     *
     * @param remoteFileService The remoteFileService handling db requests.
     */
    public IndexingTask(RemoteFileService remoteFileService) {
        this.remoteFileService = remoteFileService;
    }


    /**
     * Indexes all the servers every so often to keep the cache up to date.
     */
    @Scheduled(cron = "0 0 3 */2 * *")
    public void indexAllServers() {
        IndexingListener listener = new IndexingListenerImpl(remoteFileService);

        String[] smbServers = {"spitfire.student.utwente.nl", "stroopwafel.student.utwente.nl",
                "univac.student.utwente.nl", "campuslaan53.student.utwente.nl"};

        Timestamp startTime = Timestamp.from(Instant.now());

        for (String smbServer : smbServers) {
            logger.info("Indexing SMB server: \"{}\".", smbServer);
            ServerIndexer indexer = new ServerIndexerSMB(smbServer);
            indexer.indexServer(listener);
            logger.info("Finished indexing the SMB server: \"{}\"", smbServer);
        }

        Timestamp endTime = Timestamp.from(Instant.now());
        Duration duration =
                Duration.between(startTime.toLocalDateTime(), endTime.toLocalDateTime());
        String durationFormatted =
                DurationFormatterUtils.print(duration, DurationFormat.Style.COMPOSITE);
        logger.info("Finished indexing in {}.", durationFormatted);
    }
}
