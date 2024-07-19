package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;
@Entity
@Table(name="NHANVIEN")
public class NhanVienModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int MaAdmin;
	 private String TenAdmin;
     private String Email_Admin;
     private Date NgaySinh;
     private String DiaChi;
     @OneToOne
     @JoinColumn(name="IdUser")
     private TaiKhoaModel IdUser;
    public NhanVienModel() {};
	public NhanVienModel(int maAdmin, String tenAdmin,  String email_Admin,Date ngaySinh, String diaChi) {
		
		MaAdmin = maAdmin;
		TenAdmin = tenAdmin;
		Email_Admin = email_Admin;
		NgaySinh = ngaySinh;
		DiaChi = diaChi;
	}
	public int getMaAdmin() {
		return MaAdmin;
	}
	public void setMaAdmin(int maAdmin) {
		MaAdmin = maAdmin;
	}
	public String getTenAdmin() {
		return TenAdmin;
	}
	public void setTenAdmin(String tenAdmin) {
		TenAdmin = tenAdmin;
	}
	public String getEmail_Admin() {
		return Email_Admin;
	}
	public void setEmail_Admin(String email_Admin) {
		Email_Admin = email_Admin;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
     
}
