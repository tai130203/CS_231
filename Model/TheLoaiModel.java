package Model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "THELOAI")
public class TheLoaiModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int MaTheLoai;
   private String TenTheLoai;
   @OneToMany(mappedBy = "MaTheLoai")
   private Set<SachModel> sach;
   @OneToMany(mappedBy = "MaTheLoai")
   Set<CT_BCTheoTheLoaiModel> ct_bctheotheloai;

public Set<CT_BCTheoTheLoaiModel> getCt_bctheotheloai() {
	return ct_bctheotheloai;
}
public void setCt_bctheotheloai(Set<CT_BCTheoTheLoaiModel> ct_bctheotheloai) {
	this.ct_bctheotheloai = ct_bctheotheloai;
}
public TheLoaiModel(String tenTheLoai) {
	super();
	TenTheLoai = tenTheLoai;
}
public Set<SachModel> getSach() {
	return sach;
}
public void setSach(Set<SachModel> sach) {
	this.sach = sach;
}
public int getMaTheLoai() {
	return MaTheLoai;
}
public void setMaTheLoai(int maTheLoai) {
	MaTheLoai = maTheLoai;
}
public String getTenTheLoai() {
	return TenTheLoai;
}
public void setTenTheLoai(String tenTheLoai) {
	TenTheLoai = tenTheLoai;
}
public TheLoaiModel(int maTheLoai, String tenTheLoai) {
	super();
	MaTheLoai = maTheLoai;
	TenTheLoai = tenTheLoai;
}
public TheLoaiModel() {
	super();
}
 
}
