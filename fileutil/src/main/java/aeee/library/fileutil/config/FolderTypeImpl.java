package aeee.library.fileutil.config;

import aeee.library.fileutil.util.file.FolderType;

public enum FolderTypeImpl implements FolderType {
    ARTICLE, REQUEST, PROFILE;

    @Override
    public String getFolderName() {
        return toString();
    }
}
