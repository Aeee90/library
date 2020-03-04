package aeee.library.fileutil.util;

import java.nio.file.Path;
import java.nio.file.Paths;

class ArrayFolderConfiguration implements FolderConfiguration {

    private final int [] depths;
    private final Path root;

    ArrayFolderConfiguration(FolderProperties folderProperties, FolderType folderType) {
        this.depths = folderProperties.getProperty(folderType);
        this.root = Paths.get(folderType.toString());
    }

    @Override
    public int getFolderCountMax(int depth) {
        int len = depths.length;
        if(depth < 0 || depth >= len) return -1;
        else return depths[depth];
    }

    @Override
    public boolean isFolder(int depth) {
        return  0 <= depth && depth < depths.length - 1;
    }

    @Override
    public Path getRoot() {
        return root;
    }
}
