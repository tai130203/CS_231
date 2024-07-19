package Control;

import java.awt.event.ActionEvent;


import java.util.Date;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.Action;
import javax.swing.JOptionPane;

import DAO.QuyDinhDao;
import Model.SachModel;
import View.QuanLiSachView;


public class QuanLiSachControl implements Action
{
    public QuanLiSachView View;
  
    
	public QuanLiSachControl(QuanLiSachView view) {
		View = view;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		
		if (cm.equals("Thêm")) { 
			if (validateSach()) {
			String ngayNhap = this.View.textField_Ngaynhap.getText();
			String namxb = this.View.textField_Ngayxb.getText(); 
            Object[] qd = QuyDinhDao.getinstance().selectByID(1);
            int qdnamxb = (int)qd[0];
//            if (ngayNhap.isEmpty() && namxb.isEmpty()) {
//            	JOptionPane.showMessageDialog(View, "Vui lòng nhập đủ thông tin!");
//            } else {
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            	LocalDate date = LocalDate.parse(ngayNhap, formatter);
            	int namXuatBanStr =  Integer.valueOf(this.View.textField_Ngayxb.getText());
            	int nam = date.getYear();
                if ((nam > namXuatBanStr + qdnamxb )||(nam < namXuatBanStr)) {
                    this.View.textField_Ngaynhap.setText("");
                    this.View.textField_Ngayxb.setText("");
                    JOptionPane.showMessageDialog(View, "Ngày nhập sai quy định. Vui lòng nhập lại!");
                } else {
                    this.View.ChucNangThem();
                    this.View.xoaForm();
                    JOptionPane.showMessageDialog(View, "Thêm thành công !");
                }
            }
		}
	
	  else if (cm.equals("Lưu")){
		  if (validateSach()) {
		  String ngayNhap = this.View.textField_Ngaynhap.getText();
			String namxb = this.View.textField_Ngayxb.getText();            
			
          
          Object[] qd = QuyDinhDao.getinstance().selectByID(1);
          int qdnamxb = (int)qd[0];
//          if (ngayNhap.isEmpty() && namxb.isEmpty()) {
//          	JOptionPane.showMessageDialog(View, "Vui lòng nhập đủ thông tin!");
//          } else {
          	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          	LocalDate date = LocalDate.parse(ngayNhap, formatter);
          	int namXuatBanStr =  Integer.valueOf(this.View.textField_Ngayxb.getText());
          	int nam = date.getYear();
              if ((nam > namXuatBanStr + qdnamxb )||(nam < namXuatBanStr)) {
                  this.View.textField_Ngaynhap.setText("");
                  this.View.textField_Ngayxb.setText("");
                  JOptionPane.showMessageDialog(View, "Ngày nhập sai quy định. Vui lòng nhập lại!");
              } else {
                  this.View.ChucNangSua();
                  this.View.xoaForm();
                  JOptionPane.showMessageDialog(View, "Sửa thành công !");
              }
          }
			
		}
		 else if (cm.equals("Sửa")) {
			 this.View.hienThi();
			
		}	 else if (cm.equals("Xóa")) {
			this.View.ChucNangXoa();
		}  else if (cm.equals("Hủy")) {
			this.View.xoaForm();
		}  else if (cm.equals("Tìm kiếm")) {
			this.View.ChucNangTimSach();
		}  else if (cm.equals("Load danh sách")) {
			this.View.thucHienLoadds();
		} 
		 
	
		
		
	}
private boolean validateSach() {
		try {
		
		    String tensach = this.View.textField_Tensach.getText();
		    String tentheloai = (String) this.View.comboBox_theloai.getSelectedItem();
		    String tentacgia = (String) this.View.comboBox_matg.getSelectedItem();
		    String nhaxb = this.View.textField_Nhaxb.getText();
		    String trigiaText = this.View.textField_Trigia.getText();
		    String ngayNhap = this.View.textField_Ngaynhap.getText();
			String namxbText = this.View.textField_Ngayxb.getText();   
		   
		    if (tensach.isEmpty() || tentheloai.isEmpty() || tentacgia.isEmpty() || nhaxb.isEmpty() || trigiaText.isEmpty()||ngayNhap.isEmpty()||namxbText.isEmpty()) {
		    	JOptionPane.showMessageDialog(View, "Vui lòng nhập đầy đủ các trường thông tin");
		    	return false;
		    }
		   
		    	
	        	
		   
		    try {
		       int trigia = Integer.parseInt(trigiaText);
		       if (trigia<0) {
		    	   JOptionPane.showMessageDialog(View, "Tri giá của quyển sách không thể âm");
		    	   return false;
		       }
		    } catch (NumberFormatException e) {
		    	JOptionPane.showMessageDialog(View, "Vui lòng kiểm tra lại Trị giá");
		    	return false;
		    }
		    int namxb;
		    try {
		        namxb = Integer.parseInt(namxbText);
		        if (namxb<=0 || namxb >2024) {
		        	JOptionPane.showMessageDialog(View, "Vui lòng kiểm tra lại Năm xuất bản ");
		        	return false;
		        }
		    } catch (NumberFormatException e) {
		    	JOptionPane.showMessageDialog(View, "Vui lòng kiểm tra lại Năm xuất bản");
		    	return false;
		    }
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	LocalDate date = LocalDate.parse(ngayNhap, formatter);
	    	LocalDate currentDate = LocalDate.now();
	    	if (currentDate.isBefore(date)) {
	    		JOptionPane.showMessageDialog(View,"Ngày nhập không thể lớn hơn ngày hôm nay!");
	    		return false;
	    	}
		   
		} catch (DateTimeParseException e) {
		    
			JOptionPane.showMessageDialog(View, "Ngày nhập sách phải có định dạng dd/MM/yyyy.");
			return false;
		}  catch (Exception e) {
		    
		    e.printStackTrace();
		}
		return true;
	    
	}


	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	
	
}

