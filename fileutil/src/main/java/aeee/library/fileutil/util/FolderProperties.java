package aeee.library.fileutil.util;

import java.nio.file.Path;

interface FolderProperties {
    Path getRoot();
    int [] getProperty(FolderType folderType);
}
