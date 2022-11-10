package service;

import model.Facility.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> getList();

    boolean add(Facility facility);

    Facility findById(int id);

    boolean edit(int id, Facility facility);
}
