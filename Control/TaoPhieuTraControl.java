package Control;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Action;
import javax.swing.JOptionPane;

import DAO.QuanLiTraSachDao;
import DAO.ThemSachDao;
import Model.CT_PhieuTraModel;
import Model.PhieuTraModel;
import View.PhieuTraView;
import View.QuanLiMuonTraView;
import View.QuanLiSachView;

public class TaoPhieuTraControl implements Action {
public PhieuTraView view;

	public TaoPhieuTraControl(PhieuTraView view) {
	super();
	this.view = view;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Tạo phiếu")) {
		    PhieuTraModel p=this.view.LayThongTinPhieuTra(this.view.maDOCGIA);
		    Set<CT_PhieuTraModel> listct = new HashSet<CT_PhieuTraModel>();
		    listct=this.view.LayThongTinSach();
		    QuanLiTraSachDao.getinstance().InsertPhieuMuon(p, listct);
		    for (CT_PhieuTraModel i : listct) {
		    	ThemSachDao.getinstance().updatetra(i.getMaSach().getMaSach());
		    }
		    int Tien = Integer.valueOf(this.view.textField_TongNo.getText());
		    ThemSachDao.getinstance().UpdateGiatien(Tien, this.view.maDOCGIA);
		    JOptionPane.showMessageDialog(this.view, "Tạo phiếu thành công!");
		    dispose();
			this.view.setVisible(false);
		}
		
	}

	private void dispose() {
		// TODO Auto-generated method stub
		
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
