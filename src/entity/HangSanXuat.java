package entity;

public class HangSanXuat {
	private String maHangSX;
	private String tenHangSX;
	private String quocGia;
	
	public HangSanXuat(String maHangSX) {
		super();
		this.maHangSX = maHangSX;
	}
	public HangSanXuat() {
		super();
	}
	public HangSanXuat(String maHangSX, String tenHangSX) {
		super();
		this.maHangSX = maHangSX;
		this.tenHangSX = tenHangSX;
	}
	
	public HangSanXuat(String maHangSX, String tenHangSX, String quocGia) {
		super();
		this.maHangSX = maHangSX;
		this.tenHangSX = tenHangSX;
		this.quocGia = quocGia;
	}
	@Override
	public String toString() {
		return "HangSanXuat [maHangSX=" + maHangSX + ", tenHangSX=" + tenHangSX + ", quocGia=" + quocGia + "]";
	}
	public String getMaHangSX() {
		return maHangSX;
	}
	public void setMaHangSX(String maHangSX) {
		this.maHangSX = maHangSX;
	}
	public String getTenHangSX() {
		return tenHangSX;
	}
	public void setTenHangSX(String tenHangSX) {
		this.tenHangSX = tenHangSX;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	
}
