package Login;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class Find_IDnPW extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_phone;
	private JTextField txt_id;
	private JTextField txt_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find_IDnPW frame = new Find_IDnPW();
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
	public Find_IDnPW() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 410, 100);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514 / \uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		lblNewLabel.setIcon(new ImageIcon("./images/찾기로고.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(7, 0, 398, 90);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 120, 203, 131);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("./images/찾기이름.jpg"));
		lblNewLabel_1.setBounds(29, 18, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD578\uB4DC\uD3F0 \uBC88\uD638");
		lblNewLabel_2.setIcon(new ImageIcon("./images/찾기핸드폰번호.jpg"));
		lblNewLabel_2.setBounds(17, 53, 69, 20);
		panel_1.add(lblNewLabel_2);
		
		txt_name = new JTextField();
		txt_name.setBackground(SystemColor.control);
		txt_name.setBounds(93, 12, 92, 25);
		panel_1.add(txt_name);
		txt_name.setColumns(10);
		
		txt_phone = new JTextField();
		txt_phone.setBackground(SystemColor.control);
		txt_phone.setColumns(10);
		txt_phone.setBounds(93, 48, 92, 25);
		panel_1.add(txt_phone);
		
		JButton btnNewButton = new JButton("\uCC3E\uAE30");
		btnNewButton.setIcon(new ImageIcon("./images/찾기.jpg"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserDAO ud = new UserDAO();
				FindMsg_IDnPW fmip = new FindMsg_IDnPW();
				FindMsg_IDnPW_false fmipf = new FindMsg_IDnPW_false();
				RegisterMsgBlank rmb = new RegisterMsgBlank();
				
				ArrayList<user> userList = new ArrayList<user>();
				
				String txtname = txt_name.getText();
				String txtphone = txt_phone.getText();
				
				if(ud.find_IDnPW(txtname, txtphone) == true) {
				userList = ud.find_IDnPWs(txtname, txtphone);
				txt_id.setText(userList.get(0).getUser_id());
				txt_pw.setText(userList.get(0).getUser_pw());
				fmip.setVisible(true);
				} else if(txtname.equals("") || txtphone.equals("")) {
					rmb.setVisible(true);
				} else {
					fmipf.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(109, 94, 62, 25);
		panel_1.add(btnNewButton);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(219, 120, 203, 131);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("./images/찾기아이디.jpg"));
		lblNewLabel_1_1.setBounds(29, 14, 57, 15);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2_1.setIcon(new ImageIcon("./images/찾기비밀번호.jpg"));
		lblNewLabel_2_1.setBounds(22, 56, 64, 15);
		panel_1_1.add(lblNewLabel_2_1);
		
		txt_id = new JTextField();
		txt_id.setBackground(SystemColor.control);
		txt_id.setColumns(10);
		txt_id.setBounds(97, 11, 92, 25);
		panel_1_1.add(txt_id);
		
		txt_pw = new JTextField();
		txt_pw.setBackground(SystemColor.control);
		txt_pw.setColumns(10);
		txt_pw.setBounds(97, 51, 92, 25);
		panel_1_1.add(txt_pw);
		
		JButton btnNewButton_1 = new JButton("\uB2EB\uAE30");
		btnNewButton_1.setIcon(new ImageIcon("./images/닫기.jpg"));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/**** 창 끄기 ****/
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(113, 96, 62, 23);
		panel_1_1.add(btnNewButton_1);
	}

}
