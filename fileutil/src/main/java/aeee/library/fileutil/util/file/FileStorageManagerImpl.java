package aeee.library.fileutil.util.file;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

class FileStorageManagerImpl implements FileStorageManager, FileStorageManagerConfiguration{

    private final Map<FolderType, PathCounterFacade> folderCountMap = new HashMap<>();
    private Path root;

    @Override
    public FileStorageManagerConfiguration addFolderProperty(FolderProperty folderProperty) {
        folderCountMap.put(folderProperty.getFolderType(), new RootCounterImpl(new ArrayFolderConfiguration(folderProperty)));
        return this;
    }

    @Override
    public FileStorageManagerConfiguration setRoot(Path root) {
        this.root = root;
        return this;
    }

    @Override
    public Path getRootPath() {
        return root;
    }

    @Override
    public Path getFolderPath(FolderType folderType){
        return folderCountMap.get(folderType).getFilePath();
    }

}
