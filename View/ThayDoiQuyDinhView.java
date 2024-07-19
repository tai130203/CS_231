package View;

import java.awt.Component;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.QuanLiSachControl;
import Control.ThayDoiQuyDinhControl;
import DAO.QuyDinhDao;
import DAO.TheLoaiDao;
import Model.QuyDinhModel;
import Model.SachModel;
import Model.TheLoaiModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ThayDoiQuyDinhView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public JTextField textField_TenTheLoai;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JSpinner spinner_KhoangCachNam;
	private JSpinner spinner_TuoiToiDa;
	private JSpinner spinner_TuoiToiToiThieu;
	private JSpinner spinner_ThoiHanThe;
	private JCheckBox chckbxNewCheckBox;
	private JSpinner spinner_SoSachMuonToiDa;
	private JSpinner spinner_ThoiGianMuonToiDa;
	private JSpinner spinner_SoTienPhat;
	private JCheckBox chckbxNewCheckBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThayDoiQuyDinhView frame = new ThayDoiQuyDinhView();
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
	public ThayDoiQuyDinhView(boolean enableNewButton, boolean enableQunNhnVin, boolean enableQunLMntr, boolean enableBoCoThng, boolean enableThayiQuy, boolean enableThuTinPht) {
		setTitle("UIT_LIBRARY");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Doan Cong Tai\\Downloads\\open-book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1149, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ThayDoiQuyDinhControl Action = new ThayDoiQuyDinhControl(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 1135, 637);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Sách", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(25, 11, 539, 415);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 519, 358);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 Th\u1EC3 Lo\u1EA1i", "T\u00EAn Th\u1EC3 Lo\u1EA1i"
			}
		));
		DefaultTableModel table_model = (DefaultTableModel)table.getModel();
		try {
			List<Object[]> listTheLoai = TheLoaiDao.getinstance().selectAll();
			int stt = 0;
			for(Object[] i:listTheLoai)
			{
				stt++;
				table_model.addRow(new Object[] {stt, i[0], i[1]});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Thể Loại\r\n");
		lblNewLabel.setBounds(205, 12, 116, 23);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.text);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(589, 11, 509, 415);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBounds(51, 54, 419, 329);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Khoảng cách năm tối đa:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(35, 67, 169, 26);
		panel_5.add(lblNewLabel_4);
		
		JButton btnChinhSua1 = new JButton("Chỉnh sửa");
		btnChinhSua1.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\edit.png"));
		btnChinhSua1.setBackground(SystemColor.activeCaption);
		
		btnChinhSua1.addActionListener(Action);
		btnChinhSua1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(btnChinhSua1, "Chỉnh sửa thành công!");
			}
		});
		btnChinhSua1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChinhSua1.setBounds(162, 203, 142, 39);
		panel_5.add(btnChinhSua1);
		
	    spinner_KhoangCachNam = new JSpinner();
	    spinner_KhoangCachNam.setValue(Action.getByid()[0]);
	    spinner_KhoangCachNam.setBounds(214, 67, 120, 25);
		panel_5.add(spinner_KhoangCachNam);
		
		textField_TenTheLoai = new JTextField();
		textField_TenTheLoai.setBounds(261, 456, 144, 20);
		panel.add(textField_TenTheLoai);
		textField_TenTheLoai.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Thể Loại:");
		lblNewLabel_1_1.setBackground(SystemColor.info);
		lblNewLabel_1_1.setBounds(119, 457, 84, 17);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnThm = new JButton("Thêm");
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnThm.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\plus.png"));
		btnThm.setBackground(SystemColor.activeCaption);
		btnThm.setBounds(64, 507, 89, 33);
		panel.add(btnThm);
		
		JButton btnXoa = new JButton("Xóa ");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\bin.png"));
		btnXoa.setBackground(SystemColor.activeCaption);
		btnXoa.setBounds(192, 507, 89, 33);
		panel.add(btnXoa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSa.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\updated.png"));
		btnSa.setBackground(SystemColor.activeCaption);
		btnSa.setBounds(316, 507, 89, 33);
		panel.add(btnSa);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLu.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\diskette.png"));
		btnLu.setBackground(SystemColor.activeCaption);
		btnLu.setBounds(444, 507, 89, 33);
		panel.add(btnLu);
		
		JButton btnHome1 = new JButton("HOME");
		btnHome1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  dispose();
				  HomePageView hp = new HomePageView(enableNewButton,  enableQunNhnVin,  enableQunLMntr,  enableBoCoThng,  enableThayiQuy,  enableThuTinPht);
				  hp.setVisible(true);
			}
		});
		btnHome1.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\home.png"));
		btnHome1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHome1.setBackground(SystemColor.activeCaption);
		btnHome1.setBounds(795, 498, 136, 42);
		panel.add(btnHome1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Độc giả", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton btnChinhSua_2 = new JButton("Chỉnh Sửa\r\n");
		btnChinhSua_2.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\edit.png"));
		btnChinhSua_2.setBackground(SystemColor.activeCaption);
		btnChinhSua_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ChucNangChinhSua2();
				JOptionPane.showMessageDialog(btnChinhSua_2,"Chỉnh sửa thành công!");
			}
		});
		btnChinhSua_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChinhSua_2.setBounds(388, 526, 156, 46);
		panel_4.add(btnChinhSua_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "QUY \u0110\u1ECANH V\u1EC0 \u0110\u1ECCC GI\u1EA2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 19, 1096, 199);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Thời hạn có giá trị thẻ: ");
		lblNewLabel_3_1_1.setBounds(58, 147, 159, 19);
		panel_6.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
	    spinner_TuoiToiDa = new JSpinner();
	    spinner_TuoiToiDa.setValue(Action.getByid()[1]);
		spinner_TuoiToiDa.setBounds(248, 45, 67, 20);
		panel_6.add(spinner_TuoiToiDa);
		
		JLabel lblNewLabel_3_1 = new JLabel("Độ tuổi tối đa: ");
		lblNewLabel_3_1.setBounds(58, 42, 114, 23);
		panel_6.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Độ tuổi tối thiểu: ");
		lblNewLabel_3.setBounds(58, 91, 138, 33);
		panel_6.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		spinner_TuoiToiToiThieu = new JSpinner();
		spinner_TuoiToiToiThieu.setValue(Action.getByid()[2]);
		spinner_TuoiToiToiThieu.setBounds(248, 99, 67, 20);
		panel_6.add(spinner_TuoiToiToiThieu);
		
		spinner_ThoiHanThe = new JSpinner();
		 spinner_ThoiHanThe.setValue(Action.getByid()[3]);
		spinner_ThoiHanThe.setBounds(248, 148, 67, 20);
		panel_6.add(spinner_ThoiHanThe);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "QUY \u0110\u1ECANH V\u1EC0 M\u01AF\u1EE2N TR\u1EA2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(10, 245, 1096, 256);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(547, 21, 1, 1);
		panel_3.setLayout(null);
		panel_7.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Số lượng sách mượn tối đa:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(32, 83, 188, 23);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Thời gian mượn tối đa (ngày) :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(32, 188, 209, 25);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_4 = new JLabel("Số tiền phạt trả trễ mỗi ngày (/sách) :\r\n");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(583, 83, 265, 23);
		panel_3.add(lblNewLabel_2_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(279, 81, 188, 30);
		panel_3.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(279, 187, 188, 30);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(878, 81, 145, 30);
		panel_3.add(textField_2);
		
		JButton btnChinhSua3 = new JButton("Chỉnh Sửa");
		btnChinhSua3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChinhSua3.setBounds(451, 394, 121, 46);
		panel_3.add(btnChinhSua3);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Số tiền thu không vượt quá tiền phạt: ");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1.setBounds(583, 195, 265, 23);
		panel_3.add(lblNewLabel_2_4_1);
		
		chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBounds(878, 180, 42, 58);
		panel_3.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Thời gian mượn tối đa (ngày) :");
		lblNewLabel_2_1_1.setBounds(64, 93, 209, 25);
		panel_7.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_2 = new JLabel("Số lượng sách mượn tối đa:");
		lblNewLabel_2_2.setBounds(64, 49, 188, 23);
		panel_7.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_4_2 = new JLabel("Số tiền phạt trả trễ mỗi ngày (/sách) :\r\n");
		lblNewLabel_2_4_2.setBounds(64, 135, 265, 34);
		panel_7.add(lblNewLabel_2_4_2);
		lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		spinner_SoSachMuonToiDa = new JSpinner();
		spinner_SoSachMuonToiDa.setValue(Action.getByid()[4]);
		
		spinner_SoSachMuonToiDa.setBounds(275, 52, 67, 20);
		panel_7.add(spinner_SoSachMuonToiDa);
		
		spinner_ThoiGianMuonToiDa = new JSpinner();
		 spinner_ThoiGianMuonToiDa.setValue(Action.getByid()[5]);
		spinner_ThoiGianMuonToiDa.setBounds(294, 97, 67, 20);
		panel_7.add(spinner_ThoiGianMuonToiDa);
		
		spinner_SoTienPhat = new JSpinner();
		spinner_SoTienPhat.setValue(Action.getByid()[6]);
		spinner_SoTienPhat.setBounds(356, 144, 67, 20);
		panel_7.add(spinner_SoTienPhat);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Số tiền thu không vượt quá tiền phạt: ");
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4_1_1.setBounds(64, 193, 265, 23);
		panel_7.add(lblNewLabel_2_4_1_1);
		
		chckbxNewCheckBox_1 = new JCheckBox("");
		int k = (int) Action.getByid()[7];
		if (k == 1) {
			chckbxNewCheckBox_1.setSelected(true);
			
		}
		else chckbxNewCheckBox_1.setSelected(false);
		chckbxNewCheckBox_1.setBounds(335, 193, 99, 23);
		panel_7.add(chckbxNewCheckBox_1);
		
		JButton btnHome2 = new JButton("HOME");
		btnHome2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  dispose();
				  HomePageView hp = new HomePageView(enableNewButton,  enableQunNhnVin,  enableQunLMntr,  enableBoCoThng,  enableThayiQuy,  enableThuTinPht);
				  hp.setVisible(true);
			}
		});
		btnHome2.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\home.png"));
		btnHome2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHome2.setBackground(SystemColor.activeCaption);
		btnHome2.setBounds(604, 526, 156, 46);
		panel_4.add(btnHome2);
		btnLu.addActionListener(Action);
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSa.addActionListener(Action);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.addActionListener(Action);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChucNangXoa();
			}
		});
		btnThm.addActionListener(Action);
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	public ThayDoiQuyDinhView() throws HeadlessException {
		super();
	}

	public void showtable()
	{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);
		int stt = 0;
		for(Object[] i: TheLoaiDao.getinstance().selectAll())
		{
			stt++;
			model_table.addRow(new Object[] {stt, i[0], i[1]});
		}
		model_table.fireTableDataChanged();
	}
	
	public void ChucNangThem()
	{
         
		String tentheloai = this.textField_TenTheLoai.getText();
	    TheLoaiModel s = new TheLoaiModel( tentheloai);
	     TheLoaiDao.getinstance().insert(s);
	     this.textField.setText("");
		showtable();
	}
	public int getTheLoaiDangChon()
	{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		int matheloai = (Integer) model_table.getValueAt(i_row, 1);
	
		
		return matheloai;
	}
	public void ChucNangXoa() {
		
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luachon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa");
		if (luachon == JOptionPane.YES_NO_OPTION) 
			{
			 int id = getTheLoaiDangChon();
		     TheLoaiDao.getinstance().delete(id);
			}
		showtable();
	}
