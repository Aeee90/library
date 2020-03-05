package aeee.library.fileutil.util.file;

import java.nio.file.Path;

interface FolderConfiguration {
    int getFolderCountMax(int depth);
    boolean isFolder(int depth);
    Path getRoot();
}
