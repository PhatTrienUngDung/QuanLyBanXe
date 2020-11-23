package entity;

import java.util.Date;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String email;
	private ChucVu chucVu;
	private String sdt;
	private Date ngayVaoLam;
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ChucVu getChucVu() {
		return chucVu;
	}
	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", email=" + email + ", chucVu=" + chucVu + ", sdt="
				+ sdt + ", ngayVaoLam=" + ngayVaoLam + "]";
	}
	
	public NhanVien(String maNhanVien, String tenNhanVien, String gioiTinh, Date ngaySinh, String diaChi, String email,
			ChucVu chucVu, String sdt, Date ngayVaoLam) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.chucVu = chucVu;
		this.sdt = sdt;
		this.ngayVaoLam = ngayVaoLam;
	}
	public NhanVien(String ma, String ten, String diachi2, String email2, String sodt, ChucVu chucVu2,
			java.sql.Date ngaySinh2, java.sql.Date ngayVaoLam2, String gioiTinh2) {
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNhanVien,String tenNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
	}

	
	
	
}
