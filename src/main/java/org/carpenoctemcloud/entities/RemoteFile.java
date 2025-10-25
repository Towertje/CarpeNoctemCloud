package org.carpenoctemcloud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.sql.Timestamp;

@Entity
public class RemoteFile {
    @Column(nullable = false, length = 512)
    private String name;

    @Column(unique = true, nullable = false, length = 2048)
    private String downloadURL;

    @Column(nullable = false)
    private Timestamp lastIndexed;

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 4018)
    private String searchText;

    public RemoteFile(String name, String downloadURL, Timestamp lastIndexed) {
        this.name = name;
        this.downloadURL = downloadURL;
        this.lastIndexed = lastIndexed;
    }

    public RemoteFile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public Timestamp getLastIndexed() {
        return lastIndexed;
    }

    public void setLastIndexed(Timestamp lastIndexed) {
        this.lastIndexed = lastIndexed;
    }

    public Long getId() {
        return id;
    }
}
