package aeee.library.fileutil.util;

import java.nio.file.Path;

interface FolderConfiguration {
    int getFolderCountMax(int depth);
    boolean isFolder(int depth);
    Path getRoot();
}
