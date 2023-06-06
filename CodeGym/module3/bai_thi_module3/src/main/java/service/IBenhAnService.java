package service;

import model.BenhAn;

import java.util.List;

public interface IBenhAnService {
    List<BenhAn> getList();

    BenhAn getById(String maBenhAn);

    boolean edit(String maBenhAn, BenhAn benhAn);

    boolean remove(String maBenhAn);
}
