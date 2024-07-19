package Control;

import java.awt.event.ActionEvent;

import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import DAO.DangNhapDao;
import Model.NhanVienModel;
import Model.TaiKhoaModel;
import Model.VaiTroModel;
import View.HomePageView;
import View.LoginView;
import View.QuanLiSachView;

public class LoginControl implements Action{


  
    public LoginView View;


	public LoginControl(LoginView view) {
		View = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
      String cm = e.getActionCommand();
      
     
		if (cm.equals("SIGN IN")) { 
			String tendangnhap = (String) this.View.textUsername.getText();
			char[] matkhau=(char[])this.View.textPassword.getPassword();
			String matkhauchuoi = new String(matkhau);
			System.out.print(matkhauchuoi);
			if (tendangnhap.equals("")) {
				JOptionPane.showMessageDialog(View, "Chưa nhập tên đăng nhâp!");
				this.View.textUsername.setText(null);
				this.View.textPassword.setText(null);
			}
			else if (matkhauchuoi.equals("")) {
				JOptionPane.showMessageDialog(View, "Chưa nhập mật khẩu!");
				this.View.textUsername.setText(null);
				this.View.textPassword.setText(null);
			} else {	
			   TaiKhoaModel a = DangNhapDao.getinstance().CheckDangNhap(tendangnhap,matkhauchuoi);
		        if ((a != null)&&(a.getTypeOfAcount().equals("Admin")) ) {
			      JOptionPane.showMessageDialog(View, "Đăng nhập thành công !");  
			      boolean enableNewButton = false;
			      boolean enableQunNhnVin = false;
			      boolean enableQunLMntr = false;
			      boolean enableBoCoThng = false;
			      boolean enableThayiQuy = false;
			      boolean enableThuTinPht = false;
			      
			      for (VaiTroModel role : a.getRoles()) {
			          switch (role.getRole()) {
			              case "1":
			                  enableNewButton = true;
			                  break;
			              case "2":
			                  enableQunNhnVin = true;
			                  break;
			              case "3":
			                  enableQunLMntr = true;
			                  break;
			              case "4":
			                  enableBoCoThng = true;
			                  break;
			              case "5":
			                  enableThayiQuy = true;
			                  break;
			              case "6":
			                  enableThuTinPht = true;
			                  break;
			          }
			      }
			      
			      // Khởi tạo HomePageView với trạng thái các nút
			      HomePageView hp = new HomePageView(enableNewButton, enableQunNhnVin, enableQunLMntr, enableBoCoThng, enableThayiQuy, enableThuTinPht);
			      hp.setVisible(true);
			      View.dispose();  
		        }
		        else if (a==null)
		          JOptionPane.showMessageDialog(View, "Tên đăng nhập hoặc mật khẩu không tồn tại!");
		        this.View.textUsername.setText(null);
				this.View.textPassword.setText(null);
			}
		}
		
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
