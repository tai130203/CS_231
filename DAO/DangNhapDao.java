package DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Model.NhanVienModel;
import Model.SachModel;
import Model.TaiKhoaModel;
import Util.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class DangNhapDao {

	public static DangNhapDao getinstance()
	{
		return new DangNhapDao();
	}
	
	public TaiKhoaModel CheckDangNhap(String TenDn, String MaDn ) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<TaiKhoaModel> criteria = builder.createQuery(TaiKhoaModel.class);
//     
//		Root<TaiKhoaModel> adminRoot = criteria.from(TaiKhoaModel.class);
//        criteria.select(adminRoot).where(builder.equal(adminRoot.get("UserName"),TenDn),
//        		                         builder.equal(adminRoot.get("PassWord"),MaDn));
//       
//        TaiKhoaModel results = session.createQuery(criteria).getSingleResult();
//        return results;
   
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        CriteriaBuilder builder = session.getCriteriaBuilder();
	        CriteriaQuery<TaiKhoaModel> criteria = builder.createQuery(TaiKhoaModel.class);
	        Root<TaiKhoaModel> adminRoot = criteria.from(TaiKhoaModel.class);

	        criteria.select(adminRoot)
	                .where(builder.equal(adminRoot.get("UserName"), TenDn),
	                       builder.equal(adminRoot.get("PassWord"), MaDn));

	        Query<TaiKhoaModel> query = session.createQuery(criteria);
	        return query.uniqueResultOptional().orElse(null);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; // Hoặc xử lý ngoại lệ theo ý muốn của bạn
	    }
	}
       
}
