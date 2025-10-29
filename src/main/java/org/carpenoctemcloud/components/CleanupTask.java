package org.carpenoctemcloud.components;

import java.sql.Timestamp;
import java.time.Instant;
import org.carpenoctemcloud.remoteFile.RemoteFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static org.carpenoctemcloud.configuration.ConfigurationConstants.CLEANUP_RATE_IN_HOURS;
import static org.carpenoctemcloud.configuration.ConfigurationConstants.MAX_AGE_CACHE_IN_DAYS;

/**
 * The Purpose of this class is to clean up old indexed files which haven't been found in the past few days.
 */
@Component
public class CleanupTask {
    private final RemoteFileService fileService;
    Logger logger = LoggerFactory.getLogger(CleanupTask.class);

    /**
     * Constructor of the CleanupTask. It requires the RemoteFileService to delete old files.
     *
     * @param fileService The RemoteFileService which will be able to delete old files.
     */
    public CleanupTask(RemoteFileService fileService) {
        this.fileService = fileService;
    }

    /**
     * Deletes old files periodically.
     */
    @Scheduled(fixedDelay = CLEANUP_RATE_IN_HOURS * 60 * 60 * 1000)
    public void cleanupOldFiles() {
        logger.info("Started cleanup of old files.");
        Timestamp cutOff =
                Timestamp.from(Instant.now().minusSeconds(MAX_AGE_CACHE_IN_DAYS * 24 * 60 * 60));
        int deleteCount = fileService.deleteOldRemoteFiles(cutOff);
        logger.info("Finished cleaning up the old files. Deleted {} files.", deleteCount);
    }
}
