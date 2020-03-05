package aeee.library.fileutil.util.file;

import aeee.library.fileutil.config.FolderTypeImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
public class FileUtil {

    private static FileStorageManagerImpl fileStorageManager;

    private static FileStorageManager getFileStorageManager(){
        if(fileStorageManager == null) {
            ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
            FileUtilConfiguration fileUtilConfiguration = applicationContext.getBean(FileUtilConfiguration.class);

            fileStorageManager = new FileStorageManagerImpl();
            fileUtilConfiguration.configuration(fileStorageManager);
        }

        return fileStorageManager;
    }

    public static List<FileAttribute> write(FolderTypeImpl folderType, List<MultipartFile> files){
        return files.stream().map( file -> write(folderType, file)).collect(Collectors.toList());
    }

    public static FileAttribute write(FolderTypeImpl folderType, MultipartFile file){
        if(file == null) return FileAttribute.EMPTY;

        String originalName = file.getOriginalFilename();
        String hashName = generateStringHashName(file);

        Path rootPath = getFileStorageManager().getRootPath();
        Path localDirectoryPath = getFileStorageManager().getFolderPath(folderType);
        Path directoryPath = rootPath.resolve(localDirectoryPath);
        File directory = new File(directoryPath.toUri());
        if(!directory.exists()) directory.mkdirs();

        Path absolutePath =  directoryPath.resolve(Paths.get(hashName));

        try{
            if(write(new File(absolutePath.toUri()), file.getBytes()))
                return new FileAttribute(originalName, hashName, localDirectoryPath);
            else
                return FileAttribute.EMPTY;
        }catch(IOException e){
            return FileAttribute.EMPTY;
        }
    }

    private static boolean write(File file, byte [] data){
        if(file != null) {
            try(FileOutputStream fOut = new FileOutputStream(file)) {
                fOut.write(data);
                fOut.flush();
                return true;
            }catch(IOException e){
                return false;
            }
        }
        return false;
    }

    public static boolean delete(List<FileAttribute> fileAttributes) {
        return fileAttributes.stream().allMatch(FileUtil::delete);
    }

    public static boolean delete(FileAttribute fileAttribute){
        return delete(new File(fileAttribute.getStringPath()));
    }

    public static boolean delete(File file) {
        if(file.exists()) return file.delete();
        return false;
    }

    public static File getAbsolutePathFile(String directoryPath, String fileName) {
        return new File(getFileStorageManager().getRootPath().resolve(Paths.get(directoryPath, fileName)).toUri());
    }

    private static String generateStringHashName(MultipartFile file) {
        return generateHashName(file.getOriginalFilename());
    }
    private static Path generatePathHashName(MultipartFile file) {
        return Paths.get(generateStringHashName(file));
    }

    private static String generateHashName(String fileName) {
        return Math.abs(Objects.hashCode(Calendar.getInstance().getTimeInMillis() + getBaseName(fileName))) + "." + getExtension(fileName);
    }

    private static String getBaseName(String fileName) {
        int extensionIdx = getExtensionIndex(fileName);
        return extensionIdx < 0? null : fileName.substring(0, extensionIdx);
    }

    private static String getExtension(String fileName) {
        int extensionIdx = getExtensionIndex(fileName);
        return extensionIdx < 0? null : fileName.substring(extensionIdx + 1);
    }

    private static int getExtensionIndex(String fileName){
        return fileName.lastIndexOf(46);
    }
}
