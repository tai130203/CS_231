package Model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TACGIA")
public class TacGiaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaTacGia;
	private String TenTacGia;
	@OneToMany(mappedBy = "MaTacGia")
	private Set<SachModel> sach;
	public Set<SachModel> getSach() {
		return sach;
	}

	public void setSach(Set<SachModel> sach) {
		this.sach = sach;
	}

	public TacGiaModel() {
		super();
	}
	
	public TacGiaModel(int maTacGia, String tenTacGia) {
		super();
		MaTacGia = maTacGia;
		TenTacGia = tenTacGia;
	}
	public int getMaTacGia() {
		return MaTacGia;
	}
	public void setMaTacGia(int maTacGia) {
		MaTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return TenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		TenTacGia = tenTacGia;
	}
	


}
