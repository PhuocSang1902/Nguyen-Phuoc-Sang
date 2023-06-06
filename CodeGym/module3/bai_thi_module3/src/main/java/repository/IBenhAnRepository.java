package repository;

import model.BenhAn;

import java.util.List;

public interface IBenhAnRepository {
    List<BenhAn> getList();

    BenhAn getById(String maBenhAn);

    boolean edti(String maBenhAn, BenhAn benhAn);

    boolean remove(String maBenhAn);
}
