package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

import Control.BaoCaoControl;
import DAO.BaoCaoDao;
import DAO.PhieuMuonDao;
import DAO.QuanLiSachDao;
import DAO.QuyDinhDao;
import DAO.TheLoaiDao;
import Model.BCSachTraTreModel;
import Model.BCTheoTheLoaiModel;
import Model.CT_BCSachTraTreModel;
import Model.CT_BCTheoTheLoaiModel;
import Model.SachModel;
import Model.TheLoaiModel;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;

public class BaoCaoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panel = new JPanel();
	private JTextField textField_thang;
	private JTextField textField_nam;
	private JTable table;
	private JTextField textField_Ngay;
	private JTable table_1;
	private JTextField textField_TongLuotMuon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoCaoView frame = new BaoCaoView();
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
	public BaoCaoView(boolean enableNewButton, boolean enableQunNhnVin, boolean enableQunLMntr, boolean enableBoCoThng, boolean enableThayiQuy, boolean enableThuTinPht) {
		setTitle("UIT_LIBRARY");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Doan Cong Tai\\Downloads\\open-book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        BaoCaoControl action = new BaoCaoControl(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 993, 593);
		contentPane.add(tabbedPane);
		panel.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Báo cáo theo thể loại", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BÁO CÁO THỐNG KÊ TÌNH HÌNH MƯỢN SÁCH THEO THỂ LOẠI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(120, 11, 793, 61);
		panel.add(lblNewLabel);
		
		textField_thang = new JTextField();
		textField_thang.setBounds(294, 83, 96, 20);
		panel.add(textField_thang);
		textField_thang.setColumns(10);
		
		textField_nam = new JTextField();
		textField_nam.setColumns(10);
		textField_nam.setBounds(459, 83, 96, 20);
		panel.add(textField_nam);
		
		JLabel lblNewLabel_1 = new JLabel("Tháng:");
		lblNewLabel_1.setBounds(245, 86, 49, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Năm:");
		lblNewLabel_1_1.setBounds(421, 86, 49, 14);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 168, 978, 338);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 958, 251);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 th\u1EC3 lo\u1EA1i", "T\u00EAn Th\u1EC3 Lo\u1EA1i", "S\u1ED1 l\u01B0\u1EE3t m\u01B0\u1EE3n", "T\u1EC9 l\u1EC7"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(153);
		table.getColumnModel().getColumn(1).setPreferredWidth(154);
		table.getColumnModel().getColumn(2).setPreferredWidth(147);
		table.getColumnModel().getColumn(3).setPreferredWidth(161);
		scrollPane.setViewportView(table);
		
		textField_TongLuotMuon = new JTextField();
		textField_TongLuotMuon.setBounds(798, 289, 125, 27);
		panel_2.add(textField_TongLuotMuon);
		textField_TongLuotMuon.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tổng số lượt mượn:");
		lblNewLabel_4.setBounds(681, 289, 107, 27);
		panel_2.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("In phiếu");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\diskette.png"));
		btnNewButton.addActionListener(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(848, 124, 105, 33);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("/");
		lblNewLabel_2.setBounds(400, 86, 49, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Tìm kiếm");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\search (1).png"));
		btnNewButton_1.addActionListener(action);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(701, 124, 105, 33);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("HOME");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePageView hp = new HomePageView(enableNewButton,  enableQunNhnVin,  enableQunLMntr,  enableBoCoThng,  enableThayiQuy,  enableThuTinPht);
				hp.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\home.png"));
		btnNewButton_2.setBounds(421, 517, 114, 37);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Báo cáo sách trả trễ", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblBoCoThng = new JLabel("BÁO CÁO THỐNG KÊ TÌNH HÌNH SÁCH TRẢ TRỄ");
		lblBoCoThng.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoCoThng.setBounds(131, 29, 719, 28);
		lblBoCoThng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		panel_1.add(lblBoCoThng);
		
		textField_Ngay = new JTextField();
		textField_Ngay.setBounds(405, 91, 150, 26);
		panel_1.add(textField_Ngay);
		textField_Ngay.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(324, 91, 64, 28);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 168, 968, 314);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 948, 292);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u1ED1 s\u00E1ch", "T\u00EAn s\u00E1ch", "Ng\u00E0y m\u01B0\u1EE3n", "S\u1ED1 ng\u00E0y tr\u1EA3 tr\u1EC5"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnInPhiu = new JButton("In phiếu ");
		btnInPhiu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnInPhiu.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\diskette.png"));
		btnInPhiu.addActionListener(action);
		btnInPhiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInPhiu.setBounds(827, 124, 106, 33);
		panel_1.add(btnInPhiu);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePageView hp = new HomePageView(enableNewButton,  enableQunNhnVin,  enableQunLMntr,  enableBoCoThng,  enableThayiQuy,  enableThuTinPht);
				hp.setVisible(true);
			}
		});
		btnHome.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\home.png"));
		btnHome.setBounds(448, 506, 106, 33);
		panel_1.add(btnHome);
		
		JButton btnTmKim = new JButton("Tìm kiếm\r\n");
		btnTmKim.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTmKim.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\search (1).png"));
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DuaThongTinVaoBangTraTre();
			}
		});
		btnTmKim.setBounds(686, 124, 106, 33);
		panel_1.add(btnTmKim);
	}
	public BaoCaoView() throws HeadlessException {
		super();
	}

	public void DuaThongTinVaoBang() {
	    if ((this.textField_thang.getText().isEmpty())||(this.textField_thang.getText().isEmpty())) {
	    	JOptionPane.showMessageDialog(panel, "Thông tin ngày (tháng) đang trống!");
        	this.textField_thang.setText("");
        	this.textField_nam.setText("");
	    }
	    else {
		int thang = Integer.valueOf(this.textField_thang.getText());
	    int nam = Integer.valueOf(this.textField_nam.getText());
        if ((thang >12) || (thang < 0)) {
        	JOptionPane.showMessageDialog(panel, "Tháng không phù hợp");
        	this.textField_thang.setText("");
        	this.textField_nam.setText("");
        }
        else if ((nam <0)) {
        	JOptionPane.showMessageDialog(panel, "Năm không phù hợp");
        	this.textField_thang.setText("");
        	this.textField_nam.setText("");
        }
        else {
        DefaultTableModel table_bctheotl = (DefaultTableModel)table.getModel();
        table_bctheotl.setRowCount(0);
		try {
			List<Object[]> A = BaoCaoDao.getinstance().BCTheoTheLoai(thang,nam); 
			long tong  = 0;
			for(Object[] i:A)
			{ 
				
				tong = tong + (long)i[2];
				
			}
			this.textField_TongLuotMuon.setText(String.valueOf( tong));
			for(Object[] i:A) {
				DecimalFormat df = new DecimalFormat("#.##");
		        String formatted = df.format((Double.valueOf((long) i[2])/tong*100));
				table_bctheotl.addRow(new Object[] {i[0],i[1],i[2],formatted });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        }
	    }
	}
	
	
	public void DuaThongTinVaoBangTraTre() {
	    if ((this.textField_Ngay.getText().isEmpty())) {
	    	JOptionPane.showMessageDialog(panel, "Thông tin ngày/tháng/năm đang trống!");
        	this.textField_Ngay.setText("");
	    }
	    else {
	    	String Ngay  = (String)this.textField_Ngay.getText();
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	LocalDate specificLocalDate = LocalDate.parse(Ngay, formatter);
	    	DefaultTableModel table_bctheotratre = (DefaultTableModel)table_1.getModel();
	    	table_bctheotratre.setRowCount(0);
			try {
				Object[] qd = QuyDinhDao.getinstance().selectByID(1);
				int daymax = (int)qd[5];
				List<Object[]> A = BaoCaoDao.getinstance().findOverdueBooks(specificLocalDate,daymax); 
				System.out.println("DỘ DÀI: " +A.size());
				for(Object[] i:A) {
					Date sqlDate = (Date) i[2];
					LocalDate localDate = sqlDate.toLocalDate();
					Period period = Period.between( localDate,specificLocalDate);
					int daysBetween = period.getDays();
					table_bctheotratre.addRow(new Object[] {i[0],i[1],i[2],daysBetween});
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
   
	    }
	
	
	
	public String[][] getDataFromTable() {
		DefaultTableModel table_bctheotl = (DefaultTableModel)table.getModel();
        int rowCount = table_bctheotl.getRowCount();
        int colCount = table_bctheotl.getColumnCount();
        String[][] data = new String[rowCount + 1][colCount];

        // Lấy tiêu đề cột
        for (int col = 0; col < colCount; col++) {
            data[0][col] = table_bctheotl.getColumnName(col);
        }

        // Lấy dữ liệu từ bảng
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                Object value = table_bctheotl.getValueAt(row, col);
                data[row + 1][col] = value != null ? value.toString() : "";
            }
        }
        return data;
    }
	
	

	public BCTheoTheLoaiModel ThongTinBCTheoTL(Set<CT_BCTheoTheLoaiModel> B) {
		 int thang = Integer.valueOf(this.textField_thang.getText());
		 int nam = Integer.valueOf(this.textField_nam.getText());
		 int tong = Integer.valueOf(this.textField_TongLuotMuon.getText());
		 Set<CT_BCTheoTheLoaiModel> A = new HashSet<CT_BCTheoTheLoaiModel>();
         A =B;      
		 BCTheoTheLoaiModel bctheotl = new BCTheoTheLoaiModel(tong, thang, nam,B);
		return bctheotl;
	}
	
	public Set<CT_BCTheoTheLoaiModel> CT_Baocaotheotl(){
		   Set<CT_BCTheoTheLoaiModel> A = new HashSet<CT_BCTheoTheLoaiModel>();
		   DefaultTableModel table_bctheotl = (DefaultTableModel)table.getModel();
		   int Row = table_bctheotl.getRowCount();
		  
		   for (int i = 0; i< Row ; i++) {
				   int ma  = (int) table_bctheotl.getValueAt(i, 0);
				   TheLoaiModel tl  = new TheLoaiModel();
				   tl = TheLoaiDao.getinstance().selectByID(ma);
				   long soluotmuon = (long) table_bctheotl.getValueAt(i,2 );
				   float tile = Float.parseFloat((String) table_bctheotl.getValueAt(i, 3));
			       CT_BCTheoTheLoaiModel ctbc = new CT_BCTheoTheLoaiModel(soluotmuon, tile, tl);	
			       A.add(ctbc);
			   }
		   return A;
	}
	
	
	
	public BCSachTraTreModel ThongTinBCSachTraTre(Set<CT_BCSachTraTreModel> Bc) {
		 String ngaybc = String.valueOf(textField_Ngay.getText());
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 LocalDate localDate = LocalDate.parse(ngaybc, formatter);
		 Set<CT_BCSachTraTreModel> A = new HashSet<CT_BCSachTraTreModel>();
         A =Bc;      
		 BCSachTraTreModel bctratre= new BCSachTraTreModel(localDate, A);
		return bctratre;
	}
	
	public Set<CT_BCSachTraTreModel> CT_Baocaosachtratre(){
		   Set<CT_BCSachTraTreModel> A = new HashSet<CT_BCSachTraTreModel>();
		   DefaultTableModel table_bcsachtratre = (DefaultTableModel)table_1.getModel();
		   int Row = table_bcsachtratre.getRowCount();
		  
		   for (int i = 0; i< Row ; i++) {
				   int ma  = (int) table_bcsachtratre.getValueAt(i, 0);
				   SachModel S = new SachModel();
				   S = QuanLiSachDao.getinstance().LayThongTin(ma);
				   Date sqlDate = (Date) table_bcsachtratre.getValueAt(i, 2);
					LocalDate localDate = sqlDate.toLocalDate();
			       int soNgayTre = (int) table_bcsachtratre.getValueAt(i, 3);	   
				   CT_BCSachTraTreModel ctbctratre = new CT_BCSachTraTreModel(soNgayTre, S, localDate);
			       A.add(ctbctratre);
			   }
		   return A;
	}
	
	
	
	
	
	public  void writeDataToWord(String[][] data, String filePath) {
		try (XWPFDocument document = new XWPFDocument()) {
			  int thang = Integer.valueOf(this.textField_thang.getText());
			    int nam = Integer.valueOf(this.textField_nam.getText());
            // Tạo tiêu đề và căn giữa
            XWPFParagraph title = document.createParagraph();
            title.setAlignment(ParagraphAlignment.CENTER); // Căn giữa
            XWPFRun titleRun = title.createRun();
            titleRun.setText("BÁO CÁO THỐNG KÊ TÌNH HÌNH MƯỢN SÁCH THEO THỂ LOẠI");
            titleRun.setBold(true);
            titleRun.setFontSize(20);

            // Tạo phần tháng/năm và căn trái
            XWPFParagraph date = document.createParagraph();
            date.setAlignment(ParagraphAlignment.CENTER); // Căn trái
            XWPFRun dateRun = date.createRun();
            dateRun.setText("Tháng: " + thang + " / Năm: " + nam);
            dateRun.setFontSize(14);

            // Tạo bảng và thêm dữ liệu vào
            XWPFParagraph tableParagraph = document.createParagraph();
            XWPFTable table = document.createTable();
            tableParagraph.setAlignment(ParagraphAlignment.CENTER); // Căn giữa

            // Tạo bảng và thêm dữ liệu vào
            
            
            // Thêm tiêu đề bảng
            XWPFTableRow headerRow = table.getRow(0); // Dòng đầu tiên
            for (int j = 0; j < data[0].length; j++) {
                if (j == 0) {
                    headerRow.getCell(0).setText(data[0][j]);
                } else {
                    headerRow.addNewTableCell().setText(data[0][j]);
                }
            }
            
            // Thêm dữ liệu vào bảng
            for (int i = 1; i < data.length; i++) {
                XWPFTableRow row = table.createRow();
                for (int j = 0; j < data[i].length; j++) {
                    row.getCell(j).setText(data[i][j]);
                }
            }

            try (FileOutputStream out = new FileOutputStream(filePath)) {
                document.write(out);
                System.out.println("Đã ghi dữ liệu vào file Word: " + filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public String[][] getDataFromTableTraTre() {
		DefaultTableModel table_bctratre = (DefaultTableModel)table_1.getModel();
        int rowCount = table_bctratre.getRowCount();
        int colCount = table_bctratre.getColumnCount();
        String[][] data = new String[rowCount + 1][colCount];

        // Lấy tiêu đề cột
        for (int col = 0; col < colCount; col++) {
            data[0][col] = table_bctratre.getColumnName(col);
        }

        // Lấy dữ liệu từ bảng
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                Object value = table_bctratre.getValueAt(row, col);
                data[row + 1][col] = value != null ? value.toString() : "";
            }
        }
        return data;
    }
	public  void writeDataToWordtraTre(String[][] data, String filePath) {
		try (XWPFDocument document = new XWPFDocument()) {
			 String ngay = String.valueOf(this.textField_Ngay.getText());
			    
            // Tạo tiêu đề và căn giữa
            XWPFParagraph title = document.createParagraph();
            title.setAlignment(ParagraphAlignment.CENTER); // Căn giữa
            XWPFRun titleRun = title.createRun();
            titleRun.setText("BÁO CÁO THỐNG KÊ SÁCH TRẢ TRỄ");
            titleRun.setBold(true);
            titleRun.setFontSize(20);

            // Tạo phần tháng/năm và căn trái
            XWPFParagraph date = document.createParagraph();
            date.setAlignment(ParagraphAlignment.CENTER); // Căn trái
            XWPFRun dateRun = date.createRun();
            dateRun.setText("Ngày: " + ngay);
            dateRun.setFontSize(14);

            // Tạo bảng và thêm dữ liệu vào
            XWPFParagraph tableParagraph = document.createParagraph();
            XWPFTable table = document.createTable();
            tableParagraph.setAlignment(ParagraphAlignment.CENTER); // Căn giữa

            // Tạo bảng và thêm dữ liệu vào
            
            
            // Thêm tiêu đề bảng
            XWPFTableRow headerRow = table.getRow(0); // Dòng đầu tiên
            for (int j = 0; j < data[0].length; j++) {
                if (j == 0) {
                    headerRow.getCell(0).setText(data[0][j]);
                } else {
                    headerRow.addNewTableCell().setText(data[0][j]);
                }
            }
            
            // Thêm dữ liệu vào bảng
            for (int i = 1; i < data.length; i++) {
                XWPFTableRow row = table.createRow();
                for (int j = 0; j < data[i].length; j++) {
                    row.getCell(j).setText(data[i][j]);
                }
            }

            try (FileOutputStream out = new FileOutputStream(filePath)) {
                document.write(out);
                System.out.println("Đã ghi dữ liệu vào file Word: " + filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	  public void XoaFormTheLoai() {
		  this.textField_thang.setText("");
		  this.textField_nam.setText("");
		  this.textField_TongLuotMuon.setText("");
		  DefaultTableModel table_bctheotl = (DefaultTableModel)table.getModel();
		  table_bctheotl.setRowCount(0);
	  }
	  
	  public void XoaFormTraTre() {
		  this.textField_Ngay.setText("");
		  DefaultTableModel table_bctratre = (DefaultTableModel)table_1.getModel();
		  table_bctratre.setRowCount(0);
	  }
}
