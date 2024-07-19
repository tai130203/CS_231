package DAO;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Model.DocGiaModel;
import Model.PhieuMuonModel;
import Model.SachModel;
import Model.TacGiaModel;
import Model.TheLoaiModel;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class PhieuMuonDao {
	public static PhieuMuonDao getinstance()
	{
		return new PhieuMuonDao();
	}
	public void insert(Set<SachModel> t , DocGiaModel a, LocalDate formattedDate) {
		
		 Session session = HibernateUtil.getSessionFactory().openSession();
		        PhieuMuonModel p = new PhieuMuonModel();
		        
		        p.setNgayMuon(formattedDate);
		        
		        p.setMaDocGia(a);
		        for (SachModel i : t)
		        	p.addSach(i);
		        p.setSoLuong(t.size());
		        session.getTransaction().begin();
		        session.save(p);
		        session.getTransaction().commit();
	            
	     session.close();
	        
	    }
	public SachModel selectSach(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
         
		CriteriaQuery<SachModel> criteria = builder.createQuery(SachModel.class);
        Root<SachModel> DGRoot = criteria.from(SachModel.class);
        criteria.select(DGRoot).where(builder.equal(DGRoot.get("MaSach"), id));
        SachModel result = session.createQuery(criteria).getSingleResult();;
        session.close();
		return result;
	}
	
	public long TongSach(int id) {
//		LocalDate now = LocalDate.now();
//        LocalDate fourDaysAgo = now.minusDays(4);
//
//        // Mở phiên Hibernate
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        // Tạo CriteriaBuilder
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
//        Root<PhieuMuonModel> phieuMuon = cq.from(PhieuMuonModel.class);
//
//        // Thiết lập điều kiện truy vấn
//        cq.multiselect(cb.sum(phieuMuon.get("SoLuong")))
//          .where(
//              cb.and(
//                  cb.equal(phieuMuon.get("MaDocGia").get("MaDG"), id),
//                  cb.between(phieuMuon.get("NgayMuon"), fourDaysAgo, now)
//              )
//          );
//
//        // Thực hiện truy vấn và lấy kết quả
//        Integer result = session.createQuery(cq).getSingleResult();
//
//        // Đóng phiên Hibernate
//        session.getTransaction().commit();
//        session.close();
//
//        return  (result != null ? result : 0);
        
        LocalDate now = LocalDate.now();
        LocalDate fourDaysAgo = now.minusDays(4);

        Session session = null;
        Transaction transaction = null;
        Integer result = null;

        try {
            // Mở phiên Hibernate
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Tạo CriteriaBuilder
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
            Root<PhieuMuonModel> phieuMuon = cq.from(PhieuMuonModel.class);

            // Thiết lập điều kiện truy vấn
            cq.multiselect(cb.sum(phieuMuon.get("SoLuong")))
              .where(
                  cb.and(
                      cb.equal(phieuMuon.get("MaDocGia").get("MaDG"), id),
                      cb.between(phieuMuon.get("NgayMuon"), fourDaysAgo, now)
                  )
              );

            // Thực hiện truy vấn và lấy kết quả
            result = session.createQuery(cq).getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        // Trả về kết quả hoặc 0 nếu kết quả là null
        return (result != null ? result : 0);
    }
        
	public List<Object[]> LayPhieuMuon() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<PhieuMuonModel> phieumuonRoot = criteria.from(PhieuMuonModel.class);
		Join<DocGiaModel,PhieuMuonModel> docGiaJoin = phieumuonRoot.join("MaDocGia");
		
        criteria.select(builder.array(
        	    phieumuonRoot.get("MaPhieuMuon"),
        	    docGiaJoin.get("MaDG"),
        	    phieumuonRoot.get("NgayMuon")
        	   
        	));
		

		List<Object[]> results = session.createQuery(criteria).getResultList();
		 session.close();
		return results;
	}
	public List<Object[]> Timkiemtheomaphieu(String ma) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<PhieuMuonModel> phieumuonRoot = criteria.from(PhieuMuonModel.class);
		Join<DocGiaModel,PhieuMuonModel> docGiaJoin = phieumuonRoot.join("MaDocGia");
		criteria.where(builder.equal(phieumuonRoot.get("MaPhieuMuon").as(String.class),ma));
        criteria.select(builder.array(
        	    phieumuonRoot.get("MaPhieuMuon"),
        	    docGiaJoin.get("MaDG"),
        	    phieumuonRoot.get("NgayMuon")
        	   
        	));
		

		List<Object[]> results = session.createQuery(criteria).getResultList();
		 session.close();
		return results;
	} 
	public List<Object[]> Timkiemtheomadg(String ma) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<PhieuMuonModel> phieumuonRoot = criteria.from(PhieuMuonModel.class);
		Join<DocGiaModel,PhieuMuonModel> docGiaJoin = phieumuonRoot.join("MaDocGia");
		criteria.where(builder.equal(docGiaJoin.get("MaDG").as(String.class),ma));
        criteria.select(builder.array(
        	    phieumuonRoot.get("MaPhieuMuon"),
        	    docGiaJoin.get("MaDG"),
        	    phieumuonRoot.get("NgayMuon")
        	   
        	));
		

		List<Object[]> results = session.createQuery(criteria).getResultList();
		 session.close();
		return results;
	}
	public List<Integer> KiemTraDocGia(LocalDate specificDate,int DayMax ) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){

		   String sqlQuery = "SELECT pm.MaDG " +
		                     "FROM PHIEUMUON pm " +
		                     "JOIN CT_PHIEUMUON ct ON pm.MaPhieuMuon = ct.MaPhieuMuon " +
		                     "JOIN Sach s ON s.MaSach = ct.MaSach " +
		                     "WHERE s.TinhTrang like N'Đang mượn%' " +
		                     "AND pm.NgayMuon = (SELECT MAX(pm2.NgayMuon) " +
		                                        "FROM PhieuMuon pm2 " +
		                                        "JOIN CT_PHIEUMUON ct2 ON pm2.MaPhieuMuon = ct2.MaPhieuMuon " +
		                                        "JOIN Sach s2 ON s2.MaSach = ct2.MaSach " +
		                                        "WHERE s2.MaSach = s.MaSach " +
		                                        "AND s2.TinhTrang like N'Đang mượn%') " +
		                     "AND pm.NgayMuon < :specificDate " +
		                     "AND DATEDIFF(DAY, pm.NgayMuon, :specificDate) > :DayMax";

		   // Tạo query native SQL
		   Query<Integer> query = session.createNativeQuery(sqlQuery);
	               query.setParameter("specificDate", java.sql.Date.valueOf(specificDate));
	               query.setParameter("DayMax", DayMax);

		   // Lấy kết quả của truy vấn
		   List<Integer> results = query.getResultList();

		   session.close();
		   return results;
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return null;
		   
	}
}
