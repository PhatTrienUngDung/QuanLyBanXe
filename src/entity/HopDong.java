package entity;

import java.sql.Date;

public class HopDong {
	private String maHD;

	private KhachHang khachHang;
	
	private NhanVien nhanVien;
	private Xe xe;
	private Date ngayLap;
	
	private int thoiGianBaoHanh;
	
	public HopDong(String maHD) {
		super();
		this.maHD = maHD;
	}
	
	public HopDong(String maHD, KhachHang khachHang, NhanVien nhanVien, Xe xe, Date ngayLap, int thoiGianBaoHanh) {
		super();
		this.maHD = maHD;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.xe = xe;		
		this.ngayLap = ngayLap;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	


	@Override
	public String toString() {
		return "HopDong [maHD=" + maHD + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", xe=" + xe
				+ ", ngayLap=" + ngayLap + ",  thoiGianBaoHanh=" + thoiGianBaoHanh + "]";
	}

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
	public Xe getXe() {
		return xe;
	}
	public void setXe(Xe xe) {
		this.xe = xe;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}
	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	
	
	
}