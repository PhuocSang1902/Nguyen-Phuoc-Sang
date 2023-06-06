package repository;

import model.Facility.Facility;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> getList();

    boolean add(Facility facility);

    Facility findById(int id);

    boolean edit(int id, Facility facility);

    List<Facility> search(String search);

    boolean remove(String id);
}
