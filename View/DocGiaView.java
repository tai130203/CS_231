package View;

//import controller.qltv_controller;
//import model.DocGia;
//import model.qltv_model;
//import DAO.DocGiaDAO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Control.DocGiaControl;
import DAO.DocGiaDao;
import DAO.QuanLiSachDao;
import DAO.TheLoaiDao;
import Model.DocGiaModel;
import Model.LoaiDocGiaModel;
import Model.TacGiaModel;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ButtonGroup;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.swing.JOptionPane;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.ImageIcon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;

public class DocGiaView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	public JTextField txthoTenDG;
	public JTextField txtdiaChi;
	public JTextField txtemail;
	private JTextField textField_search;
	public JTextField txtngSinh;
	private JTable table;
	public JComboBox comboBox_maLoaiDG;
	public JTextField txtngLapThe;
	private JTextField txtNgayHetHan;
	private int maDG;
	private JTextField btnSearch;

    
    private  final  ButtonGroup buttonGroup = new ButtonGroup();
    
	public JTextField getTxtNgaySinh() {
	    return txtngSinh;
	}

	public void setNgayHetHan(Date ngayHetHan) {
	    txtNgayHetHan.setText(new SimpleDateFormat("dd/MM/yyyy").format(ngayHetHan));
	} 
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocGiaView frame = new DocGiaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.getStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public DocGiaView(boolean enableNewButton, boolean enableQunNhnVin, boolean enableQunLMntr, boolean enableBoCoThng, boolean enableThayiQuy, boolean enableThuTinPht) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Doan Cong Tai\\Downloads\\open-book.png"));
		
		setForeground(new Color(0, 0, 0));
		setTitle("UIT_LIBRARY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 728);
		
		DocGiaControl action = new DocGiaControl(this);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm \u0111\u1ECDc gi\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(10, 11, 1077, 115);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm theo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 31, 315, 56);
		panel_2.add(panel);
		panel.setBackground(SystemColor.menu);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_maDG = new JRadioButton("Mã độc giả");
		rdbtnNewRadioButton_maDG.setBounds(22, 21, 103, 21);
		panel.add(rdbtnNewRadioButton_maDG);
		rdbtnNewRadioButton_maDG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		buttonGroup.add(rdbtnNewRadioButton_maDG);
		
		JRadioButton rdbtnNewRadioButton_tenDG = new JRadioButton("Tên độc giả");
		rdbtnNewRadioButton_tenDG.setBounds(180, 21, 103, 21);
		panel.add(rdbtnNewRadioButton_tenDG);
		rdbtnNewRadioButton_tenDG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup.add(rdbtnNewRadioButton_tenDG);	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(546, 17, 436, 70);
		panel_2.add(panel_1);
		panel_1.setBackground(SystemColor.menu);
		panel_1.setLayout(null);
			
			textField_search = new JTextField();
			textField_search.setBounds(46, 24, 311, 31);
			panel_1.add(textField_search);
			textField_search.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_search.setColumns(10);
			
			JButton btnSearch_1 = new JButton("");
			btnSearch_1.setBounds(379, 24, 47, 31);
			panel_1.add(btnSearch_1);
			
				btnSearch_1.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\search (1).png"));
				btnSearch_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            ChucNangTim();
	        }
	    });
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, rdbtnNewRadioButton_maDG, rdbtnNewRadioButton_tenDG, textField_search, panel, panel_1, panel_2, btnSearch_1}));
		
		txtNgayHetHan = new JTextField();
        txtNgayHetHan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        txtNgayHetHan.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\plus.png"));
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(139, 373, 118, 31);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\bin.png"));
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(319, 373, 110, 31);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\loading.png"));
		btnSua.addActionListener(action);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(503, 373, 104, 31);
		contentPane.add(btnSua);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\forbidden.png"));
		btnHuy.addActionListener(action);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuy.setBounds(857, 373, 110, 31);
		contentPane.add(btnHuy);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setBackground(SystemColor.activeCaption);
