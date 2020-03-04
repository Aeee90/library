package aeee.library.fileutil.util;

import java.nio.file.Path;
import java.util.Calendar;
import java.util.Objects;

interface PathCounter {

    static String getInitDate() {
        return String.valueOf(Math.abs(Objects.hashCode(Calendar.getInstance().getTimeInMillis())));
    }

    boolean isFull();
    Path getPath();
}
