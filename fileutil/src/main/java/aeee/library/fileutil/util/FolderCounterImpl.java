package aeee.library.fileutil.util;

import java.nio.file.Path;
import java.nio.file.Paths;

class FolderCounterImpl implements FolderComposite, PathCounter {

    private String INIT_DATE_HASH;
    private boolean isNotInitialize = true;
    private PathCounter child;
    private int maxCount;
    private int currentCount;


    FolderCounterImpl() {
        INIT_DATE_HASH = PathCounter.getInitDate();
    }


    private void setMaxCount(int maxCount){
        if(isNotInitialize) this.maxCount = maxCount;
    }

    @Override
    public void init(FolderConfiguration folderConfiguration, int depth){
        maxCount = folderConfiguration.getFolderCountMax(depth);
        currentCount = 0;
        isNotInitialize = false;
        if(folderConfiguration.isFolder(depth + 1)) {
            FolderCounterImpl folderCounter = new FolderCounterImpl();
            child = folderCounter;
            folderCounter.init(folderConfiguration, depth + 1);
        }else {
            FileCounterImpl fileCounter = new FileCounterImpl();
            child = fileCounter;
            fileCounter.init(folderConfiguration, depth + 1);
        }
    }

    @Override
    public boolean isFull() {
        if(currentCount >= maxCount) {
            currentCount = 0;
            INIT_DATE_HASH = PathCounter.getInitDate();
            return true;
        } else return false;
    }

    @Override
    public final Path getPath(){
        Path childPath = child.getPath();
        Path currentPath = Paths.get(INIT_DATE_HASH + currentCount);

        if(child.isFull()) currentCount++;

        return childPath != null? currentPath.resolve(childPath) : currentPath;
    }
}

