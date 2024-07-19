package Model;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "THAMSO")
public class QuyDinhModel {
	 @Id
	 private int id;
     public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int TuoiToiDa;
	 private int TuoiToiThieu;
     private int ThoiHanThe;
     private int ThoiHanNhanSach;
     private int DonGiaPhat;
     private int KiemTraSoTienThu;
     public QuyDinhModel() {
		
	}
	private int SoSachMuonToiDa;
     private int SoNgayMuonToiDa;
  
     
     public QuyDinhModel(int tuoiToiDa, int tuoiToiThieu, int thoiHanThe, int donGiaPhat, int kiemTraSoTienThu,
 			int soSachMuonToiDa, int soNgayMuonToiDa) {
 		super();
 		TuoiToiDa = tuoiToiDa;
 		TuoiToiThieu = tuoiToiThieu;
 		ThoiHanThe = thoiHanThe;
 		DonGiaPhat = donGiaPhat;
 		KiemTraSoTienThu = kiemTraSoTienThu;
 		SoSachMuonToiDa = soSachMuonToiDa;
 		SoNgayMuonToiDa = soNgayMuonToiDa;
 	}
	public int getTuoiToiDa() {
		return TuoiToiDa;
	}
	public void setTuoiToiDa(int tuoiToiDa) {
		TuoiToiDa = tuoiToiDa;
	}
	public int getTuoiToiThieu() {
		return TuoiToiThieu;
	}
	public void setTuoiToiThieu(int tuoiToiThieu) {
		TuoiToiThieu = tuoiToiThieu;
	}
	public int getThoiHanThe() {
		return ThoiHanThe;
	}
	public void setThoiHanThe(int thoiHanThe) {
		ThoiHanThe = thoiHanThe;
	}

	
	public int getThoiHanNhanSach() {
		return ThoiHanNhanSach;
	}
	public void setThoiHanNhanSach(int thoiHanNhanSach) {
		ThoiHanNhanSach = thoiHanNhanSach;
	}
	public QuyDinhModel(int thoiHanNhanSach) {
		ThoiHanNhanSach = thoiHanNhanSach;
	}
	public QuyDinhModel(int donGiaPhat, int kiemTraSoTienThu, int soSachMuonToiDa, int soNgayMuonToiDa) {
		super();
		DonGiaPhat = donGiaPhat;
		KiemTraSoTienThu = kiemTraSoTienThu;
		SoSachMuonToiDa = soSachMuonToiDa;
		SoNgayMuonToiDa = soNgayMuonToiDa;
	}
	public QuyDinhModel(int tuoiToiDa, int tuoiToiThieu, int thoiHanThe) {
		super();
		TuoiToiDa = tuoiToiDa;
		TuoiToiThieu = tuoiToiThieu;
		ThoiHanThe = thoiHanThe;
	}
	public int getDonGiaPhat() {
		return DonGiaPhat;
	}
	public void setDonGiaPhat(int donGiaPhat) {
		DonGiaPhat = donGiaPhat;
	}
	public int getKiemTraSoTienThu() {
		return KiemTraSoTienThu;
	}
	public void setKiemTraSoTienThu(int kiemTraSoTienThu) {
		KiemTraSoTienThu = kiemTraSoTienThu;
	}
	public int getSoSachMuonToiDa() {
		return SoSachMuonToiDa;
	}
	public void setSoSachMuonToiDa(int soSachMuonToiDa) {
		SoSachMuonToiDa = soSachMuonToiDa;
	}
	public int getSoNgayMuonToiDa() {
		return SoNgayMuonToiDa;
	}
	public void setSoNgayMuonToiDa(int soNgayMuonToiDa) {
		SoNgayMuonToiDa = soNgayMuonToiDa;
	}
     
	
	
}
