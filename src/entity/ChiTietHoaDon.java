package entity;

public class ChiTietHoaDon {

	private HoaDon hoaDon;
	private Xe sanPham;
	private double donGia;
	private double ThueVAT;
	
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(HoaDon hoaDon, Xe sanPham, double donGia, double thueVAT) {
		super();
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
		this.donGia = donGia;
		ThueVAT = thueVAT;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Xe getSanPham() {
		return sanPham;
	}

	public void setSanPham(Xe sanPham) {
		this.sanPham = sanPham;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getThueVAT() {
		return ThueVAT;
	}

	public void setThueVAT(double thueVAT) {
		ThueVAT = thueVAT;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", donGia=" + donGia + ", ThueVAT="
				+ ThueVAT + "]";
	}
}
