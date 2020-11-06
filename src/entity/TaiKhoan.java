package entity;

public class TaiKhoan {

	private NhanVien nhanVien;
	private String matKhau;
	private String quyen;
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(NhanVien nhanVien, String matKhau, String quyen) {
		super();
		this.nhanVien = nhanVien;
		this.matKhau = matKhau;
		this.quyen = quyen;
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

	@Override
	public String toString() {
		return "TaiKhoan [nhanVien=" + nhanVien + ", matKhau=" + matKhau + ", quyen=" + quyen + "]";
	}
	
	
}
