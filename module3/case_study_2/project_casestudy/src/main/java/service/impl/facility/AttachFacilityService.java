package service.impl.facility;

import model.Facility.AttachFacility;
import model.Facility.FacilityType;
import repository.IAttachFacilityRepository;
import repository.impl.facility.AttachFacilityRepository;
import service.IAttachFacilityService;

import java.util.List;

public class AttachFacilityService implements IAttachFacilityService {
    private IAttachFacilityRepository attachFacilityRepository = new AttachFacilityRepository();
    @Override
    public AttachFacility findById(int id) {
        return attachFacilityRepository.findById(id);
    }
    @Override
    public List<AttachFacility> getList() {
        return attachFacilityRepository.getList();
    }
}
