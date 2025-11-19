package org.carpenoctemcloud.controllers;

import org.carpenoctemcloud.redirect_files.RedirectFileCreator;
import org.carpenoctemcloud.redirect_files.RedirectFileFactory;
import org.carpenoctemcloud.redirect_files.RedirectFilePlatform;
import org.carpenoctemcloud.remote_file.RemoteFile;
import org.carpenoctemcloud.remote_file.RemoteFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Collection of endpoints which handles sending a downloadable file to the client.
 * This downloadable file is what will redirect the client.
 */
@Controller
@SuppressWarnings("SameReturnValue")
@RequestMapping("/file")
public class FileInspectController {

    private final RemoteFileService fileService;

    /**
     * Creates a new controller instance.
     *
     * @param fileService The file service to query the files through.
     */
    public FileInspectController(RemoteFileService fileService) {
        this.fileService = fileService;
    }

    /**
     * The page where you can inspect/view a specific file.
     *
     * @param model The model of the Thymeleaf ssr.
     * @param id    The id of the RemoteFile.
     * @return The template of the fileInspectPage.
     */
    @GetMapping({"/{id}", "/{id}/"})
    public String fileInspectPage(Model model, @PathVariable int id) {
        Optional<RemoteFile> file = fileService.getRemoteFileByID(id);

        model.addAttribute("resultFile", file.get());

        return "fileInspectPage";
    }
}
