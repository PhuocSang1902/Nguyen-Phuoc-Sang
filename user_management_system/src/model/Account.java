package model;

public abstract class Account {
    private int idAccount;
    private String codeAccount;
    private String ownerName;
    private String creatDate;

    public Account() {
    }

    public Account(int idAccount, String codeAccount, String ownerName, String creatDate) {
        this.idAccount = idAccount;
        this.codeAccount = codeAccount;
        this.ownerName = ownerName;
        this.creatDate = creatDate;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(String codeAccount) {
        this.codeAccount = codeAccount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate;
    }

    @Override
    public String toString() {
        return
                "idAccount='" + idAccount + '\'' +
                ", codeAccount='" + codeAccount + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", creatDate='" + creatDate + '\'' ;
    }

    public abstract String getInfo();
}
