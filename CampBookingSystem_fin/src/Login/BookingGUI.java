package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.GridLayout;

public class BookingGUI extends JFrame implements ActionListener {

	public static int[][] cmpClicked= new int[3][5];	//선택된 캠프 자리 // 캠프자리 번호 1은 배열 0번으로 하자

	private boolean clicked;	//한 자리가 선택됐는지 판단 - 한 자리 선택했으면 true; 아무것도 선택하지 않았으면 false;
	private JPanel contentPane;

	private static int camp_num = 0;
	private static String startDate = "";	//시작일
	private static String endDate = "";		//마감일

	private static JButton btn_startDate;	
	private static JButton btn_endDate;

	private static int totalPrice;			//camp_payment로 넘기기
	private static int price;				
	private static int people;				//user_people로 넘기기
	private static int calDate;				//일 수 계산용

	JButton[][] btnCamp = new JButton[3][5];


	JPanel[] cmpPan1 = new JPanel[5];
	JPanel[] cmpPan2 = new JPanel[5];
	JPanel[] cmpPan3 = new JPanel[5];

	public void isBookedtrue() {
		
	}
	
	public int[][] getCmpClicked() {
		return cmpClicked;
	}


	public void setCmpClicked(int[][] cmpClicked) {
		this.cmpClicked = cmpClicked;
	}


