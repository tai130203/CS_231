package View;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.QuanLiMuonTraConTrol;
import Control.QuanLiSachControl;
import DAO.DocGiaDao;
import DAO.PhieuMuonDao;
import DAO.QuanLiSachDao;
import DAO.QuanLiTraSachDao;
import DAO.QuyDinhDao;
import DAO.TacGiaDao;
import DAO.ThemSachDao;
import Model.DocGiaModel;
import Model.PhieuMuonModel;
import Model.SachModel;
import Model.TacGiaModel;
import Model.TheLoaiModel;


import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import javax.swing.event.PopupMenuListener;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class QuanLiMuonTraView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_1;
	private JComboBox comboBox;
	private JButton btnNewButton_1;
	private JComboBox comboBox_1;
	private JLabel lblTncGi;
	private JButton btnNewButton;
	private JTextField textField_ten;
	private JTextField textField_loai;
	private JTextField textField_dia;
	private JTextField textField_email;
	private JTextField textField_ngayl;
	private JTextField textField_ngay;
	private JTextField textField_tong;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTable table_2;
	private JComboBox comboBox_Madocgia;
	private JTabbedPane tabbedPane_2;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JRadioButton rdbtnMaDG;
	private JRadioButton rdbtnMaPhieuMuon;
	private JPanel panel_2_1;
	private JTextField textField_tk;
	private JTable table_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_PT;
	private JTable table_PT;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnNewButton_4_2;
	private JButton btnNewButton_4_3;
	private JButton btnNewButton_loaddanhsach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiMuonTraView frame = new QuanLiMuonTraView();
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
	public QuanLiMuonTraView(boolean enableNewButton, boolean enableQunNhnVin, boolean enableQunLMntr, boolean enableBoCoThng, boolean enableThayiQuy, boolean enableThuTinPht) {
		setTitle("UIT_LIBRARY");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Doan Cong Tai\\Downloads\\open-book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 664);
		QuanLiMuonTraConTrol action = new QuanLiMuonTraConTrol(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1070, 605);
		contentPane.add(tabbedPane);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Mượn Sách", null, panel, null);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane_1.setBounds(0, 0, 1065, 577);
		panel.add(tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.inactiveCaption);
		tabbedPane_1.addTab("Tìm kiếm phiếu mượn", null, panel_5, null);
		panel_5.setLayout(null);
		
		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm phi\u1EBFu m\u01B0\u1EE3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(10, 11, 1024, 114);
		panel_5.add(panel_7);
		
		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null, "T\u00ECm theo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(25, 26, 336, 65);
		panel_7.add(panel_8);
		
		rdbtnMaDG = new JRadioButton("Mã phiếu mượn");
		buttonGroup.add(rdbtnMaDG);
		rdbtnMaDG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMaDG.setBounds(20, 19, 124, 23);
		panel_8.add(rdbtnMaDG);
		
		rdbtnMaPhieuMuon = new JRadioButton("Mã đọc giả");
		buttonGroup.add(rdbtnMaPhieuMuon);
		rdbtnMaPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMaPhieuMuon.setBounds(167, 19, 111, 23);
		panel_8.add(rdbtnMaPhieuMuon);
		
		panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(null, "Nh\u1EADp th\u00F4ng tin t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1.setBounds(412, 26, 330, 65);
		panel_7.add(panel_2_1);
		
		textField_tk = new JTextField();
		textField_tk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_tk.setColumns(10);
		textField_tk.setBounds(51, 23, 235, 31);
		panel_2_1.add(textField_tk);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\search (1).png"));
		btnTim.addActionListener(action);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBackground(Color.WHITE);
		btnTim.setBounds(771, 13, 196, 36);
		panel_7.add(btnTim);
		
		JButton btnLoadds = new JButton("Load danh sách");
		btnLoadds.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\reload.png"));
		btnLoadds.addActionListener(action);
		btnLoadds.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoadds.setBackground(Color.WHITE);
		btnLoadds.setBounds(771, 60, 196, 36);
		panel_7.add(btnLoadds);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 136, 1017, 319);
		panel_5.add(panel_9);
		panel_9.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 997, 297);
		panel_9.add(scrollPane_2);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 phi\u1EBFu m\u01B0\u1EE3n", "M\u00E3 \u0111\u1ECDc gi\u1EA3", "Ng\u00E0y m\u01B0\u1EE3n"
			}
		));
		DefaultTableModel table_Phieumuon = (DefaultTableModel)table_3.getModel();
		try {
			List<Object[]> A = PhieuMuonDao.getinstance().LayPhieuMuon(); 
			for(Object[] i:A)
			{
				table_Phieumuon.addRow(new Object[]{i[0], i[1], i[2]});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		scrollPane_2.setViewportView(table_3);
		
		btnNewButton_4_2 = new JButton("HOME");
		btnNewButton_4_2.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\home.png"));
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePageView hp = new HomePageView(enableNewButton,  enableQunNhnVin,  enableQunLMntr,  enableBoCoThng,  enableThayiQuy,  enableThuTinPht);
				hp.setVisible(true);
			}
		});
		btnNewButton_4_2.setBounds(444, 478, 139, 45);
		panel_5.add(btnNewButton_4_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		tabbedPane_1.addTab("Tạo phiếu mượn", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã đọc giả :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 30, 96, 17);
		panel_2.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(431, 30, 128, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		lblTncGi = new JLabel("Tên đọc giả :");
		lblTncGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTncGi.setBounds(318, 30, 96, 17);
		panel_2.add(lblTncGi);
		
		JLabel lblNgyMn = new JLabel("Ngày mượn :");
		lblNgyMn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyMn.setBounds(671, 33, 96, 17);
		panel_2.add(lblNgyMn);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setText(SetTime());
		textField_2.setColumns(10);
		textField_2.setBounds(777, 33, 128, 20);
		panel_2.add(textField_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 155, 1036, 325);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "Th\u1EC3 Lo\u1EA1i", "T\u00E1c gi\u1EA3"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
	    btnNewButton = new JButton("Tạo Phiếu Mượn");
	    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
	    btnNewButton.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\plus.png"));
	    btnNewButton.addActionListener(action);
	    btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	    btnNewButton.setBounds(450, 491, 139, 33);
	    panel_2.add(btnNewButton);
	    
	    comboBox = new JComboBox();
	    comboBox.addPopupMenuListener(new PopupMenuListener() {
	    	public void popupMenuCanceled(PopupMenuEvent e) {
	    	}
	    	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
	    	}
	    	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	    		comboBox.removeAllItems();
	    	    comboBox.addItem("");

	    	    for (Object[] j : ThemSachDao.getinstance().selectAll()) {
	    			  comboBox.addItem(j[0]);
	    		}
	    	}
	    });
       
	    comboBox.setBounds(116, 91, 128, 20);
	    panel_2.add(comboBox);
	  
	    
	    JLabel lblNewLabel_1 = new JLabel("Mã sách");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblNewLabel_1.setBounds(10, 94, 83, 17);
	    panel_2.add(lblNewLabel_1);
	    
	    btnNewButton_1 = new JButton("Thêm");
	    btnNewButton_1.addActionListener(action);
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton_1.setBounds(318, 90, 89, 23);
	    panel_2.add(btnNewButton_1);
	    
	    comboBox_1 = new JComboBox();
	    comboBox_1.addItem("");

	    
	    
	    
		for (Object[] j : DocGiaDao.getinstance().selectAll()) {
			  comboBox_1.addItem(j[0]);
		}
	    comboBox_1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	LayThongTinSach();
	            }
	    });
	    
		comboBox_1.setBounds(116, 25, 128, 22);
		panel_2.add(comboBox_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Trả sách", null, panel_1, null);
		panel_1.setLayout(null);
		
		tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane_2.setBounds(0, 0, 1065, 566);
		panel_1.add(tabbedPane_2);
		
		panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.inactiveCaption);
		tabbedPane_2.addTab("Tìm kiếm phiếu trả", null, panel_6, null);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(20, 147, 997, 297);
		panel_6.add(scrollPane_2_1);
		
		table_PT = new JTable();
		table_PT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 phi\u1EBFu tr\u1EA3", "M\u00E3 \u0111\u1ECDc gi\u1EA3", "Ng\u00E0y tr\u1EA3", "Ti\u1EC1n ph\u1EA1t"
			}
		));
		DefaultTableModel table_Phieutra = (DefaultTableModel)table_PT.getModel();
		scrollPane_2_1.setViewportView(table_PT);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBounds(10, 11, 1024, 114);
		panel_7_1.setLayout(null);
		panel_7_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm phi\u1EBFu tr\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7_1.setBackground(Color.LIGHT_GRAY);
		panel_6.add(panel_7_1);
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setLayout(null);
		panel_8_1.setBorder(new TitledBorder(null, "T\u00ECm theo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8_1.setBounds(25, 26, 336, 65);
		panel_7_1.add(panel_8_1);
		
		JRadioButton rdbtnMPhiuTr = new JRadioButton("Mã phiếu trả");
		buttonGroup_1.add(rdbtnMPhiuTr);
		rdbtnMPhiuTr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMPhiuTr.setBounds(20, 19, 124, 23);
		panel_8_1.add(rdbtnMPhiuTr);
		
		JRadioButton rdbtnMaPhieuTra_1 = new JRadioButton("Mã đọc giả");
		buttonGroup_1.add(rdbtnMaPhieuTra_1);
		rdbtnMaPhieuTra_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMaPhieuTra_1.setBounds(167, 19, 111, 23);
		panel_8_1.add(rdbtnMaPhieuTra_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new TitledBorder(null, "Nh\u1EADp th\u00F4ng tin t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1_1.setBounds(412, 26, 330, 65);
		panel_7_1.add(panel_2_1_1);
		
		textField_PT = new JTextField();
		textField_PT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_PT.setColumns(10);
		textField_PT.setBounds(51, 23, 235, 31);
		panel_2_1_1.add(textField_PT);
		
		JButton btnTim_TimPT = new JButton("Tìm kiếm");
		btnTim_TimPT.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\search (1).png"));
		btnTim_TimPT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     ChucNangTimPhieuTra();
			}
		});
		btnTim_TimPT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim_TimPT.setBackground(Color.WHITE);
		btnTim_TimPT.setBounds(771, 13, 203, 36);
		panel_7_1.add(btnTim_TimPT);
		
		JButton btnLoadds_PT = new JButton("Load danh sách");
		btnLoadds_PT.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\reload.png"));
		btnLoadds_PT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Duathongtinvaobangphieutra();
			}
		});
		btnLoadds_PT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoadds_PT.setBackground(Color.WHITE);
		btnLoadds_PT.setBounds(771, 60, 203, 36);
		panel_7_1.add(btnLoadds_PT);
		
		btnNewButton_4_3 = new JButton("HOME");
		btnNewButton_4_3.setBackground(new Color(153, 180, 209));
		btnNewButton_4_3.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\home.png"));
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePageView hp = new HomePageView(enableNewButton,  enableQunNhnVin,  enableQunLMntr,  enableBoCoThng,  enableThayiQuy,  enableThuTinPht);
				hp.setVisible(true);
			}
		});
		btnNewButton_4_3.setBounds(427, 483, 120, 40);
		panel_6.add(btnNewButton_4_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		tabbedPane_2.addTab("Tạo phiếu trả", null, panel_3, null);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("THÔNG TIN ĐỌC GIẢ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(304, 7, 451, 30);
		panel_3.add(lblNewLabel_2);
		
		textField_ten = new JTextField();
		textField_ten.setColumns(10);
		textField_ten.setBounds(244, 94, 166, 20);
		panel_3.add(textField_ten);
		
		textField_loai = new JTextField();
		textField_loai.setColumns(10);
		textField_loai.setBounds(244, 137, 166, 20);
		panel_3.add(textField_loai);
		
		textField_dia = new JTextField();
		textField_dia.setColumns(10);
		textField_dia.setBounds(734, 48, 166, 20);
		panel_3.add(textField_dia);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(734, 94, 166, 20);
		panel_3.add(textField_email);
		
		textField_ngayl = new JTextField();
		textField_ngayl.setColumns(10);
		textField_ngayl.setBounds(734, 137, 166, 20);
		panel_3.add(textField_ngayl);
		
		textField_ngay = new JTextField();
		textField_ngay.setColumns(10);
		textField_ngay.setBounds(244, 184, 166, 20);
		panel_3.add(textField_ngay);
		
		textField_tong = new JTextField();
		textField_tong.setColumns(10);
		textField_tong.setBounds(734, 184, 166, 20);
		panel_3.add(textField_tong);
		
		lblNewLabel_3 = new JLabel("Mã độc giả :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(109, 46, 114, 20);
		panel_3.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Tên đọc giả :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(109, 94, 114, 20);
		panel_3.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Loại đọc giả :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(109, 135, 114, 20);
		panel_3.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Ngày sinh :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(109, 182, 114, 20);
		panel_3.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Địa chỉ :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(613, 46, 114, 20);
		panel_3.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Email :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(613, 92, 114, 20);
		panel_3.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Ngày lập thẻ :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(613, 135, 114, 20);
		panel_3.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Tổng nợ:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(613, 182, 114, 20);
		panel_3.add(lblNewLabel_10);
		
		comboBox_Madocgia = new JComboBox();
		comboBox_Madocgia.setBounds(243, 47, 167, 20);
		comboBox_Madocgia.addItem("");
		for (Object[] j : DocGiaDao.getinstance().selectAll()) {
			  comboBox_Madocgia.addItem(j[0]);
		}
		
		comboBox_Madocgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	DefaultTableModel model_tb =(DefaultTableModel) table_2.getModel();
            	model_tb.setRowCount(0);
            	LayThongTinSach2();
            	hienthitabletra();
            }
	    });
		panel_3.add(comboBox_Madocgia);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 216, 1056, 333);
		panel_3.add(panel_4);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 1045, 255);
		panel_4.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 s\u00E1ch", "Ng\u00E0y m\u01B0\u1EE3n", "S\u1ED1 ng\u00E0y m\u01B0\u1EE3n", "Ti\u1EC1n ph\u1EA1t"
			}
		));
		table_2.getColumnModel().getColumn(3).setPreferredWidth(103);
	
		scrollPane.setViewportView(table_2);
		
		JLabel lblNewLabel_11 = new JLabel("Sách đang mượn");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_11.setBounds(10, 11, 234, 45);
		panel_4.add(lblNewLabel_11);
		
		JButton btnNewButton_3 = new JButton("Lập phiếu trả");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\plus.png"));
		btnNewButton_3.addActionListener(action);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(892, 17, 135, 37);
		panel_4.add(btnNewButton_3);
		
		btnNewButton_loaddanhsach = new JButton("Load lại danh sách");
		btnNewButton_loaddanhsach.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_loaddanhsach.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\reload.png"));
		btnNewButton_loaddanhsach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model_table_2 = (DefaultTableModel)table_2.getModel();
				model_table_2.setRowCount(0);
				hienthitabletra();
			}
		});
		btnNewButton_loaddanhsach.setBounds(731, 17, 151, 37);
		panel_4.add(btnNewButton_loaddanhsach);
		try {
			 int stt = 0;
			List<Object[]> A = QuanLiTraSachDao.getinstance().LayPhieuTra(); 
			for(Object[] i:A)
			{   stt++;
				table_Phieutra.addRow(new Object[]{stt,i[0], i[1], i[2],i[3]});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public QuanLiMuonTraView() throws HeadlessException {
		super();
	}

	public void ThemSachVaoPhieu() {
		DefaultTableModel model_table_1 = (DefaultTableModel) table_1.getModel();
		int ma = (Integer)this.comboBox.getSelectedItem();
		int r_conut = model_table_1.getRowCount();
		int kt = 0;
		for (int i = 0 ;i < r_conut;i++) {
			 if (ma == (Integer)model_table_1.getValueAt(i,1)) {
				 kt = 1;
				 break;
			 }
		}
		if (kt == 0) {
		
		Object[] i = QuanLiSachDao.getinstance().selectByID(ma);
		model_table_1.addRow(new Object [] {r_conut+1, i[0],i[1],i[3],i[2]});
		}
		else JOptionPane.showMessageDialog(this, "Sách đã tồn tại!");
		comboBox.setSelectedIndex(-1);
	}
	
	public void LayThongTinSach() {
	     int id = (Integer)	comboBox_1.getSelectedItem();
	     Object[] a = DocGiaDao.getinstance().selectByID(id);
	     textField_1.setText((String) a[1]);
	}
	
    public Set<SachModel> LayTatCaSach() {
    	Set<SachModel> a = new HashSet<>();
    	DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
    	int r_conut = model_table.getRowCount();
    	for (int i = 0 ; i < r_conut;i++ )
    		{
    			  int  maSach = (Integer)model_table .getValueAt(i, 1);
		          SachModel t = new SachModel();
		          t = PhieuMuonDao.getinstance().selectSach(maSach);
		      
		         
		       a.add(t);     
            }
    	return a;
    }
    public void TaoPhieu() {
    	int a = (Integer) comboBox_1.getSelectedItem();
    	System.out.println(a);
    	DocGiaModel dg = DocGiaDao.getinstance().selectdg(a);
    	Set<SachModel> l = new HashSet<SachModel>();
    	l = LayTatCaSach();
    	LocalDate currentDate = LocalDate.now();
        Object[] qd = QuyDinhDao.getinstance().selectByID(1);
        List<Integer> dgtratre = PhieuMuonDao.getinstance().KiemTraDocGia(currentDate,(int) qd[5]);
        boolean kt = true;
        System.out.println("ĐAY NAY ME: "+dgtratre.size());
        for (int i:dgtratre) {
        	if (a == i) {
       		kt = false;
       		break;
        	}
       }
    	if (dg.getNgayHetHan().isBefore(currentDate) )
    		{
    		
    		JOptionPane.showMessageDialog(this, "Thẻ đã hết thời hạn,mượn thất bại!");
    		JOptionPane.showMessageDialog(this, "Vui lòng đăng kí lại, hoặc gia hạn thẻ ");
    		System.out.print("TRUE");
    		DefaultTableModel table = (DefaultTableModel) table_1.getModel();
    		table.setRowCount(0);
    		textField_1.setText("");
    		comboBox_1.setSelectedIndex(0);
    		}
    	else if (((PhieuMuonDao.getinstance().TongSach(a) + l.size())  > (int)qd[4])||(l.size()>(int)qd[4])) 
    		{
    		System.out.println(PhieuMuonDao.getinstance().TongSach(a));
    		JOptionPane.showMessageDialog(this, "Số lượng sách vượt quá quy định!");
    		JOptionPane.showMessageDialog(this, "Vui lòng quay lại sau ");
    		System.out.print("TRUE");
    		DefaultTableModel table = (DefaultTableModel) table_1.getModel();
    		table.setRowCount(0);
    		textField_1.setText("");
    		comboBox_1.setSelectedIndex(0);
    		
    		
    		}
    	else if(kt == false) {
    		JOptionPane.showMessageDialog(this, "Đọc giả có sách trả trễ! ");
    		System.out.print("TRUE");
    		DefaultTableModel table = (DefaultTableModel) table_1.getModel();
    		table.setRowCount(0);
    		textField_1.setText("");
    		comboBox_1.setSelectedIndex(0);
    	}
    	
    	else  
    	{
    	String ngayNhap = this.textField_2.getText();
    	  // Định dạng của chuỗi ngày tháng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = null;
        try {
            // Chuyển đổi chuỗi thành LocalDate với định dạng "dd/MM/yyyy"
             date = LocalDate.parse(ngayNhap, formatter);
           
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
		PhieuMuonDao.getinstance().insert(l, dg, date );
		
	     JOptionPane.showMessageDialog(this, "Thêm phiếu mượn thành công!");
	   
         for (SachModel i : l)
         {
        	 String manum = String.valueOf(a);
        	 //ThemSachDao.getinstance().update(i.getMaSach());
        	 ThemSachDao.getinstance().update(i.getMaSach(),manum);
         }  
	     DefaultTableModel table = (DefaultTableModel) table_1.getModel();
	     table.setRowCount(0);
	     textField_1.setText("");
 		 comboBox_1.setSelectedItem(0);
    	}
    }
    public String SetTime() {
    	 // Lấy ngày hôm nay
        Date currentDate = new Date();

        // Định dạng ngày hôm nay theo "dd/MM/yyyy"
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(currentDate);
		return formattedDate;
	}
    public void LayThongTinSach2() {
	     int id = (Integer)	comboBox_Madocgia.getSelectedItem();
	     DocGiaModel a = DocGiaDao.getinstance().selectdg(id);
	     textField_ten.setText((String) a.getTenDG());
	     textField_dia.setText((String) a.getDiaChi());
	     textField_email.setText((String) a.getEmail());
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	     textField_loai.setText((String) a.getMaLoaiDocGia().getTenLoaiDocGia());
	     textField_ngay.setText((String) a.getNgaySinh().format(formatter));
	     textField_tong.setText(String.valueOf(a.getTongNo()));
	     textField_ngayl.setText((String)a.getNgayLap().format(formatter));
	   
	}
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    public void ChucNangTimSach()
    {
    DefaultTableModel model_table= (DefaultTableModel) table_3.getModel();
    model_table.setRowCount(0);
    if (getSelectedButtonText(buttonGroup).equals("Mã phiếu mượn")) {
    
    for(Object[] i: PhieuMuonDao.getinstance().Timkiemtheomaphieu(textField_tk.getText()))
    {
    	
    	model_table.addRow(new Object [] {i[0],i[1],i[2]});
    }
    }
    if (getSelectedButtonText(buttonGroup).equals("Mã đọc giả")) {
    	
    for(Object[] i: PhieuMuonDao.getinstance().Timkiemtheomadg(textField_tk.getText()))
    {
    
    	model_table.addRow(new Object [] {i[0],i[1],i[2]});
    }
    }
    }
    public void Duathongtinvaobang() {
    	
    	DefaultTableModel table_Phieumuon = (DefaultTableModel)table_3.getModel();
    	table_Phieumuon.setRowCount(0);
		try {
			List<Object[]> A = PhieuMuonDao.getinstance().LayPhieuMuon(); 
			for(Object[] i:A)
			{
				table_Phieumuon.addRow(new Object[]{i[0], i[1], i[2]});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void hienthitabletra() {
    	int a = (Integer)comboBox_Madocgia.getSelectedItem();
    	DefaultTableModel table_Phieutra = (DefaultTableModel)table_2.getModel();
		try {
			List<Object[]> A = QuanLiTraSachDao.getinstance().SachDangMuon(a); 
			if (A.size() == 0) table_Phieutra.setRowCount(0);
			else {
			int stt = 0;
			for(Object[] i:A)
			{   stt++;
			    int t = KhoangCachMuon((LocalDate) i[1]);
				table_Phieutra.addRow(new Object[]{stt,i[0], i[1],t,TinhTienNo(t)});
			}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
    }
    public int KhoangCachMuon(LocalDate anyDate) {
    	LocalDate today = LocalDate.now();
        
        int daysBetween = (int) ChronoUnit.DAYS.between(anyDate,today);
        return daysBetween;
    }
    public int TinhTienNo(int t) {
    	Object[] k =  QuyDinhDao.getinstance().selectByID(1);
    	
    	  if (t <= (int) k[5]) return 0 ;
    	  else  return (int) (t *(int)k[6]);
    }
    
    public List<Object[]> SachDangChonMuon(){
    	DefaultTableModel model = (DefaultTableModel) table_2.getModel();
        int colCount = model.getColumnCount();
        int[] selectedRows = table_2.getSelectedRows();

        List<Object[]> selectedData = new ArrayList<>();

        for (int row : selectedRows) {
            Object[] rowData = new Object[colCount];        
            for (int col = 1; col < colCount; col++) {
                rowData[col] = model.getValueAt(row, col);
            }
            selectedData.add(rowData);
        }

        return selectedData;
    }
    public Object[] LayThongTinDocGia() {
        Object[] a = new Object[5];
        a[0] = comboBox_Madocgia.getSelectedItem();
        a[1] = textField_ten.getText();
        a[2] = this.SetTime();
        a[3] = Integer.valueOf(this.textField_tong.getText());
        return a;
    }
    public void ChucNangTimPhieuTra()
    {
    DefaultTableModel model_table= (DefaultTableModel) table_PT.getModel();
    model_table.setRowCount(0);
    if (getSelectedButtonText(buttonGroup_1).equals("Mã phiếu trả")) {
       int stt =0;
    for(Object[] i: QuanLiTraSachDao.getinstance().Timkiemtheomaphieutra(textField_PT.getText()))
    {
    	stt++;
    	model_table.addRow(new Object [] {stt,i[0],i[1],i[2],i[3]});
    }
    }
    if (getSelectedButtonText(buttonGroup_1).equals("Mã đọc giả")) {
    	int stt =0;
    for(Object[] i: QuanLiTraSachDao.getinstance().Timkiemtheomadg(textField_PT.getText()))
    {
        stt++;
    	model_table.addRow(new Object [] {stt,i[0],i[1],i[2],i[3]});
    }
    }
    }
    public void Duathongtinvaobangphieutra() {
    	
    	DefaultTableModel table_Phieutra = (DefaultTableModel)table_PT.getModel();
    	table_Phieutra.setRowCount(0);
		try {
			int stt = 0;
			List<Object[]> A = QuanLiTraSachDao.getinstance().LayPhieuTra(); 
			for(Object[] i:A)
			{ 
				stt++;
				table_Phieutra.addRow(new Object[]{stt,i[0], i[1], i[2],i[3]});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
