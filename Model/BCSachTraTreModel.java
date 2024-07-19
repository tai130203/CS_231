package Model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="BCSACHTRATRE")
public class BCSachTraTreModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int MaBCTraTre;
  private LocalDate NgayLapBC;
  @OneToMany(mappedBy = "bcSachTraTre")
  Set<CT_BCSachTraTreModel> ct_bctheotheloai;
  
  
public BCSachTraTreModel( LocalDate ngayLapBC, Set<CT_BCSachTraTreModel> ct_bctheotheloai) {
	
	NgayLapBC = ngayLapBC;
	this.ct_bctheotheloai = ct_bctheotheloai;
}
public BCSachTraTreModel() {
	super();
}
public int getMaBCTraTre() {
	return MaBCTraTre;
}
public void setMaBCTraTre(int maBCTraTre) {
	MaBCTraTre = maBCTraTre;
}
public LocalDate getNgayLapBC() {
	return NgayLapBC;
}
public void setNgayLapBC(LocalDate ngayLapBC) {
	NgayLapBC = ngayLapBC;
}
public Set<CT_BCSachTraTreModel> getCt_bctheotheloai() {
	return ct_bctheotheloai;
}
public void setCt_bctheotheloai(Set<CT_BCSachTraTreModel> ct_bctheotheloai) {
	this.ct_bctheotheloai = ct_bctheotheloai;
}
  
}
