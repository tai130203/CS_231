package DAO;



import Model.SachModel;
import Model.TacGiaModel;
import Model.TheLoaiModel;
import Util.HibernateUtil;

import java.sql.Connection;



import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import org.hibernate.Session;

import View.QuanLiSachView;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;



public class TacGiaDao implements DaoSachInterface<TacGiaModel> {


	public static TacGiaDao getinstance()
	{
		return new TacGiaDao();
	}

	@Override
	public void insert(TacGiaModel t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TacGiaModel t) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void delete(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object[]> selectAll() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		Root<TacGiaModel> tacgiaRoot = criteria.from(TacGiaModel.class);
		
     	// Chọn thuộc tính tenTacGia từ bảng TacGiaModel
		criteria.select(builder.array(tacgiaRoot.get("MaTacGia"),tacgiaRoot.get("TenTacGia")));

		// Thực hiện truy vấn
		List<Object[]> TacGiaList = session.createQuery(criteria).getResultList();
		session.close();
  return TacGiaList;

	}

	@Override
	public Object[] selectByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TacGiaModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SachModel LayThongTin(String ma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> selectByMa(String ma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> selectByTenSach(String ma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> selectByTenTg(String ma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> selectByTheLoai(String ma) {
		// TODO Auto-generated method stub
		return null;
	}


}
