package aeee.library.fileutil.util;

import java.nio.file.Path;

public interface FileStorageManager {

    Path getRootPath();
    Path getFolderPath(FolderType folderType);
}
