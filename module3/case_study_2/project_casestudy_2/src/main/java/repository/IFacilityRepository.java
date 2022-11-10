package repository;

import model.Facility.Facility;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> getList();

    boolean add(Facility facility);

    Facility findById(int id);
}
