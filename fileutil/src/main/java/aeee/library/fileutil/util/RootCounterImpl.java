package aeee.library.fileutil.util;

import java.nio.file.Path;

class RootCounterImpl implements PathCounterFacade {

    private Path root;
    private PathCounter child;
    private boolean isNotInitialize = true;

    public RootCounterImpl(FolderConfiguration folderConfiguration) {
        init(folderConfiguration);
    }

    @Override
    public void init(FolderConfiguration folderConfiguration) {
        root = folderConfiguration.getRoot();
        int depth = 0;
        if(folderConfiguration.isFolder(depth)) {
            FolderCounterImpl folderCounter = new FolderCounterImpl();
            child = folderCounter;
            folderCounter.init(folderConfiguration, depth);
        }else {
            child = new FileCounterImpl();
        }
        isNotInitialize= false;
    }

    @Override
    public Path getFilePath() {
        assert !isNotInitialize;

        child.isFull();
        return root.resolve(child.getPath());
    }
}
