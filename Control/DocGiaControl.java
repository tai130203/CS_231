package Control;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import com.google.protobuf.TextFormat.ParseException;

import DAO.QuyDinhDao;
import View.DocGiaView;

public class DocGiaControl implements Action{

	public DocGiaView view;
	
	public DocGiaControl(DocGiaView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 String cm = e.getActionCommand();
	        if (cm.equals("Thêm")) {
	        	if (validateDocGia()) {
	                this.view.ChucNangThem();
	                this.view.xoaForm();
	                JOptionPane.showMessageDialog(view, "Thêm thành công!");
	            }
	        } else if (cm.equals("Lưu")) {
	            
	            
	                    if (validateDocGia()) {
	                        this.view.ChucNangSua();
	                        this.view.xoaForm();
	                        JOptionPane.showMessageDialog(view, "Sửa thành công!");
	                      }
	                
	            
	        } else if (cm.equals("Sửa")) {
	                this.view.hienThi();
	       
	        } else if (cm.equals("Xóa")) {
	                this.view.ChucNangXoa();
	        } else if (cm.equals("Hủy")) {
	            this.view.xoaForm();
	        } else if (cm.equals("Tìm")) {
	            this.view.ChucNangTim();
	        } else if (cm.equals("Load lại danh sách")) {
	            this.view.thucHienLoadds();
	        }
	    }
		
	

private boolean validateDocGia() {
    try {
    	String tendocgia = this.view.txthoTenDG.getText();
    	String loaidocgia = (String)this.view.comboBox_maLoaiDG.getSelectedItem();
    	String diachi = this.view.txtdiaChi.getText();
    	String email = this.view.txtemail.getText();
    	String ngaylap = this.view.txtngLapThe.getText();
    	String ngaysinh = this.view.txtngSinh.getText();
    	if (tendocgia.isEmpty() || loaidocgia.isEmpty() || diachi.isEmpty() || email.isEmpty() || ngaylap.isEmpty()||ngaysinh.isEmpty()) {
	    	JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ các trường thông tin");
	    	return false;
	    }
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate date = LocalDate.parse(ngaysinh, formatter);
		
        int tuoi = calculateAge(date);
        Object[] qd = QuyDinhDao.getinstance().selectByID(1);
        int tuoitoida = (int)qd[1];
        int tuoitoithieu = (int)qd[2];
        if (tuoi < tuoitoithieu || tuoi > tuoitoida) {
            JOptionPane.showMessageDialog(view, "Số tuổi quá quy định ,tuổi độc giả phải từ " +tuoitoithieu+ " đến "+tuoitoida);
            return false;
        }
        
        try {
        	LocalDate ngayLapThe = LocalDate.parse(ngaylap,formatter);
        	LocalDate currentDate = LocalDate.now();
        	if (currentDate.isBefore(ngayLapThe)) {
        		JOptionPane.showMessageDialog(view, "Ngày lập thẻ phải trước ngày " + currentDate);
        		return false;
        	}
		    } catch (DateTimeParseException e) {
		    	JOptionPane.showMessageDialog(view, "Ngày lập thẻ phải có định dạng dd/MM/yyyy.");
		    	return false;
		    }
        
        
    } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(view, "Ngày sinh phải có định dạng dd/MM/yyyy.");
        return false;
    }
    return true;
}


private int calculateAge(LocalDate birthDate) {
	 LocalDate today = LocalDate.now();
     Period period = Period.between(birthDate, today);
     return period.getYears();
}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
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
