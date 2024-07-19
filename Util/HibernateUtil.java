package Util;


import java.util.Properties;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import Model.NhanVienModel;
import Model.BCSachTraTreModel;
import Model.BCTheoTheLoaiModel;
import Model.CT_BCSachTraTreModel;
import Model.CT_BCTheoTheLoaiModel;
import Model.CT_PhieuTraModel;
import Model.DocGiaModel;
import Model.LoaiDocGiaModel;
import Model.PhieuMuonModel;
import Model.PhieuThuTienModel;
import Model.PhieuTraModel;
import Model.QuyDinhModel;
import Model.SachModel;
import Model.TacGiaModel;
import Model.TaiKhoaModel;
import Model.TheLoaiModel;
import Model.VaiTroModel;


public class HibernateUtil {
   
     private final static SessionFactory FACTORY;
     static {
    	 Configuration conf = new Configuration();
    	 conf.configure("hibernate.cfg.xml");
    	 /* Properties pros = new Properties();
    	 pros.put(Environment.DIALECT,"org.hibernate.dialect.SQLServerDialect");
    	 pros.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 pros.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=qltv;encrypt=true;trustServerCertificate=true");
    	 pros.put(Environment.USER, "sa");
    	 pros.put(Environment.PASS, "13022003");
    	 conf.setProperties(pros);*/
    	 
    	 conf.addAnnotatedClass(SachModel.class);
    	 conf.addAnnotatedClass(TacGiaModel.class);
    	 conf.addAnnotatedClass(TheLoaiModel.class);
    	 conf.addAnnotatedClass(QuyDinhModel.class);
    	 conf.addAnnotatedClass(NhanVienModel.class);
    	 conf.addAnnotatedClass(PhieuMuonModel.class);
    	 conf.addAnnotatedClass(DocGiaModel.class);
    	 conf.addAnnotatedClass(CT_PhieuTraModel.class);
    	 conf.addAnnotatedClass(PhieuTraModel.class);
    	 conf.addAnnotatedClass(CT_BCTheoTheLoaiModel.class);
    	 conf.addAnnotatedClass(BCTheoTheLoaiModel.class);
    	 conf.addAnnotatedClass(LoaiDocGiaModel.class);
    	 conf.addAnnotatedClass(PhieuThuTienModel.class);
    	 conf.addAnnotatedClass(BCSachTraTreModel.class);
    	 conf.addAnnotatedClass(CT_BCSachTraTreModel.class);
    	 conf.addAnnotatedClass(VaiTroModel.class);
    	 conf.addAnnotatedClass(TaiKhoaModel.class);
    	 
    	 ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
         
    	 FACTORY = conf.buildSessionFactory(registry);   	 
     }
     
     public static SessionFactory getSessionFactory() {
          return FACTORY;		
	}
}
