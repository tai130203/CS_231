package Control;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Action;
import javax.swing.JOptionPane;

import DAO.BaoCaoDao;
import Model.CT_BCSachTraTreModel;
import Model.CT_BCTheoTheLoaiModel;
import View.BaoCaoView;

public class BaoCaoControl implements Action{
    public BaoCaoView view;
    
	public BaoCaoControl(BaoCaoView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cm = e.getActionCommand();
		if (cm.equals("Tìm kiếm")) {
			this.view.DuaThongTinVaoBang();
		}
		else if (cm.equals("In phiếu")) {
			JOptionPane.showMessageDialog(view, "In phiếu thành công!");
			this.view.writeDataToWord(this.view.getDataFromTable(),"Bao_Cao_deMo.docx");
			Set<CT_BCTheoTheLoaiModel> A = new HashSet<CT_BCTheoTheLoaiModel>();
			A = this.view.CT_Baocaotheotl();
			BaoCaoDao.getinstance().InsertBCTheoTL(this.view.ThongTinBCTheoTL(A), A);
			this.view.XoaFormTheLoai();
		}else if (cm.equals("In phiếu ")) {
			JOptionPane.showMessageDialog(view, "In phiếu thành công!");
		    this.view.writeDataToWordtraTre(this.view.getDataFromTableTraTre(),"Bao_Cao_deMo_TraTre.docx");
			Set<CT_BCSachTraTreModel> A = new HashSet<CT_BCSachTraTreModel>();
			A = this.view.CT_Baocaosachtratre();
			BaoCaoDao.getinstance().InsertBCSachTraTre(this.view.ThongTinBCSachTraTre(A), A);
			this.view.XoaFormTraTre();
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
