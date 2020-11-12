package entity;

import java.util.Date;

public class HopDong {
	private String maHD;
	private KhachHang maKH;
	private KhachHang tenKH;
	private NhanVien maNV;
	private NhanVien tenNV;
	private Xe maXe;
	private Xe tenXe;
	private Date ngayLap;
	private String chuThich;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public KhachHang getMaKH() {
		return maKH;
	}
	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}
	public KhachHang getTenKH() {
		return tenKH;
	}
	public void setTenKH(KhachHang tenKH) {
		this.tenKH = tenKH;
	}
	public NhanVien getMaNV() {
		return maNV;
	}
	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}
	public NhanVien getTenNV() {
		return tenNV;
	}
	public void setTenNV(NhanVien tenNV) {
		this.tenNV = tenNV;
	}
	public Xe getMaXe() {
		return maXe;
	}
	public void setMaXe(Xe maXe) {
		this.maXe = maXe;
	}
	public Xe getTenXe() {
		return tenXe;
	}
	public void setTenXe(Xe tenXe) {
		this.tenXe = tenXe;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getChuThich() {
		return chuThich;
	}
	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	@Override
	public String toString() {
		return "HopDong [maHD=" + maHD + ", maKH=" + maKH + ", tenKH=" + tenKH + ", maNV=" + maNV + ", tenNV=" + tenNV
				+ ", maXe=" + maXe + ", tenXe=" + tenXe + ", ngayLap=" + ngayLap + ", chuThich=" + chuThich + "]";
	}
	public HopDong(String maHD, KhachHang maKH, KhachHang tenKH, NhanVien maNV, NhanVien tenNV, Xe maXe, Xe tenXe,
			Date ngayLap, String chuThich) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.ngayLap = ngayLap;
		this.chuThich = chuThich;
	}
	
	
}