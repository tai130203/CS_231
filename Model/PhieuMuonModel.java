package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PHIEUMUON")
public class PhieuMuonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaPhieuMuon;
    @ManyToOne
    @JoinColumn(name="MaDG")
    private DocGiaModel MaDocGia;
    private LocalDate NgayMuon;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
    		   name="CT_PHIEUMUON",
               joinColumns = {@JoinColumn(name="MaPhieuMuon")},
               inverseJoinColumns = {@JoinColumn(name="MaSach")}
    		)
    
    private Set<SachModel> DSsach = new HashSet<>();
    private int SoLuong;
    
  
    
    
    
	
	public int getMaPhieuMuon() {
		return MaPhieuMuon;
	}
	public void setMaPhieuMuon(int maPhieuMuon) {
		MaPhieuMuon = maPhieuMuon;
	}
	public DocGiaModel getMaDocGia() {
		return MaDocGia;
	}
	public void setMaDocGia(DocGiaModel maDocGia) {
		MaDocGia = maDocGia;
	}
	public LocalDate getNgayMuon() {
		return NgayMuon;
	}
	public void setNgayMuon(LocalDate ngayMuon) {
		NgayMuon = ngayMuon;
	}
	public Set<SachModel> getDSsach() {
		return DSsach;
	}
	public void setDSsach(Set<SachModel> dSsach) {
		DSsach = dSsach;
	}
	public PhieuMuonModel(DocGiaModel maDocGia, LocalDate ngayMuon, Set<SachModel> dSsach) {

		MaDocGia = maDocGia;
		NgayMuon = ngayMuon;
		DSsach = dSsach;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public PhieuMuonModel() {
		
	}
	public void addSach(SachModel s) {
		  this.DSsach.add(s);
	}
}