public void hienThi() {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    int i_row = table.getSelectedRow();
	    String Tentheloai  = (String)model_table.getValueAt(i_row,2);
		this.textField_TenTheLoai.setText(Tentheloai+"");
		
	}
	
	public void ChucNangSua()
	{
		int matheloai = getTheLoaiDangChon();
		String tentheloai =(String) this.textField_TenTheLoai.getText();
		
		TheLoaiModel s = new TheLoaiModel(matheloai,tentheloai);
		TheLoaiDao.getinstance().update(s);
		this.textField.setText("");
		showtable();
	}
	
	public void ChucNangChinhSua1()
	{
		int ThoihanNhanSach =(Integer) this.spinner_KhoangCachNam.getValue();
		QuyDinhModel s = new QuyDinhModel(ThoihanNhanSach);
		QuyDinhDao.getinstance().update(s);
	
	}
	
	public void ChucNangChinhSua2()
	{
		int DotuoiMin = (Integer)this.spinner_TuoiToiToiThieu.getValue();
		int DotuoiMax = (Integer)this.spinner_TuoiToiDa.getValue();
		int Thoihanthe = (Integer)this.spinner_ThoiHanThe.getValue();
		int Sosachmuontoida = (Integer)this.spinner_SoSachMuonToiDa.getValue();
		int Songaymuontoida = (Integer)this.spinner_ThoiGianMuonToiDa.getValue();
		int Tienphat = (Integer)this.spinner_SoTienPhat.getValue();
		int ChoPhepThu = 0;
		if (this.chckbxNewCheckBox_1.isSelected()) ChoPhepThu = 1; 
		QuyDinhModel s = new QuyDinhModel(DotuoiMax, DotuoiMin, Thoihanthe, Tienphat, ChoPhepThu, Sosachmuontoida, Songaymuontoida);
		QuyDinhDao.getinstance().update1(s);
		
	}
}
