package service.impl.facility;

import model.Facility.Facility;
import repository.IFacilityRepository;
import repository.impl.facility.FacilityRepository;
import service.IFacilityService;
import validation.FacilityValidation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public List<Facility> getList() {
        return facilityRepository.getList();
    }

    @Override
    public Map<String, String> add(Facility facility) {
        Map<String,String> errorMap = new HashMap<>();
        if("".equals(facility.getName())){
            errorMap.put("facilityName", "Không được để trống");
        }else if (!FacilityValidation.checkName(facility.getName())){
            errorMap.put("facilityName", "Không đúng định dạng");
        }
        if (errorMap.isEmpty()){
            facilityRepository.add(facility);
        }
        return errorMap;
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public boolean edit(int id, Facility facility) {
        return facilityRepository.edit(id, facility);
    }

    @Override
    public List<Facility> search(String search) {
        return facilityRepository.search(search);
    }

    @Override
    public boolean remove(String id) {
        return facilityRepository.remove(id);
    }
}
