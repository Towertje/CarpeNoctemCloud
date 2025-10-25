package org.carpenoctemcloud.configuration;

public class ConfigurationConstants {
    /**
     * The amount of hours between each indexing attempt.
     */
    public static final int INDEXING_RATE_IN_HOURS = 48;

    /**
     * The amount of hours between each clean-up of the indexed/cached files.
     */
    public static final int CLEANUP_RATE_IN_HOURS = 12;

    /**
     * The time it should take for the cleanup task to delete this file as it is considered outdated.
     * This means that if a cleanup cycle is triggered, and the file hasn't been indexed in 4 days,
     * it will be deleted.
     */
    public static final int MAX_AGE_CACHE_IN_DAYS = 4;

    /**
     * Limits how many films can be queried at once.
     */
    public static final int MAX_FETCH_SIZE = 20;
}
