package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.FileUpload;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public List<FileUpload> getFileListByUserId(Integer userId) {
        return fileMapper.getFileListByUserId(userId);
    }
    public void uploadFile(FileUpload file) {
        fileMapper.uploadFile(file);
    }

    public void deleteFileByFileId(Integer fileId) {
        fileMapper.deleteFileByFileId(fileId);
    }
}
