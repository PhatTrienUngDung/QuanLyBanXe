package entity;

public class TaiKhoan {

	private NhanVien nhanVien;
	private String matKhau;
	private String quyen;
	private String chuThich;
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TaiKhoan(NhanVien nhanVien, String matKhau, String quyen, String chuThich) {
		super();
		this.nhanVien = nhanVien;
		this.matKhau = matKhau;
		this.quyen = quyen;
		this.chuThich = chuThich;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	@Override
	public String toString() {
		return "TaiKhoan [nhanVien=" + nhanVien + ", matKhau=" + matKhau + ", quyen=" + quyen + ", chuThich=" + chuThich
				+ "]";
	}

	
}
