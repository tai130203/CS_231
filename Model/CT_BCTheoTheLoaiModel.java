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
@Table(name="CT_BCTHEOTHELOAI")
public class CT_BCTheoTheLoaiModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaCTBaoCao;
	private long SoLuotMuon;
	private float TiLe;
    @ManyToOne
    @JoinColumn(name = "MaTheLoai")
    TheLoaiModel MaTheLoai;
    @ManyToOne
    @JoinColumn(name = "MaBCTheoTL")
    BCTheoTheLoaiModel MaBCTheoTL;
    
    
    public CT_BCTheoTheLoaiModel() {}
	public CT_BCTheoTheLoaiModel(long soLuotMuon, float tiLe, TheLoaiModel maTheLoai) {
		
		SoLuotMuon = soLuotMuon;
		TiLe = tiLe;
		MaTheLoai = maTheLoai;
	}
	public int getMaCTBaoCao() {
		return MaCTBaoCao;
	}
	public void setMaCTBaoCao(int maCTBaoCao) {
		MaCTBaoCao = maCTBaoCao;
	}
	public long getSoLuotMuon() {
		return SoLuotMuon;
	}
	public void setSoLuotMuon(long soLuotMuon) {
		SoLuotMuon = soLuotMuon;
	}
	public float getTiLe() {
		return TiLe;
	}
	public void setTiLe(float tiLe) {
		TiLe = tiLe;
	}
	public TheLoaiModel getMaTheLoai() {
		return MaTheLoai;
	}
	public void setMaTheLoai(TheLoaiModel maTheLoai) {
		MaTheLoai = maTheLoai;
	}
	public BCTheoTheLoaiModel getMaBCTheoTL() {
		return MaBCTheoTL;
	}
	public void setMaBCTheoTL(BCTheoTheLoaiModel maBCTheoTL) {
		MaBCTheoTL = maBCTheoTL;
	}
}
