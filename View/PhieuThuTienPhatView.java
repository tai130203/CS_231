package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DocGiaDao;
import DAO.QuanLiSachDao;
import DAO.QuyDinhDao;
import Model.DocGiaModel;
import Model.PhieuThuTienModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class PhieuThuTienPhatView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_Tongno;
	private JTextField textField_Sotienthu;
	private JTextField textField_Conlai;
	private JComboBox comboBox;
	private JTextField textField_tendg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuThuTienPhatView frame = new PhieuThuTienPhatView();
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
	public PhieuThuTienPhatView(boolean enableNewButton, boolean enableQunNhnVin, boolean enableQunLMntr, boolean enableBoCoThng, boolean enableThayiQuy, boolean enableThuTinPht) {
		setTitle("UIT_LIBRARY");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Doan Cong Tai\\Downloads\\open-book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 669);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 350, 933, 282);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 phi\u1EBFu thu", "T\u00EAn \u0111\u1ECDc gi\u1EA3", "T\u1ED5ng n\u1EE3", "S\u1ED1 ti\u1EC1n thu", "C\u00F2n l\u1EA1i"
			}
		));
		DefaultTableModel table_model = (DefaultTableModel)table.getModel();
		try {
			List<Object[]> A = DocGiaDao.getinstance().LayPhieThu(); 
			int stt = 0;
			for(Object[] i:A)
			{
				stt++;
				table_model.addRow(new Object[] {stt,i[0],i[1],i[2],i[3],i[4]});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Phi\u1EBFu thu ti\u1EC1n", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(220, 11, 488, 264);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đọc giả:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(73, 90, 110, 17);
		panel.add(lblNewLabel);
		
		JLabel lblTngN = new JLabel("Tổng nợ:");
		lblTngN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTngN.setBounds(73, 131, 110, 20);
		panel.add(lblTngN);
		
		JLabel lblSTinThu = new JLabel("Số tiền thu:");
		lblSTinThu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTinThu.setBounds(73, 162, 96, 28);
		panel.add(lblSTinThu);
		
		textField_Tongno = new JTextField();
		textField_Tongno.setBounds(193, 123, 168, 28);
		panel.add(textField_Tongno);
		textField_Tongno.setColumns(10);
		
		JLabel lblCnLi = new JLabel("Còn lại:");
		lblCnLi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCnLi.setBounds(73, 210, 110, 28);
		panel.add(lblCnLi);
		
		textField_Sotienthu = new JTextField();
		textField_Sotienthu.setColumns(10);
		textField_Sotienthu.setBounds(193, 164, 168, 28);
		panel.add(textField_Sotienthu);
		
		textField_Conlai = new JTextField();
		textField_Conlai.setColumns(10);
		textField_Conlai.setBounds(193, 212, 168, 28);
		panel.add(textField_Conlai);
		
		comboBox = new JComboBox();
		comboBox.setBounds(193, 36, 168, 28);
		comboBox.addItem("");
		
		for (DocGiaModel i : DocGiaDao.getinstance().selectDGno()) {
			comboBox.addItem(i.getMaDG());
			}
		 
		comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ThongTinPhieu();
            }
        });
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("In dư");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Indu();
			}
		});
		btnNewButton.setBounds(376, 162, 89, 32);
		panel.add(btnNewButton);
		
		textField_tendg = new JTextField();
		textField_tendg.setColumns(10);
		textField_tendg.setBounds(193, 79, 168, 28);
		panel.add(textField_tendg);
		
		JLabel lblMcGi = new JLabel("Mã đọc giả:");
		lblMcGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMcGi.setBounds(73, 47, 110, 17);
		panel.add(lblMcGi);
		
		JButton btnNewButton_1 = new JButton("Tạo phiếu");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\plus.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaoPhieu();
			}
		});
		btnNewButton_1.setBounds(408, 286, 116, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Hủy");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\forbidden.png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Huy();
			}
		});
		btnNewButton_1_1.setBounds(592, 286, 116, 33);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("HOME");
		btnNewButton_1_1_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\home.png"));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePageView hp = new HomePageView(enableNewButton,  enableQunNhnVin,  enableQunLMntr,  enableBoCoThng,  enableThayiQuy,  enableThuTinPht);
				hp.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1_1.setBounds(220, 286, 116, 33);
		contentPane.add(btnNewButton_1_1_1);
	}
	
	public PhieuThuTienPhatView() {
		
	}

	public void ThongTinPhieu() {
		 int id = (int) this.comboBox.getSelectedItem();
	     DocGiaModel a = DocGiaDao.getinstance().selectdg(id);
	     textField_tendg.setText(String.valueOf(a.getTenDG()));
	     textField_Tongno.setText( String.valueOf(a.getTongNo()));
	}
	public void Indu() {
		 if(textField_Sotienthu.getText().isEmpty()) {
			 JOptionPane.showMessageDialog(contentPane,"Bạn chưa nhập số tiền trả!" );
		 }
		 else {
			   Object[] tien = QuyDinhDao.getinstance().selectByID(1);
			   int tientra = Integer.valueOf( this.textField_Sotienthu.getText());
			   int tienno = Integer.valueOf( this.textField_Tongno.getText());
			   if ((tientra > tienno) && ((int)tien[7] == 1))
			   {
				   textField_Conlai.setText(String.valueOf(0));
			   }
			   else if ((tientra > tienno) && ((int)tien[7] == 0)){
				   JOptionPane.showMessageDialog(contentPane,"Số tiền bạn trả phải nhỏ hơn số tiền nợ!" );
			   }
			   else  textField_Conlai.setText(String.valueOf(tienno - tientra));
		 }
	}
	public void TaoPhieu() {
		int id = (int) this.comboBox.getSelectedItem();
		int no = Integer.valueOf(this.textField_Conlai.getText());
		DocGiaDao.getinstance().UpdateNo(id, no);
		DocGiaDao.getinstance().ThemPhieuThuTien(ThemPhieuThu());
		ShowTable();
		
	}
	public void Huy() {
		
		textField_tendg.setText("");
		textField_Sotienthu.setText("");
		textField_Tongno.setText("");
		textField_Conlai.setText("");
		comboBox.setSelectedIndex(-1);
	}
	public void ShowTable() {
		DefaultTableModel table_model = (DefaultTableModel)table.getModel();
		table_model.setRowCount(0);
		int stt=0;
		for (Object[] i : DocGiaDao.getinstance().LayPhieThu()) {
			stt++;
			table_model.addRow(new Object[] {stt,i[0],i[1],i[2],i[3],i[4]});
		}
		
	}
	public PhieuThuTienModel ThemPhieuThu() {
		int id = (int) this.comboBox.getSelectedItem();
		DocGiaModel dg = DocGiaDao.getinstance().selectdg(id);
		int tientra = Integer.valueOf( this.textField_Sotienthu.getText());
		int tienno = Integer.valueOf( this.textField_Tongno.getText());
		int conlai = Integer.valueOf(this.textField_Conlai.getText());
		PhieuThuTienModel phieuthu = new PhieuThuTienModel(tientra, tienno, conlai, dg);
		return phieuthu;
	}
}
