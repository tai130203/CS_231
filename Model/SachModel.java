package Model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="SACH")
public class SachModel {
   @Id //khóa chính
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int MaSach;
   private String TenSach;
   private String NhaXB;
   private int NamXB;
   private LocalDate NgayNhap;
   @ManyToOne
   @JoinColumn(name ="MaTacGia")
   private TacGiaModel MaTacGia;
   @ManyToOne
   @JoinColumn(name="MaTheLoai")
   private TheLoaiModel MaTheLoai;
   private String TriGia;
   @OneToMany(mappedBy = "MaSach")
   Set<CT_PhieuTraModel> ct_phieutra;
   private String TinhTrang;
   @ManyToMany(mappedBy = "DSsach")
   private Set<PhieuMuonModel> DSPhieuMuon = new HashSet<>();
   @OneToMany(mappedBy = "MaSach")
   private Set<CT_BCSachTraTreModel> ct_bcsachtratre;
   
   
  

public String getNhaXB() {
	return NhaXB;
}


public void setNhaXB(String nhaXB) {
	NhaXB = nhaXB;
}


public int getNamXB() {
	return NamXB;
}


public void setNamXB(int namXB) {
	NamXB = namXB;
}


public TheLoaiModel getMaTheLoai() {
	return MaTheLoai;
}


public void setMaTheLoai(TheLoaiModel maTheLoai) {
	MaTheLoai = maTheLoai;
}


public Set<CT_PhieuTraModel> getCt_phieutra() {
	return ct_phieutra;
}


public void setCt_phieutra(Set<CT_PhieuTraModel> ct_phieutra) {
	this.ct_phieutra = ct_phieutra;
}


public Set<PhieuMuonModel> getDSPhieuMuon() {
	return DSPhieuMuon;
}


public void setDSPhieuMuon(Set<PhieuMuonModel> dSPhieuMuon) {
	DSPhieuMuon = dSPhieuMuon;
}


public SachModel(int maSach, String tenSach) {
	super();
	MaSach = maSach;
	TenSach = tenSach;
}




public String getTinhTrang() {
	return TinhTrang;
}


public void setTinhTrang(String tinhTrang) {
	TinhTrang = tinhTrang;
}


public SachModel() {}


public int getMaSach() {
	return MaSach;
}


public void setMaSach(int maSach) {
	MaSach = maSach;
}


public String getTenSach() {
	return TenSach;
}


public SachModel(int maSach, String tenSach, String nhaXB, int namXB, LocalDate ngayNhap, TacGiaModel maTacGia,
		TheLoaiModel maTheLoai, String triGia, String tinhTrang) {
	super();
	MaSach = maSach;
	TenSach = tenSach;
	NhaXB = nhaXB;
	NamXB = namXB;
	NgayNhap = ngayNhap;
	MaTacGia = maTacGia;
	MaTheLoai = maTheLoai;
	TriGia = triGia;
	TinhTrang = tinhTrang;
}


public void setTenSach(String tenSach) {
	TenSach = tenSach;
}


public String getNhaxb() {
	return NhaXB;
}


public void setNhaxb(String nhaxb) {
	NhaXB = nhaxb;
}


public int getNamxb() {
	return NamXB;
}


public void setNamxb(int namxb) {
	NamXB = namxb;
}


public LocalDate getNgayNhap() {
	return NgayNhap;
}


public void setNgayNhap(LocalDate ngayNhap) {
	NgayNhap = ngayNhap;
}





public TheLoaiModel getMatheLoai() {
	return MaTheLoai;
}


public void setMatheLoai(TheLoaiModel matheLoai) {
	MaTheLoai = matheLoai;
}


public String getTriGia() {
	return TriGia;
}


public void setTriGia(String triGia) {
	TriGia = triGia;
}


public TacGiaModel getMaTacGia() {
	return MaTacGia;
}


public void setMaTacGia(TacGiaModel maTacGia) {
	MaTacGia = maTacGia;
}


public SachModel(String tenSach, String nhaXB, int namXB, LocalDate ngayNhap, TacGiaModel maTacGia,
	TheLoaiModel maTheLoai, String triGia, String tinhTrang) {

	TenSach = tenSach;
	NhaXB = nhaXB;
	NamXB = namXB;
	NgayNhap = ngayNhap;
	MaTacGia = maTacGia;
	MaTheLoai = maTheLoai;
	TriGia = triGia;
	TinhTrang = tinhTrang;
}

  








}




