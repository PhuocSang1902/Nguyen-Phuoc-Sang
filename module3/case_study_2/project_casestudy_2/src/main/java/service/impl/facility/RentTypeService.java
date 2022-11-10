package service.impl.facility;

import model.Facility.RentType;
import repository.IRentTypeRepository;
import repository.impl.facility.RentTypeRepository;
import service.IRenTypeService;

import java.util.List;

public class RentTypeService implements IRenTypeService {
    IRentTypeRepository rentTypeRepository = new RentTypeRepository();
    @Override
    public List<RentType> getList() {
        return rentTypeRepository.getList();
    }
}
