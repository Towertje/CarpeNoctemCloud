package org.carpenoctemcloud.remoteFile;

import java.sql.Timestamp;


/**
 * The RemoteFile is an entry in the database which contains an indexed reference to a file on a server.
 *
 * @param id          The primary key of the RemoteFile.
 * @param name        The name of the indexed file without its full path.
 * @param downloadURL The url to the file on the remote server.
 * @param lastIndexed The time at which it was indexed last.
 */
public record RemoteFile(Long id, String name, String downloadURL, Timestamp lastIndexed) {

}
