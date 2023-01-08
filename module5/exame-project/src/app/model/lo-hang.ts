import {SanPham} from './san-pham';

export interface LoHang {
  idLoHang?: number;
  ma?: string;
  sanPham?: SanPham;
  soLuong?: number;
  ngayNhapHang?: string;
  ngaySanXuat?: string;
  ngayHetHan?: string;
  tenSanPham?: string;
  giaTien?: number;
  donVi?: string;
}
