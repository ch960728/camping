package Login;

public class user {
	
	/**** 유저 테이블 구성요소 ****/
	private int user_number;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_phone;
	private int user_account;
	private int camp_num;
	
	public int getUser_account() {
		return user_account;
	}

	public void setUser_account(int user_account) {
		this.user_account = user_account;
	}




	public int getCamp_num() {
		return camp_num;
	}

	public void setCamp_num(int camp_num) {
		this.camp_num = camp_num;
	}

	/**** 유저 테이블 구성요소 ****/
	
	public user(int user_number, String user_id, String user_pw, String user_name, String user_phone, int user_account, int camp_num) {
		
		/**** 유저 테이블 구성요소 ****/
		this.user_number = user_number;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_account = user_account;
		this.camp_num = camp_num;
		/**** 유저 테이블 구성요소 ****/
		
	}
	
	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPhone() {
		return user_phone;
	}

	public void setPhone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

}