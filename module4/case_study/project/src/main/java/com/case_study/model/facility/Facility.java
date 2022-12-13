package com.case_study.model.facility;

import com.case_study.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

@Entity
@SQLDelete(sql = "UPDATE facility SET flag_remove = false WHERE id = ?")
@Where(clause = "flag_remove = true")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    @ManyToOne
    private RentType rentType;
    @ManyToOne
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloor;
    @Column(columnDefinition = "text")
    private String facilityFree;
    @OneToMany(mappedBy = "facility")
    @JsonBackReference
    private Set<Contract> contractSet;
    @Column(columnDefinition = "boolean")
    private Boolean flagRemove = true;
}
