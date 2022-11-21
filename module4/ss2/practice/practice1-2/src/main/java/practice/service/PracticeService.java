package practice.service;

import org.springframework.stereotype.Service;

@Service
public class PracticeService {


    public boolean checkEmail(String email) {
        String regex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        boolean result = email.matches(regex);
        return result;
    }
}
