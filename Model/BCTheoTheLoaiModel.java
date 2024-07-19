package Model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "BCTHEOTHELOAI")
public class BCTheoTheLoaiModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int MaBCTheoTL;
   private int SoLuong;
   private int Thang;
   private int Nam;
   @OneToMany(mappedBy = "MaBCTheoTL")
   Set<CT_BCTheoTheLoaiModel> ct_bctheotheloai;
   
public BCTheoTheLoaiModel( int soLuong, int thang, int nam,
		Set<CT_BCTheoTheLoaiModel> ct_bctheotheloai) {
	SoLuong = soLuong;
	Thang = thang;
	Nam = nam;
	this.ct_bctheotheloai = ct_bctheotheloai;
}
public BCTheoTheLoaiModel() {
	super();
}
public int getMaBCTheoTL() {
	return MaBCTheoTL;
}
public void setMaBCTheoTL(int maBCTheoTL) {
	MaBCTheoTL = maBCTheoTL;
}
public int getSoLuong() {
	return SoLuong;
}
public void setSoLuong(int soLuong) {
	SoLuong = soLuong;
}
public int getThang() {
	return Thang;
}
public void setThang(int thang) {
	Thang = thang;
}
public int getNam() {
	return Nam;
}
public void setNam(int nam) {
	Nam = nam;
}
public Set<CT_BCTheoTheLoaiModel> getCt_bctheotheloai() {
	return ct_bctheotheloai;
}
public void setCt_bctheotheloai(Set<CT_BCTheoTheLoaiModel> ct_bctheotheloai) {
	this.ct_bctheotheloai = ct_bctheotheloai;
} 
   

}
