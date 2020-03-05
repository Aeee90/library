package aeee.library.fileutil.util.file;

import java.nio.file.Path;
import java.util.Calendar;
import java.util.Objects;

interface PathComposite {
    static String getInitDate() {
        return String.valueOf(Math.abs(Objects.hashCode(Calendar.getInstance().getTimeInMillis())));
    }

    void init(FolderConfiguration folderConfiguration, int depth);

    boolean isFull();
    Path getPath();
}