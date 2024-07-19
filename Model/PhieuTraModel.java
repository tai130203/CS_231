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
@Table(name="PHIEUTRA")
public class PhieuTraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaPhieuTra;
    @ManyToOne
    @JoinColumn(name="MaDocGia")
    private DocGiaModel MaDocGia;
    private LocalDate NgayTra;
    private int TienPhatKiNay;
    
    @OneToMany(mappedBy = "MaPhieuTra") 
    Set<CT_PhieuTraModel> ct_phieutra;
    
    
    public PhieuTraModel() {}
	public Set<CT_PhieuTraModel> getCt_phieutra() {
		return ct_phieutra;
	}
	
	public void setCt_phieutra(Set<CT_PhieuTraModel> ct_phieutra) {
		this.ct_phieutra = ct_phieutra;
	}
	public int getMaPhieuTra() {
		return MaPhieuTra;
	}
	public void setMaPhieuTra(int maPhieuTra) {
		MaPhieuTra = maPhieuTra;
	}
	public DocGiaModel getMaDocGia() {
		return MaDocGia;
	}
	public void setMaDocGia(DocGiaModel maDocGia) {
		MaDocGia = maDocGia;
	}
	public LocalDate getNgayTra() {
		return NgayTra;
	}
	public void setNgayTra(LocalDate ngayTra) {
		NgayTra = ngayTra;
	}
	public int getTienPhatKiNay() {
		return TienPhatKiNay;
	}
	public void setTienPhatKiNay(int tienPhatKiNay) {
		TienPhatKiNay = tienPhatKiNay;
	}
	
    public PhieuTraModel(DocGiaModel maDocGia, LocalDate ngayTra, int tienPhatKiNay,
			Set<CT_PhieuTraModel> ct_phieutra) {
		super();
		MaDocGia = maDocGia;
		NgayTra = ngayTra;
		TienPhatKiNay = tienPhatKiNay;
		this.ct_phieutra = ct_phieutra;
	}
	public void addctpt(CT_PhieuTraModel ctp) {
    	this.ct_phieutra.add(ctp);
    }
}
    