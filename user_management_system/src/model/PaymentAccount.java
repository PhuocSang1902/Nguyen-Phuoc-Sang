package model;

public class PaymentAccount extends Account {

    private String cardNumber;
    private double moneyAccount;

    public PaymentAccount() {
    }

    public PaymentAccount(int idAccount, String codeAccount, String ownerName, String creatDate) {
        super(idAccount, codeAccount, ownerName, creatDate);
    }

    public PaymentAccount(int idAccount, String codeAccount, String ownerName, String creatDate, String cardNumber, double moneyAccount) {
        super(idAccount, codeAccount, ownerName, creatDate);
        this.cardNumber = cardNumber;
        this.moneyAccount = moneyAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(double moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                super.toString() +
                ", cardNumber='" + cardNumber + '\'' +
                ", moneyAccount=" + moneyAccount +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s", super.getIdAccount(), super.getCodeAccount(), super.getOwnerName(), super.getCreatDate(), this.getCardNumber(), this.getMoneyAccount());
    }
}
