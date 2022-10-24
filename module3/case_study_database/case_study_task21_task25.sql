USE furama_management;
-- SQL NÂNG CAO

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Đà Nẵng” và 
-- đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.

CREATE VIEW v_nhan_vien AS
SELECT
	nv.*,
    hd.ngay_lam_hop_dong
FROM
	hop_dong hd JOIN nhan_vien nv ON hd.ma_nhan_vien = nv.ma_nhan_vien
WHERE
	nv.dia_chi LIKE '%Đà Nẵng%'
    AND
    month(hd.ngay_lam_hop_dong) = 4
    AND
    year(hd.ngay_lam_hop_dong) = 2021;

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.

UPDATE
	nhan_vien
SET
	dia_chi = regexp_replace(dia_chi, 'Đà Nẵng', 'Liên Chiểu')
WHERE
	ma_nhan_vien IN
	(
		SELECT * FROM (SELECT
			ma_nhan_vien
		FROM
			v_nhan_vien) AS x
    );

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.

DELIMITER //
CREATE PROCEDURE sp_xoa_khach_hang(IN ma INT)
BEGIN
SET SQL_SAFE_UPDATES = 0;
SET foreign_key_checks = 0;
DELETE
FROM khach_hang
WHERE ma_khach_hang = ma;
SET SQL_SAFE_UPDATES = 1;
SET foreign_key_checks = 1;
END //
DELIMITER ;

CALL sp_xoa_khach_hang(10);

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

DELIMITER //
CREATE PROCEDURE sp_them_moi_hop_dong(ngay_lam DATETIME, ngay_het DATETIME, tien_dat DOUBLE, ma_nv INT, ma_kh INT, ma_dv INT)
BEGIN
INSERT INTO hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
	VALUES (ngay_lam, ngay_het, tien_dat, ma_nv, ma_kh, ma_dv);
END //
DELIMITER ;

CALL sp_them_moi_hop_dong('2020-07-14','2020-07-21',200000,7,3,1);

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị 
-- tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

CREATE TABLE lich_su_xoa_hop_dong (ma_hop_dong INT PRIMARY KEY, ngay_xoa DATETIME, tong_so_hop_dong_con_lai INT);

DELIMITER //
CREATE TRIGGER tr_xoa_hop_dong
AFTER DELETE ON hop_dong
FOR EACH ROW 
BEGIN
 INSERT INTO lich_su_xoa_hop_dong VALUE (old.ma_hop_dong, now(), (SELECT count(ma_hop_dong) FROM hop_dong));
END //
DELIMITER ;

SET SQL_SAFE_UPDATES = 0;
SET foreign_key_checks = 0;
SET SQL_SAFE_UPDATES = 1;
SET foreign_key_checks = 1;
DELETE FROM hop_dong WHERE ma_hop_dong = 2;

SELECT * FROM lich_su_xoa_hop_dong;

-- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không,
-- với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày.
-- Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo
-- “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

DELIMITER //
CREATE TRIGGER tr_cap_nhap_hop_dong
BEFORE UPDATE ON hop_dong
FOR EACH ROW
BEGIN
	DECLARE errormassage VARCHAR(200);
	SET errormassage = 'Ngay ket thuc khong hop le';
	IF datediff(new.ngay_ket_thuc, old.ngay_lam_hop_dong) < 2
	THEN SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = errormassage;
	END IF;
END //
DELIMITER ;
DROP TRIGGER tr_cap_nhap_hop_dong;
UPDATE hop_dong
SET ngay_ket_thuc = '2020-12-05'
WHERE ma_hop_dong = 1;

-- 27.	Tạo Function thực hiện yêu cầu sau:
-- a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
-- b.	Tạo Function func_tinh_thoi_gian_hop_dong:
-- Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà khách hàng đã thực hiện thuê dịch vụ
-- (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng).
-- Mã của khách hàng được truyền vào như là 1 tham số của function này.

-- a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
CREATE VIEW w_dich_vu AS
SELECT dich_vu.ma_dich_vu 
FROM hop_dong JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
GROUP BY dich_vu.ma_dich_vu 
HAVING sum(dich_vu.chi_phi_thue) > 2000000;

DELIMITER //
CREATE FUNCTION f_dem_cac_dich_vu ()
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE dich_vu_da_su_dung INT;
	SET dich_vu_da_su_dung = (SELECT count(ma_dich_vu) 
    FROM w_dich_vu);
    
    RETURN dich_vu_da_su_dung;
END //
DELIMITER ;

SELECT f_dem_cac_dich_vu();

-- b.	Tạo Function func_tinh_thoi_gian_hop_dong
DELIMITER //
CREATE FUNCTION f_thoi_gian_dai_nhat ()
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE thoi_gian_dai_nhat INT;
    SET thoi_gian_dai_nhat = (SELECT max(datediff(ngay_ket_thuc, ngay_lam_hop_dong)) FROM hop_dong);
	RETURN thoi_gian_dai_nhat;
END //
DELIMITER ;

SELECT f_thoi_gian_dai_nhat();

-- 28.	Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để
-- tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2019 đến hết năm 2020
-- để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng dich_vu)
-- và xóa những hop_dong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng hop_dong) và những bản liên quan khác.

CREATE VIEW w_hop_dong_room AS
SELECT 
	hd.ma_dich_vu,
    hd.ma_hop_dong
FROM
	hop_dong hd JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
    JOIN loai_dich_vu ldv ON ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
WHERE
	year(hd.ngay_lam_hop_dong) IN (2019,2020)
    AND
    ldv.ten_loai_dich = 'Room';

DELIMITER //
CREATE PROCEDURE sp_xoa_dich_vu_va_hd_room ()
BEGIN
SET SQL_SAFE_UPDATES = 0;
SET foreign_key_checks = 0;

DELETE FROM dich_vu
WHERE ma_dich_vu IN (SELECT * FROM (SELECT ma_dich_vu FROM w_hop_dong_room) AS x);

DELETE FROM hop_dong
WHERE ma_hop_dong IN (SELECT * FROM (SELECT ma_hop_dong FROM w_hop_dong_room) AS y);

SET SQL_SAFE_UPDATES = 1;
SET foreign_key_checks = 1;
END //
DELIMITER ;

call sp_xoa_dich_vu_va_hd_room();