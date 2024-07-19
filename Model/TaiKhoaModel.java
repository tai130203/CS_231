package Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TAIKHOAN")
public class TaiKhoaModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int IdUser;
 private String UserName;
 private String PassWord;
 private String TypeOfAcount;
 @OneToOne(mappedBy = "IdUser",cascade = CascadeType.ALL)
 private NhanVienModel admin;
 
 @OneToOne(mappedBy = "IdUser")
 private DocGiaModel docgia;
 
 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 @JoinTable(
     name = "TAIKHOAN_VAITRO",
     joinColumns = {@JoinColumn(name="IdUser")},
     inverseJoinColumns = {@JoinColumn(name="IdRole")}
 )
 private Set<VaiTroModel> roles = new HashSet<>();
public DocGiaModel getDocgia() {
	return docgia;
}
public void setDocgia(DocGiaModel docgia) {
	this.docgia = docgia;
}
public Set<VaiTroModel> getRoles() {
	return roles;
}
public void setRoles(Set<VaiTroModel> roles) {
	this.roles = roles;
}
public TaiKhoaModel(int idUser, String userName, String passWord, String typeOfAcount, NhanVienModel admin) {
	super();
	IdUser = idUser;
	UserName = userName;
	PassWord = passWord;
	TypeOfAcount = typeOfAcount;
	this.admin = admin;
}
public TaiKhoaModel() {
	super();
}
public int getIdUser() {
	return IdUser;
}
public void setIdUser(int idUser) {
	IdUser = idUser;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getPassWord() {
	return PassWord;
}
public void setPassWord(String passWord) {
	PassWord = passWord;
}
public String getTypeOfAcount() {
	return TypeOfAcount;
}
public void setTypeOfAcount(String typeOfAcount) {
	TypeOfAcount = typeOfAcount;
}
public NhanVienModel getAdmin() {
	return admin;
}
public void setAdmin(NhanVienModel admin) {
	this.admin = admin;
}
 
}
