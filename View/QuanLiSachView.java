package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
//import Dao.SachDao;
//import Dao.TacGiaDao;
//import Dao.TheLoaiDao;
//import Control.QuanLiSachControl;
import Model.SachModel;
import Model.TacGiaModel;
import Model.TheLoaiModel;

import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ListSelectionModel;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Control.QuanLiSachControl;
import DAO.QuanLiSachDao;
import DAO.TacGiaDao;
import DAO.TheLoaiDao;


public class QuanLiSachView extends JFrame {

	private static final long serialVersionUID = 1L;
    public  JTextField textField_Tensach;
    public  JTextField textField_Nhaxb;
    public  JTextField textField_Ngayxb;
    public  JTextField TextNhapTT;
    private  final  ButtonGroup buttonGroup = new ButtonGroup();
    public JTextField textField_Ngaynhap;
    private JTable table;
    public JTextField textField_Trigia;
    public JComboBox comboBox_theloai;
    public JComboBox comboBox_matg;
    public JComboBox comboBox_TinhTrang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiSachView frame = new QuanLiSachView();
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
	public QuanLiSachView(boolean enableNewButton, boolean enableQunNhnVin, boolean enableQunLMntr, boolean enableBoCoThng, boolean enableThayiQuy, boolean enableThuTinPht) {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		getContentPane().setForeground(new Color(0, 0, 0));
		setBackground(new Color(177, 205, 198));
		setTitle("UIT_LIBRARY");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Doan Cong Tai\\Downloads\\open-book.png"));
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1096, 812);
		
		QuanLiSachControl action = new QuanLiSachControl(this);
				
		JPanel panel = new JPanel();
		panel.setBounds(73, 183, 925, 214);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		
		JLabel lblTnSch = new JLabel("Tên Sách :");
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnSch.setBounds(55, 28, 106, 24);
		panel.add(lblTnSch);
		
		JLabel lblThLoi = new JLabel("Thể Loại:");
		lblThLoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThLoi.setBounds(55, 81, 123, 24);
		panel.add(lblThLoi);
		
		JLabel lblNhXutBn = new JLabel("Nhà Xuất Bản :");
		lblNhXutBn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhXutBn.setBounds(55, 180, 123, 24);
		panel.add(lblNhXutBn);
		
		JLabel lblNgyXutBn = new JLabel("Năm Xuất Bản :");
		lblNgyXutBn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgyXutBn.setBounds(484, 32, 123, 24);
		panel.add(lblNgyXutBn);
		
		textField_Tensach = new JTextField();
		textField_Tensach.setColumns(10);
		textField_Tensach.setBounds(188, 27, 184, 30);
		panel.add(textField_Tensach);
		
		textField_Nhaxb = new JTextField();
		textField_Nhaxb.setColumns(10);
		textField_Nhaxb.setBounds(188, 174, 184, 30);
		panel.add(textField_Nhaxb);
		
