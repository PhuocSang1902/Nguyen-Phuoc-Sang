package service;

import model.Facility.Facility;

import java.util.List;
import java.util.Map;

public interface IFacilityService {
    List<Facility> getList();

    Map<String, String> add(Facility facility);

    Facility findById(int id);

    boolean edit(int id, Facility facility);

    List<Facility> search(String search);

    boolean remove(String id);
}
