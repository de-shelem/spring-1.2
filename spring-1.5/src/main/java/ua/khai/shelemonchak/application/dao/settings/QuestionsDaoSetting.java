package ua.khai.shelemonchak.application.dao.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application")
public class QuestionsDaoSetting {


    public String getCvsFileName() {
        return cvsFileName;
    }

    public void setCvsFileName(String cvsFileName) {
        this.cvsFileName = cvsFileName;
    }

    @Override
    public String toString() {
        return "QuestionsDaoSetting{" +
                "cvsFileName='" + cvsFileName + '\'' +
                '}';
    }


    private String cvsFileName;


}
