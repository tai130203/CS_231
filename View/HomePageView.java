package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import Dao.SachDao;
//import Model.SachModel;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLayeredPane;

public class HomePageView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JPanel panelMenu;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JButton btnNewButton;
	public JButton btnQunNhnVin;
	public JButton btnQunLMntr;
	public JButton btnThayiQuy;
	public JButton btnThuTinPht;
	public JButton btnBoCoThng; 
    void openMenuBar() {
    	int width = 233;
    	int height = 642;
    	new Thread(new Runnable() {
    		@Override
    		public void run() {
    			for (int i = 0;i< width;i++)
    				panelMenu.setSize(i,height);
    		}
    	}).start();
    }
    void closeMenuBar() {
    	int width = 233;
    	int height = 642;
    	new Thread(new Runnable() {
    		@Override
    		public void run() {
    			for (int i = width;i>0;i--)
    				panelMenu.setSize(i,height);
    		}
    	}).start();
    }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageView frame = new HomePageView();
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
	public HomePageView(boolean enableNewButton, boolean enableQunNhnVin, boolean enableQunLMntr, boolean enableBoCoThng, boolean enableThayiQuy, boolean enableThuTinPht) {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Doan Cong Tai\\Downloads\\open-book.png"));
		setTitle("UIT_LIBRARY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(0, 0, 904, 642);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
	    panelMenu = new JPanel();
	    panelMenu.setBackground(SystemColor.info);
		panelMenu.setBounds(0, 0, 1, 642);
		panel_1.add(panelMenu);
		panelMenu.setLayout(null);
		
		btnNewButton = new JButton("Quản lí sách");
		btnNewButton.setEnabled(enableNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  setVisible(false);
			  QuanLiSachView ql = new QuanLiSachView(enableNewButton, enableQunNhnVin, enableQunLMntr, enableBoCoThng, enableThayiQuy, enableThuTinPht);
			  ql.setVisible(true);
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\book (2).png"));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(20, 165, 145, 36);
		panelMenu.add(btnNewButton);
		
		btnQunNhnVin = new JButton("Quản lí đọc giả");
		btnQunNhnVin.setEnabled(enableQunNhnVin);
		btnQunNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnQunNhnVin.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\youth.png"));
		btnQunNhnVin.setBackground(Color.LIGHT_GRAY);
		btnQunNhnVin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DocGiaView dgv = new DocGiaView(enableNewButton, enableQunNhnVin, enableQunLMntr, enableBoCoThng, enableThayiQuy, enableThuTinPht);
				dgv.setVisible(true);
			}
		});
		btnQunNhnVin.setBounds(20, 224, 145, 36);
		panelMenu.add(btnQunNhnVin);
		

        btnQunLMntr = new JButton("Quản lí mươn/Trả sách");
        btnQunLMntr.setEnabled(enableQunLMntr);
		btnQunLMntr.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnQunLMntr.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\borrow.png"));
		btnQunLMntr.setBackground(Color.LIGHT_GRAY);
		btnQunLMntr.setBounds(20, 282, 184, 36);
		panelMenu.add(btnQunLMntr);
		btnQunLMntr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				  QuanLiMuonTraView mt = new QuanLiMuonTraView(enableNewButton, enableQunNhnVin, enableQunLMntr, enableBoCoThng, enableThayiQuy, enableThuTinPht);
				  mt.setVisible(true);
			}
		});
		
		btnBoCoThng = new JButton("Báo cáo thống kê");
		btnBoCoThng.setEnabled(enableBoCoThng);
		btnBoCoThng.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBoCoThng.setHorizontalAlignment(SwingConstants.LEADING);
		btnBoCoThng.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\trend (1).png"));
		btnBoCoThng.setBackground(Color.LIGHT_GRAY);
		btnBoCoThng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BaoCaoView bcview = new BaoCaoView(enableNewButton, enableQunNhnVin, enableQunLMntr, enableBoCoThng, enableThayiQuy, enableThuTinPht);
				bcview.setVisible(true);
			}
		});
		btnBoCoThng.setBounds(20, 345, 184, 36);
		panelMenu.add(btnBoCoThng);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeMenuBar();
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\reject.png"));
		lblNewLabel.setBounds(200, 11, 33, 14);
		panelMenu.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\r\n");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\library.png"));
		lblNewLabel_2.setBounds(33, 0, 132, 132);
		panelMenu.add(lblNewLabel_2);
		
		btnThayiQuy = new JButton("Thay đổi quy định\r\n");
		btnThayiQuy.setEnabled(enableThayiQuy);
		btnThayiQuy.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnThayiQuy.setHorizontalAlignment(SwingConstants.LEFT);
		btnThayiQuy.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\settings.png"));
		btnThayiQuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				  ThayDoiQuyDinhView tdqd = new ThayDoiQuyDinhView(enableNewButton, enableQunNhnVin, enableQunLMntr, enableBoCoThng, enableThayiQuy, enableThuTinPht);
				  tdqd.setVisible(true);
			}
		});
		btnThayiQuy.setBackground(Color.LIGHT_GRAY);
		btnThayiQuy.setBounds(20, 414, 184, 36);
		panelMenu.add(btnThayiQuy);
		
		JButton btnNewButton_1 = new JButton("Đăng xuất");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  btnNewButton.setEnabled(false);
				  btnBoCoThng.setEnabled(false);
				  btnQunLMntr.setEnabled(false);
				  btnQunNhnVin.setEnabled(false);
				  btnThayiQuy.setEnabled(false);
				  btnThuTinPht.setEnabled(false);
				  dispose();
				  LoginView lg = new LoginView();
				  lg.setVisible(true);
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\logout (1).png"));
		btnNewButton_1.setBounds(43, 590, 138, 41);
		panelMenu.add(btnNewButton_1);
		
		btnThuTinPht = new JButton("Thu tiền phạt");
		btnThuTinPht.setEnabled(enableThuTinPht);
		btnThuTinPht.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnThuTinPht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PhieuThuTienPhatView pttp = new PhieuThuTienPhatView(enableNewButton, enableQunNhnVin, enableQunLMntr, enableBoCoThng, enableThayiQuy, enableThuTinPht);
				pttp.setVisible(true);
			}
		});
		btnThuTinPht.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\money.png"));
		btnThuTinPht.setHorizontalAlignment(SwingConstants.LEFT);
		btnThuTinPht.setBackground(Color.LIGHT_GRAY);
		btnThuTinPht.setBounds(20, 476, 145, 36);
		panelMenu.add(btnThuTinPht);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openMenuBar();
			
				
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\menu.png"));
		lblNewLabel_1.setBounds(11, 9, 38, 55);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(191, 205, 219));
		panel_2.setBounds(0, 66, 904, 576);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\OneDrive\\图片\\MNT-DESIGN-HINH-NEN-GIAO-DUC-TRUONG-HOC.jpg"));
		lblNewLabel_4.setBounds(10, 11, 884, 554);
		panel_2.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_3 = new JLabel("QUẢN LÍ THƯ VIỆN");
		lblNewLabel_3.setForeground(new Color(172, 169, 34));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(304, 9, 256, 46);
		panel_1.add(lblNewLabel_3);
	}
	
	public HomePageView() {
        this(false, false, false, false, false, false);
    }
	
}
