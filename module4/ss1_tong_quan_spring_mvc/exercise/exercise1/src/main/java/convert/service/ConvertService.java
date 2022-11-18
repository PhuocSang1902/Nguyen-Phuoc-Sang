package convert.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService {
    static public Float convert(float number1){
        Float result = number1 * 25000;
        return result;
    }
}
