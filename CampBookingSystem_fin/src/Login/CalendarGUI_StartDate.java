package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Font;

public class CalendarGUI_StartDate extends JFrame implements ActionListener {

	Calendar cal = Calendar.getInstance();
	GregorianCalendar gc = new GregorianCalendar(); 
	Date d;

	private JPanel contentPane;
	private JButton btn_55;
	private int year = Calendar.YEAR;
	private int month = Calendar.MONTH + 1;

	JButton[] jbtn0 = new JButton[7];
	JButton[][] jbtn1 = new JButton[6][7];
	String[] week = {"일", "월", "화", "수", "목", "금", "토"};

	public String[][][] day (int year) {

		String[][][] day = new String[12][6][7];

		cal.set(Calendar.YEAR, year);

		for(int m=0; m<12; m++) {
			cal.set(Calendar.MONTH, month);
			int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			for(int i=1; i<=maxDay; i++) {
				cal.set(Calendar.DATE, i);
				day[cal.get(Calendar.MONTH)]
						[cal.get(Calendar.WEEK_OF_MONTH)-1]
								[cal.get(Calendar.DAY_OF_WEEK)-1] = i + "";
			}


		}
		return day; 
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarGUI_StartDate frame = new CalendarGUI_StartDate();
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
	public CalendarGUI_StartDate() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);

		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf;
		BookingGUI bg = new BookingGUI();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 75);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_year = new JPanel();
		panel.add(panel_year);
		panel_year.setLayout(null);

		JPanel panel_month = new JPanel();
		panel.add(panel_month);
		panel_month.setLayout(null);

		JPanel panel_day = new JPanel();
		panel_day.setBounds(10, 85, 417, 265);
		contentPane.add(panel_day);
		panel_day.setLayout(new GridLayout(0, 7, 0, 0));

		JLabel lbl_year = new JLabel("New label");
		lbl_year.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_year.setBounds(81, 10, 54, 55);
		panel_year.add(lbl_year);
		lbl_year.setText(cal.get(Calendar.YEAR) + "");

		JButton btn_yearMinus = new JButton("\u25C0");
		btn_yearMinus.setFont(new Font("굴림", Font.PLAIN, 10));

		btn_yearMinus.setBounds(31, 18, 45, 39);
		panel_year.add(btn_yearMinus);

		JButton btn_yearPlus = new JButton("\u25B6");
		btn_yearPlus.setFont(new Font("굴림", Font.PLAIN, 10));
		btn_yearPlus.setBounds(137, 18, 45, 39);
		panel_year.add(btn_yearPlus);

		JLabel lbl_month = new JLabel("New label");
		lbl_month.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_month.setBounds(82, 10, 54, 55);
		panel_month.add(lbl_month);
		lbl_month.setText((cal.get(Calendar.MONTH) + 1) + "");

		JButton btn_monPlus = new JButton("\u25B6");
		btn_monPlus.setFont(new Font("굴림", Font.PLAIN, 10));
		btn_monPlus.setBounds(130, 18, 45, 39);
		panel_month.add(btn_monPlus);

		JButton btn_monMinus = new JButton("\u25C0");
		btn_monMinus.setFont(new Font("굴림", Font.PLAIN, 10));
		btn_monMinus.setBounds(40, 18, 45, 39);
		panel_month.add(btn_monMinus);

		btn_yearPlus.setBackground(new Color(255, 255, 255));
		btn_yearMinus.setBackground(new Color(255, 255, 255));
		btn_monPlus.setBackground(new Color(255, 255, 255));
		btn_monMinus.setBackground(new Color(255, 255, 255));
		//초기값 설정
		String day[][] = new String[6][7];

		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	// i번째 달의 날짜 수 세기

		for(int i = 1 ; i <= maxDay ; i++) {
			cal.set(Calendar.DATE, i);
			day[cal.get(Calendar.WEEK_OF_MONTH)-1]
					[cal.get(Calendar.DAY_OF_WEEK)-1] = i + "";
		}
		System.out.println(year + " / " + month);

		//배열 버튼 : 요일
		for (int i = 0; i < 7; i++) {
			panel_day.add(jbtn0[i] = new JButton(week[i]));
			jbtn0[i].setBackground(new Color(255, 255, 255));
		}
		
		jbtn0[0].setForeground(new Color(255, 0, 0));// 일요일 "일" RGB의 색 넣는다.
		jbtn0[6].setForeground(new Color(0, 0, 255));// 토요일 "토"
		//배열 버튼 : 날짜
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				panel_day.add(jbtn1[i][j] = new JButton(day[i][j]));
				jbtn1[i][j].setEnabled(false);
				jbtn1[i][j].setBackground(new Color(255, 255, 255));
			}
			//배열 색설정
			jbtn1[i][0].setForeground(new Color(255, 0, 0));// 일요일 "일" RGB의 색 넣는다.
			jbtn1[i][6].setForeground(new Color(0, 0, 255));// 토요일 "토"
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if(day(year)[month][i][j] != null) {
					String strd = year + "-" + (month+1) + "-" + day(year)[month][i][j];
					String strdate = day(year)[month][i][j] + ""; 

					sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date strDay = null;

					if( jbtn1[i][j].equals(null) == false && strdate != "null") {
						try {
							strDay = sdf.parse(strd);
						} catch (ParseException e1) {e1.printStackTrace();}
					}

					if(strDay != null && jbtn1[i][j] != null) {
						if(d.before(strDay)) {

							jbtn1[i][j].setEnabled(true);

						} else {
						}
					}//end if
				}//end for
			}//end for
		}

		/**** 연도 플러스 버튼 눌렀을 때 ****/
		btn_yearPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//버튼 비활성화
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						jbtn1[i][j].setEnabled(false);
					}
				}
				
				year++;
				lbl_year.setText(year + "");

				day(year);

				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						jbtn1[i][j].setText(day(year)[month][i][j]);
					}
				}

				SimpleDateFormat sdf = new SimpleDateFormat();
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						if(day(year)[month][i][j] != null) {
							String strd = year + "-" + (month+1) + "-" + day(year)[month][i][j];
							String strdate = day(year)[month][i][j] + ""; 

							sdf = new SimpleDateFormat("yyyy-MM-dd");
							Date strDay = null;

							if( jbtn1[i][j].equals(null) == false && strdate != "null") {
								try {
									strDay = sdf.parse(strd);
								} catch (ParseException e1) {e1.printStackTrace();}
							}

							if(strDay != null && jbtn1[i][j] != null) {
								if(d.before(strDay)) {

									jbtn1[i][j].setEnabled(true);

								} else {
								}
							}//end if
						}//end for
					}//end for
				}//end event
			}
		});
		/**** 연도 마이너스 버튼 눌렀을 때 ****/
		btn_yearMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				//버튼 비활성화
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						jbtn1[i][j].setEnabled(false);
					}
				}
				
				year--;
				lbl_year.setText(year + "");

				day(year);

				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						jbtn1[i][j].setText(day(year)[month][i][j]);
					}
				}
				SimpleDateFormat sdf = new SimpleDateFormat();
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						if(day(year)[month][i][j] != null) {
							String strd = year + "-" + (month+1) + "-" + day(year)[month][i][j];
							String strdate = day(year)[month][i][j] + ""; 

							sdf = new SimpleDateFormat("yyyy-MM-dd");
							Date strDay = null;

							if( jbtn1[i][j].equals(null) == false && strdate != "null") {
								try {
									strDay = sdf.parse(strd);
								} catch (ParseException e1) {e1.printStackTrace();}
							}

							if(strDay != null && jbtn1[i][j] != null) {
								if(d.before(strDay)) {

									jbtn1[i][j].setEnabled(true);

								} else {
								}
							}//end if
						}//end for
					}//end for
				}//end event

			}
		});		/**** 연도 마이너스 버튼 눌렀을 때 end ****/

		/**** 월 플러스 버튼 눌렀을 때 ****/
		btn_monPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//버튼 비활성화
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						jbtn1[i][j].setEnabled(false);
					}
				}
				
				//월 값 변경하기
				if(month < 11) {
					month++;
					lbl_month.setText((month + 1) + "");
				} else if(month == 11) {
					month = 0;
					year++;
					lbl_month.setText((month + 1) + "");
					lbl_year.setText(year + "");
				}

				day(year);

				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						jbtn1[i][j].setText(day(year)[month][i][j]);
					}
				}
				SimpleDateFormat sdf = new SimpleDateFormat();
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						if(day(year)[month][i][j] != null) {
							String strd = year + "-" + (month+1) + "-" + day(year)[month][i][j];
							String strdate = day(year)[month][i][j] + ""; 

							sdf = new SimpleDateFormat("yyyy-MM-dd");
							Date strDay = null;

							if( jbtn1[i][j].equals(null) == false && strdate != "null") {
								try {
									strDay = sdf.parse(strd);
								} catch (ParseException e1) {e1.printStackTrace();}
							}

							if(strDay != null && jbtn1[i][j] != null) {
								if(d.before(strDay)) {

									jbtn1[i][j].setEnabled(true);

								} else {
								}
							}//end if
						}//end for
					}//end for
				}//end event

			}
		});		/**** 월 플러스 버튼 눌렀을 때 end****/


		/**** 월 마이너스 버튼 눌렀을 때 ****/
		btn_monMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//버튼 비활성화
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						jbtn1[i][j].setEnabled(false);
					}
				}
				
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						jbtn1[i][j].setEnabled(false);
					}
				}
				if(month > 0) {
					--month;
					lbl_month.setText((month + 1) + "");
				} else if(month == 0) {
					month = 11;
					year--;
					lbl_month.setText((month + 1) + "");
					lbl_year.setText(year + "");
				}
				day(year);

				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						jbtn1[i][j].setText(day(year)[month][i][j]);
					}
				}
				SimpleDateFormat sdf = new SimpleDateFormat();
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						if(day(year)[month][i][j] != null) {
							String strd = year + "-" + (month+1) + "-" + day(year)[month][i][j];
							
							sdf = new SimpleDateFormat("yyyy-MM-dd");
							Date strDay = null;

							if( jbtn1[i][j].equals(null) == false) {
								try {
									strDay = sdf.parse(strd);
								} catch (ParseException e1) {e1.printStackTrace();}
							}

							if(strDay != null && jbtn1[i][j] != null) {
								if(d.before(strDay)) {

									jbtn1[i][j].setEnabled(true);

								} else {
								}
							}//end if
						}//end for
					}//end for
				}//end event
			}
		});


		/**** 달력 클릭 이벤트 ****/
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				jbtn1[i][j].addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BookingGUI bg = new BookingGUI();
		CalMethod cm = new CalMethod();
		CampDAO cd = new CampDAO();
		UserDAO ud = new UserDAO();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date d = new Date();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				bg.cmpClicked[i][j] = 0;
			}
		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if(e.getSource() == jbtn1[i][j]) {
					if(day(year)[month][i][j] != null) {
						
						bg.setStartDate(year + "-" + (month+1) + "-" + day(year)[month][i][j]);
						dispose();
						System.out.println(i + "/" + j);
						break;
					}
				}
			}

		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				if(bg.getEndDate().equals("")==false) {
					
					cd.setGetCnum((i)*5 + (j+1));
					
					if(cd.isBookedCamp( cd.getGetCnum(), cm.StringToDate(bg.getStartDate()), cm.StringToDate(bg.getEndDate())) == true) {
						
						System.out.println(bg.getCamp_num() + " / "  + " / " + bg.getStartDate() + " / " + bg.getEndDate());

						bg.cmpClicked[i][j] = 2;
					}
				}
			}
		}
		cd.setGetCnum(0);
		bg.main(null);
		
	}
}
