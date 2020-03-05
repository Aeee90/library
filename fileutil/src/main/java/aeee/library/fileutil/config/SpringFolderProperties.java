package aeee.library.fileutil.config;

import aeee.library.fileutil.util.file.FileStorageManagerConfiguration;
import aeee.library.fileutil.util.file.SpringFileUtilConfigurationSpringAdaptor;
import aeee.library.fileutil.util.file.FolderProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration
@ConfigurationProperties(prefix = "file.util.tree")
class SpringFolderProperties extends SpringFileUtilConfigurationSpringAdaptor {

    private String root;

    private int [] article;

    private int [] request;

    private int [] profile;

    @Override
    public FileStorageManagerConfiguration configuration(FileStorageManagerConfiguration fileStorageManagerConfiguration) {
        return fileStorageManagerConfiguration
                .setRoot(Paths.get(root))
                .addFolderProperty(FolderProperties.of(FolderTypeImpl.ARTICLE, article))
                .addFolderProperty(FolderProperties.of(FolderTypeImpl.REQUEST, request))
                .addFolderProperty(FolderProperties.of(FolderTypeImpl.PROFILE, profile));
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public void setArticle(int[] article) {
        this.article = article;
    }

    public void setRequest(int[] request) {
        this.request = request;
    }

    public void setProfile(int[] profile) {
        this.profile = profile;
    }
}
