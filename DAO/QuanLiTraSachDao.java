package DAO;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import Model.CT_PhieuTraModel;
import Model.DocGiaModel;
import Model.PhieuMuonModel;
import Model.PhieuTraModel;
import Model.SachModel;
import Util.HibernateUtil;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

public class QuanLiTraSachDao {
  public static QuanLiTraSachDao getinstance() {
	  return new QuanLiTraSachDao();
  }
  
//  public List<Object[]> SachDangMuon(int maDocGia){
//	// Open Hibernate session
//	  Session session = HibernateUtil.getSessionFactory().openSession();
//
//
//	//Tạo CriteriaBuilder
//	  CriteriaBuilder cb = session.getCriteriaBuilder();
//
//	  // Tạo CriteriaQuery
//	  CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
//
//	  // Xác định các root
//	  Root<PhieuMuonModel> pmRoot = cq.from(PhieuMuonModel.class);
//	  Join<PhieuMuonModel, DocGiaModel> dgJoin = pmRoot.join("MaDocGia");
//	  Join<PhieuMuonModel, SachModel> sachJoin = pmRoot.join("DSsach");
//
//	  // Tạo subquery để tìm ngày mượn mới nhất của mỗi quyển sách
//	  Subquery<Date> subquery = cq.subquery(Date.class);
//	  Root<PhieuMuonModel> subPmRoot = subquery.from(PhieuMuonModel.class);
//	  Join<PhieuMuonModel, SachModel> subSachJoin = subPmRoot.join("DSsach");
//	  subquery.select(cb.greatest(subPmRoot.get("NgayMuon")))
//	          .where(cb.equal(subSachJoin.get("MaSach"), sachJoin.get("MaSach")),
//	                  cb.equal(subPmRoot.get("MaDocGia").get("MaDG"), maDocGia),
//	                  cb.equal(sachJoin.get("TinhTrang"), "Đang mượn"));
//	  // Tạo truy vấn chính
//	  cq.multiselect(
//	          sachJoin.get("MaSach"),
//	          pmRoot.get("NgayMuon")
//	  ).where(cb.equal(dgJoin.get("MaDG"), maDocGia),
//	          cb.equal(sachJoin.get("TinhTrang"), "Đang mượn"),
//	          cb.equal(pmRoot.get("NgayMuon"), subquery)).groupBy(
//	                    sachJoin.get("MaSach"),pmRoot.get("NgayMuon"));
//
//	  List<Object[]> results = session.createQuery(cq).getResultList();
//	  session.close();
//
//	  return results;
//
//  }
  
  /// Mới sửa chạy ko đc xóa
  public List<Object[]> SachDangMuon(int maDocGia){
		// Open Hibernate session
		  Session session = HibernateUtil.getSessionFactory().openSession();


		//Tạo CriteriaBuilder
		  CriteriaBuilder cb = session.getCriteriaBuilder();

		  // Tạo CriteriaQuery
		  CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		  // Xác định các root
		  Root<PhieuMuonModel> pmRoot = cq.from(PhieuMuonModel.class);
		  Join<PhieuMuonModel, DocGiaModel> dgJoin = pmRoot.join("MaDocGia");
		  Join<PhieuMuonModel, SachModel> sachJoin = pmRoot.join("DSsach");

		  // Tạo subquery để tìm ngày mượn mới nhất của mỗi quyển sách
		  Subquery<Date> subquery = cq.subquery(Date.class);
		  Root<PhieuMuonModel> subPmRoot = subquery.from(PhieuMuonModel.class);
		  Join<PhieuMuonModel, SachModel> subSachJoin = subPmRoot.join("DSsach");
		  subquery.select(cb.greatest(subPmRoot.get("NgayMuon")))
		          .where(cb.equal(subSachJoin.get("MaSach"), sachJoin.get("MaSach")),
		                  cb.equal(subPmRoot.get("MaDocGia").get("MaDG"), maDocGia),
		                  cb.equal(sachJoin.get("TinhTrang"), "Đang mượn"+String.valueOf(maDocGia)));
		  // Tạo truy vấn chính
		  cq.multiselect(
		          sachJoin.get("MaSach"),
		          pmRoot.get("NgayMuon")
		  ).where(cb.equal(dgJoin.get("MaDG"), maDocGia),
		          cb.equal(sachJoin.get("TinhTrang"), "Đang mượn"+String.valueOf(maDocGia)),
		          cb.equal(pmRoot.get("NgayMuon"), subquery)).groupBy(
		                    sachJoin.get("MaSach"),pmRoot.get("NgayMuon"));

		  List<Object[]> results = session.createQuery(cq).getResultList();
		  session.close();

		  return results;

	  }
  public void InsertPhieuMuon(PhieuTraModel pt, Set<CT_PhieuTraModel> list ) {
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  
      session.getTransaction().begin();
      session.save(pt);
      for (CT_PhieuTraModel i : list) {
		  i.setMaPhieuTra(pt);
		  session.save(i);
	  }
      session.getTransaction().commit();
      
      session.close();
  }
  public List<Object[]> Timkiemtheomaphieutra(String ma) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<PhieuTraModel> phieumuonRoot = criteria.from(PhieuTraModel.class);
		Join<DocGiaModel,PhieuTraModel> docGiaJoin = phieumuonRoot.join("MaDocGia");
		criteria.where(builder.equal(phieumuonRoot.get("MaPhieuTra").as(String.class),ma));
      criteria.select(builder.array(
      	    phieumuonRoot.get("MaPhieuTra"),
      	    docGiaJoin.get("MaDG"),
      	    phieumuonRoot.get("NgayTra"),
      	    phieumuonRoot.get("TienPhatKiNay")
      	   
      	));
		
      
		List<Object[]> results = session.createQuery(criteria).getResultList();
		session.close();
		return results;
	} 
  public List<Object[]> Timkiemtheomadg(String ma) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<PhieuTraModel> phieumuonRoot = criteria.from(PhieuTraModel.class);
		Join<DocGiaModel,PhieuTraModel> docGiaJoin = phieumuonRoot.join("MaDocGia");
		criteria.where(builder.equal(phieumuonRoot.get("MaDocGia").as(String.class),ma));
    criteria.select(builder.array(
    	    phieumuonRoot.get("MaPhieuTra"),
    	    docGiaJoin.get("MaDG"),
    	    phieumuonRoot.get("NgayTra"),
    	    phieumuonRoot.get("TienPhatKiNay")
    	   
    	));
		

		List<Object[]> results = session.createQuery(criteria).getResultList();
		session.close();
		return results;
	} 
  public List<Object[]> LayPhieuTra() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<PhieuTraModel> phieumuonRoot = criteria.from(PhieuTraModel.class);
		Join<DocGiaModel,PhieuTraModel> docGiaJoin = phieumuonRoot.join("MaDocGia");
		
      criteria.select(builder.array(
      	    phieumuonRoot.get("MaPhieuTra"),
      	    docGiaJoin.get("MaDG"),
      	    phieumuonRoot.get("NgayTra"),
      	    phieumuonRoot.get("TienPhatKiNay")
      	   
      	));
		

		List<Object[]> results = session.createQuery(criteria).getResultList();
		session.close();
		return results;
	}
}