		textField_Ngayxb = new JTextField();
		textField_Ngayxb.setColumns(10);
		textField_Ngayxb.setBounds(666, 28, 184, 30);
		panel.add(textField_Ngayxb);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 11, 1024, 114);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "T\u00ECm theo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(25, 26, 580, 65);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnMasach = new JRadioButton("Mã sách");
		buttonGroup.add(rdbtnMasach);
		rdbtnMasach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMasach.setBounds(41, 19, 111, 23);
		panel_2.add(rdbtnMasach);
		
		JRadioButton rdbtnTensach = new JRadioButton("Tên sách");
		buttonGroup.add(rdbtnTensach);
		rdbtnTensach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTensach.setBounds(167, 19, 111, 23);
		panel_2.add(rdbtnTensach);
		
		JRadioButton rdbtnTenTG = new JRadioButton("Tên tác giả");
		buttonGroup.add(rdbtnTenTG);
		rdbtnTenTG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTenTG.setBounds(307, 19, 111, 23);
		panel_2.add(rdbtnTenTG);
		
		JRadioButton rdbtnTheloai = new JRadioButton("Thể loại");
		buttonGroup.add(rdbtnTheloai);
		rdbtnTheloai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTheloai.setBounds(446, 19, 111, 23);
		panel_2.add(rdbtnTheloai);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new TitledBorder(null, "Nh\u1EADp th\u00F4ng tin t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1.setBounds(675, 26, 330, 65);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		TextNhapTT = new JTextField();
		TextNhapTT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TextNhapTT.setBounds(51, 23, 235, 31);
		panel_2_1.add(TextNhapTT);
		TextNhapTT.setColumns(10);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setBackground(new Color(153, 180, 209));
		btnHome.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\home.png"));
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHome.setBounds(206, 136, 117, 36);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  dispose();
				  HomePageView hp = new HomePageView(enableNewButton,  enableQunNhnVin,  enableQunLMntr,  enableBoCoThng,  enableThayiQuy,  enableThuTinPht);
				  hp.setVisible(true);
			}
		});
		
		JButton btnThem = new JButton("Thêm");
	    btnThem.addActionListener(action);
		btnThem.setBackground(Color.WHITE);
		btnThem.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\plus.png"));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setBounds(165, 410, 99, 36);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(action);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.setBackground(Color.WHITE);
		btnSua.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\updated.png"));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSua.setBounds(339, 410, 99, 36);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\bin.png"));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoa.setBounds(498, 410, 99, 36);
		
		JButton btnLoadds = new JButton("Load danh sách");
		btnLoadds.addActionListener(action);
		btnLoadds.setBackground(Color.WHITE);
		btnLoadds.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\loading.png"));
		btnLoadds.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoadds.setBounds(453, 138, 196, 36);
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		getContentPane().add(panel_1);
		getContentPane().add(btnHome);
		getContentPane().add(btnThem);
		getContentPane().add(btnSua);
		getContentPane().add(btnXoa);
		getContentPane().add(btnLoadds);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(25, 457, 1024, 214);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 18, 1004, 185);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "Th\u1EC3 lo\u1EA1i", "T\u00ECnh Tr\u1EA1ng"
			}
		));
		
		DefaultTableModel table_model = (DefaultTableModel)table.getModel();
		try {
			List<Object[]> A = QuanLiSachDao.getinstance().selectAll(); 
			int stt1 = 0;
			for(Object[] i:A)
			{
				stt1++;
				table_model.addRow(new Object[] {stt1,i[0],i[1],i[2],i[3],i[8]});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
		panel_3.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{scrollPane, table}));
		
	
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		btnLuu.setBackground(Color.WHITE);
		btnLuu.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\diskette.png"));
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLuu.setBounds(654, 410, 99, 36);
		getContentPane().add(btnLuu);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(action);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHuy.setBackground(Color.WHITE);
		btnHuy.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\forbidden.png"));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHuy.setBounds(812, 410, 99, 36);
		getContentPane().add(btnHuy);
		
		JLabel lblTnTcGi = new JLabel("Tác Giả :");
		lblTnTcGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnTcGi.setBounds(55, 129, 123, 24);
		panel.add(lblTnTcGi);
		
		JLabel lblNgyNhp = new JLabel("Ngày Nhập : ");
		lblNgyNhp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgyNhp.setBounds(484, 82, 123, 24);
		panel.add(lblNgyNhp);
		
		textField_Ngaynhap = new JTextField();
		textField_Ngaynhap.setColumns(10);
		textField_Ngaynhap.setBounds(666, 81, 184, 30);
		panel.add(textField_Ngaynhap);
		
		textField_Trigia = new JTextField();
		textField_Trigia.setColumns(10);
		textField_Trigia.setBounds(666, 130, 184, 30);
		panel.add(textField_Trigia);
		
		JLabel lblTrGi = new JLabel("Trị Giá :");
		lblTrGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTrGi.setBounds(484, 130, 123, 24);
		panel.add(lblTrGi);
		
		
		comboBox_theloai = new JComboBox();
		comboBox_theloai.addItem("");
		for(Object[] i: TheLoaiDao.getinstance().selectAll())
		{
			comboBox_theloai.addItem(i[1]);
		}
		comboBox_theloai.setBounds(188, 75, 184, 30); 
		panel.add(comboBox_theloai);
		
		comboBox_matg = new JComboBox();
		comboBox_matg.addItem("");
		for (Object[] j : TacGiaDao.getinstance().selectAll()) {
			  comboBox_matg.addItem(j[1]);
		}
		comboBox_matg.setBounds(188, 121, 184, 30);
		panel.add(comboBox_matg);
		
		JLabel lblTnhTrng = new JLabel("Tình Trạng:");
		lblTnhTrng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnhTrng.setBounds(484, 174, 123, 24);
		panel.add(lblTnhTrng);
		
	    comboBox_TinhTrang = new JComboBox();
	    comboBox_TinhTrang.addItem("Có sẵn");
		comboBox_TinhTrang.setBounds(666, 174, 184, 30);
		panel.add(comboBox_TinhTrang);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTnSch, lblThLoi, lblNhXutBn, lblNgyXutBn, textField_Tensach, textField_Nhaxb, textField_Ngayxb, lblTnTcGi, lblNgyNhp, textField_Ngaynhap, textField_Trigia, lblTrGi, comboBox_theloai, comboBox_matg, lblTnhTrng, lblTnhTrng, comboBox_TinhTrang}));
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(action);
		btnTim.setBackground(Color.WHITE);
		btnTim.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\search (1).png"));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(759, 136, 127, 36);
		getContentPane().add(btnTim);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel, lblTnSch, lblThLoi, lblNhXutBn, lblNgyXutBn, textField_Tensach, textField_Nhaxb, textField_Ngayxb, lblTnTcGi, lblNgyNhp, textField_Ngaynhap, textField_Trigia, lblTrGi, comboBox_theloai, comboBox_matg, lblTnhTrng, panel_1, panel_2, rdbtnMasach, rdbtnTensach, rdbtnTenTG, rdbtnTheloai, panel_2_1, TextNhapTT, btnHome, btnThem, btnSua, btnXoa, btnLoadds, panel_3, scrollPane, table, btnLuu, btnHuy, btnTim, lblTnhTrng, comboBox_TinhTrang}));
		
	
		
	}

	
	
	public QuanLiSachView() throws HeadlessException {
		super();
	}

	public void xoaForm() {
	
		textField_Ngaynhap.setText("");
		textField_Ngayxb.setText("");
		textField_Nhaxb.setText("");
		comboBox_matg.setSelectedIndex(-1);
		textField_Tensach.setText("");
        comboBox_theloai.setSelectedIndex(-1);
		textField_Trigia.setText("");
		TextNhapTT.setText("");
		comboBox_TinhTrang.setSelectedIndex(-1);
		
	}
	
	public void ChucNangThem() 
	{
         
		String tenSach = this.textField_Tensach.getText();
		String nhaxb = this.textField_Nhaxb.getText();
	    int namxb = Integer.valueOf(this.textField_Ngayxb.getText());
		String theLoai = (String)this.comboBox_theloai.getSelectedItem();
		int matheloai = Integer.valueOf(this.comboBox_theloai.getSelectedIndex());
		TheLoaiModel tl = new TheLoaiModel(matheloai, theLoai);
		String tenTG = (String)this.comboBox_matg.getSelectedItem();
		int matacgia = Integer.valueOf(this.comboBox_matg.getSelectedIndex());
		TacGiaModel tg = new TacGiaModel(matacgia, tenTG);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ngayNhap = this.textField_Ngaynhap.getText();
		LocalDate ngaynhap= LocalDate.parse(ngayNhap, formatter);
		
		String triGia = this.textField_Trigia.getText();
		String tinhTrang =(String) this.comboBox_TinhTrang.getSelectedItem();
		
	    SachModel s = new SachModel(tenSach, nhaxb, namxb, ngaynhap, tg, tl, triGia, tinhTrang);
	    QuanLiSachDao.getinstance().insert(s);
	    showtable();
	}
		
	public void showtable()
	{
		DefaultTableModel model_table=  (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);int stt = 0;
		for(Object[] i: QuanLiSachDao.getinstance().selectAll())
		{
			stt +=1;
			model_table.addRow(new Object[] {stt,i[0],i[1],i[2],i[3],i[8]});
		}
		model_table.fireTableDataChanged();
	}
	
