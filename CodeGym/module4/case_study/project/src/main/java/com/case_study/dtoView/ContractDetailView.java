package com.case_study.dtoView;

import com.case_study.model.contract.AttachFacility;
import com.case_study.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


public interface ContractDetailView {
    Integer getId();

    Integer getContractId();

    String getAttachFacilityName();

    Integer getQuantity();
}
