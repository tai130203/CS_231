package DAO;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Model.CT_PhieuTraModel;
import Model.DocGiaModel;
import Model.LoaiDocGiaModel;
import Model.PhieuThuTienModel;
import Model.PhieuTraModel;
import Model.SachModel;
import Model.TacGiaModel;
import Model.TheLoaiModel;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transaction;

public class DocGiaDao {
	public static DocGiaDao getinstance()
	{
		return new DocGiaDao();
	}
	
	public Object[] selectByID(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<DocGiaModel> DGRoot = criteria.from(DocGiaModel.class);
		
		criteria.where(builder.equal(DGRoot.get("MaDG"),id));
        criteria.select(builder.array(
        	    DGRoot.get("MaDG"), 
        	    DGRoot.get("TenDG")	   
        	));
		

		Object[] results = session.createQuery(criteria).getSingleResult();
		 session.close();
		return results;
	}
	public List<Object[]> selectAll() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		

        Root<DocGiaModel> DGRoot = criteria.from(DocGiaModel.class);
        Join<DocGiaModel,LoaiDocGiaModel> TheLoaiDGJoin = DGRoot.join("MaLoaiDocGia");
        criteria.select(builder.array(
        	    DGRoot.get("MaDG"), 
        	    DGRoot.get("TenDG"),
        	    TheLoaiDGJoin.get("TenLoaiDocGia"),
        	    DGRoot.get("NgaySinh"),
        	    DGRoot.get("DiaChi"),
        	    DGRoot.get("Email"),
        	    DGRoot.get("NgayLap"),
        	    DGRoot.get("NgayHetHan"),
        	    DGRoot.get("TongNo")
        	));
		

		List<Object[]> results = session.createQuery(criteria).getResultList();
		session.close();
		return results;
	}
	public DocGiaModel selectdg(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
         
		CriteriaQuery<DocGiaModel> criteria = builder.createQuery(DocGiaModel.class);
        Root<DocGiaModel> DGRoot = criteria.from(DocGiaModel.class);
        criteria.select(DGRoot).where(builder.equal(DGRoot.get("MaDG"), id));
        DocGiaModel result = session.createQuery(criteria).getSingleResult();;
        session.close();
		return result;
	}
	
	public void insert(DocGiaModel docGia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
	      session.getTransaction().begin();
			  session.save(docGia);
	      session.getTransaction().commit();
	      
	      session.close();
	  
    }
	public void update(DocGiaModel docGia) {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
       
            String hql = "UPDATE DocGiaModel D SET D.TenDG=:tenDG, D.NgaySinh=:ngaySinh,  D.DiaChi=:diaChi, D.Email=:email, D.NgayLap=:ngayLap, D.MaLoaiDocGia =:maLoaiDocGia, D.NgayHetHan=:ngayHetHan WHERE D.MaDG=:maDG";

            Query query = session.createQuery(hql);
            
            query.setParameter("tenDG", docGia.getTenDG());
            query.setParameter("ngaySinh", docGia.getNgaySinh());
            query.setParameter("diaChi", docGia.getDiaChi());
            query.setParameter("email", docGia.getEmail());
            query.setParameter("ngayLap", docGia.getNgayLap());
            query.setParameter("ngayHetHan", docGia.getNgayHetHan());
            query.setParameter("maLoaiDocGia", docGia.getMaLoaiDocGia());
            query.setParameter("maDG", docGia.getMaDG());
            session.getTransaction().begin();
            query.executeUpdate();           
            session.getTransaction().commit();
            session.close();
        
    }
	public void delete(int x ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	      

        Query q = session.createQuery("DELETE FROM DocGiaModel s WHERE s.MaDG=:maDG");
        q.setParameter("maDG",x );
        session.getTransaction().begin();
        q.executeUpdate();           
        session.getTransaction().commit();
        session.close();
	
	}
	public List<Object[]> selectByTenDG(String tenDG) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
