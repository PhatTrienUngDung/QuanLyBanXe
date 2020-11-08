package entity;

import java.util.Date;

public class HopDong {
	private String maHD;
	private String maKH;
	private String tenKH;
	private String maNV;
	private String tenNV;
	private String maXe;
	private String tenXe;
	private Date ngayLap;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public HopDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HopDong(String maHD, String maKH, String tenKH, String maNV, String tenNV, String maXe, String tenXe,
			Date ngayLap) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.ngayLap = ngayLap;
	}
	@Override
	public String toString() {
		return "HopDong [maHD=" + maHD + ", maKH=" + maKH + ", tenKH=" + tenKH + ", maNV=" + maNV + ", tenNV=" + tenNV
				+ ", maXe=" + maXe + ", tenXe=" + tenXe + ", ngayLap=" + ngayLap + "]";
	}
	
}
