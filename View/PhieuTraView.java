package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.QuanLiMuonTraConTrol;
import Control.TaoPhieuTraControl;
import DAO.DocGiaDao;
import DAO.PhieuMuonDao;
import DAO.QuanLiTraSachDao;
import Model.CT_PhieuTraModel;
import Model.DocGiaModel;
import Model.PhieuMuonModel;
import Model.PhieuTraModel;
import Model.SachModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class PhieuTraView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_tendocgia;
	private JTextField textField_NgayTra;
	private JTextField textField_TienPhatKiNay;
	public JTextField textField_TongNo;
	private JTable table;
	public int maDOCGIA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuTraView frame = new PhieuTraView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PhieuTraView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Doan Cong Tai\\Downloads\\open-book.png"));
		setTitle("UIT_LIBRARY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 543);
		TaoPhieuTraControl action = new TaoPhieuTraControl(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 998, 506);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 11, 978, 192);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PHIẾU TRẢ SÁCH");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(295, 11, 341, 44);
		panel_1.add(lblNewLabel);
		
		textField_tendocgia = new JTextField();
		textField_tendocgia.setBounds(185, 66, 188, 25);
		panel_1.add(textField_tendocgia);
		textField_tendocgia.setColumns(10);
		
		textField_NgayTra = new JTextField();
		textField_NgayTra.setEnabled(false);
		textField_NgayTra.setColumns(10);
		textField_NgayTra.setBounds(185, 135, 188, 25);
		panel_1.add(textField_NgayTra);
		
		textField_TienPhatKiNay = new JTextField();
		textField_TienPhatKiNay.setColumns(10);
		textField_TienPhatKiNay.setBounds(677, 74, 188, 25);
		panel_1.add(textField_TienPhatKiNay);
		
		textField_TongNo = new JTextField();
		textField_TongNo.setColumns(10);
		textField_TongNo.setBounds(677, 133, 188, 25);
		panel_1.add(textField_TongNo);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đọc giả :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(69, 66, 103, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày trả :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(69, 135, 103, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tiền phạt kì này:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(553, 74, 114, 25);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Tổng nợ :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(553, 134, 103, 25);
		panel_1.add(lblNewLabel_1_1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 214, 978, 215);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 978, 215);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 s\u00E1ch", "Ng\u00E0y m\u01B0\u1EE3n", "S\u1ED1 ng\u00E0y m\u01B0\u1EE3n", "Ti\u1EC1n ph\u1EA1t"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(91);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Tạo phiếu");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\plus.png"));
		
		btnNewButton.addActionListener(action);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(383, 447, 169, 34);
		panel.add(btnNewButton);
	}
	public void hienthitablephieutra(List<Object[]> A) {
    	
    	DefaultTableModel table_Phieutra = (DefaultTableModel)table.getModel();
		try {
			if (A.size() == 0) table_Phieutra.setRowCount(0);
			else {
			int stt = 0;int tong = 0;
			for(Object[] i:A)
			{   stt++;
			    tong = tong + (int)i[4];
				table_Phieutra.addRow(new Object[]{stt,i[1], i[2],i[3],i[4]});
			}
		    this.textField_TienPhatKiNay.setText(String.valueOf(tong));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
    }
	public void HienThiThongtindocgia(Object[] k) {
		this.maDOCGIA = (int) k[0];
		this.textField_tendocgia.setText(String.valueOf(k[1]));
		this.textField_NgayTra.setText(String.valueOf(k[2]));
		int tien = Integer.valueOf(this.textField_TienPhatKiNay.getText());
		tien = tien + (int) k[3];
		this.textField_TongNo.setText(String.valueOf(tien));
		
	}
	public PhieuTraModel LayThongTinPhieuTra(int ma) {
		PhieuTraModel Phieu = new PhieuTraModel();
		String dateString = (String) this.textField_NgayTra.getText();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate localDate = LocalDate.parse(dateString, formatter);
	    Phieu.setNgayTra(localDate);
		int tienPhatKiNay = Integer.valueOf(this.textField_TienPhatKiNay.getText());
		Phieu.setTienPhatKiNay(tienPhatKiNay);
		int tongTien = Integer.valueOf(this.textField_TongNo.getText());
		DocGiaModel docGia = DocGiaDao.getinstance().selectdg(ma);
		Phieu.setMaDocGia(docGia);
		Set<CT_PhieuTraModel> Listsach = new HashSet<CT_PhieuTraModel>();
		Listsach = this.LayThongTinSach();
		Phieu.setCt_phieutra(Listsach);
		return Phieu;
	}
	public Set<CT_PhieuTraModel> LayThongTinSach() {
		DefaultTableModel table_Phieutra = (DefaultTableModel)table.getModel();
		Set<CT_PhieuTraModel> Listsach = new HashSet<>();
		int row = table_Phieutra.getRowCount();
		for (int i=0;i<row;i++) {
			 int ma = (int)table_Phieutra.getValueAt(i,1);
			
			 SachModel s = new SachModel();
			 s = PhieuMuonDao.getinstance().selectSach(ma);
			 int songaymuon = (int)table_Phieutra.getValueAt(i, 3);
			
			 int tienphat = (int) table_Phieutra.getValueAt(i,4);
			
			 CT_PhieuTraModel ctpt = new CT_PhieuTraModel(songaymuon, s, tienphat);
			 Listsach.add(ctpt);
		}
		return Listsach;
	}
	
}
