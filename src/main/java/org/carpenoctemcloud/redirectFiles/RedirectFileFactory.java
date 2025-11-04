package org.carpenoctemcloud.redirectFiles;

public class RedirectFileFactory {
    public static RedirectFileCreator getFileCreator(RedirectFilePlatform platform) {
        switch (platform) {
            case MAC -> {
                return new MacRedirectFileCreator();
            }
            case WINDOWS -> {
                return new WindowsRedirectFileCreator();
            }
            default -> throw new IllegalStateException("Unexpected value: " + platform);
        }
    }
}
