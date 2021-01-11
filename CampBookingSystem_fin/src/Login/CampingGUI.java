package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CampingGUI extends JFrame {

	//전역변수 설정
	private JPanel contentPane;
	private JFrame frame;
	UserDAO ud;
	Login login;
	
	
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CampingGUI frame = new CampingGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CampingGUI() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		setLocationRelativeTo(null);

		

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 100, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 568, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);

		JButton btn_logo = new JButton("main");
		btn_logo.setIcon(new ImageIcon("./images/로고5.jpg"));
		btn_logo.setBounds(10, 8, 200, 90);
		btn_logo.setBorderPainted(false);
		btn_logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 클릭했을 때 main으로 넘어가기

			}
		});
		btn_logo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.setLayout(null);
		panel.add(btn_logo);

		/**** 로그인 객체 생성 ****/
		ud = new UserDAO();
		login = new Login();
		
		JButton btn_login = new JButton();
		btn_login.setBounds(401, 39, 120, 30);
		btn_login.setIcon(new ImageIcon("./images/로그아웃.jpg"));
		
		/**** 로그인 확인 ****/
		if(ud.getGetUID().isEmpty()) {	//loginedUserid에 값이 없으면 로그인 안한걸로 판단
			btn_login.setText("login");						//근데 지금 여기 오류나서 안되는 상황... else if만 정상 작동 중
			System.out.println("로그인 값 없음");
		} else if(ud.getGetUID().isEmpty() == false) {	//loginedUserid에 값이 있으면 로그인 한걸로 판단
			String id = ud.getGetUID();			//로그인한 아이디를 id에 넣어줌
			btn_login.setText("logout");
			System.out.println("로그인 값 있음");
		} else {
			System.out.println("else");
		}
		
		
		
		/**** 로그인 / 로그아웃 버튼 ****/
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				login.setVisible(true);				//로그인창 열기
				ud.setGetUID(null);		//로그인한 유저id 초기화
				ud.setGetUnum(0);		//로그인한 유저번호 초기화
				dispose();
			}
		});
		panel.add(btn_login);

		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 21, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 648, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JButton btn_explain1 = new JButton("\uC124\uBA851");
		btn_explain1.setIcon(new ImageIcon("./images/캠핑장 소개.jpg"));
		btn_explain1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 클릭했을 때 설명1
				// 클릭했을 때 explain1 화면으로 넘어가기
				Explain1GUI.main(null);

				//CampingGUI창 닫기
				frame.dispose();
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, btn_explain1, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btn_explain1, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_explain1, 200, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btn_explain1, -10, SpringLayout.EAST, panel_1);
		btn_explain1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btn_explain1);

		JButton btn_explain2 = new JButton("\uC124\uBA852");
		btn_explain2.setIcon(new ImageIcon("./images/숙박안내3.jpg"));
		btn_explain2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//클릭했을 때 설명2
				// 클릭했을 때 explain2 화면으로 넘어가기
				Explain2GUI.main(null);

				//CampingGUI창 닫기
				frame.dispose();
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, btn_explain2, 6, SpringLayout.SOUTH, btn_explain1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btn_explain2, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btn_explain2, -10, SpringLayout.EAST, panel_1);
		panel_1.add(btn_explain2);

		JButton btn_explain3 = new JButton("\uC124\uBA853");
		btn_explain3.setIcon(new ImageIcon("./images/편의시설.jpg"));
		btn_explain3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 클릭했을 때 설명3
				// 클릭했을 때 explain3 화면으로 넘어가기
				Explain3GUI.main(null);

				//CampingGUI창 닫기
				frame.dispose();
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, btn_explain3, 413, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_explain3, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btn_explain2, -6, SpringLayout.NORTH, btn_explain3);
		sl_panel_1.putConstraint(SpringLayout.WEST, btn_explain3, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btn_explain3, 0, SpringLayout.EAST, btn_explain1);
		panel_1.add(btn_explain3);

		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 5, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, panel);
		
		JButton btn_userInfo = new JButton();
		
		/**** 유저 정보 버튼 텍스트 삽입 로그인/비로그인 ****/
		if(ud.getGetUID().isEmpty() == true) {
			btn_userInfo.setText("정보 없음");
		} else if(ud.getGetUID().isEmpty() == false) {
			btn_userInfo.setText("개인 정보");
		}
		
		btn_userInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				userInfoGUI ui = new userInfoGUI();
				
				if(ud.getGetUID().isEmpty() == true) {
					System.out.println("로그인 안됨");
				} else if(ud.getGetUID().isEmpty() == false) {
					
					userInfoGUI.main(null);
				}
				
			}
		});
		btn_userInfo.setBounds(246, 39, 120, 30);
		btn_userInfo.setIcon(new ImageIcon("./images/마이페이지.jpg"));
		panel.add(btn_userInfo);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btn_reserve = new JButton("");
		btn_reserve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookingGUI bg = new BookingGUI();
				
				bg.main(null);
				dispose();
			}
		});
		btn_reserve.setIcon(new ImageIcon("./images/예약버튼.jpg"));
		btn_reserve.setBackground(Color.WHITE);
		btn_reserve.setBounds(80, 8, 394, 72);
		panel_2.add(btn_reserve);
	}
}
