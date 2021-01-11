package Login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class BookingGUI_MsgPur2 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BookingGUI_MsgPur2 dialog = new BookingGUI_MsgPur2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BookingGUI_MsgPur2() {
		setBounds(100, 100, 200, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\uACB0\uC81C\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 160, 58);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uCDE8\uC18C");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						BookingGUI bg = new BookingGUI();
						
						bg.main(null);
						dispose();
					}
				});
				{
					JButton okButton_1 = new JButton("\uD655\uC778");
					okButton_1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							BookingGUI_MsgPur3 bmpc = new BookingGUI_MsgPur3();
							BookingGUI_MsgPur4 bmpc4 = new BookingGUI_MsgPur4();
							BookingGUI bg = new BookingGUI();
							CalendarGUI_StartDate sd = new CalendarGUI_StartDate();
							CalendarGUI_EndDate ce = new CalendarGUI_EndDate();
							CalMethod cm = new CalMethod();
							CampDAO cd = new CampDAO();
							UserDAO ud = new UserDAO();

							int camp_num = bg.getCamp_num();
							int user_num = ud.getGetUnum();
							int camp_payment = bg.getTotalPrice();
							int user_people = bg.getPeople() + 1;
							Date camp_date_in = cm.StringToDate(bg.getStartDate());
							Date camp_date_out = cm.StringToDate(bg.getEndDate());
							char camp_in = "1".charAt(0);

							if(ud.accountCheck(user_num).get(0).getUser_account() >= camp_payment) {

							int user_account = ud.accountCheck(user_num).get(0).getUser_account() - camp_payment;
								
							ud.updateUserAccount(user_num, user_account);

								cd.Insert_C(camp_num, user_num, camp_payment, user_people, camp_date_in, camp_date_out, camp_in);

								bg.setCamp_num(0);
								bg.setTotalPrice(0);
								bg.setPeople(0);
								bg.setStartDate("");
								bg.setEndDate("");
								bg.setPrice(0);

								dispose();

								bmpc.setVisible(true);
							} else {
								System.out.println("유저 잔고가 결제금액보다 작습니다.");
								bmpc4.setVisible(true);
							}
						}
					});
					okButton_1.setActionCommand("OK");
					buttonPane.add(okButton_1);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
