package DAO;

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
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import Model.DocGiaModel;
import Model.SachModel;
import Model.TacGiaModel;
import Model.TheLoaiModel;
import Util.HibernateUtil;

public class TheLoaiDao
{

	public static TheLoaiDao getinstance()
	{
		return new TheLoaiDao();
	}

	
	public void insert(TheLoaiModel t) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(t);
        session.close();
    

	}

	
	public void update(TheLoaiModel t) {

		Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("UPDATE TheLoaiModel t SET t.TenTheLoai=:tentheloai"
        		+" WHERE t.MaTheLoai=:matheloai");
                 
            q.setParameter("tentheloai",t.getTenTheLoai());
            q.setParameter("matheloai",t.getMaTheLoai());
            session.getTransaction().begin();
            q.executeUpdate();           
            session.getTransaction().commit();
            session.close();


	}

	
	public void delete(int x) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	      

        Query q = session.createQuery("DELETE FROM TheLoaiModel t WHERE t.MaTheLoai=:matheloai");
        q.setParameter("matheloai",x );
        session.getTransaction().begin();
        q.executeUpdate();           
        session.getTransaction().commit();
        session.close();
	}

	
	public List<Object[]> selectAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		Root<TheLoaiModel> theloaiRoot = criteria.from(TheLoaiModel.class);
		
     	// Chọn thuộc tính tenTacGia từ bảng TacGiaModel
		criteria.select(builder.array(theloaiRoot.get("MaTheLoai"),theloaiRoot.get("TenTheLoai")));

		// Thực hiện truy vấn
		List<Object[]> TheLoaiList = session.createQuery(criteria).getResultList();
		 session.close();
		return TheLoaiList;
	}

	
	public TheLoaiModel selectByID(int id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<TheLoaiModel> criteria = builder.createQuery(TheLoaiModel.class);

	
		Root<TheLoaiModel> TLRoot = criteria.from(TheLoaiModel.class);
		
		criteria.select(TLRoot).where(builder.equal(TLRoot.get("MaTheLoai"), id));
        TheLoaiModel result = session.createQuery(criteria).getSingleResult();
        session.close();
		return result;
	}

	
	public ArrayList<TheLoaiModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public SachModel LayThongTin(String ma) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Object[]> selectByMa(String ma) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Object[]> selectByTenSach(String ma) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Object[]> selectByTenTg(String ma) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object[]> selectByTheLoai(String ma) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
