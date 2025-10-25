package org.carpenoctemcloud.services;

import jakarta.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import org.carpenoctemcloud.entities.RemoteFile;
import org.carpenoctemcloud.indexing.IndexedFile;
import org.carpenoctemcloud.repositories.RemoteFileRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RemoteFileService {
    private final RemoteFileRepository repository;

    public RemoteFileService(RemoteFileRepository repository) {
        this.repository = repository;
    }

    /**
     * Deletes old files from the cache.
     *
     * @param cutOff If the file is cached after the cut-off, it isn't deleted.
     *               If it is older, it gets removed.
     */
    public void deleteOldRemoteFiles(Timestamp cutOff) {
        repository.deleteAllByLastIndexedBefore(cutOff);
    }

    /**
     * Adds a file to the cache database.
     *
     * @param indexedFile The file to add to the database.
     */
    public void addRemoteFile(IndexedFile indexedFile) {
        RemoteFile probe = new RemoteFile();
        probe.setDownloadURL(indexedFile.url());
        Optional<RemoteFile> optFoundFile = repository.findOne(Example.of(probe));

        if (optFoundFile.isPresent()) {
            optFoundFile.get().setLastIndexed(Timestamp.from(Instant.now()));
            return;
        }

        RemoteFile entity = new RemoteFile(indexedFile.filename(), indexedFile.url(),
                                           Timestamp.from(Instant.now()));
        repository.save(entity);
    }
}
