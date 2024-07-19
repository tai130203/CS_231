package Control;

import java.awt.event.ActionEvent;

import java.util.Date;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import DAO.QuyDinhDao;
import Model.QuyDinhModel;
import View.ThayDoiQuyDinhView;


public class ThayDoiQuyDinhControl implements Action
{
    public ThayDoiQuyDinhView View;
    
    
     public ThayDoiQuyDinhControl(ThayDoiQuyDinhView view) {
	      View = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		
		if (cm.equals("Thêm")) { 
			if (this.View.textField_TenTheLoai.getText().isEmpty()) 
				{
				   JOptionPane.showMessageDialog(View,"Bạn chưa nhập thông tin!");
				}
			else this.View.ChucNangThem();
		}	
		else if (cm.equals("Lưu")){
			
			if (this.View.textField_TenTheLoai.getText().isEmpty()) 
			{
			   JOptionPane.showMessageDialog(View,"Bạn chưa nhập thông tin!");
			}
		    else this.View.ChucNangSua();
		}
		 else if (cm.equals("Sửa")) {
			 this.View.hienThi();
			
		} else if (cm.equals("Xóa")) {
			this.View.ChucNangXoa();
		}	
		else if (cm.equals("Chỉnh sửa")) {
			this.View.ChucNangChinhSua1();
		}	
	}
	
	public Object[] getByid() {
		Object[] qd ;
		qd = QuyDinhDao.getinstance().selectByID(1);
		return qd;
		
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