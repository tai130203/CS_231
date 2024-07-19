package Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="VAITRO")
public class VaiTroModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private int IdRole;
  @Column(name="ChucNang")
  private String Role;
  @ManyToMany(mappedBy = "roles")
  private Set<TaiKhoaModel> users = new HashSet<>();
public VaiTroModel(int idRole, String role, Set<TaiKhoaModel> users) {
	super();
	IdRole = idRole;
	Role = role;
	this.users = users;
}
public VaiTroModel() {
	super();
}
public int getIdRole() {
	return IdRole;
}
public void setIdRole(int idRole) {
	IdRole = idRole;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public Set<TaiKhoaModel> getUsers() {
	return users;
}
public void setUsers(Set<TaiKhoaModel> users) {
	this.users = users;
}
}
