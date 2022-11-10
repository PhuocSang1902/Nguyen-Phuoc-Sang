package service.impl.facility;

import model.Facility.Facility;
import repository.IFacilityRepository;
import repository.impl.facility.FacilityRepository;
import service.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public List<Facility> getList() {
        return facilityRepository.getList();
    }

    @Override
    public boolean add(Facility facility) {
        return facilityRepository.add(facility);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id);
    }
}
