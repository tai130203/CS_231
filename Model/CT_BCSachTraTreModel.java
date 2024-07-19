package Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CT_BCSACHTRATRE")
public class CT_BCSachTraTreModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int MaCT_BCsachTraTre;
   private int SoNgayTraTre;
   @ManyToOne
   @JoinColumn(name="MaBCTraTre")
   BCSachTraTreModel bcSachTraTre;
   @ManyToOne
   @JoinColumn(name="MaSach")
   SachModel MaSach;
 
public CT_BCSachTraTreModel() {
	
}
public CT_BCSachTraTreModel( int soNgayTraTre, SachModel maSach,
		LocalDate ngayMuon) {

	SoNgayTraTre = soNgayTraTre;
	MaSach = maSach;
	NgayMuon = ngayMuon;
}
public int getMaCT_BCsachTraTre() {
	return MaCT_BCsachTraTre;
}
public void setMaCT_BCsachTraTre(int maCT_BCsachTraTre) {
	MaCT_BCsachTraTre = maCT_BCsachTraTre;
}
public int getSoNgayTraTre() {
	return SoNgayTraTre;
}
public void setSoNgayTraTre(int soNgayTraTre) {
	SoNgayTraTre = soNgayTraTre;
}
public BCSachTraTreModel getMaBCTraTre() {
	return bcSachTraTre;
}
public void setMaBCTraTre(BCSachTraTreModel maBCTraTre) {
	bcSachTraTre = maBCTraTre;
}
public SachModel getMaSach() {
	return MaSach;
}
public void setMaSach(SachModel maSach) {
	MaSach = maSach;
}
public LocalDate getNgayMuon() {
	return NgayMuon;
}
public void setNgayMuon(LocalDate ngayMuon) {
	NgayMuon = ngayMuon;
}
private LocalDate NgayMuon;
}
