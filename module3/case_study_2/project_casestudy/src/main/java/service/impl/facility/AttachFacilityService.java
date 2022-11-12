package service.impl.facility;

import model.Facility.AttachFacility;
import repository.IAttachFacilityRepository;
import repository.impl.facility.AttachFacilityRepository;
import service.IAttachFacilityService;

public class AttachFacilityService implements IAttachFacilityService {
    private IAttachFacilityRepository attachFacilityRepository = new AttachFacilityRepository();
    @Override
    public AttachFacility findById(int id) {
        return attachFacilityRepository.findById(id);
    }
}
