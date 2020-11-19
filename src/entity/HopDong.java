package entity;

import java.util.Date;

public class HopDong {
	private String maHD;

	private KhachHang khachHang;
	
	private NhanVien nhanVien;
	private LoaiXe loaiXe;
	
	private Date ngayLap;
	private String tgbh;
	
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public LoaiXe getXe() {
		return loaiXe;
	}
	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getTGBH() {
		return tgbh;
	}
	public void setTGBH(String tgbh) {
		tgbh = tgbh;
	}
	public HopDong(String maHD, KhachHang khachHang, NhanVien nhanVien, LoaiXe loaiXe, Date ngayLap, String tGBH) {
		super();
		this.maHD = maHD;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.loaiXe = loaiXe;
		this.ngayLap = ngayLap;
		tgbh= tgbh;
	}
	
	@Override
	public String toString() {
		return "HopDong [maHD=" + maHD + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", loaiXe=" + loaiXe
				+ ", ngayLap=" + ngayLap + ", TGBH=" + tgbh + "]";
	}
	
}