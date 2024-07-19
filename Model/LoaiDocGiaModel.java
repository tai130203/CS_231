package Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="LOAIDOCGIA")
public class LoaiDocGiaModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int MaLoaiDocGia;
   private String TenLoaiDocGia;
   @OneToOne(mappedBy = "MaLoaiDocGia",cascade = CascadeType.ALL)
   private DocGiaModel MaDG;
   
   
public LoaiDocGiaModel(String tenLoaiDocGia, DocGiaModel maDG) {
	
	TenLoaiDocGia = tenLoaiDocGia;
	MaDG = maDG;
}
public LoaiDocGiaModel() {
	
}
public LoaiDocGiaModel(int maLoaiDocGia, String tenLoaiDocGia) {
	super();
	MaLoaiDocGia = maLoaiDocGia;
	TenLoaiDocGia = tenLoaiDocGia;
}
public int getMaLoaiDocGia() {
	return MaLoaiDocGia;
}
public void setMaLoaiDocGia(int maLoaiDocGia) {
	MaLoaiDocGia = maLoaiDocGia;
}
public String getTenLoaiDocGia() {
	return TenLoaiDocGia;
}
public void setTenLoaiDocGia(String tenLoaiDocGia) {
	TenLoaiDocGia = tenLoaiDocGia;
}
public DocGiaModel getMaDG() {
	return MaDG;
}
public void setMaDG(DocGiaModel maDG) {
	MaDG = maDG;
}
   
}
