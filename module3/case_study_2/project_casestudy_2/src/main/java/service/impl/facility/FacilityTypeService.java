package service.impl.facility;

import model.Facility.FacilityType;
import repository.IFacilityTypeRepository;
import repository.impl.facility.FacilityTypeRepository;
import service.IFacilityTypeService;

import java.util.List;

public class FacilityTypeService implements IFacilityTypeService {
    private IFacilityTypeRepository facilityTypeRepository = new FacilityTypeRepository();
    @Override
    public List<FacilityType> getList() {
        return facilityTypeRepository.getList();
    }
}
