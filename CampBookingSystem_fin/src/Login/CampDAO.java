package Login;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CampDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);
	UserDAO dao = new UserDAO();

	public static int getCnum;
	public static Date getDateIn;
	public static Date getDateOut;



	public static int getGetCnum() {
		return getCnum;
	}



	public static void setGetCnum(int getCnum) {
		CampDAO.getCnum = getCnum;
	}



	public static Date getGetDateIn() {
		return getDateIn;
	}



	public static void setGetDateIn(Date getDateIn) {
		CampDAO.getDateIn = getDateIn;
	}



	public static Date getGetDateOut() {
		return getDateOut;
	}



	public static void setGetDateOut(Date getDateOut) {
		CampDAO.getDateOut = getDateOut;
	}



	public void Connect() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, password);

			if (conn == null) {
				System.out.println("DB연결 실패!");
			} else {
				System.out.println("DB연결 성공");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {// db열결 실패
			e.printStackTrace();
		} catch (Exception e) {// db열결 실패
			e.printStackTrace();
			System.out.println("알수 없는 오류");
		}
	}



	public void Insert_C(int camp_num, int user_num, int camp_payment, int user_people, Date camp_date_in, Date camp_date_out, char camp_in) { //캠핑장 만들기


		try {

			Connect();

			String sql = "insert into Camp_tb values (?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, camp_num);
			pst.setInt(2, user_num);
			pst.setInt(3, camp_payment);
			pst.setInt(4, user_people);
			pst.setDate(5, new java.sql.Date(camp_date_in.getTime()));
			pst.setDate(6, new java.sql.Date(camp_date_out.getTime()));
			pst.setString(7, String.valueOf(camp_in));
			// Query문 실행
			pst.executeUpdate();

		} catch (SQLException e) {// db열결 실패
			e.printStackTrace();
		} catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			Close();
		}

	}

	public void inAndout(char camp_in, int camp_num) {// 입 퇴실
		try {

			Connect();

			String sql = "update Camp_tb set camp_in=? where camp_num=?";
			pst = conn.prepareStatement(sql);

			pst.setString(1, String.valueOf(camp_in));
			pst.setInt(2, camp_num);
			pst.executeUpdate();

		} catch (SQLException e) {// db열결 실패
			e.printStackTrace();
		} catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			Close();
		}
	}

	public void Update_C(char camp_in, int camp_num) {// 입 퇴실
		try {

			Connect();

			String sql = "update Camp_tb set user_num=? user_people=? camp_date_in=? camp_date_out=? where camp_num=?";
			pst = conn.prepareStatement(sql);

			pst.setString(1, String.valueOf(camp_in));
			pst.setInt(2, camp_num);
			pst.executeUpdate();

		} catch (SQLException e) {// db열결 실패
			e.printStackTrace();
		} catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			Close();
		}
	}

	public void Close() {
		try {
			// 연결했었던 객체 : conn, pst 반드시 닫아주어야함
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {// db열결 실패
			e.printStackTrace();
		}

	}

	public ArrayList<Camp> Select_C() { 
		ArrayList<Camp> campList = new ArrayList<Camp>();

		try {
			Connect();

			String sql = "select * from  camp_tb";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Camp camp = new Camp(rs.getInt("Camp_num"),
						rs.getInt("user_num"),
						rs.getInt("camp_payment"),
						rs.getInt("user_people"),
						rs.getDate("Camp_date_in"),
						rs.getDate("Camp_date_out"),
						rs.getString("camp_in"));

				// pst.setString(6, String.valueOf(camp_in));
				campList.add(camp);
			}

		} catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			Close();
		}

		return campList;
	}

	public boolean isBookedCamp(int Camp_num, Date Camp_date_in, Date Camp_date_out) { 
		ArrayList<Camp> campList = new ArrayList<Camp>();
		UserDAO ud = new UserDAO();
		BookingGUI bg = new BookingGUI();
		CalMethod cm = new CalMethod();

		Date b_in;
		Date b_out;

		double b_intime;
		double b_outtime;

		Date in = cm.StringToDate(bg.getStartDate());	//입력한 입실일
		Date out = cm.StringToDate(bg.getEndDate());	//입력한 퇴실일

		double intime = in.getTime() / ( 24 * 60 * 60 *1000);
		double outtime = out.getTime() / ( 24 * 60 * 60 *1000);

		boolean isBooked = false;

		try {
			Connect();

			String sql = "select * from  camp_tb";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Camp camp = new Camp(rs.getInt("Camp_num"),
						rs.getInt("user_num"),
						rs.getInt("camp_payment"),
						rs.getInt("user_people"),
						rs.getDate("Camp_date_in"),
						rs.getDate("Camp_date_out"),
						rs.getString("camp_in"));
				if(rs.getInt("Camp_num") == Camp_num) {

					System.out.println("캠프번호가 일치합니다.");

					b_in = rs.getDate("Camp_date_in");
					b_out = rs.getDate("Camp_date_out");

					b_intime = b_in.getTime() / ( 24 * 60 * 60 *1000);		//디비 입실일
					b_outtime = b_out.getTime() / ( 24 * 60 * 60 *1000);	//디비 퇴실일

					System.out.println(intime + "\t" + outtime + "\t" + b_intime + "\t" + b_outtime);

					double i = b_intime;
					
					
					while(i <= b_outtime) {	
						
						if((intime <= i && i < outtime)) {
							System.out.println("선택입실일 <= db입실일 < 선택퇴실일 또는");
							System.out.println("선택입실일 <= db퇴실일 < 선택퇴실일");
							System.out.println(rs.getInt("Camp_num") + " / " + Camp_num);
							isBooked = true;	//날짜 겹치면 true
						}
						i++;
					}
				} else {
					System.out.println(rs.getInt("Camp_num") + " / " + Camp_num);
					System.out.println("캠프번호가 일치하지 않습니다.");
				}
				// pst.setString(6, String.valueOf(camp_in));
				campList.add(camp);
			}

		} catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			Close();
		}

		return isBooked;
	}
	public ArrayList<Camp> Select_user_num(int user_num) { 
		ArrayList<Camp> campList = new ArrayList<Camp>();

		try {
			Connect();

			String sql = "select * from  camp_tb";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Camp camp = new Camp(rs.getInt("Camp_num"),
						rs.getInt("user_num"),
						rs.getInt("camp_payment"),
						rs.getInt("user_people"),
						rs.getDate("Camp_date_in"),
						rs.getDate("Camp_date_out"),
						rs.getString("camp_in"));
				if(rs.getInt("user_num") == user_num) {
					campList.add(camp);
				}
				// pst.setString(6, String.valueOf(camp_in));	
			}

		} catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			Close();
		}

		return campList;
	}
	public void Update_accountPlus(char camp_in, int camp_num) {// 입 퇴실
		try {

			Connect();

			String sql = "update Camp_tb set user_num=? user_people=? camp_date_in=? camp_date_out=? where camp_num=?";
			pst = conn.prepareStatement(sql);

			pst.setString(1, String.valueOf(camp_in));
			pst.setInt(2, camp_num);
			pst.executeUpdate();

		} catch (SQLException e) {// db열결 실패
			e.printStackTrace();
		} catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			Close();
		}
	}
}




/*
	public void wtf() {

		try {
			Connect();

			String sql = "select * from  camp_tb";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(6));
			}
		} catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			Close();
		}

	}
 */
