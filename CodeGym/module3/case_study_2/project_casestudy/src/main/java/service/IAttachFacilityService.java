package service;

import model.Facility.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    AttachFacility findById(int id);

    List<AttachFacility> getList();
}
