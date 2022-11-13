package repository;

import model.Facility.AttachFacility;

import java.util.List;

public interface IAttachFacilityRepository {
    AttachFacility findById(int id);

    List<AttachFacility> getList();
}
