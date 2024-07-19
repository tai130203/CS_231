package View;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Control.LoginControl;
import DAO.DangNhapDao;
import Model.NhanVienModel;

import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textUsername;
	public JPasswordField textPassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox chckbxNewCheckBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setTitle("UIT_LIBRARY");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Doan Cong Tai\\Downloads\\open-book.png"));
		setBackground(new Color(240, 248, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 519);
		contentPane = new JPanel();
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setToolTipText("");
		contentPane.setBackground(SystemColor.textHighlightText);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LoginControl action = new LoginControl(this);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(SystemColor.text);
		panel.setBounds(357, 41, 460, 381);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setForeground(SystemColor.inactiveCaptionText);
		textUsername.setBackground(SystemColor.inactiveCaption);
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textUsername.setColumns(10);
		textUsername.setBounds(100, 130, 241, 30);
		panel.add(textUsername);
		
		textPassword = new JPasswordField();
		textPassword.setBackground(SystemColor.inactiveCaption);
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPassword.setBounds(100, 189, 241, 30);
		panel.add(textPassword);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(59, 176, 31, 59);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\password.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\user-interface.png"));
		lblNewLabel_1.setBounds(59, 130, 31, 30);
		panel.add(lblNewLabel_1);
		
		JButton btnngNhp = new JButton("SIGN IN");
		btnngNhp.addActionListener(action);
		btnngNhp.setBounds(138, 273, 156, 37);
		panel.add(btnngNhp);
		btnngNhp.setForeground(SystemColor.menuText);
		btnngNhp.setBackground(SystemColor.inactiveCaption);
		btnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblNewLabel = new JLabel("SIGN IN\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(115, 43, 207, 46);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.GRAY);
		separator.setBounds(88, 96, 275, 10);
		panel.add(separator);
		
		chckbxNewCheckBox = new JCheckBox("  Hiển thị mật khẩu");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.setBackground(SystemColor.text);
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
                   textPassword.setEchoChar((char) 0); // Hiển thị mật khẩu
                } else {
                   textPassword.setEchoChar('*'); // Ẩn mật khẩu
                }
			}
		});
		
		chckbxNewCheckBox.setBounds(100, 226, 132, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Doan Cong Tai\\Downloads\\security (2).png"));
		lblNewLabel_3.setBounds(20, 91, 337, 318);
		contentPane.add(lblNewLabel_3);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel, textUsername, textPassword, lblNewLabel_2, lblNewLabel_1, btnngNhp, lblNewLabel, separator, chckbxNewCheckBox, lblNewLabel_3}));
	}
}



