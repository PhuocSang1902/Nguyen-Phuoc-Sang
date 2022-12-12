package com.case_study.model.facility;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

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
    @Column(columnDefinition = "boolean")
    private Boolean flagRemove = true;
}
