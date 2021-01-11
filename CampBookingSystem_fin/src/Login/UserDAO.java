package Login;

import java.awt.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class UserDAO {

	//conn , pst, rs 변수선언부//
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**** 유저 테이블 변수 ****/
	int user_num;
	String user_id;
	String user_pw;
	String user_name;
	String user_phone;
	int user_account;
	int camp_num;
	
	public static int getUnum;
	public static String getUID;
	public static String getUname;
	public static String getUphone;
	public static int getUaccount;
	
	public static int getGetUaccount() {
		return getUaccount;
	}

	public static void setGetUaccount(int getUaccount) {
		UserDAO.getUaccount = getUaccount;
	}

	public static String getGetUname() {
		return getUname;
	}

	public static void setGetUname(String getUname) {
		UserDAO.getUname = getUname;
	}

	public static String getGetUphone() {
		return getUphone;
	}

	public static void setGetUphone(String getUphone) {
		UserDAO.getUphone = getUphone;
	}

	public static int getGetUnum() {
		return getUnum;
	}

	public static void setGetUnum(int getUnum) {
		UserDAO.getUnum = getUnum;
	}

	public static String getGetUID() {
		return getUID;
	}

	public static void setGetUID(String getUID) {
		UserDAO.getUID = getUID;
	}

	/**** 접속 메소드 ***/
	public void connect() {

		try {
			//
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			//
			Class.forName(driver);

			//DB연결
			conn = DriverManager.getConnection(url, user, password);
			if (conn == null) {
				System.out.println("DB연결 실패!");
			} else {
				System.out.println("DB연결 성공");
			}
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();}
	}

	/**** 종료 메소드 ***/
	public void close() {
		try { 
			if (rs != null) { rs.close();}
			if (pst != null) { pst.close();}
			if (conn != null) {conn.close();}

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		}
	}

	/**** 입력 메소드 ***/
	public void insert( String user_id, 
			String user_pw, 
			String user_name,
			String user_phone, 
			int user_account,
			int camp_num) {

		try {
			connect();

			String sql = "insert into  User_tb values(user_num.nextval,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			//pst.setInt(1, user_num);
			pst.setString(1, user_id);
			pst.setString(2, user_pw);
			pst.setString(3, user_name);
			pst.setString(4, user_phone);
			pst.setInt(5, user_account);
			pst.setInt(6, camp_num);

			pst.executeUpdate();

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
	}

	/**** 삭제 메소드 ***/
	public void delete(int user_num) {
		try {//어..유저 넘버가 조건...

			connect();

			String sql = "delete from  User_tb where User_num = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, user_num);//prepareStatement 1부터 시작

			//Query문 실행
			pst.executeUpdate();

		} catch (SQLException e) {// db열결 실패
			e.printStackTrace();
		} catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			close();
		}

	}

	/**** 업데이트 메소드 ***/
	public void Update(  String user_pw,
			String user_name, String user_phone,int user_num) {//업데이트인데 어.. 조건이 유저넘버에요
		try {													//알겠어요

			connect();

			String sql = "update User_tb set user_pw = ?, user_name = ?, user_phone = ? where user_num = ?";


			pst = conn.prepareStatement(sql);
			pst.setString(1, user_pw);
			pst.setString(2, user_name);
			pst.setString(3, user_phone);
			pst.setInt(4, user_num);

			// Query문 실행
			pst.executeUpdate();

			pst.executeUpdate();

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
	}

	/**** 조회 메소드 ***/
	public ArrayList<user> Select() {
		ArrayList<user> userList = new ArrayList<user>();

		try {
			connect();

			String sql = "select * from  User_tb";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while(rs.next()) {
				user user = new user(rs.getInt("user_num"), 
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_phone"),
						rs.getInt("user_account"),
						rs.getInt("camp_num"));
				/*
			String rname = rs.getNString("name");
			int rage = rs.getInt("age");
			String rphone = rs.getString("phone");
			System.out.println(" "+rname+" | "+rage+" | "+rphone);
				 */
				userList.add(user);
			}

		}catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			close();
		}

		return userList;
	}
	/**** user_num 의 중복값을 피하기 위해 유저의 총 수를 세주는 메소드입니다 ****/
	public int count() {

		ArrayList<user> userList = new ArrayList<user>();
		int cnt = 0;

		try {
			connect();

			String sql = "select * from User_tb"; 
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				user userArray = new user(rs.getInt("user_num"),
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_phone"),
						rs.getInt("user_account"),
						rs.getInt("camp_num"));
				userList.add(userArray);
				cnt++;
				System.out.println(cnt);
			}

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	/**** ID 중복값 찾기 메소드 ***/
	public boolean findOverlapedID(String txtid) {

		boolean ovl = false;

		ArrayList<user> userList = new ArrayList<user>();

		try {
			connect();

			String sql = "select * from User_tb"; 
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				user userArray = new user(rs.getInt("user_num"),
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_phone"),
						rs.getInt("user_account"),
						rs.getInt("camp_num"));
				if(rs.getString("user_id").equals(txtid)==true) {
					System.out.println("아이디중복");
					ovl = true;
					break;
				}
				userList.add(userArray);
			}

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
		return ovl;
	}
	
	/**** ID와 PW 확인하는 메소드 :: 로그인용 ****/
	public boolean identify_IDnPW(String txtid, String txtpw) {

		ArrayList<user> userList = new ArrayList<user>();

		boolean ovl = false;
		
		try {
			connect();

			String sql = "select * from User_tb"; 
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				user userArray = new user(rs.getInt("user_num"),
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_phone"),
						rs.getInt("user_account"),
						rs.getInt("camp_num"));
				if(rs.getString("user_id").equals(txtid)==true && rs.getString("user_pw").equals(txtpw)==true) {
					System.out.println("아이디와 비밀번호가 일치합니다.");
					getUnum = rs.getInt("user_num");
					getUID = txtid;
					getUname = rs.getString("user_name");
					getUphone = rs.getString("user_phone");
					getUaccount = rs.getInt("user_account");
					System.out.println(getUID + " / " + getUnum);
					ovl = true;
					break;
				} else {
					System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
				}
			}

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
		return ovl;
	}
	public boolean find_IDnPW(String txtname, String txtphone) {

		boolean ovl = false;

		ArrayList<user> userList = new ArrayList<user>();

		try {
			connect();

			String sql = "select * from User_tb"; 
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				user userArray = new user(rs.getInt("user_num"),
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_phone"),
						rs.getInt("user_account"),
						rs.getInt("camp_num"));
				if(rs.getString("user_name").equals(txtname)==true && rs.getString("user_phone").equals(txtphone)==true) {
					System.out.println("이름과 핸드폰 번호가 일치합니다.");
					userList.add(userArray);
					ovl = true;
					break;
				} else {
					System.out.println("이름과 핸드폰 번호가 일치하지 않습니다.");
				}

			
			}
		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
		return ovl;
	}
	public ArrayList<user> find_IDnPWs(String txtname, String txtphone) {
		ArrayList<user> userList = new ArrayList<user>();

		try {
			connect();

			String sql = "select * from User_tb";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();


			user userArray = new user(rs.getInt("user_num"),
					rs.getString("user_id"),
					rs.getString("user_pw"),
					rs.getString("user_name"),
					rs.getString("user_phone"),
					rs.getInt("user_account"),
					rs.getInt("camp_num"));
			if(rs.getString("user_name").equals(txtname)==true && rs.getString("user_phone").equals(txtphone)==true) {
				System.out.println("이름과 핸드폰 번호가 일치합니다.");
				
			}


		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
		return userList;

	}
	public String Login(String user_id) {
		try {
			connect();
			String sql = "select user_id from User_tb where user_id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			rs = pst.executeQuery();

			if(rs.next()) {
				getUID = rs.getString("user_id");
				Get_user_num(user_id);
			}
		}catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(getUID);
		return getUID;
	}


	public int Get_user_num(String user_id) {//로그인 성공시 유저 넘버 가져 옴 +++++ //미완//+++

		try {
			connect();
			String sql = "select user_num from User_tb where user_id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);

			rs = pst.executeQuery();

			if(rs.next()) {
				getUnum = rs.getInt("user_num");
			}
		}catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(getUnum);
		return getUnum;

	}
	public ArrayList<user> accountCheck(int user_num) {
		ArrayList<user> userList = new ArrayList<user>();

		try {
			connect();

			String sql = "select * from  User_tb";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while(rs.next()) {
				user user = new user(rs.getInt("user_num"), 
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_phone"),
						rs.getInt("user_account"),
						rs.getInt("camp_num"));
				if(rs.getInt("user_num") == user_num) {
					userList.add(user);
				}
			}

		}catch (Exception e) {// db열결 실패
			e.printStackTrace();
		} finally {
			close();
		}

		return userList;
	}
	/**** 업데이트 메소드 ***/
	public void updateUserAccount(int user_num, int user_account) {//업데이트인데 어.. 조건이 유저넘버에요
		try {													//알겠어요

			connect();

			String sql = "update User_tb set user_account = ?"
					+ " where user_num = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, user_account);
			pst.setInt(2, user_num);

			// Query문 실행
			pst.executeUpdate();

			pst.executeUpdate();

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
	}
	public void Deposit(int deposit) {//업데이트인데 어.. 조건이 유저넘버에요
		try {													//알겠어요

			connect();

			String sql = "update User_tb set user_account = ? =user_account+" + deposit + " where user_num = ?";

			pst.setInt(1, user_account);
			pst.setInt(2, user_num);

			// Query문 실행
			pst.executeUpdate();

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
	}
	public void updateWithdraw(int withdraw) {//업데이트인데 어.. 조건이 유저넘버에요
		try {													//알겠어요

			connect();

			String sql = "update User_tb set user_account = ? =user_account- " +withdraw+ " where user_num = ?";

			pst.setInt(1, user_account);
			pst.setInt(2, user_num);

			// Query문 실행
			pst.executeUpdate();

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
	
	}

	public void updateDeposit1(int deposit) {
		// TODO Auto-generated method stub
		
	}
}