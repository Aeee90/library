package aeee.library.fileutil.util.file;

import java.nio.file.Path;

interface PathCounterFacade {

    void init(FolderConfiguration folderConfiguration);
    Path getFilePath();
}
