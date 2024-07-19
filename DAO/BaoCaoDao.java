package DAO;

import java.sql.Date;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import Model.BCSachTraTreModel;
import Model.BCTheoTheLoaiModel;
import Model.CT_BCSachTraTreModel;
import Model.CT_BCTheoTheLoaiModel;
import Model.CT_PhieuTraModel;
import Model.DocGiaModel;
import Model.PhieuMuonModel;
import Model.PhieuTraModel;
import Model.SachModel;
import Model.TheLoaiModel;
import Util.HibernateUtil;
import View.BaoCaoView;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

public class BaoCaoDao {
   public static BaoCaoDao getinstance() {
	   return new BaoCaoDao();
   }
   
   public List<Object[]> BCTheoTheLoai(int specificMonth,int specificYear ) {
	   Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<PhieuMuonModel> pmroot = criteria.from(PhieuMuonModel.class);
        Join<PhieuMuonModel, SachModel> sachJoin = pmroot.join("DSsach");
        Join<SachModel, TheLoaiModel> theLoaiJoin = sachJoin.join("MaTheLoai");

        criteria.multiselect(theLoaiJoin.get("MaTheLoai"),theLoaiJoin.get("TenTheLoai"), builder.count(sachJoin))
             .where(builder.equal(builder.function("month", Integer.class, pmroot.get("NgayMuon")), specificMonth),
                     builder.equal(builder.function("year", Integer.class, pmroot.get("NgayMuon")), specificYear))
             .groupBy(theLoaiJoin.get("MaTheLoai"),theLoaiJoin.get("TenTheLoai"));
		

		List<Object[]> results = session.createQuery(criteria).getResultList();
		 session.close();
		return results;
   }
   
   public void InsertBCTheoTL(BCTheoTheLoaiModel bcttl, Set<CT_BCTheoTheLoaiModel> list ) {
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  
	      session.getTransaction().begin();
	      session.save(bcttl);
	      for (CT_BCTheoTheLoaiModel i : list) {
			  i.setMaBCTheoTL(bcttl);
			  session.save(i);
		  }
	      session.getTransaction().commit();
	      
	      session.close();
	  }
   
   
   public void InsertBCSachTraTre(BCSachTraTreModel bcsachtratre, Set<CT_BCSachTraTreModel> list ) {
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  
	      session.getTransaction().begin();
	      session.save(bcsachtratre);
	      for (CT_BCSachTraTreModel i : list) {
			  i.setMaBCTraTre(bcsachtratre);
			  session.save(i);
		  }
	      session.getTransaction().commit();
	      
	      session.close();
	  }

   
   public List<Object[]> findOverdueBooks(LocalDate specificDate, int DayMax) {
	


//	   Session session = HibernateUtil.getSessionFactory().openSession();
//
//	   String hql = "SELECT s.MaSach, s.TenSach, pm.NgayMuon " +
//	                "FROM PhieuMuonModel pm " +
//	                "JOIN pm.DSsach s " +
//	                "WHERE s.TinhTrang = 'Đang mượn' " +
//	                "AND pm.NgayMuon = (SELECT MAX(pm2.NgayMuon) " +
//	                "                   FROM PhieuMuonModel pm2 " +
//	                "                   JOIN pm2.DSsach s2 " +
//	                "                   WHERE s2.MaSach = s.MaSach " +
//	                "                   AND s2.TinhTrang = 'Đang mượn') " +
//	                "AND pm.NgayMuon < :specificDate " +
//	                "AND DATEDIFF(DAY, pm.NgayMuon, :specificDate) > :DayMax";
//
//	   Query query = session.createQuery(hql);
//	   query.setParameter("specificDate", specificDate);
//
//	   List<Object[]> results = query.getResultList();
//	   session.close();
//	return results;
	   
	   Session session = HibernateUtil.getSessionFactory().openSession();

	   String sqlQuery = "SELECT s.MaSach, s.TenSach, pm.NgayMuon " +
	                     "FROM PhieuMuon pm " +
	                     "JOIN CT_PHIEUMUON ct ON pm.MaPhieuMuon = ct.MaPhieuMuon " +
	                     "JOIN Sach s ON s.MaSach = ct.MaSach " +
	                     "WHERE s.TinhTrang Like N'Đang mượn%' " +
	                     "AND pm.NgayMuon = (SELECT MAX(pm2.NgayMuon) " +
	                                        "FROM PhieuMuon pm2 " +
	                                        "JOIN CT_PHIEUMUON ct2 ON pm2.MaPhieuMuon = ct2.MaPhieuMuon " +
	                                        "JOIN Sach s2 ON s2.MaSach = ct2.MaSach " +
	                                        "WHERE s2.MaSach = s.MaSach " +
	                                        "AND s2.TinhTrang Like N'Đang mượn%') " +
	                     "AND pm.NgayMuon < :specificDate " +
	                     "AND DATEDIFF(DAY, pm.NgayMuon, :specificDate) > :DayMax";

	   // Tạo query native SQL
	   Query<Object[]> query = session.createNativeQuery(sqlQuery);
               query.setParameter("specificDate", java.sql.Date.valueOf(specificDate));
               query.setParameter("DayMax", DayMax);

	   // Lấy kết quả của truy vấn
	   List<Object[]> results = query.getResultList();

	   session.close();
	   return results;
   }

}
