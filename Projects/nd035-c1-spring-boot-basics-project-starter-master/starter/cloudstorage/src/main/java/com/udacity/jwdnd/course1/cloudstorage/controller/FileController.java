package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.FileUpload;
import com.udacity.jwdnd.course1.cloudstorage.security.token.SuperDuperDriveToken;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {
    private FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(Model model, MultipartFile fileUpload, Authentication authentication) {
        SuperDuperDriveToken token = (SuperDuperDriveToken) authentication;

        //upload file
        if (!fileUpload.isEmpty()) {
            try {
                FileUpload file = new FileUpload(null, fileUpload.getOriginalFilename(), fileUpload.getContentType(),
                        String.valueOf(fileUpload.getSize()), ((SuperDuperDriveToken) authentication).getUserId(), fileUpload.getBytes());
                fileService.uploadFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //get file list
        List<FileUpload> fileUploadList = fileService.getFileListByUserId(token.getUserId());
        model.addAttribute("fileUploadList", fileUploadList);

        return "redirect:/home";
    }

    @PostMapping("/download")
    public String downloadFile(Authentication authentication, FileUpload fileUpload) {
        SuperDuperDriveToken token = (SuperDuperDriveToken) authentication;

        return "home";
    }

    @PostMapping("/deleteFile")
    public String deleteFile(Model model, Authentication authentication, FileUpload fileUpload) {
        SuperDuperDriveToken token = (SuperDuperDriveToken) authentication;

        //delete file
        fileService.deleteFileByFileId(fileUpload.getFileId());

        //get file list
        List<FileUpload> fileUploadList = fileService.getFileListByUserId(token.getUserId());
        model.addAttribute("fileUploadList", fileUploadList);

        return "home";
    }
}
