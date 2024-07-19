package DAO;

import java.util.ArrayList;
import java.util.List;

import Model.SachModel;

public interface DaoSachInterface <T>{
    public void insert(T t);
    public void update(T t);
    public void delete(int x);
    public List<Object[]> selectAll();
    public Object[] selectByID(int id);
    public ArrayList<T> selectByCondition(String condition);
	SachModel LayThongTin(String ma);
	List<Object[]> selectByMa(String ma);
	List<Object[]> selectByTenSach(String ma);
	List<Object[]> selectByTenTg(String ma);
	List<Object[]> selectByTheLoai(String ma);
	
}
