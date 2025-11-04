package org.carpenoctemcloud.redirect_files;

public class MacRedirectFileCreator implements RedirectFileCreator {
    /**
     * Creates the content of a file to redirect towards the resource at the url.
     *
     * @param url The url to redirect the user to.
     * @return The contents of the file in a string.
     */
    @Override
    public String createFileContent(String url) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"https://www.apple.com/DTDs/PropertyList-1.0.dtd\"><plist version=\"1.0\"><dict><key>URL</key><string>" +
                url + "</string></dict></plist>";
    }

    /**
     * Used to create the right extension of the file.
     *
     * @return The extension of the file with the dot. So for example ".url" or ".docx".
     */
    @Override
    public String getFileExtension() {
        return ".webloc";
    }
}
