package aeee.library.fileutil.util.file;

import java.nio.file.Path;

public interface FileStorageManager{

    Path getRootPath();
    Path getFolderPath(FolderType folderType);
}
