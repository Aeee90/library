package aeee.library.fileutil.util;

import java.nio.file.Path;

interface PathCounterFacade {

    void init(FolderConfiguration folderConfiguration);
    Path getFilePath();
}
