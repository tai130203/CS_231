package DAO;


import java.sql.Connection;




import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.persister.collection.mutation.RowMutationOperations.Restrictions;

import javax.swing.JButton;
import View.QuanLiSachView;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transaction;
import Model.DocGiaModel;
import Model.SachModel;
import Model.TacGiaModel;
import Model.TheLoaiModel;
import Util.HibernateUtil;

public class QuanLiSachDao {

	public static QuanLiSachDao getinstance()
	{
		return new QuanLiSachDao();
	}
	
	public void insert(SachModel t) {
		
		 Session session = HibernateUtil.getSessionFactory().openSession();
	            session.save(t);
	            session.close();
	        
	    }


	
	public void update(SachModel t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
      

        Query q = session.createQuery("UPDATE SachModel S SET S.TenSach=:tensach,S.MaTacGia=: matacgia,S.MaTheLoai=:matheloai,S.NhaXB=:nhaxb,S.NamXB=:namxb,"
        		+ "S.NgayNhap=:ngaynhap,S.TriGia=:trigia,S.TinhTrang=:tinhtrang WHERE S.MaSach=:masach");
                 
            q.setParameter("tensach",t.getTenSach());
            q.setParameter("matacgia",t.getMaTacGia());
            q.setParameter("matheloai",t.getMatheLoai());
            q.setParameter("nhaxb",t.getNhaxb());
            q.setParameter("namxb",t.getNamxb());
            q.setParameter("ngaynhap",t.getNgayNhap());
            q.setParameter("trigia",t.getTriGia());
            q.setParameter("tinhtrang",t.getTinhTrang());
            q.setParameter("masach",t.getMaSach());
            session.getTransaction().begin();
            q.executeUpdate();           
            session.getTransaction().commit();
            session.close();

	}

	
	public void delete(int x ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	      

        Query q = session.createQuery("DELETE FROM SachModel s WHERE s.MaSach=:masach");
        q.setParameter("masach",x );
        session.getTransaction().begin();
        q.executeUpdate();           
        session.getTransaction().commit();
        session.close();
	
	}

	
	public List<Object[]> selectAll() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<SachModel> sachRoot = criteria.from(SachModel.class);
		Join<SachModel, TheLoaiModel> theLoaiJoin = sachRoot.join("MaTheLoai");
		Join<SachModel, TacGiaModel> tacGiaJoin = sachRoot.join("MaTacGia");
		
        criteria.select(builder.array(
        	    sachRoot.get("MaSach"), 
        	    sachRoot.get("TenSach"),
        	    tacGiaJoin.get("TenTacGia"),
        	    theLoaiJoin.get("TenTheLoai"),
        	    sachRoot.get("NhaXB"), 
        	    sachRoot.get("NamXB"),
        	    sachRoot.get("NgayNhap"),
        	    sachRoot.get("TriGia"),
        	    sachRoot.get("TinhTrang")
        	   
        	));
		

		List<Object[]> results = session.createQuery(criteria).getResultList();
		 session.close();
		return results;
	}

	
	public Object[] selectByID(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<SachModel> sachRoot = criteria.from(SachModel.class);
		Join<SachModel, TheLoaiModel> theLoaiJoin = sachRoot.join("MaTheLoai");
		Join<SachModel, TacGiaModel> tacGiaJoin = sachRoot.join("MaTacGia");
		criteria.where(builder.equal(sachRoot.get("MaSach"),id));
        criteria.select(builder.array(
        	    sachRoot.get("MaSach"), 
        	    sachRoot.get("TenSach"),
        	    tacGiaJoin.get("TenTacGia"),
        	    theLoaiJoin.get("TenTheLoai"),
        	    sachRoot.get("NhaXB"), 
        	    sachRoot.get("NamXB"),
        	    sachRoot.get("NgayNhap"),
        	    sachRoot.get("TriGia"),
        	    sachRoot.get("TinhTrang")
        	   
        	));
		

		Object[] results = session.createQuery(criteria).getSingleResult();
		 session.close();
		return results;
	}

	
	public ArrayList<SachModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}


	public SachModel LayThongTin(int ma) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<SachModel> criteria = builder.createQuery(SachModel.class);

	
		Root<SachModel> sachRoot = criteria.from(SachModel.class);
		Predicate condition = builder.equal(sachRoot.get("MaSach"), ma);
        criteria.where(condition);

		SachModel results = session.createQuery(criteria).getSingleResult();
		 session.close();
		return results;
	}

	
	public List<Object[]> selectByMa(String ma) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<SachModel> sachRoot = criteria.from(SachModel.class);
		Join<SachModel, TheLoaiModel> theLoaiJoin = sachRoot.join("MaTheLoai");
		Join<SachModel, TacGiaModel> tacGiaJoin = sachRoot.join("MaTacGia");
		criteria.where(builder.like(sachRoot.get("MaSach").as(String.class),ma+"%"));
        criteria.select(builder.array(
        	    sachRoot.get("MaSach"), 
        	    sachRoot.get("TenSach"),
        	    tacGiaJoin.get("TenTacGia"),
        	    theLoaiJoin.get("TenTheLoai"),
        	    sachRoot.get("NhaXB"), 
        	    sachRoot.get("NamXB"),
        	    sachRoot.get("NgayNhap"),
        	    sachRoot.get("TriGia"),
        	    sachRoot.get("TinhTrang")
        	   
        	));
		

		List<Object[]> results = session.createQuery(criteria).getResultList();
		 session.close();
		return results;
	}

	
	public List<Object[]> selectByTenSach(String ma) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//
