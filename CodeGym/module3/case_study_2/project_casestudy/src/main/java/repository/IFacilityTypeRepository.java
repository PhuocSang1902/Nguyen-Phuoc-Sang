package repository;

import model.Facility.FacilityType;

import java.util.List;

public interface IFacilityTypeRepository {
    List<FacilityType> getList();
}
