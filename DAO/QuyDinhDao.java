package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import Model.QuyDinhModel;
import Model.SachModel;
import Model.TacGiaModel;
import Model.TheLoaiModel;
import Util.HibernateUtil;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;


public class QuyDinhDao implements DaoSachInterface<QuyDinhModel>{

	public static QuyDinhDao getinstance()
	{
		return new QuyDinhDao();
	}

	@Override
	public void insert(QuyDinhModel t) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void update(QuyDinhModel t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("UPDATE QuyDinhModel q SET q.ThoiHanNhanSach=:thoihannhansach WHERE q.id=:ma");
                 
            q.setParameter("thoihannhansach",t.getThoiHanNhanSach());
            q.setParameter("ma", 1);
            session.getTransaction().begin();
            q.executeUpdate();           
            session.getTransaction().commit();
            session.close();
	}

	
	public void update1(QuyDinhModel t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("UPDATE QuyDinhModel q SET q.TuoiToiThieu=:tuoitoithieu, q.TuoiToiDa=:tuoitoida, q.ThoiHanThe=:thoihanthe, q.DonGiaPhat=:dongiaphat, q.KiemTraSoTienThu=:kiemtrasotienthu, q.SoSachMuonToiDa=:sosachmuontoida, q.SoNgayMuonToiDa=:songaymuontoida WHERE q.id=:ma");
                 
            q.setParameter("tuoitoida",t.getTuoiToiDa());
            q.setParameter("tuoitoithieu",t.getTuoiToiThieu());
            q.setParameter("thoihanthe",t.getThoiHanThe());
            q.setParameter("dongiaphat",t.getDonGiaPhat());
            q.setParameter("kiemtrasotienthu",t.getKiemTraSoTienThu());
            q.setParameter("sosachmuontoida",t.getSoSachMuonToiDa());
            q.setParameter("songaymuontoida",t.getSoNgayMuonToiDa());
            q.setParameter("ma", 1);
            session.getTransaction().begin();
            q.executeUpdate();           
            session.getTransaction().commit();
            session.close();
		
	}
	

	
	@Override
	public void delete(int x) {
	
	}

	@Override
	public List<Object[]> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] selectByID(int x) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

	
		Root<QuyDinhModel> quydinhRoot = criteria.from(QuyDinhModel.class);
		criteria.where(builder.equal(quydinhRoot.get("id"),x));
        criteria.select(builder.array(
        		quydinhRoot.get("ThoiHanNhanSach"), 
        		quydinhRoot.get("TuoiToiDa"),
        		quydinhRoot.get("TuoiToiThieu"), 
        		quydinhRoot.get("ThoiHanThe"),
        		quydinhRoot.get("SoSachMuonToiDa"),
        		quydinhRoot.get("SoNgayMuonToiDa"),
        		quydinhRoot.get("DonGiaPhat"),
        		quydinhRoot.get("KiemTraSoTienThu")
        	   
        	));
		

		Object[] results = session.createQuery(criteria).getSingleResult();
		return results;
	}

	@Override
	public ArrayList<QuyDinhModel> selectByCondition(String condition) {
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
