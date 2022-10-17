package model;

public class SaveAccount extends Account {

    private double saveMoney;
    private String saveDate;
    private double interest;
    private int period;

    public SaveAccount() {
    }

    public SaveAccount(int idAccount, String codeAccount, String ownerName, String creatDate) {
        super(idAccount, codeAccount, ownerName, creatDate);
    }

    public SaveAccount(int idAccount, String codeAccount, String ownerName, String creatDate, double saveMoney, String saveDate, double interest, int period) {
        super(idAccount, codeAccount, ownerName, creatDate);
        this.saveMoney = saveMoney;
        this.saveDate = saveDate;
        this.interest = interest;
        this.period = period;
    }

    public double getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(double saveMoney) {
        this.saveMoney = saveMoney;
    }

    public String getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(String saveDate) {
        this.saveDate = saveDate;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "SaveAccount{" +
                super.toString() +
                ", saveMoney=" + saveMoney +
                ", saveDate='" + saveDate + '\'' +
                ", interest=" + interest +
                ", period=" + period +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", super.getIdAccount(), super.getCodeAccount(), super.getOwnerName(), super.getCreatDate(), this.getSaveMoney(), this.getSaveDate(), this.getInterest(), this.getPeriod());
    }
}
