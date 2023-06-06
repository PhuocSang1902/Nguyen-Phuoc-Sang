package model.contract;

import model.Facility.AttachFacility;

public class ContractDetail {
    private String id;
    private Contract contract;
    private AttachFacility attachFacility;
    private String quantity;

    public ContractDetail() {
    }

    public ContractDetail(Contract contract, AttachFacility attachFacility, String quantity) {
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    public ContractDetail(String id, Contract contract, AttachFacility attachFacility, String quantity) {
        this.id = id;
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
