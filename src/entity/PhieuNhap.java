package entity;

import java.util.Date;

public class PhieuNhap {
	private String maPhieuNhap;
	private NhanVien nhanVien;
	private NhaCungCap nhaCungCap;
	private Date ngayNhap;
	private String chuThich;
	public PhieuNhap() {
		super();
	}
	public PhieuNhap(String maPhieuNhap, NhanVien nhanVien, NhaCungCap nhaCungCap, Date ngayNhap, String chuThich) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.nhanVien = nhanVien;
		this.nhaCungCap = nhaCungCap;
		this.ngayNhap = ngayNhap;
		this.chuThich = chuThich;
	}
	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public String getChuThich() {
		return chuThich;
	}
	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	@Override
	public String toString() {
		return "PhieuNhap [maPhieuNhap=" + maPhieuNhap + ", nhanVien=" + nhanVien + ", nhaCungCap=" + nhaCungCap
				+ ", ngayNhap=" + ngayNhap + ", chuThich=" + chuThich + "]";
	}
	
	
}
