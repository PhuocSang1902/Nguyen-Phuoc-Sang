package com.case_study.dto;

import com.case_study.model.facility.FacilityType;
import com.case_study.model.facility.RentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class FacilityDto implements Serializable, Validator {
    private Integer id;
    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+\\d*(\\s\\p{Lu}\\p{Ll}+\\d*)*$", message = "{Invalid}")
    private String name;
    @NotNull(message = "{NotEmpty}")
    @Min(value = 0, message = "{NotCorrect}")
    private Integer area;
    @NotNull(message = "{NotEmpty}")
    @Min(value = 1, message = "{NotCorrect}")
    private Double cost;
    @NotNull(message = "{NotEmpty}")
    @Min(value = 1, message = "{NotCorrect}")
    private Integer maxPeople;
    @NotBlank(message = "{NotEmpty}")
    private RentType rentType;
    @NotBlank(message = "{NotEmpty}")
    private FacilityType facilityType;
    @NotBlank(message = "{NotEmpty}")
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloor;
    private String facilityFree;
    private Boolean flagRemove = true;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        if (facilityDto.facilityType.getId().equals(1)) {
            if (facilityDto.poolArea != null) {
                if (facilityDto.poolArea <= 0) {
                    errors.rejectValue("poolArea", "NotCorrect");
                }
            } else {
                errors.rejectValue("poolArea", "NotEmpty");
            }
            if (facilityDto.numberOfFloor != null) {
                if (facilityDto.numberOfFloor <= 0) {
                    errors.rejectValue("numberOfFloor", "NotCorrect");
                }
            } else {
                errors.rejectValue("numberOfFloor", "NotEmpty");
            }
        }
        if (facilityDto.facilityType.getId().equals(2)) {
            if (facilityDto.numberOfFloor != null) {
                if (facilityDto.numberOfFloor <= 0) {
                    errors.rejectValue("numberOfFloor", "NotCorrect");
                }
            } else {
                errors.rejectValue("numberOfFloor", "NotEmpty");
            }
        }
        if (facilityDto.facilityType.getId().equals(3)) {
            if (facilityDto.numberOfFloor == null) {
                errors.rejectValue("facilityFree", "NotEmpty");
            }
        }
    }
}
