package DAO;

import java.util.List;

import org.hibernate.Session;

import Model.SachModel;
import Model.TacGiaModel;
import Model.TheLoaiModel;
import Util.HibernateUtil;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

public class ThemSachDao {

public static ThemSachDao getinstance()
	{
		return new ThemSachDao();
	}
	
public List<Object[]> selectAll() {
		
	Session session = HibernateUtil.getSessionFactory().openSession();
	CriteriaBuilder builder = session.getCriteriaBuilder();

	
	CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	Root<SachModel> sachRoot = criteria.from(SachModel.class);
	Join<SachModel, TheLoaiModel> theLoaiJoin = sachRoot.join("MaTheLoai");
	Join<SachModel, TacGiaModel> tacGiaJoin = sachRoot.join("MaTacGia");
	criteria.where(builder.equal(sachRoot.get("TinhTrang"),"Có sẵn"));
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
//public void update(int ma) {
//	Session session = HibernateUtil.getSessionFactory().openSession();
//  
//
//    Query q = session.createQuery("UPDATE SachModel S SET S.TinhTrang=:tinhtrang WHERE S.MaSach=:masach");
//             
//        q.setParameter("tinhtrang","Đang mượn");
//        q.setParameter("masach",ma);
//       
//        session.getTransaction().begin();
//        q.executeUpdate();           
//        session.getTransaction().commit();
//        session.close();
//        
//
//}

/// Mới sửa chạy ko đc xóa
public void update(int ma,String manum) {
	Session session = HibernateUtil.getSessionFactory().openSession();
  

    Query q = session.createQuery("UPDATE SachModel S SET S.TinhTrang=:tinhtrang WHERE S.MaSach=:masach");
             
        q.setParameter("tinhtrang","Đang mượn"+manum);
        q.setParameter("masach",ma);
       
        session.getTransaction().begin();
        q.executeUpdate();           
        session.getTransaction().commit();
        session.close();
        

}

public void updatetra(int ma) {
	Session session = HibernateUtil.getSessionFactory().openSession();
  

    Query q = session.createQuery("UPDATE SachModel S SET S.TinhTrang=:tinhtrang WHERE S.MaSach=:masach");
             
        q.setParameter("tinhtrang","Có sẵn");
        q.setParameter("masach",ma);
       
        session.getTransaction().begin();
        q.executeUpdate();           
        session.getTransaction().commit();   
        session.close();

}
public void UpdateGiatien(int Tien,int ma) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	  

    Query q = session.createQuery("UPDATE DocGiaModel DG SET DG.TongNo=:tongno WHERE DG.MaDG=:madg");
             
        q.setParameter("tongno",Tien);
        q.setParameter("madg",ma);
       
        session.getTransaction().begin();
        q.executeUpdate();           
        session.getTransaction().commit();
        session.close();
}
}
