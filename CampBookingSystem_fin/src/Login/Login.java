package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login extends JFrame {
	private JTextField txt_inputID;
	private JPasswordField txt_password;

	UserDAO ud;
	
	CampingGUI cmpGUI;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		
//		setUndecorated(true);
//		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
//		�� ���� Ÿ��Ʋ�� ���� �� �ִ�. Ȥ�� �𸣴� ���ܵ�.
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 600);
		setTitle("�α���");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		txt_inputID = new JTextField();
		txt_inputID.setOpaque(false);
		txt_inputID.setForeground(Color.BLACK);
		txt_inputID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txt_inputID.setColumns(8);
		txt_inputID.setBounds(177, 363, 69, 23);
		getContentPane().add(txt_inputID);
			
		txt_password = new JPasswordField();
		txt_password.setOpaque(false);
		txt_password.setForeground(Color.BLACK);
		txt_password.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txt_password.setColumns(8);
		txt_password.setBounds(177, 403, 69, 23);
		getContentPane().add(txt_password);
		
		JButton btn_register = new JButton("");
		btn_register.setBorderPainted(false);
		btn_register.setFocusPainted(false);
		btn_register.setContentAreaFilled(false);
		btn_register.setBounds(84, 436, 90, 23);
		getContentPane().add(btn_register);
		btn_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**** ȸ������â ���� ****/
				Register regi = new Register();
				
				dispose();
				
				regi.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_register.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_register.setBorderPainted(false);

			}
		});
		
		JButton btn_findIDnPassword = new JButton("");
		btn_findIDnPassword.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Find_IDnPW fip = new Find_IDnPW();
				fip.setVisible(true);
				}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_findIDnPassword.setBorderPainted(true);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_findIDnPassword.setBorderPainted(false);

			}
		});
		btn_findIDnPassword.setBorderPainted(false);
		btn_findIDnPassword.setFocusPainted(false);
		btn_findIDnPassword.setContentAreaFilled(false);
		btn_findIDnPassword.setBounds(169, 436, 96, 23);
		getContentPane().add(btn_findIDnPassword);
		
		
		JButton btn_login = new JButton();
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/**** ��ü ����� ****/
				UserDAO ud = new UserDAO();
				LoginFailed lf = new LoginFailed();
				LoginSuccess ls = new LoginSuccess();
				ud = new UserDAO();
				
				/**** �ؽ�Ʈ�ʵ� ���ڿ� Ÿ������ ��ȯ ****/
				String txtid = txt_inputID.getText();
				String txtpw = txt_password.getText();
				int txtnum;
				
				/**** �α��� ���� ****/
				if(ud.identify_IDnPW(txtid, txtpw) == true) {//id�� pw ��ġ�ϸ� �α��� ����â ���� > Ȯ�� ������ ����â ���
					ls.setVisible(true);
					
					txtnum = ud.user_num;
					
					/**** ����ƽ ������ �α��� ���� ���� ****/

					dispose();
					
				} else {// id�� pw Ʋ���� ����â ���� 
					lf.setVisible(true);
				}
			}
			@Override 
			public void mouseEntered(MouseEvent arg0) {
				btn_login.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_login.setBorderPainted(false);
			}
		});

		btn_login.setBounds(269, 363, 43, 67);
		btn_login.setBorderPainted(false);
		btn_login.setFocusPainted(false);
		btn_login.setContentAreaFilled(false);
		getContentPane().add(btn_login);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 384, 561);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("./images/ķ�ηα���â.jpg"));
		label.setBounds(0, 0, 384, 561);
		panel.add(label);
	}
}
