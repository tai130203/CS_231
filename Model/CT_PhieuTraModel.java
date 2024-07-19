package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CT_PHIEUTRA")
public class CT_PhieuTraModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ID;
  private int SoNgayMuon;
  @ManyToOne
  @JoinColumn(name = "MaPhieuTra")
  PhieuTraModel MaPhieuTra;
  @ManyToOne
  @JoinColumn(name = "MaSach")
  SachModel MaSach;
  private int TienPhat;

public int getTienPhat() {
	return TienPhat;
}
public void setTienPhat(int tienPhat) {
	TienPhat = tienPhat;
}
public CT_PhieuTraModel() {}
public CT_PhieuTraModel( int soNgayMuon, SachModel maSach, int tienPhat) {
	SoNgayMuon = soNgayMuon;
	MaSach = maSach;
	TienPhat = tienPhat;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public int getSoNgayMuon() {
	return SoNgayMuon;
}
public void setSoNgayMuon(int soNgayMuon) {
	SoNgayMuon = soNgayMuon;
}
public PhieuTraModel getMaPhieuTra() {
	return MaPhieuTra;
}
public void setMaPhieuTra(PhieuTraModel maPhieuTra) {
	MaPhieuTra = maPhieuTra;
}
public SachModel getMaSach() {
	return MaSach;
}
public void setMaSach(SachModel maSach) {
	MaSach = maSach;
}
}
