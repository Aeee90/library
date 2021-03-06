package aeee.library.fileutil.util.file;

import java.nio.file.Path;

class FileCounterImpl implements PathComposite {

    private int maxCount;
    private int currentCount;

    @Override
    public void init(FolderConfiguration folderConfiguration, int depth) {
        maxCount = folderConfiguration.getFolderCountMax(depth);
        currentCount = 0;
    }

    @Override
    public boolean isFull() {
        if(currentCount >= maxCount) {
            currentCount = 0;
            return true;
        } else return false;
    }

    @Override
    public Path getPath() {
        currentCount++;
        return null;
    }
}
