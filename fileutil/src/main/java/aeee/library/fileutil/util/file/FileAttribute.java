package aeee.library.fileutil.util.file;

import java.nio.file.Path;
import java.util.Objects;

public class FileAttribute {

    public static final FileAttribute EMPTY = new FileAttribute("", "" , null);

    public final String originalName;
    public final String hashName;
    public final Path directoryPath;

    FileAttribute(String originalName, String hashName, Path directoryPath){
        this.originalName = originalName;
        this.hashName = hashName;
        this.directoryPath = directoryPath;
    }

    public Path getPath(){
        return directoryPath.resolve(hashName);
    }

    public String getStringPath(){
        return directoryPath.resolve(hashName).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileAttribute that = (FileAttribute) o;
        return Objects.equals(originalName, that.originalName) &&
                Objects.equals(hashName, that.hashName) &&
                Objects.equals(directoryPath, that.directoryPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalName, hashName, directoryPath);
    }

    @Override
    public String toString() {
        return "FileAttribute{" +
                "originalName='" + originalName + '\'' +
                ", hashName='" + hashName + '\'' +
                ", directoryPath=" + directoryPath +
                '}';
    }
}
