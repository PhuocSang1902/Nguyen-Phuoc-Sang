package repository;

import model.Facility.AttachFacility;

public interface IAttachFacilityRepository {
    AttachFacility findById(int id);
}
