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

	//conn , pst, rs ���������//
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**** ���� ���̺� ���� ****/
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

	/**** ���� �޼ҵ� ***/
	public void connect() {

		try {
			//
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			//
			Class.forName(driver);

			//DB����
			conn = DriverManager.getConnection(url, user, password);
			if (conn == null) {
				System.out.println("DB���� ����!");
			} else {
				System.out.println("DB���� ����");
			}
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();}
	}

	/**** ���� �޼ҵ� ***/
	public void close() {
		try { 
			if (rs != null) { rs.close();}
			if (pst != null) { pst.close();}
			if (conn != null) {conn.close();}

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		}
	}

	/**** �Է� �޼ҵ� ***/
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

	/**** ���� �޼ҵ� ***/
	public void delete(int user_num) {
		try {//��..���� �ѹ��� ����...

			connect();

			String sql = "delete from  User_tb where User_num = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, user_num);//prepareStatement 1���� ����

			//Query�� ����
			pst.executeUpdate();

		} catch (SQLException e) {// db���� ����
			e.printStackTrace();
		} catch (Exception e) {// db���� ����
			e.printStackTrace();
		} finally {
			close();
		}

	}

	/**** ������Ʈ �޼ҵ� ***/
	public void Update(  String user_pw,
			String user_name, String user_phone,int user_num) {//������Ʈ�ε� ��.. ������ �����ѹ�����
		try {													//�˰ھ��

			connect();

			String sql = "update User_tb set user_pw = ?, user_name = ?, user_phone = ? where user_num = ?";


			pst = conn.prepareStatement(sql);
			pst.setString(1, user_pw);
			pst.setString(2, user_name);
			pst.setString(3, user_phone);
			pst.setInt(4, user_num);

			// Query�� ����
			pst.executeUpdate();

			pst.executeUpdate();

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
	}

	/**** ��ȸ �޼ҵ� ***/
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

		}catch (Exception e) {// db���� ����
			e.printStackTrace();
		} finally {
			close();
		}

		return userList;
	}
	/**** user_num �� �ߺ����� ���ϱ� ���� ������ �� ���� ���ִ� �޼ҵ��Դϴ� ****/
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

	/**** ID �ߺ��� ã�� �޼ҵ� ***/
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
					System.out.println("���̵��ߺ�");
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
	
	/**** ID�� PW Ȯ���ϴ� �޼ҵ� :: �α��ο� ****/
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
					System.out.println("���̵�� ��й�ȣ�� ��ġ�մϴ�.");
					getUnum = rs.getInt("user_num");
					getUID = txtid;
					getUname = rs.getString("user_name");
					getUphone = rs.getString("user_phone");
					getUaccount = rs.getInt("user_account");
					System.out.println(getUID + " / " + getUnum);
					ovl = true;
					break;
				} else {
					System.out.println("���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
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
					System.out.println("�̸��� �ڵ��� ��ȣ�� ��ġ�մϴ�.");
					userList.add(userArray);
					ovl = true;
					break;
				} else {
					System.out.println("�̸��� �ڵ��� ��ȣ�� ��ġ���� �ʽ��ϴ�.");
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
				System.out.println("�̸��� �ڵ��� ��ȣ�� ��ġ�մϴ�.");
				
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
		}catch (Exception e) {// db���� ����
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(getUID);
		return getUID;
	}


	public int Get_user_num(String user_id) {//�α��� ������ ���� �ѹ� ���� �� +++++ //�̿�//+++

		try {
			connect();
			String sql = "select user_num from User_tb where user_id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);

			rs = pst.executeQuery();

			if(rs.next()) {
				getUnum = rs.getInt("user_num");
			}
		}catch (Exception e) {// db���� ����
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

		}catch (Exception e) {// db���� ����
			e.printStackTrace();
		} finally {
			close();
		}

		return userList;
	}
	/**** ������Ʈ �޼ҵ� ***/
	public void updateUserAccount(int user_num, int user_account) {//������Ʈ�ε� ��.. ������ �����ѹ�����
		try {													//�˰ھ��

			connect();

			String sql = "update User_tb set user_account = ?"
					+ " where user_num = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, user_account);
			pst.setInt(2, user_num);

			// Query�� ����
			pst.executeUpdate();

			pst.executeUpdate();

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
	}
	public void Deposit(int deposit) {//������Ʈ�ε� ��.. ������ �����ѹ�����
		try {													//�˰ھ��

			connect();

			String sql = "update User_tb set user_account = ? =user_account+" + deposit + " where user_num = ?";

			pst.setInt(1, user_account);
			pst.setInt(2, user_num);

			// Query�� ����
			pst.executeUpdate();

		} catch (SQLException e) {e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();
		} finally {
			close();
		}
	}
	public void updateWithdraw(int withdraw) {//������Ʈ�ε� ��.. ������ �����ѹ�����
		try {													//�˰ھ��

			connect();

			String sql = "update User_tb set user_account = ? =user_account- " +withdraw+ " where user_num = ?";

			pst.setInt(1, user_account);
			pst.setInt(2, user_num);

			// Query�� ����
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