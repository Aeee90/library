package aeee.library.fileutil.service;

import aeee.library.fileutil.dao.FileDao;
import aeee.library.fileutil.util.file.FileAttribute;
import aeee.library.fileutil.util.file.FileUtil;
import aeee.library.fileutil.config.FolderTypeImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileService {

    private FileDao fileDao;

    FileService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public File getImage(Long fileIdx) {
        FileAttribute fileAttribute = fileDao.get(fileIdx);
        if(fileAttribute == null) return null;
        else return FileUtil.getAbsolutePathFile(fileAttribute.directoryPath.toString(), fileAttribute.hashName);
    }

    public Long addFile(FolderTypeImpl folderType, MultipartFile file) {
        FileAttribute fileAttribute = FileUtil.write(folderType, file);
        return fileDao.save(fileAttribute);
    }
}
