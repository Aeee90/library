package aeee.library.fileutil.util.file;

public class FolderProperties implements FolderProperty{

    private FolderType folderType;
    private int [] folderProperty;

    FolderProperties(String folderType, int [] folderProperty){
        this(new FolderType.FolderTypeImpl(folderType), folderProperty);
    }

    FolderProperties(FolderType folderType, int [] folderProperty){
        this.folderType = folderType;
        this.folderProperty = folderProperty;
    }

    public static FolderProperty of(String folderType, int [] folderProperty){
        return new FolderProperties(folderType, folderProperty);
    }

    public static FolderProperty of(FolderType folderType, int [] folderProperty){
        return new FolderProperties(folderType, folderProperty);
    }

    @Override
    public FolderType getFolderType() {
        return folderType;
    }

    @Override
    public int[] getProperty() {
        return folderProperty;
    }
}
