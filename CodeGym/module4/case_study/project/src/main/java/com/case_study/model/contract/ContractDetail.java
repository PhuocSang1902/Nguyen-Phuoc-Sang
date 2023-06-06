package com.case_study.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@SQLDelete(sql = "UPDATE contract_detail SET flag_remove = false WHERE id = ?")
@Where(clause = "flag_remove = true")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JsonBackReference
    private Contract contract;
    @ManyToOne
    private AttachFacility attachFacility;
    private Integer quantity;
    private boolean flagRemove = true;
}
