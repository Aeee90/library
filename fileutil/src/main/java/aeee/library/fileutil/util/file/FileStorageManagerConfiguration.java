package aeee.library.fileutil.util.file;

import java.nio.file.Path;

public interface FileStorageManagerConfiguration {

    FileStorageManagerConfiguration setRoot(Path root);
    FileStorageManagerConfiguration addFolderProperty(FolderProperty folderProperty);

}
