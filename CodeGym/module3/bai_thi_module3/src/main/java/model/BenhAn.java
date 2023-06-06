package model;

public class BenhAn {
    private String maBenhAn;
    private BenhNhan benhNhan;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String lyDo;
    private String bacSi;
    private String phuongPhap;

    public BenhAn() {
    }

    public BenhAn(String maBenhAn, BenhNhan benhNhan, String ngayNhapVien, String ngayRaVien, String lyDo, String bacSi, String phuongPhap) {
        this.maBenhAn = maBenhAn;
        this.benhNhan = benhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDo = lyDo;
        this.bacSi = bacSi;
        this.phuongPhap = phuongPhap;
    }

    public BenhAn(BenhNhan benhNhan, String ngayNhapVien, String ngayRaVien, String lyDo, String bacSi, String phuongPhap) {
        this.benhNhan = benhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDo = lyDo;
        this.bacSi = bacSi;
        this.phuongPhap = phuongPhap;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getBacSi() {
        return bacSi;
    }

    public void setBacSi(String bacSi) {
        this.bacSi = bacSi;
    }

    public String getPhuongPhap() {
        return phuongPhap;
    }

    public void setPhuongPhap(String phuongPhap) {
        this.phuongPhap = phuongPhap;
    }
}
