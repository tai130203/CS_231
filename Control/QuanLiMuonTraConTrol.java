package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.Action;

import View.PhieuTraView;
import View.QuanLiMuonTraView;
import View.QuanLiSachView;

public class QuanLiMuonTraConTrol implements Action{
	
public QuanLiMuonTraView View;
public PhieuTraView View1;  
    
	public QuanLiMuonTraConTrol(QuanLiMuonTraView view) {
		this.View = view;
	}

	public QuanLiMuonTraConTrol(PhieuTraView view1) {
		this.View1 = view1;
	}
	public void setView(QuanLiMuonTraView view) {
        this.View = view;
    }

    // Phương thức để đặt giá trị cho PhieuTraView
    public void setView1(PhieuTraView view1) {
        this.View1 = view1;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
       String cm = e.getActionCommand();
		
		if (cm.equals("Thêm")) {
			this.View.ThemSachVaoPhieu();
		}
		else if (cm.equals("Tạo Phiếu Mượn")) {
			
			
			this.View.TaoPhieu();
			
		}else if (cm.equals("Tìm kiếm")) {
			this.View.ChucNangTimSach();
		}
		else if (cm.equals("Load danh sách")) {
			this.View.Duathongtinvaobang();
		}else if (cm.equals("Lập phiếu trả")) {
			PhieuTraView pt = new PhieuTraView();
			pt.setVisible(true);
			List<Object[]> A = this.View.SachDangChonMuon();
			pt.hienthitablephieutra(A);  
		    pt.HienThiThongtindocgia(this.View.LayThongTinDocGia());
		}
	}


	public QuanLiMuonTraConTrol(QuanLiMuonTraView view, PhieuTraView view1) {
		
		View = view;
		View1 = view1;
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