public void hienThi() {
		
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    int i_row = table.getSelectedRow();   
	    int maSach =  (Integer)model_table.getValueAt(i_row, 1);
	    Object[] i = QuanLiSachDao.getinstance().selectByID(maSach);
		this.textField_Tensach.setText(i[1]+"");
		this.comboBox_matg.setSelectedItem(i[2]+"");
		this.comboBox_theloai.setSelectedItem(i[3]+"");
		this.textField_Nhaxb.setText(i[4]+"");
		this.textField_Ngayxb.setText(i[5]+"");
		LocalDate ngaynhap = (LocalDate) i[6];
		this.textField_Ngaynhap.setText(ngaynhap.format(formatter));
		this.textField_Trigia.setText(i[7]+"");
		this.comboBox_TinhTrang.setSelectedItem(i[8]+"");
		
		
	}
	
public int getSachDangChon()
{
	DefaultTableModel model_table = (DefaultTableModel) table.getModel();
    int i_row = table.getSelectedRow(); 
    int maSach =  (Integer)model_table.getValueAt(i_row, 1);
    return maSach;
	
	
}

public void ChucNangSua()
{  
	        int  maSach = getSachDangChon();
			String tenSach = this.textField_Tensach.getText();
			String nhaxb = this.textField_Nhaxb.getText();
		    int namxb = Integer.valueOf(this.textField_Ngayxb.getText());
			String theLoai = (String)this.comboBox_theloai.getSelectedItem();
			int matheloai = Integer.valueOf(this.comboBox_theloai.getSelectedIndex());
			TheLoaiModel tl = new TheLoaiModel(matheloai, theLoai);
			String tenTG = (String)this.comboBox_matg.getSelectedItem();
			int matacgia = Integer.valueOf(this.comboBox_matg.getSelectedIndex());
			TacGiaModel tg = new TacGiaModel(matacgia, tenTG);
			LocalDate ngaynhap = LocalDate.parse(this.textField_Ngaynhap.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));	
			String triGia = this.textField_Trigia.getText();
			String tinhTrang =(String) this.comboBox_TinhTrang.getSelectedItem();
			
		    SachModel s = new SachModel(maSach, tenSach, nhaxb, namxb, ngaynhap, tg, tl, triGia, tinhTrang);
		    QuanLiSachDao.getinstance().update(s);
		   
		    showtable();
}
public void ChucNangXoa() {
	
	DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	int i_row = table.getSelectedRow();
	int luachon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa");
	if (luachon == JOptionPane.YES_NO_OPTION) 
		{
		 int s = getSachDangChon();
	     QuanLiSachDao.getinstance().delete(s);
		}
	showtable();
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
String selectedOption = getSelectedButtonText(buttonGroup);
if (selectedOption == null) {
	 JOptionPane.showMessageDialog(this, "Vui lòng chọn một thuộc tính tìm kiếm.");
     return;
}
else {
DefaultTableModel model_table= (DefaultTableModel) table.getModel();
model_table.setRowCount(0);
if (getSelectedButtonText(buttonGroup).equals("Mã sách")) {
	int stt = 0;
for(Object[] i: QuanLiSachDao.getinstance().selectByMa(TextNhapTT.getText()))
{
	stt++;
	model_table.addRow(new Object [] {stt,i[0],i[1],i[2],i[3],i[8]});
}
}
if (getSelectedButtonText(buttonGroup).equals("Tên sách")) {
	int stt = 0;
for(Object[] i: QuanLiSachDao.getinstance().selectByTenSach(TextNhapTT.getText()))
{
	stt++;
	model_table.addRow(new Object [] {stt,i[0],i[1],i[2],i[3],i[8]});
}
}
if (getSelectedButtonText(buttonGroup).equals("Tên tác giả")) {
	int stt = 0;
for(Object[] i: QuanLiSachDao.getinstance().selectByTenTg(TextNhapTT.getText()))
{
	stt++;
	model_table.addRow(new Object [] {stt,i[0],i[1],i[2],i[3],i[8]});
}
}
if (getSelectedButtonText(buttonGroup).equals("Thể loại")) {
	int stt = 0;
for(Object[] i: QuanLiSachDao.getinstance().selectByTheLoai(TextNhapTT.getText()))
{
	stt++;
	model_table.addRow(new Object [] {stt,i[0],i[1],i[2],i[3],i[8]});
}
}
model_table.fireTableDataChanged();
}
}
public void thucHienLoadds() {
    showtable();
}

//public void Home() {
//	
//	dispose();
//   HomePageView hp = new HomePageView();
//   hp.setVisible(true);
//}
}
