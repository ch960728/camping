package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_password;
	private JTextField txt_name;
	private JTextField txt_phone;

	public JTextField getTxt_id() {
		return txt_id;
	}

	public void setTxt_id(JTextField txt_id) {
		this.txt_id = txt_id;
	}

	public JTextField getTxt_password() {
		return txt_password;
	}

	public void setTxt_password(JTextField txt_password) {
		this.txt_password = txt_password;
	}

	public JTextField getTxt_name() {
		return txt_name;
	}

	public void setTxt_name(JTextField txt_name) {
		this.txt_name = txt_name;
	}

	public JTextField getTxt_phone() {
		return txt_phone;
	}

	public void setTxt_phone(JTextField txt_phone) {
		this.txt_phone = txt_phone;
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Register() {
		UserDAO ud = new UserDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 360, 130);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_3.setIcon(new ImageIcon("./images/회원가입로고.jpg"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 360, 130);
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 150, 360, 401);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./images/아이디.jpg"));
		lblNewLabel.setBounds(72, 54, 90, 40);
		panel_1.add(lblNewLabel);

		txt_id = new JTextField();
		txt_id.setBackground(SystemColor.control);
		txt_id.setBounds(179, 56, 128, 36);
		panel_1.add(txt_id);
		txt_id.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("./images/비밀번호.jpg"));
		lblNewLabel_1.setBounds(72, 142, 90, 39);
		panel_1.add(lblNewLabel_1);

		txt_password = new JTextField();
		txt_password.setBackground(SystemColor.control);
		txt_password.setColumns(10);
		txt_password.setBounds(179, 145, 128, 36);
		panel_1.add(txt_password);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("./images/이름.jpg"));
		lblNewLabel_2.setBounds(72, 191, 91, 40);
		panel_1.add(lblNewLabel_2);

		txt_name = new JTextField();
		txt_name.setBackground(SystemColor.control);
		txt_name.setColumns(10);
		txt_name.setBounds(179, 196, 129, 35);
		panel_1.add(txt_name);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("./images/핸드폰번호.jpg"));
		lblNewLabel_1_1.setBounds(72, 239, 91, 39);
		panel_1.add(lblNewLabel_1_1);

		txt_phone = new JTextField();
		txt_phone.setBackground(SystemColor.control);
		txt_phone.setColumns(10);
		txt_phone.setBounds(179, 244, 126, 34);
		panel_1.add(txt_phone);

		JButton btnRegister = new JButton("\uAC00\uC785");
		btnRegister.setIcon(new ImageIcon("./images/가입.jpg"));
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterMsgOvlid_true rmot = new RegisterMsgOvlid_true();
				RegisterMsgBlank rmb = new RegisterMsgBlank();
				RegisterSuccess rs = new RegisterSuccess();
				String txtid = txt_id.getText();

				int cnt = 0;
				
				/**** 유저 번호 값 중복 방지 ****/
				cnt = ud.count() + 1;
				
				/**** 빈칸 확인 ****/
				if(		txt_id.getText().equals("") || 
						txt_password.getText().equals("")|| 
						txt_name.getText().equals("") || 
						txt_phone.getText().equals("")) {
						rmb.setVisible(true);
				} else if(ud.findOverlapedID(txtid) == true) {	
					rmot.setVisible(true);
				} else {//getText는 텍스트 필드를 getter설정해줘야 가져올 수 있어요//
					ud.insert( txt_id.getText(), txt_password.getText(), txt_name.getText(), txt_phone.getText(),1000000,0);
					rs.setVisible(true);
					dispose();
				}
				
				/**** 텍스트 입력칸 초기화 ****/
				txt_id.setText("");
				txt_password.setText("");
				txt_name.setText("");
				txt_phone.setText("");
			}
		});
		btnRegister.setBounds(88, 303, 97, 23);
		panel_1.add(btnRegister);

		JButton btnRegisterCancle = new JButton("\uCDE8\uC18C");
		btnRegisterCancle.setIcon(new ImageIcon("./images/취소.jpg"));
		btnRegisterCancle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login lg = new Login();
				lg.setVisible(true);
			}
		});
		btnRegisterCancle.setBounds(192, 303, 97, 23);
		panel_1.add(btnRegisterCancle);

		JButton btn_ovlID = new JButton("\uC911\uBCF5\uD655\uC778");
		btn_ovlID.setIcon(new ImageIcon("./images/중복확인.jpg"));
		btn_ovlID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterMsgOvlid_true rmot = new RegisterMsgOvlid_true();
				RegisterMsgOvlid_false rmof = new RegisterMsgOvlid_false();
				RegisterMsgOvlid_null rmon = new RegisterMsgOvlid_null();
				
				/**** ID 중복 확인 ****/
				String txtid = txt_id.getText();		//txtid에 txt_id값 입력 (txt_id는 jtextfield 타입이기 때문에 스트링으로 바꿔줘야 비교 가능)
				if(ud.findOverlapedID(txtid) == true) {
					rmot.setVisible(true);
				} else if(txtid.equals("")) {
					rmon.setVisible(true);
				} else {
					rmof.setVisible(true);
				}
			}
		});
		btn_ovlID.setBounds(191, 104, 97, 23);
		panel_1.add(btn_ovlID);
	}
}