//		btnHome.addActionListener(action);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  dispose();
				  HomePageView hp = new HomePageView( enableNewButton,  enableQunNhnVin,  enableQunLMntr,  enableBoCoThng,  enableThayiQuy,  enableThuTinPht);
				  hp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\home.png"));
		
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHome.setBounds(287, 137, 136, 31);
		contentPane.add(btnHome);
		
		JButton btnReload = new JButton("Load lại danh sách");
		btnReload.addActionListener(action);
		btnReload.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\reload.png"));
		
		btnReload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReload.setBounds(606, 137, 216, 31);
		contentPane.add(btnReload);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(20, 435, 1054, 231);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0111\u1ED9c gi\u1EA3", "T\u00EAn \u0111\u1ED9c gi\u1EA3", "Lo\u1EA1i \u0111\u1ED9c gi\u1EA3", "Ng\u00E0y sinh", "\u0110\u1ECBa ch\u1EC9", "Email", "Ng\u00E0y l\u1EADp th\u1EBB", "Ng\u00E0y h\u1EBFt h\u1EA1n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
		table.getColumnModel().getColumn(4).setPreferredWidth(115);
		table.getColumnModel().getColumn(5).setPreferredWidth(115);
		table.getColumnModel().getColumn(6).setPreferredWidth(115);
		table.getColumnModel().getColumn(7).setPreferredWidth(115);
		DefaultTableModel table_model = (DefaultTableModel)table.getModel();
		this.showtable();
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Danh s\u00E1ch \u0111\u1ECDc gi\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(SystemColor.menu);
		panel_4.setBounds(10, 415, 1077, 262);
		contentPane.add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin \u0111\u1ED9c gi\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(40, 179, 1018, 183);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ:");
		lblNewLabel_4.setBounds(602, 41, 112, 31);
		panel_3.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBounds(602, 82, 112, 31);
		panel_3.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_6 = new JLabel("Ngày lập thẻ:");
		lblNewLabel_6.setBounds(602, 123, 112, 31);
		panel_3.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtdiaChi = new JTextField();
		txtdiaChi.setBounds(724, 42, 187, 31);
		panel_3.add(txtdiaChi);
		txtdiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdiaChi.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(724, 83, 187, 31);
		panel_3.add(txtemail);
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtemail.setColumns(10);
		
		txtngLapThe = new JTextField();
		txtngLapThe.setBounds(724, 124, 187, 31);
		panel_3.add(txtngLapThe);
		txtngLapThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtngLapThe.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Loại độc giả:");
		lblNewLabel.setBounds(58, 81, 103, 31);
		panel_3.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		comboBox_maLoaiDG = new JComboBox();
		comboBox_maLoaiDG.setBounds(163, 82, 187, 31);
		panel_3.add(comboBox_maLoaiDG);
		comboBox_maLoaiDG.setForeground(new Color(0, 0, 0));
		comboBox_maLoaiDG.setToolTipText("");
		comboBox_maLoaiDG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_maLoaiDG.addItem("");
		for(Object[] i: DocGiaDao.getinstance().selectAllTheLoaiDG())
		{
			comboBox_maLoaiDG.addItem(i[1]);
		}
		
		JLabel lblNewLabel_3 = new JLabel("Tên độc giả:");
		lblNewLabel_3.setBounds(58, 41, 103, 31);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txthoTenDG = new JTextField();
		txthoTenDG.setBounds(163, 42, 187, 31);
		panel_3.add(txthoTenDG);
		txthoTenDG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txthoTenDG.setColumns(10);
		
		txtngSinh = new JTextField();
		txtngSinh.setBounds(163, 124, 188, 31);
		panel_3.add(txtngSinh);
		txtngSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtngSinh.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Ngày sinh:");
		lblNewLabel_9.setBounds(58, 123, 91, 31);
		panel_3.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBounds(686, 373, 108, 31);
		contentPane.add(btnLuu);
		btnLuu.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\diskette.png"));
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
	}
	
	public DocGiaView() throws HeadlessException {
		super();
	}

	public void xoaForm() {
        
        txthoTenDG.setText("");
        txtdiaChi.setText("");
        txtngSinh.setText("");
        txtemail.setText("");
        txtngLapThe.setText("");
        txtNgayHetHan.setText("");
        textField_search.setText("");
        comboBox_maLoaiDG.setSelectedIndex(-1);
    }
	
	public void ChucNangThem() {
	    String hoTenDG = this.txthoTenDG.getText();
	    String diaChi = this.txtdiaChi.getText();
	    String email = this.txtemail.getText();
	    LocalDate ngSinh = LocalDate.parse(this.txtngSinh.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    LocalDate ngLapThe = LocalDate.parse(this.txtngLapThe.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    LocalDate ngHetHan = ngLapThe.plusMonths(6);
	    String tenloaidg = (String)this.comboBox_maLoaiDG.getSelectedItem();
		int maloaidg = Integer.valueOf(this.comboBox_maLoaiDG.getSelectedIndex());
		LoaiDocGiaModel loaidg = new LoaiDocGiaModel(maloaidg, tenloaidg);
	    
	    DocGiaModel docGia = new DocGiaModel(hoTenDG, ngSinh, diaChi, email, ngLapThe, ngHetHan, loaidg);

	    
	    DocGiaDao.getinstance().insert(docGia);
	    
	    showtable();
	}
	
	public void showtable() {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    model_table.setRowCount(0);
	   // List<Object[]> data = DocGiaDao.getinstance().selectAll();

	    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//	    for (Object[] record : data) {
//	        Object[] rowData = new Object[12];
//
//	        rowData[0] = record[0];
//	        rowData[1] = record[1];
//
//	        if (record[2] instanceof LocalDate) {
//	            rowData[2] = ((LocalDate) record[2]).format(outputFormatter);
//	        } else if (record[2] instanceof String) {
//	            try {
//	                LocalDate date = LocalDate.parse((String) record[2], inputFormatter);
//	                rowData[2] = date.format(outputFormatter);
//	            } catch (DateTimeParseException e) {
//	                rowData[2] = record[2];
//	            }
//	        } else {
//	            rowData[2] = record[2];
//	        }
//
//	        rowData[3] = record[3];
//	        rowData[4] = record[4];
//	        rowData[5] = record[5];
//
//	        if (record[6] instanceof LocalDate) {
//	            rowData[6] = ((LocalDate) record[6]).format(outputFormatter);
//	        } else if (record[6] instanceof String) {
//	            try {
//	                LocalDate date = LocalDate.parse((String) record[6], inputFormatter);
//	                rowData[6] = date.format(outputFormatter);
//	            } catch (DateTimeParseException e) {
//	                rowData[6] = record[6];
//	            }
//	        } else {
//	            rowData[6] = record[6];
//	        }
//
//	        if (record[7] instanceof LocalDate) {
//	            rowData[7] = ((LocalDate) record[7]).format(outputFormatter);
//	        } else if (record[7] instanceof String) {
//	            try {
//	                LocalDate date = LocalDate.parse((String) record[7], inputFormatter);
//	                rowData[7] = date.format(outputFormatter);
//	            } catch (DateTimeParseException e) {
//	                rowData[7] = record[7];
//	            }
//	        } else {
//	            rowData[7] = record[7];
//	        }
//
//	        rowData[8] = record[8];
//	        rowData[9] = record[9];
//	        rowData[10] = record[10];
//	        rowData[11] = record[11];
//
//	        model_table.addRow(rowData);
//	    }
//
//	    model_table.fireTableDataChanged();
		for(Object[] i: DocGiaDao.getinstance().selectAll())
		{
			model_table.addRow(new Object[] {i[0],i[1],i[2],i[3],i[4],i[5],i[6],i[7]});
		}
		model_table.fireTableDataChanged();
	}
	
	public void hienThi() {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    int i_row = table.getSelectedRow();
	    if (i_row >= 0) {
	        int maDG = (Integer) model_table.getValueAt(i_row, 0);
	        DocGiaModel dg =DocGiaDao.getinstance().selectdg(maDG);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            this.txthoTenDG.setText(dg.getTenDG().toString());
	            this.txtngSinh.setText(((LocalDate) dg.getNgaySinh()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	            this.txtdiaChi.setText(dg.getDiaChi().toString());
	            this.txtemail.setText(dg.getEmail().toString());
	            this.txtngLapThe.setText(((LocalDate) dg.getNgayLap()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	            this.comboBox_maLoaiDG.setSelectedItem(dg.getMaLoaiDocGia().getTenLoaiDocGia());
	    }
	}


	
	public int getDocGiaDangChon() {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    int i_row = table.getSelectedRow();
	    if (i_row == -1) {
	        throw new IllegalStateException("Không có độc giả nào được chọn.");
	    }
	    Object value = model_table.getValueAt(i_row, 0);
	    int maDG = Integer.parseInt(value.toString());
	    return maDG;
	}
	
	public void ChucNangSua() {
		int maDG = getDocGiaDangChon();
		String hoTenDG = this.txthoTenDG.getText();
	    String diaChi = this.txtdiaChi.getText();
	    String email = this.txtemail.getText();
	    LocalDate ngSinh = LocalDate.parse(this.txtngSinh.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    LocalDate ngLapThe = LocalDate.parse(this.txtngLapThe.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    LocalDate ngHetHan = ngLapThe.plusMonths(6);
	    String tenloaidg = (String)this.comboBox_maLoaiDG.getSelectedItem();
		int maloaidg = Integer.valueOf(this.comboBox_maLoaiDG.getSelectedIndex());
		LoaiDocGiaModel loaidg = new LoaiDocGiaModel(maloaidg, tenloaidg);
	    
	    DocGiaModel docGia = new DocGiaModel(maDG, hoTenDG, ngSinh, diaChi, email, ngLapThe, ngHetHan, loaidg);
        DocGiaDao.getinstance().update(docGia);
        showtable();
    }
	
	public void ChucNangXoa() {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    int i_row = table.getSelectedRow();
	    if (i_row == -1) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một độc giả để xóa.");
	        return;
	    }
	    int luachon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
	    if (luachon == JOptionPane.YES_OPTION) {
	        int maDG = getDocGiaDangChon();
	        DocGiaDao.getinstance().delete(maDG);
	        showtable();
	        JOptionPane.showMessageDialog(this, "Độc giả đã được xóa thành công!");
	    }
	}

	public void ChucNangTim() {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    model_table.setRowCount(0);

	    String selectedOption = getSelectedButtonText(buttonGroup);

	    if (selectedOption == null) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một thuộc tính tìm kiếm.");
	        return;
	    }

	    String searchText = textField_search.getText();
	    List<Object[]> results = new ArrayList<>();
	    if (selectedOption.equals("Mã độc giả")) {
	        results = DocGiaDao.getinstance().selectByMaDG(searchText);
	    } else if (selectedOption.equals("Tên độc giả")) {
	        results = DocGiaDao.getinstance().selectByTenDG(searchText);
	    }

	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    if (results.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp.");
	    } else {
	        for (Object[] i : results) {
	            if (i.length >= 7) { // Đảm bảo mảng có đủ 12 phần tử
	                String ngaySinh = formatDate(i[3], dateFormatter);
	                String ngayLapThe = formatDate(i[6], dateFormatter);
	                String ngayHetHan = formatDate(i[7], dateFormatter);

	                model_table.addRow(new Object[]{
	                    i[0],  // Mã độc giả
	                    i[1],  // Tên độc giả
	                    i[2],
	                    ngaySinh,
	                    i[4],  // Địa chỉ
	                    i[5],  // Email
	                    ngayLapThe,  // Ngày lập thẻ
	                    ngayHetHan,  // Ngày hết hạn
	
	                });
	            } else {
	                System.err.println("Dữ liệu không đủ phần tử: " + Arrays.toString(i));
	            }
	        }
	    }

	    model_table.fireTableDataChanged();
	}
	
	private String formatDate(Object dateObj, DateTimeFormatter formatter) {
	    if (dateObj instanceof LocalDate) {
	        return ((LocalDate) dateObj).format(formatter);
	    }
	    return "";
	}

	private String getSelectedButtonText(ButtonGroup buttonGroup) {
	    for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	        AbstractButton button = buttons.nextElement();
	        if (button.isSelected()) {
	            return button.getText();
	        }
	    }
	    return null;
	}
	
	public void thucHienLoadds() {
		showtable();
	}

//	public void Home() {		
//	   dispose();
//	   HomePageView hp = new HomePageView(enableNewButton, enableQunNhnVin, enableQunLMntr, enableBoCoThng, enableThayiQuy, enableThuTinPht);
//	   hp.setVisible(true);
//	}
}