package emailConfig.service;

import emailConfig.model.EmailConfig;
import emailConfig.model.Login;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailConfigService {
    private static List<EmailConfig> emailConfigList = new ArrayList<>();
    static{
        emailConfigList.add(new EmailConfig("sang", "1234", "english", "25","1", "Sang"));
        emailConfigList.add(new EmailConfig("bao", "1234", "vietnam", "20","0", "Bao"));
        emailConfigList.add(new EmailConfig("phuong", "1234", "usa", "15","1", "Phuong"));
        emailConfigList.add(new EmailConfig("dat", "1234", "english", "10","0", "Dat"));
    }
    public EmailConfig login(Login login) {
        for (int i = 0; i < emailConfigList.size(); i++) {
            if (emailConfigList.get(i).getAccount().equals(login.getAccount()) && emailConfigList.get(i).getPassword().equals(login.getPassword())){
                return emailConfigList.get(i);
            }
        }
        return null;
    }
}
