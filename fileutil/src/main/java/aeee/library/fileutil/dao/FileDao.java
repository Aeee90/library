package aeee.library.fileutil.dao;

import aeee.library.fileutil.util.file.FileAttribute;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FileDao {

    private Map<Long, FileAttribute> db = new HashMap<>();
    private Long generatedId = 0L;

    public FileAttribute get(Long idx) {
        return db.get(idx);
    }

    public Long save(FileAttribute fileAttribute) {
        Long idx = generatedId++;
        db.put(idx, fileAttribute);
        return idx;
    }
}