//		
//		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
//
//	
//		Root<SachModel> sachRoot = criteria.from(SachModel.class);
//		Join<SachModel, TheLoaiModel> theLoaiJoin = sachRoot.join("MaTheLoai");
//		Join<SachModel, TacGiaModel> tacGiaJoin = sachRoot.join("MaTacGia");
//		criteria.where(builder.like(sachRoot.get("TenSach").as(String.class),"%"+ma+"%"));
//        criteria.select(builder.array(
//        	    sachRoot.get("MaSach"), 
//        	    sachRoot.get("TenSach"),
//        	    tacGiaJoin.get("TenTacGia"),
//        	    theLoaiJoin.get("TenTheLoai"),
//        	    sachRoot.get("NhaXB"), 
//        	    sachRoot.get("NamXB"),
//        	    sachRoot.get("NgayNhap"),
//        	    sachRoot.get("TriGia"),
//        	    sachRoot.get("TinhTrang")
//        	   
//        	));
//		
//
//		List<Object[]> results = session.createQuery(criteria).getResultList();
//		 session.close();
//		return results;
		List<Object[]> SachList = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM SachModel sach WHERE sach.TenSach LIKE :tenSach";
            Query query = session.createQuery(hql);
            query.setParameter("tenSach", "%" + ma + "%");
            List<SachModel> results = query.getResultList();

            for (SachModel sach : results) {
                SachList.add(new Object[]{
                    sach.getMaSach(),
                    sach.getTenSach(),
                    sach.getMaTacGia().getTenTacGia(),
                    sach.getMatheLoai().getTenTheLoai(),
                    sach.getNhaXB(),
                    sach.getNamXB(),
                    sach.getNgayNhap(),
                    sach.getTriGia(),
                    sach.getTinhTrang(),
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
       // System.out.println("selectByHoTenDG results: " + docGiaList);
        return SachList;
		
	}

	
	public List<Object[]> selectByTenTg(String ma) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//
//		
//		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
//
//	
//		Root<SachModel> sachRoot = criteria.from(SachModel.class);
//		Join<SachModel, TheLoaiModel> theLoaiJoin = sachRoot.join("MaTheLoai");
//		Join<SachModel, TacGiaModel> tacGiaJoin = sachRoot.join("MaTacGia");
//		criteria.where(builder.like(tacGiaJoin.get("TenTacGia").as(String.class),"%"+ma+"%"));
//        criteria.select(builder.array(
//        	    sachRoot.get("MaSach"), 
//        	    sachRoot.get("TenSach"),
//        	    tacGiaJoin.get("TenTacGia"),
//        	    theLoaiJoin.get("TenTheLoai"),
//        	    sachRoot.get("NhaXB"), 
//        	    sachRoot.get("NamXB"),
//        	    sachRoot.get("NgayNhap"),
//        	    sachRoot.get("TriGia"),
//        	    sachRoot.get("TinhTrang")
//        	   
//        	));
//		
//
//		List<Object[]> results = session.createQuery(criteria).getResultList();
//		 session.close();
//		return results;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select s.MaSach, s.TenSach, tg.TenTacGia, tl.TenTheLoai, s.NhaXB, s.NamXB, s.NgayNhap, s.TriGia, s.TinhTrang "
		           + "from SachModel s "
		           + "inner join s.MaTacGia tg "
		           + "inner join s.MaTheLoai tl "
		           + "where tg.TenTacGia like :tenTacGia";

		List<Object[]> results = session.createQuery(hql)
		        .setParameter("tenTacGia", "%" + ma + "%")
		        .getResultList();

		session.close();
		return results;
	}

	
	public List<Object[]> selectByTheLoai(String ma) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<SachModel> sachRoot = criteria.from(SachModel.class);
		Join<SachModel, TheLoaiModel> theLoaiJoin = sachRoot.join("MaTheLoai");
		Join<SachModel, TacGiaModel> tacGiaJoin = sachRoot.join("MaTacGia");
		criteria.where(builder.like(theLoaiJoin.get("TenTheLoai").as(String.class),ma+"%"));
        criteria.select(builder.array(
        	    sachRoot.get("MaSach"), 
        	    sachRoot.get("TenSach"),
        	    tacGiaJoin.get("TenTacGia"),
        	    theLoaiJoin.get("TenTheLoai"),
        	    sachRoot.get("NhaXB"), 
        	    sachRoot.get("NamXB"),
        	    sachRoot.get("NgayNhap"),
        	    sachRoot.get("TriGia"),
        	    sachRoot.get("TinhTrang")
        	   
        	));
		

		List<Object[]> results = session.createQuery(criteria).getResultList();
		 session.close();
		return results;
	}
	
}

	

