package entity;

public class LoaiXe {
	private String maLoaiXe;
	private String tenLoaiXe;
	public LoaiXe(String maLoaiXe) {
		super();
		this.maLoaiXe = maLoaiXe;
	}
	public LoaiXe(String maLoaiXe, String tenLoaiXe) {
		super();
		this.maLoaiXe = maLoaiXe;
		this.tenLoaiXe = tenLoaiXe;
	}
	
	
	public LoaiXe() {
		super();
	}
	public String getMaLoaiXe() {
		return maLoaiXe;
	}
	public void setMaLoaiXe(String maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}
	public String getTenLoaiXe() {
		return tenLoaiXe;
	}
	public void setTenLoaiXe(String tenLoaiXe) {
		this.tenLoaiXe = tenLoaiXe;
	}
	@Override
	public String toString() {
		return "LoaiXe [maLoaiXe=" + maLoaiXe + ", tenLoaiXe=" + tenLoaiXe + "]";
	}
	
	
}