//    
//            Root<DocGiaModel> docGiaRoot = criteria.from(DocGiaModel.class);
//            Join<DocGiaModel,LoaiDocGiaModel> TheLoaiDGJoin = docGiaRoot.join("MaLoaiDocGia");
//            criteria.where(builder.like(docGiaRoot.get("TenDG").as(String.class), "%" + tenDG + "%"));
//            criteria.select(builder.array(
//                docGiaRoot.get("MaDG"),
//                docGiaRoot.get("TenDG"),
//                TheLoaiDGJoin.get("TenLoaiDocGia"), 
//                docGiaRoot.get("NgaySinh"),             
//                docGiaRoot.get("DiaChi"),
//                docGiaRoot.get("Email"),
//                docGiaRoot.get("NgayLap"),
//                docGiaRoot.get("NgayHetHan")
//                
//             
//            ));
//    
//            List<Object[]> results = session.createQuery(criteria).getResultList();
//            session.close();
//            return results;
//        }
		List<Object[]> docGiaList = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM DocGiaModel dg WHERE dg.TenDG LIKE :tenDG";
            Query query = session.createQuery(hql);
            query.setParameter("tenDG", "%" + tenDG + "%");
            List<DocGiaModel> results = query.list();

            for (DocGiaModel dg : results) {
                docGiaList.add(new Object[]{
                    dg.getMaDG(),
                    dg.getTenDG(),
                    dg.getMaLoaiDocGia().getTenLoaiDocGia(),
                    dg.getNgaySinh(),
                    dg.getDiaChi(),
                    dg.getEmail(),
                    dg.getNgayLap(),
                    dg.getNgayHetHan(),
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
       // System.out.println("selectByHoTenDG results: " + docGiaList);
        return docGiaList;
    }
	public List<Object[]> selectByMaDG(String madg) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
    
            Root<DocGiaModel> docGiaRoot = criteria.from(DocGiaModel.class);
            Join<DocGiaModel,LoaiDocGiaModel> TheLoaiDGJoin = docGiaRoot.join("MaLoaiDocGia");
            criteria.where(builder.like(docGiaRoot.get("MaDG").as(String.class),  madg + "%"));
            criteria.select(builder.array(
                docGiaRoot.get("MaDG"),
                docGiaRoot.get("TenDG"),
                TheLoaiDGJoin.get("TenLoaiDocGia"),              
                docGiaRoot.get("NgaySinh"),
                docGiaRoot.get("DiaChi"),
                docGiaRoot.get("Email"),
                docGiaRoot.get("NgayLap"),
                docGiaRoot.get("NgayHetHan")
                
             
            ));
    
            List<Object[]> results = session.createQuery(criteria).getResultList();
            session.close();
            return results;
        }
    }
	
	public List<Object[]> selectAllTheLoaiDG() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		Root<LoaiDocGiaModel> theloaiRoot = criteria.from(LoaiDocGiaModel.class);
		
     	// Chọn thuộc tính tenTacGia từ bảng TacGiaModel
		criteria.select(builder.array(theloaiRoot.get("MaLoaiDocGia"),theloaiRoot.get("TenLoaiDocGia")));

		// Thực hiện truy vấn
		List<Object[]> TheLoaiList = session.createQuery(criteria).getResultList();
		 session.close();
		return TheLoaiList;
	}

	public List<DocGiaModel> selectDGno() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM DocGiaModel WHERE TongNo > 0";
            Query<DocGiaModel> query = session.createQuery(hql, DocGiaModel.class);
            return query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
	public void UpdateNo(int x,int no ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("UPDATE DocGiaModel d SET d.TongNo =:tongNo WHERE d.MaDG =:maDG");
        q.setParameter("tongNo", no);
        q.setParameter("maDG", x);
        session.getTransaction().begin();
        q.executeUpdate();           
        session.getTransaction().commit();
        session.close();
	
	}
	public void ThemPhieuThuTien(PhieuThuTienModel pt) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
	      session.getTransaction().begin();
	      session.save(pt);
	      session.getTransaction().commit();
	      
	      session.close();
	}
	public List<Object[]> LayPhieThu(){
					
			Session session = HibernateUtil.getSessionFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
			

	        Root<PhieuThuTienModel> PhieuThuRoot = criteria.from(PhieuThuTienModel.class);
	        Join<PhieuTraModel,DocGiaModel> DGJoin = PhieuThuRoot.join("MaDocGia");
	        criteria.select(builder.array(
	        		PhieuThuRoot.get("MaPhieuThu"), 
	        	    DGJoin.get("TenDG"),
	        	    PhieuThuRoot.get("TongNo"),
	        	    PhieuThuRoot.get("SoTienThu"),
	           	    PhieuThuRoot.get("ConLai")
	        	));
			

			List<Object[]> results = session.createQuery(criteria).getResultList();
			session.close();
			return results;
	}
}
