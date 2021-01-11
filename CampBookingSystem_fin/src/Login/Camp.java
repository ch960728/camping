package Login;

import java.io.Reader;
import java.sql.Date;

public class Camp {
	private int camp_num;
	private int user_num;
	private int camp_payment;
	private int user_people;
	private Date camp_date_in;
	private Date camp_date_out;
	private String camp_in;
	
	
	
	public Camp(int camp_num, int user_num, int camp_payment, int user_people, Date camp_date_in, Date camp_date_out, String camp_in) {
		
		this.camp_num = camp_num;
		this.user_num = user_num;
		this.camp_payment = camp_payment;
		this.user_people = user_people;
		this.camp_date_in = camp_date_in;
		this.camp_date_out = camp_date_out;
		this.camp_in = camp_in;
	}
	
	
	public int getCamp_payment() {
		return camp_payment;
	}


	public void setCamp_payment(int camp_payment) {
		this.camp_payment = camp_payment;
	}


	public int getCamp_num() {
		return camp_num;
	}
	public void setCamp_num(int camp_num) {
		this.camp_num = camp_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getUser_people() {
		return user_people;
	}
	public void setUser_people(int user_people) {
		this.user_people = user_people;
	}
	public Date getCamp_date_in() {
		return camp_date_in;
	}
	public void setCamp_date_in(Date camp_date_in) {
		this.camp_date_in = camp_date_in;
	}
	public Date getCamp_date_out() {
		return camp_date_out;
	}
	public void setCamp_date_out(Date camp_date_out) {
		this.camp_date_out = camp_date_out;
	}
	public String getCamp_in() {
		return camp_in;
	}
	public void setCamp_in(String camp_in) {
		this.camp_in = camp_in;
	}
}
