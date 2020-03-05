package aeee.library.fileutil.util.file;

public class SpringFileUtilConfigurationSpringAdaptor implements FileUtilConfiguration {

    private FileStorageManagerImpl fileStorageManagerImpl;

    SpringFileUtilConfigurationSpringAdaptor(FileStorageManagerImpl fileStorageManagerImpl){
        this.fileStorageManagerImpl = fileStorageManagerImpl;
    }

    public SpringFileUtilConfigurationSpringAdaptor(){
        this.fileStorageManagerImpl = new FileStorageManagerImpl();
    }

    @Override
    public FileStorageManagerConfiguration configuration() {
        return configuration(fileStorageManagerImpl);
    }

    @Override
    public FileStorageManagerConfiguration configuration(FileStorageManagerConfiguration fileStorageManagerConfiguration) {
        return fileStorageManagerConfiguration;
    }
}
