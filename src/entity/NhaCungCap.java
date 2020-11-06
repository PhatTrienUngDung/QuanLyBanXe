package entity;

public class NhaCungCap {
	private String nhaCungCap;
	private String tenNhaCungCap;
	private String diaChi;
	private String chuThich;
	private String soDienThoai;
	
	public NhaCungCap(String nhaCungCap, String tenNhaCungCap, String diaChi, String chuThich, String soDienThoai) {
		super();
		this.nhaCungCap = nhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.chuThich = chuThich;
		this.soDienThoai = soDienThoai;
	}
	
	public NhaCungCap() {
		super();
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
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

	@Override
	public String toString() {
		return "NhaCungCap [nhaCungCap=" + nhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", diaChi=" + diaChi
				+ ", chuThich=" + chuThich + ", soDienThoai=" + soDienThoai + "]";
	}
}
