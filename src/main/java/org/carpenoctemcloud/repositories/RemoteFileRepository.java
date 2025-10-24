package org.carpenoctemcloud.repositories;

import java.sql.Timestamp;
import org.carpenoctemcloud.entities.RemoteFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemoteFileRepository extends JpaRepository<RemoteFile, Long> {
    void deleteAllByLastIndexedBefore(Timestamp cutoff);
}
