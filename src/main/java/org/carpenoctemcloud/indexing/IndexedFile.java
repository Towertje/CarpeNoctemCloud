package org.carpenoctemcloud.indexing;

/**
 * Representation of a file which was indexed.
 *
 * @param filename The name of the file which was found.
 *                 If the file was in server/films/movie.mkv the name will just be movie.mkv.
 * @param url      The url to the server on which the film was found so that it can be downloaded.
 */
public record IndexedFile(String filename, String url) {
}
