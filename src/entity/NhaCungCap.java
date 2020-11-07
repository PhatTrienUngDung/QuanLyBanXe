package entity;

public class NhaCungCap {
	private String maNhaCungCap;
	private String tenNhaCungCap;
	private String diaChi;
	private String chuThich;
	private String soDienThoai;
	private String email;
	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String chuThich, String soDienThoai, String email) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.chuThich = chuThich;
		this.soDienThoai = soDienThoai;
		this.email= email;
	}
	
	public NhaCungCap() {
		super();
	}

	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(String nhaCungCap) {
		this.maNhaCungCap = nhaCungCap;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChuThich() {
		return chuThich;
	}
	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NhaCungCap [nhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", diaChi=" + diaChi
				+ ", chuThich=" + chuThich + ", soDienThoai=" + soDienThoai + ", email=" + email + "]";
	}

	
	
}
