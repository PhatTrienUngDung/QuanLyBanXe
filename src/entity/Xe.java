package entity;

import java.sql.Date;

public class Xe {
	private String maXe;
	private String tenXe;
	private String mauXe;
	private int phanKhoi;
	private int soLuong;
	private double giaNhap;
	private LoaiXe loaiXe;
	private NhaCungCap nhaCungCap;
	private HangSanXuat hangSanXuat;
	private Date ngayNhap;
	private String trangThai;
	private String chuThich;
	private String img1;
	private String img2;
	private String img3;
	
	public Xe(String maXe, String tenXe) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
	}

	public Xe(String maXe, String tenXe, String mauXe, int phanKhoi, int soLuong, double giaNhap, LoaiXe loaiXe,
			NhaCungCap nhaCungCap, HangSanXuat hangSanXuat, String trangThai, String chuThich, String img1, String img2,
			String img3) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.mauXe = mauXe;
		this.phanKhoi = phanKhoi;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.loaiXe = loaiXe;
		this.nhaCungCap = nhaCungCap;
		this.hangSanXuat = hangSanXuat;
		this.trangThai = trangThai;
		this.chuThich = chuThich;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}

	public Xe(String maXe, String tenXe, String mauXe, int phanKhoi, int soLuong, double giaNhap, LoaiXe loaiXe,
			NhaCungCap nhaCungCap, HangSanXuat hangSanXuat, Date ngayNhap, String trangThai, String chuThich,
			String img1, String img2, String img3) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.mauXe = mauXe;
		this.phanKhoi = phanKhoi;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.loaiXe = loaiXe;
		this.nhaCungCap = nhaCungCap;
		this.hangSanXuat = hangSanXuat;
		this.ngayNhap = ngayNhap;
		this.trangThai = trangThai;
		this.chuThich = chuThich;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}

	public Xe() {
		super();
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

	public String getMauXe() {
		return mauXe;
	}

	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}

	public int getPhanKhoi() {
		return phanKhoi;
	}

	public void setPhanKhoi(int phanKhoi) {
		this.phanKhoi = phanKhoi;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public LoaiXe getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public HangSanXuat getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	@Override
	public String toString() {
		return "Xe [maXe=" + maXe + ", tenXe=" + tenXe + ", mauXe=" + mauXe + ", phanKhoi=" + phanKhoi + ", soLuong="
				+ soLuong + ", giaNhap=" + giaNhap + ", loaiXe=" + loaiXe + ", nhaCungCap=" + nhaCungCap
				+ ", hangSanXuat=" + hangSanXuat + ", ngayNhap=" + ngayNhap + ", trangThai=" + trangThai + ", chuThich="
				+ chuThich + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + "]";
	}

	public Xe(String maXe) {
		super();
		this.maXe = maXe;
	}

	public Xe(String ma, String ten, String mau, int phanKhoi2, int soLuong2, double giaNhap2, LoaiXe loaiXe2,
			NhaCungCap nhaCungCap2, HangSanXuat hangSanXuat2, java.util.Date parse, String trangThai2, String chuThich2,
			String img12, String img22, String img32) {
		// TODO Auto-generated constructor stub
	}
	
}
