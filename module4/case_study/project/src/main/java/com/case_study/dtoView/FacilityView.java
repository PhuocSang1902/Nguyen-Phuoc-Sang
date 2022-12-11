package com.case_study.dtoView;

import com.case_study.model.facility.FacilityType;
import com.case_study.model.facility.RentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class FacilityView {
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private RentType rentType;
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloor;
    private String facilityFree;
    private Boolean flagRemove = true;
}
