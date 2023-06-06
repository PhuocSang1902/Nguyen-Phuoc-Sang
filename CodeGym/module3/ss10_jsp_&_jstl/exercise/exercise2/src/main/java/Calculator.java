public class Calculator {
    private float firstOperand;
    private float secondOperand;
    private String Math;

    public Calculator() {
    }

    public Calculator(float firstOperand, float secondOperand, String math) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        Math = math;
    }

    public float getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(float firstOperand) {
        this.firstOperand = firstOperand;
    }

    public float getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(float secondOperand) {
        this.secondOperand = secondOperand;
    }

    public String getMath() {
        return Math;
    }

    public void setMath(String math) {
        Math = math;
    }
}
