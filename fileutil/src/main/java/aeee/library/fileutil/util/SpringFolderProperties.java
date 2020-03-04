package aeee.library.fileutil.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@ConfigurationProperties(prefix = "catch-k.file.tree")
class SpringFolderProperties implements FolderProperties{

    private String root;

    private int [] article;

    private int [] request;

    private int [] profile;

    @Override
    public Path getRoot() {
        return Paths.get(root);
    }

    @Override
    public int [] getProperty(FolderType folderType){
        assert article != null || article.length > 0;
        assert request != null || request.length > 0;
        assert profile != null || profile.length > 0;

        switch (folderType){
            case Article: return article;
            case Profile: return profile;
            case Request: return request;
            default:{
                throw new IllegalArgumentException();
            }
        }
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public int[] getArticle() {
        return article;
    }

    public void setArticle(int[] article) {
        this.article = article;
    }

    public int[] getRequest() {
        return request;
    }

    public void setRequest(int[] request) {
        this.request = request;
    }

    public int[] getProfile() {
        return profile;
    }

    public void setProfile(int[] profile) {
        this.profile = profile;
    }
}