	public boolean isClicked() {
		return clicked;
	}


	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}


	public static int getCamp_num() {
		return camp_num;
	}


	public static void setCamp_num(int camp_num) {
		BookingGUI.camp_num = camp_num;
	}


	public static JButton getBtn_startDate() {
		return btn_startDate;
	}


	public static void setBtn_startDate(JButton btn_startDate) {
		BookingGUI.btn_startDate = btn_startDate;
	}


	public static JButton getBtn_endDate() {
		return btn_endDate;
	}


	public static void setBtn_endDate(JButton btn_endDate) {
		BookingGUI.btn_endDate = btn_endDate;
	}


	public static String getStartDate() {
		return startDate;
	}


	public static void setStartDate(String startDate) {
		BookingGUI.startDate = startDate;
	}


	public static String getEndDate() {
		return endDate;
	}


	public static void setEndDate(String endDate) {
		BookingGUI.endDate = endDate;
	}


	public static int getTotalPrice() {
		return totalPrice;
	}


	public static void setTotalPrice(int totalPrice) {
		BookingGUI.totalPrice = totalPrice;
	}


	public static int getPrice() {
		return price;
	}


	public static void setPrice(int price) {
		BookingGUI.price = price;
	}


	public static int getPeople() {
		return people;
	}


	public static void setPeople(int people) {
		BookingGUI.people = people;
	}


	public static int getCalDate() {
		return calDate;
	}


	public static void setCalDate(int calDate) {
		BookingGUI.calDate = calDate;
	}


	private BookingGUI_MsgReservedCmp mr = new BookingGUI_MsgReservedCmp();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingGUI frame = new BookingGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BookingGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("캠핑장 예약");
		setBounds(100, 100, 600, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel_Main = new JPanel();
		panel_Main.setBackground(Color.WHITE);
		panel_Main.setBounds(0, 10, 584, 751);
		contentPane.add(panel_Main);
		panel_Main.setLayout(null);
		
		JPanel panel_Map = new JPanel();
		panel_Map.setBounds(8, 3, 562, 380);
		panel_Main.add(panel_Map);
		panel_Map.setLayout(null);
		
		JPanel panel_camp1 = new JPanel();
		panel_camp1.setOpaque(false);
		panel_camp1.setBounds(51, 296, 379, 18);
		panel_Map.add(panel_camp1);
		panel_camp1.setLayout(new GridLayout(0, 10, 0, 0));

		JPanel panel_camp2 = new JPanel(); 
		panel_camp2.setOpaque(false);
		panel_camp2.setBounds(35, 239, 428, 18);
		panel_Map.add(panel_camp2);
		panel_camp2.setLayout(new GridLayout(0, 10, 0, 0));

		JPanel panel_camp3 = new JPanel();
		panel_camp3.setOpaque(false);
		panel_camp3.setBounds(63, 171, 422, 18);
		panel_Map.add(panel_camp3);
		panel_camp3.setLayout(new GridLayout(0, 10, 0, 0));
		
		/**** 캠프 버튼 만들기 ****/
		for (int i = 0; i < 5; i++) {
			panel_camp1.add(btnCamp[0][i] = new JButton());
			panel_camp1.add(cmpPan1[i] = new JPanel());
			panel_camp2.add(btnCamp[1][i] = new JButton());
			panel_camp2.add(cmpPan2[i] = new JPanel());
			panel_camp3.add(btnCamp[2][i] = new JButton());
			panel_camp3.add(cmpPan3[i] = new JPanel());
			btnCamp[0][i].setBackground(new Color(255, 228, 0));
			btnCamp[1][i].setBackground(new Color(255, 228, 0));
			btnCamp[2][i].setBackground(new Color(255, 228, 0));
		}
		for (int i = 0; i < 5; i++) {
			cmpPan1[i].setOpaque(false);
			cmpPan2[i].setOpaque(false);
			cmpPan3[i].setOpaque(false);
		}

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 584, 100);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_Booking = new JPanel();
		panel_Booking.setBackground(Color.WHITE);
		panel_Booking.setLayout(null);
		panel_Booking.setBounds(0, 761, 584, 100);
		contentPane.add(panel_Booking);

		JButton btn_Booking = new JButton("\uC608\uC57D\uD558\uAE30");
		btn_Booking.setBorderPainted(false);
		btn_Booking.setIcon(new ImageIcon("./images/예약버튼.jpg"));
		btn_Booking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookingGUI_MsgPur1 bmc = new BookingGUI_MsgPur1();
				dispose();
				bmc.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btn_Booking.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Booking.setBorderPainted(false);
			}
		});
		btn_Booking.setBounds(90, 0, 402, 72);
		panel_Booking.add(btn_Booking);

	



		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon("./images/캠핑장전경4.jpg"));
		lblNewLabel_1.setBounds(0, 0, 562, 380);
		panel_Map.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("\uCEA0\uD551\uC7A5 \uB300\uC5EC\uB8CC :");
		lblNewLabel.setIcon(new ImageIcon("./images/예약캠핑장대여료.jpg"));
		lblNewLabel.setBounds(57, 438, 100, 30);
		panel_Main.add(lblNewLabel);

		JLabel lbl_cmpPrice = new JLabel();
		lbl_cmpPrice.setBounds(191, 446, 57, 15);
		panel_Main.add(lbl_cmpPrice);

		JLabel lblNewLabel_4 = new JLabel("\uC2DC\uC791 \uB0A0\uC9DC :");
		lblNewLabel_4.setIcon(new ImageIcon("./images/예약입실날짜.jpg"));
		lblNewLabel_4.setBounds(57, 484, 100, 30);
		panel_Main.add(lblNewLabel_4);

		JLabel lblNewLabel_2 = new JLabel("\uC885\uB8CC \uB0A0\uC9DC :");
		lblNewLabel_2.setIcon(new ImageIcon("./images/예약퇴실날짜.jpg"));
		lblNewLabel_2.setBounds(57, 529, 100, 30);
		panel_Main.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("\uC778\uC6D0\uC218 :");
		lblNewLabel_2_1.setIcon(new ImageIcon("./images/예약인원수.jpg"));
		lblNewLabel_2_1.setBounds(57, 569, 100, 30);
		panel_Main.add(lblNewLabel_2_1);


		String peopleNum[] = new String[] { "1", "2", "3", "4", "5", "6", "7", "8" ,"9" , "10"};
		JComboBox comboBox = new JComboBox(peopleNum);
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BookingGUI bg = new BookingGUI();
				System.out.println(bg.isClicked());
				if(clicked==true) {
				} else if(clicked==false) {
					System.out.println("자리 선택 안함");
					BookingGUI_MsgCSC2 bgm2 = new BookingGUI_MsgCSC2();
					bgm2.setVisible(true);

				} else {

				}
			}
		});
		comboBox.setBounds(169, 574, 68, 25);
		panel_Main.add(comboBox);

		JLabel lbl_totalPrice = new JLabel();
		lbl_totalPrice.setBounds(169, 630, 79, 30);
		panel_Main.add(lbl_totalPrice);

		JLabel lblNewLabel_2_2 = new JLabel("\uCD1D \uAE08\uC561 :");
		lblNewLabel_2_2.setIcon(new ImageIcon("./images/예약총금액.jpg"));
		lblNewLabel_2_2.setBounds(57, 630, 100, 30);
		panel_Main.add(lblNewLabel_2_2);

		lbl_cmpPrice.setText(price+"");

		JButton btn_startDate = new JButton("\uC120\uD0DD");
		btn_startDate.setBackground(Color.WHITE);
		btn_startDate.setIcon(new ImageIcon("./images/선택.jpg"));
		btn_startDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CalendarGUI_StartDate cg = new CalendarGUI_StartDate();
				dispose();
				cg.setVisible(true);

			}
		});
		btn_startDate.setBounds(268, 484, 70, 30);
		panel_Main.add(btn_startDate);

		JButton btn_endDate = new JButton("\uC120\uD0DD");
		btn_endDate.setBackground(Color.WHITE);
		btn_endDate.setIcon(new ImageIcon("./images/선택.jpg"));
		btn_endDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookingGUI bg = new BookingGUI();
				if(bg.getStartDate().equals("")==false) {
					CalendarGUI_EndDate cge = new CalendarGUI_EndDate();
					dispose();
					cge.setVisible(true);
				} else {
					CalendarGUI_MsgSetStartDate cm = new CalendarGUI_MsgSetStartDate();
					cm.setVisible(true);
				}
			}
		});
		btn_endDate.setBounds(268, 529, 70, 30);
		panel_Main.add(btn_endDate);

		JLabel lbl_startDate = new JLabel("New label");
		lbl_startDate.setBounds(169, 484, 68, 30);
		panel_Main.add(lbl_startDate);

		lbl_startDate.setText(startDate);

		JLabel lbl_endDate = new JLabel("New label");
		lbl_endDate.setBounds(169, 529, 68, 30);
		panel_Main.add(lbl_endDate);

		lbl_endDate.setText(endDate);	


		/**** 인원수 고르는 이벤트 ****/
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CalMethod cm = new CalMethod();
				BookingGUI bg = new BookingGUI();



				System.out.println(cm.getBookedDate(bg.getStartDate(), bg.getEndDate()));
				calDate = cm.getBookedDate(startDate, endDate);

				bg.setPeople(comboBox.getSelectedIndex());
				if(people < 4) {
					totalPrice = ( price ) * calDate;
				} else {
					totalPrice = ( price + ( people - 2 ) * 5000) * calDate;
				}
				System.out.println();
				lbl_cmpPrice.setText(price+"");
				lbl_totalPrice.setText(totalPrice+"");

			}
		});




		
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				if(cmpClicked[i][j] == 2) {
				btnCamp[i][j].setEnabled(false);
				btnCamp[i][j].setBackground(new Color(255, 0, 0));
				btnCamp[i][j].setForeground(new Color(255, 0, 0));
				}
			}
		}

		/**** 캠프 버튼 이벤트 ****/
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {

				btnCamp[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						BookingGUI bg = new BookingGUI();
						CalMethod cm = new CalMethod();
						CampDAO cd = new CampDAO();
						UserDAO ud = new UserDAO();

						if(bg.getEndDate().equals("")==false) {
							for (int i = 0; i < 3; i++) {
								for (int j = 0; j < 5; j++) {
									{//end if
										if(e.getSource() == btnCamp[i][j]) {
											if(cmpClicked[i][j] == 0 && clicked == false) {
												btnCamp[i][j].setBackground(new Color(29, 219, 22));
												bg.setVisible(false);
												cmpClicked[i][j] = 1;
												clicked = true;
												System.out.println(bg.camp_num);
												bg.setCamp_num( j + 1 + (5) * i);
												bg.setPrice( 15000 + i * 10000 );
												if(bg.getPeople() < 4) {
													bg.setTotalPrice(( price ) * calDate);
												} else {
													bg.setTotalPrice(( price + ( people - 2 ) * 5000) * calDate);
												}
												System.out.println(bg.camp_num);
												System.out.println(bg.price);

												lbl_cmpPrice.setText(price+"");
												lbl_totalPrice.setText(totalPrice+"");

												break;
											} else if(cmpClicked[i][j] == 1 && clicked == true) {
												btnCamp[i][j].setBackground(new Color(255, 228, 0));
												cmpClicked[i][j] = 0;
												clicked = false;
											} else if(cmpClicked[i][j] == 2) {
												btnCamp[i][j].setBackground(new Color(255, 0, 0));
												btnCamp[i][j].setForeground(new Color(255, 0, 0));
												mr.setVisible(true);
											}

										}
									} 
								}
							}
						} else { 
							BookingGUI_MsgCSC bgmsc = new BookingGUI_MsgCSC();
							bgmsc.setVisible(true);
						}
					}
				});
			}

		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
