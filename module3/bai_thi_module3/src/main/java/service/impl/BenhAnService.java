package service.impl;

import model.BenhAn;
import repository.IBenhAnRepository;
import repository.impl.BenhAnRepository;
import service.IBenhAnService;

import java.util.List;

public class BenhAnService implements IBenhAnService {

    private IBenhAnRepository benhAnRepository = new BenhAnRepository();

    @Override
    public List<BenhAn> getList() {
        return benhAnRepository.getList();
    }

    @Override
    public BenhAn getById(String maBenhAn) {
        return benhAnRepository.getById(maBenhAn);
    }

    @Override
    public boolean edit(String maBenhAn, BenhAn benhAn) {
        return benhAnRepository.edti(maBenhAn, benhAn);
    }

    @Override
    public boolean remove(String maBenhAn) {
        return benhAnRepository.remove(maBenhAn);
    }
}
