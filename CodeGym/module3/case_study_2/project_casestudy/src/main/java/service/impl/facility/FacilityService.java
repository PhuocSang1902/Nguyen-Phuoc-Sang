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
        if("".equals(facility.getArea())){
            errorMap.put("area", "Không được để trống");
        }else if (!FacilityValidation.checkArea(facility.getArea())){
            errorMap.put("area", "Không đúng định dạng");
        }else if(Double.parseDouble(facility.getArea()) <= 0){
            errorMap.put("area", "Phải lớn hơn 0");
        }
        if("".equals(facility.getCost())){
            errorMap.put("cost", "Không được để trống");
        }else if (!FacilityValidation.checkCost(facility.getCost())){
            errorMap.put("cost", "Không đúng định dạng");
        }else if(Double.parseDouble(facility.getCost()) <= 0){
            errorMap.put("cost", "Phải lớn hơn 0");
        }
        if("".equals(facility.getMaxPeople())){
            errorMap.put("maxPeople", "Không được để trống");
        }else if (!FacilityValidation.checkPeopleNumber(facility.getMaxPeople())){
            errorMap.put("maxPeople", "Không đúng định dạng");
        }else if(Integer.parseInt(facility.getMaxPeople()) <= 0){
            errorMap.put("maxPeople", "Phải lớn hơn 0");
        }
        if("".equals(facility.getRentTypeId())){
            errorMap.put("rentType", "Không được để trống");
        }
        if("".equals(facility.getStandardRoom())){
            errorMap.put("standardRoom", "Không được để trống");
        }
        if("".equals(facility.getPoolArea())){
            errorMap.put("area", "Không được để trống");
        }else if (!FacilityValidation.checkArea(facility.getPoolArea())){
            errorMap.put("area", "Không đúng định dạng");
        }else if(Double.parseDouble(facility.getPoolArea()) <= 0){
            errorMap.put("area", "Phải lớn hơn 0");
        }
        if("".equals(facility.getNumberOfFloor())){
            errorMap.put("numberOfFloor", "Không được để trống");
        }else if (!FacilityValidation.checkPeopleNumber(facility.getNumberOfFloor())){
            errorMap.put("numberOfFloor", "Không đúng định dạng");
        }else if(Integer.parseInt(facility.getNumberOfFloor()) <= 0){
            errorMap.put("numberOfFloor", "Phải lớn hơn 0");
        }
        if("".equals(facility.getFacilityFree())){
            errorMap.put("facilityFree", "Không được để trống");
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
