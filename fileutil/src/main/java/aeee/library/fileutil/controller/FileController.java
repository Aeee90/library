package aeee.library.fileutil.controller;

import aeee.library.fileutil.service.FileService;
import aeee.library.fileutil.util.FolderType;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class FileController {

    private FileService fileService;
    FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(value = "/image/{idx}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte []  getImage(
            @PathVariable("idx") Long idx
    ) throws IOException {
        File file = fileService.getImage(idx);
        if(file != null) return IOUtils.toByteArray(new FileInputStream(file));
        else return null;
    }

    @PostMapping(value = "/image")
    public String addImage(MultipartFile file) {
        return "/image/" + fileService.addFile(FolderType.Article, file);
    }
}
