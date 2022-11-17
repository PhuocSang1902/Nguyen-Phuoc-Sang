package repository.impl;

import model.BenhAn;
import model.BenhNhan;
import repository.BaseRepository;
import repository.IBenhAnRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository implements IBenhAnRepository {

    static final String GET_LIST = "select ba.*, bn.name from benh_an ba join benh_nhan bn on ba.id_benh_nhan = bn.id;";
    static final String GET_LIST_BY_ID = "select ba.*, bn.name from benh_an ba join benh_nhan bn on ba.id_benh_nhan = bn.id where ba.id = ?;";
    static final String EDIT = "UPDATE benh_an \n" +
            "\tSET benh_an.ngay_nhap = ?, \n" +
            "\t\tbenh_an.ngay_ra = ?, \n" +
            "\t\tbenh_an.ly_do = ?, \n" +
            "\t\tbenh_an.bac_si = ?, \n" +
            "\t\tbenh_an.phuong_phap =?\n" +
            "\tWHERE\n" +
            "\t\tbenh_an.id = ?;";
    static final String DELETE = "call delete_by_id (?);";

    @Override
    public List<BenhAn> getList() {
        List<BenhAn> benhAnList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maBenhAn = resultSet.getString("id");
                String maBenhNhan = resultSet.getString("id_benh_nhan");
                String ngayNhapVien = resultSet.getString("ngay_nhap");
                String ngayRaVien = resultSet.getString("ngay_ra");
                String lyDo = resultSet.getString("ly_do");
                String bacSi = resultSet.getString("bac_si");
                String phuongPhap = resultSet.getString("phuong_phap");
                String tenBanhNhan = resultSet.getString("name");
                BenhNhan benhNhan = new BenhNhan(maBenhNhan, tenBanhNhan);
                benhAnList.add(new BenhAn(maBenhAn, benhNhan, ngayNhapVien, ngayRaVien, lyDo, bacSi, phuongPhap));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhAnList;
    }

    @Override
    public BenhAn getById(String maBenhAn) {
        BenhAn benhAn = new BenhAn();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_BY_ID);
            preparedStatement.setString(1, maBenhAn);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maBenhNhan = resultSet.getString("id_benh_nhan");
                String ngayNhapVien = resultSet.getString("ngay_nhap");
                String ngayRaVien = resultSet.getString("ngay_ra");
                String lyDo = resultSet.getString("ly_do");
                String bacSi = resultSet.getString("bac_si");
                String phuongPhap = resultSet.getString("phuong_phap");
                String tenBanhNhan = resultSet.getString("name");
                BenhNhan benhNhan = new BenhNhan(maBenhNhan, tenBanhNhan);
                benhAn = new BenhAn(maBenhAn, benhNhan, ngayNhapVien, ngayRaVien, lyDo, bacSi, phuongPhap);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhAn;
    }

    @Override
    public boolean edti(String maBenhAn, BenhAn benhAn) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT);
            preparedStatement.setString(1,benhAn.getNgayNhapVien());
            preparedStatement.setString(2,benhAn.getNgayRaVien());
            preparedStatement.setString(3,benhAn.getLyDo());
            preparedStatement.setString(4,benhAn.getBacSi());
            preparedStatement.setString(5,benhAn.getPhuongPhap());
            preparedStatement.setString(6,maBenhAn);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(String maBenhAn) {
        Connection connection = new BaseRepository().getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1, maBenhAn);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
