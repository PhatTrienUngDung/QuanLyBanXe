package entity;

import java.util.Date;

public class PhieuNhap {
	private String maPhieuNhap;
	private NhanVien nhanVien;
	private NhaCungCap nhaCungCap;
	private Date ngayNhap;
	private int soLuong;
	private float vat;
	private float tienThue;
	private float donGia;
	private float thanhTien;
	private String chuThich;
	private Xe xe;
	public PhieuNhap() {
		super();
	}
	public PhieuNhap(String maPhieuNhap, NhanVien nhanVien, NhaCungCap nhaCungCap, Date ngayNhap, int soLuong, float vat,
			float tienThue, float donGia, float thanhTien, String chuThich, Xe xe) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.nhanVien = nhanVien;
		this.nhaCungCap = nhaCungCap;
		this.ngayNhap = ngayNhap;
		this.soLuong = soLuong;
		this.vat = vat;
		this.tienThue = tienThue;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
		this.chuThich = chuThich;
		this.xe = xe;
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
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getVat() {
		return vat;
	}
	public void setVat(float vat) {
		this.vat = vat;
	}
	public float getTienThue() {
		return donGia * vat;
	}
	public void setTienThue(float tienThue) {
		this.tienThue = tienThue;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public float getThanhTien() {
		return (soLuong * donGia) + (donGia * vat);
	}
	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getChuThich() {
		return chuThich;
	}
	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	public Xe getXe() {
		return xe;
	}
	public void setXe(Xe xe) {
		this.xe = xe;
	}
	@Override
	public String toString() {
		return "PhieuNhap [maPhieuNhap=" + maPhieuNhap + ", nhanVien=" + nhanVien + ", nhaCungCap=" + nhaCungCap
				+ ", ngayNhap=" + ngayNhap + ", soLuong=" + soLuong + ", vat=" + vat + ", tienThue=" + tienThue
				+ ", donGia=" + donGia + ", thanhTien=" + thanhTien + ", chuThich=" + chuThich + ", xe=" + xe + "]";
	}
	
	
}
