package calculation.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    public static Float calculate(Float number1, Float number2, String math) {
        Float calculationResult;
        switch (math) {
            case "+":
                calculationResult = number1 + number2;
                break;
            case "-":
                calculationResult = number1 - number2;
                break;
            case "*":
                calculationResult = number1 * number2;
                break;
            case "/":
                calculationResult = number1 / number2;
                break;
            default:
                calculationResult = null;
                break;
        }
        return calculationResult;
    }
}
