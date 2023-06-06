CREATE DATABASE furama_management;
USE furama_management;
CREATE TABLE vi_tri (
    ma_vi_tri INT,
    ten_vi_tri VARCHAR(45),
    CONSTRAINT ma_vt_pk PRIMARY KEY (ma_vi_tri)
);
CREATE TABLE trinh_do (
    ma_trinh_do INT,
    ten_trinh_do VARCHAR(45),
    CONSTRAINT ma_td_pk PRIMARY KEY (ma_trinh_do)
);
CREATE TABLE bo_phan (
    ma_bo_phan INT,
    ten_bo_phan VARCHAR(45),
    CONSTRAINT ma_bp_pk PRIMARY KEY (ma_bo_phan)
);
CREATE TABLE loai_khach (
    ma_loai_khach INT,
    ten_loai_khach VARCHAR(45),
    CONSTRAINT ma_lk_pk PRIMARY KEY (ma_loai_khach)
);
CREATE TABLE loai_dich_vu (
    ma_loai_dich_vu INT,
    ten_loai_dich VARCHAR(45),
    CONSTRAINT ma_ldv_pk PRIMARY KEY (ma_loai_dich_vu)
);
CREATE TABLE kieu_thue (
    ma_kieu_thue INT,
    ten_kieu_thue VARCHAR(45),
    CONSTRAINT ma_kt_pk PRIMARY KEY (ma_kieu_thue)
);
CREATE TABLE dich_vu_di_kem (
    ma_dich_vu_di_kem INT NOT NULL,
    ten_dich_vu_di_kem VARCHAR(45) NOT NULL,
    gia DOUBLE NOT NULL,
    don_vi VARCHAR(10) NOT NULL,
    trang_thai VARCHAR(45),
    CONSTRAINT ma_dvdk_pk PRIMARY KEY (ma_dich_vu_di_kem)
);
CREATE TABLE khach_hang (
    ma_khach_hang INT NOT NULL,
    ma_loai_khach INT NOT NULL,
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE NOT NULL,
    gioi_tinh BIT(1) NOT NULL,
    so_cmnd VARCHAR(45) NOT NULL,
    so_dien_thoai VARCHAR(45) NOT NULL,
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    CONSTRAINT ma_kh_pk PRIMARY KEY (ma_khach_hang),
    CONSTRAINT ma_lk_fk FOREIGN KEY (ma_loai_khach)
        REFERENCES loai_khach (ma_loai_khach)
);
CREATE TABLE nhan_vien (
    ma_nhan_vien INT NOT NULL,
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE NOT NULL,
    so_cmnd VARCHAR(45) NOT NULL,
    luong DOUBLE NOT NULL,
    so_dien_thoai VARCHAR(45) NOT NULL,
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    ma_vi_tri INT NOT NULL,
    ma_trinh_do INT NOT NULL,
    ma_bo_phan INT NOT NULL,
    CONSTRAINT ma_nv PRIMARY KEY (ma_nhan_vien),
    CONSTRAINT ma_vt_fk FOREIGN KEY (ma_vi_tri)
        REFERENCES vi_tri (ma_vi_tri),
    CONSTRAINT ma_td_fk FOREIGN KEY (ma_trinh_do)
        REFERENCES trinh_do (ma_trinh_do),
    CONSTRAINT ma_bp_fk FOREIGN KEY (ma_bo_phan)
        REFERENCES bo_phan (ma_bo_phan)
);
CREATE TABLE dich_vu (
    ma_dich_vu INT,
    ten_dich_vu VARCHAR(45) NOT NULL,
    dien_tich INT,
    chi_phi_thue DOUBLE NOT NULL,
    so_nguoi_toi_da INT,
    ma_kieu_thue INT NOT NULL,
    ma_loai_dich_vu INT NOT NULL,
    tieu_chuan_phong VARCHAR(45),
    mo_ta_tien_nghi_khac VARCHAR(45),
    dien_tich_so_boi DOUBLE,
    so_tang INT,
    dich_vu_mien_phi_di_kem TEXT,
    CONSTRAINT ma_dv_pk PRIMARY KEY (ma_dich_vu),
    CONSTRAINT ma_kt_fk FOREIGN KEY (ma_kieu_thue)
        REFERENCES kieu_thue (ma_kieu_thue),
    CONSTRAINT ma_ldv_fk FOREIGN KEY (ma_loai_dich_vu)
        REFERENCES loai_dich_vu (ma_loai_dich_vu)
);
CREATE TABLE hop_dong (
    ma_hop_dong INT AUTO_INCREMENT,
    ngay_lam_hop_dong DATETIME NOT NULL,
    ngay_ket_thuc DATETIME NOT NULL,
    tien_dat_coc DOUBLE NOT NULL,
    ma_nhan_vien INT NOT NULL,
    ma_khach_hang INT NOT NULL,
    ma_dich_vu INT NOT NULL,
    CONSTRAINT ma_hd_pk PRIMARY KEY (ma_hop_dong),
    CONSTRAINT ma_nv_fk FOREIGN KEY (ma_nhan_vien)
        REFERENCES nhan_vien (ma_nhan_vien),
    CONSTRAINT ma_kh_fk FOREIGN KEY (ma_khach_hang)
        REFERENCES khach_hang (ma_khach_hang),
    CONSTRAINT ma_dv_fk FOREIGN KEY (ma_dich_vu)
        REFERENCES dich_vu (ma_dich_vu)
);
CREATE TABLE hop_dong_chi_tiet (
    ma_hop_dong_chi_tiet INT,
    ma_hop_dong INT NOT NULL,
    ma_dich_vu_di_kem INT NOT NULL,
    so_luong INT NOT NULL,
    CONSTRAINT ma_hdct_pk PRIMARY KEY (ma_hop_dong_chi_tiet),
    CONSTRAINT ma_hd_fk FOREIGN KEY (ma_hop_dong)
        REFERENCES hop_dong (ma_hop_dong),
    CONSTRAINT ma_dvdk_fk FOREIGN KEY (ma_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (ma_dich_vu_di_kem)
);