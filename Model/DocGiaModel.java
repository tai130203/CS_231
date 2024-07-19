package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="DOCGIA")
public class DocGiaModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int MaDG;
private String TenDG;
private  LocalDate NgaySinh;
private  String DiaChi;
private String Email;
private LocalDate NgayLap;
private int TongNo;
private LocalDate NgayHetHan;

@OneToOne
@JoinColumn(name="MaLoaiDocGia")
private LoaiDocGiaModel MaLoaiDocGia ;

@OneToOne
@JoinColumn(name="IdUser")
private TaiKhoaModel IdUser;


public TaiKhoaModel getIdUser() {
	return IdUser;
}
public void setIdUser(TaiKhoaModel idUser) {
	IdUser = idUser;
}
@OneToMany
@JoinColumn(name="MaPhieuMuon")
private List<PhieuMuonModel> dsphieu;

@OneToMany(mappedBy = "MaDocGia",cascade = CascadeType.ALL)
private List<PhieuThuTienModel> listphieuphat;


public DocGiaModel(int maDG, String tenDG, LocalDate ngaySinh, String diaChi, String email, LocalDate ngayLap,
		LocalDate ngayHetHan, LoaiDocGiaModel maLoaiDocGia) {
	MaDG = maDG;
	TenDG = tenDG;
	NgaySinh = ngaySinh;
	DiaChi = diaChi;
	Email = email;
	NgayLap = ngayLap;
	NgayHetHan = ngayHetHan;
	MaLoaiDocGia = maLoaiDocGia;
}
public List<PhieuMuonModel> getDsphieu() {
	return dsphieu;
}
public void setDsphieu(List<PhieuMuonModel> dsphieu) {
	this.dsphieu = dsphieu;
}

public int getMaDG() {
	return MaDG;
}
public void setMaDG(int maDG) {
	MaDG = maDG;
}
public String getTenDG() {
	return TenDG;
}
public void setTenDG(String tenDG) {
	TenDG = tenDG;
}
public LocalDate getNgaySinh() {
	return NgaySinh;
}
public void setNgaySinh(LocalDate ngaySinh) {
	NgaySinh = ngaySinh;
}
public String getDiaChi() {
	return DiaChi;
}
public void setDiaChi(String diaChi) {
	DiaChi = diaChi;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public LocalDate getNgayLap() {
	return NgayLap;
}
public void setNgayLap(LocalDate ngayLap) {
	NgayLap = ngayLap;
}
public int getTongNo() {
	return TongNo;
}
public void setTongNo(int tongNo) {
	TongNo = tongNo;
}
public DocGiaModel() {
	
}

public LocalDate getNgayHetHan() {
	return NgayHetHan;
}
public void setNgayHetHan(LocalDate ngayHetHan) {
	NgayHetHan = ngayHetHan;
}
public LoaiDocGiaModel getMaLoaiDocGia() {
	return MaLoaiDocGia;
}
public void setMaLoaiDocGia(LoaiDocGiaModel maLoaiDocGia) {
	MaLoaiDocGia = maLoaiDocGia;
}
public DocGiaModel(int maDG, String tenDG, LocalDate ngaySinh, String diaChi, String email, LocalDate ngayLap, int tongNo) {
	super();
	MaDG = maDG;
	TenDG = tenDG;
	NgaySinh = ngaySinh;
	DiaChi = diaChi;
	Email = email;
	NgayLap = ngayLap;
	TongNo = tongNo;
}
public DocGiaModel(String tenDG, LocalDate ngaySinh, String diaChi, String email, LocalDate ngayLap,
		LocalDate ngayHetHan, LoaiDocGiaModel maLoaiDocGia) {
	super();
	TenDG = tenDG;
	NgaySinh = ngaySinh;
	DiaChi = diaChi;
	Email = email;
	NgayLap = ngayLap;
	NgayHetHan = ngayHetHan;
	MaLoaiDocGia = maLoaiDocGia;
}
}
