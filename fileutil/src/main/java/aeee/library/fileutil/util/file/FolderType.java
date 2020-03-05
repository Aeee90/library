package aeee.library.fileutil.util.file;

public interface FolderType {
    String getFolderName();

    class FolderTypeImpl implements FolderType{

        private final String folderName;

        FolderTypeImpl(String folderName) {
            this.folderName = folderName;
        }

        @Override
        public String getFolderName() {
            return folderName;
        }
    }
}
