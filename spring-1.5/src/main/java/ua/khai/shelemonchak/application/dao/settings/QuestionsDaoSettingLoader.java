package ua.khai.shelemonchak.application.dao.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsDaoSettingLoader {

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    private final String FILE_NAME;

    @Autowired
    public QuestionsDaoSettingLoader(QuestionsDaoSetting questionsDaoSetting) {
        this.FILE_NAME = questionsDaoSetting.getCvsFileName();
    }

}
