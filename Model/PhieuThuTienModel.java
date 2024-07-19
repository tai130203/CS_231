package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PHIEUTHUTIEN")
public class PhieuThuTienModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int MaPhieuThu;
 private int SoTienThu;
 private int TongNo;
 private int ConLai;
 @ManyToOne
 @JoinColumn(name="MaDocGia")
 private DocGiaModel MaDocGia;
public int getMaPhieuThu() {
	return MaPhieuThu;
}
public void setMaPhieuThu(int maPhieuThu) {
	MaPhieuThu = maPhieuThu;
}
public int getSoTienThu() {
	return SoTienThu;
}
public void setSoTienThu(int soTienThu) {
	SoTienThu = soTienThu;
}
public int getTongNo() {
	return TongNo;
}
public void setTongNo(int tongNo) {
	TongNo = tongNo;
}
public int getConLai() {
	return ConLai;
}
public void setConLai(int conLai) {
	ConLai = conLai;
}
public DocGiaModel getMaDocGia() {
	return MaDocGia;
}
public void setMaDocGia(DocGiaModel maDocGia) {
	MaDocGia = maDocGia;
}
public PhieuThuTienModel() {
	super();
}
public PhieuThuTienModel(int soTienThu, int tongNo, int conLai, DocGiaModel maDocGia) {
	SoTienThu = soTienThu;
	TongNo = tongNo;
	ConLai = conLai;
	MaDocGia = maDocGia;
}
}
