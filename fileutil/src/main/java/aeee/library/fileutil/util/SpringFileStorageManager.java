package aeee.library.fileutil.util;

import org.springframework.context.ApplicationContext;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

class SpringFileStorageManager implements FileStorageManager{

    private final Map<FolderType, PathCounterFacade> folderCountMap = new HashMap<>();

    public boolean isNotInitialize = true;

    private FolderProperties folderProperties;

    private void init(){
        if(isNotInitialize) {
            ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
            folderProperties = applicationContext.getBean(FolderProperties.class);


            for(FolderType folderType : FolderType.values()) {
                folderCountMap.put(folderType, new RootCounterImpl(new ArrayFolderConfiguration(folderProperties, folderType)));
            }

            isNotInitialize = false;
        }
    }

    @Override
    public Path getRootPath() {
        if(isNotInitialize)  init();

        return folderProperties.getRoot();
    }

    @Override
    public Path getFolderPath(FolderType folderType){
        if(isNotInitialize)  init();

        return folderCountMap.get(folderType).getFilePath();
    }

}
