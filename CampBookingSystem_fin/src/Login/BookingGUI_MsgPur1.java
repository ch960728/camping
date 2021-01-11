package Login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookingGUI_MsgPur1 extends JDialog {

	BookingGUI bg = new BookingGUI();

	int tp;		//총 가격
	int pr;		//가격
	int pp;		//사람
	int date; 	//일수

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BookingGUI_MsgPur1 dialog = new BookingGUI_MsgPur1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BookingGUI_MsgPur1() {
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		/**** 변수에 데이터 넣어주기 ****/
		tp = bg.getTotalPrice();	//총가격
		pr = bg.getPrice();			//가격
		pp = bg.getPeople() + 1;		//인원수
		date = bg.getCalDate();		//잃수

		{
			JLabel lblNewLabel = new JLabel("\uCEA0\uD551\uC7A5 \uB300\uC5EC\uB8CC :");
			lblNewLabel.setBounds(57, 10, 87, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lbl_cmpPrice = new JLabel("0");
			lbl_cmpPrice.setBounds(167, 10, 57, 15);
			contentPanel.add(lbl_cmpPrice);

			lbl_cmpPrice.setText(pr+"");		//가격
		}
		{
			JLabel lblNewLabel_2_1 = new JLabel("\uC778\uC6D0\uC218 :");
			lblNewLabel_2_1.setBounds(59, 60, 85, 15);
			contentPanel.add(lblNewLabel_2_1);
		}
		{
			JLabel lbl_totalPrice = new JLabel("0");
			lbl_totalPrice.setBounds(165, 103, 57, 15);
			contentPanel.add(lbl_totalPrice);

			lbl_totalPrice.setText(tp+"");		//총가격
		}
		{
			JLabel lblNewLabel_2_2 = new JLabel("\uCD1D \uAE08\uC561 :");
			lblNewLabel_2_2.setBounds(57, 103, 85, 15);
			contentPanel.add(lblNewLabel_2_2);
		}
		{
			JLabel lblNewLabel = new JLabel("\uB300\uC5EC \uC77C\uC218 : ");
			lblNewLabel.setBounds(57, 35, 87, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lbl_cmpDate = new JLabel("0");
			lbl_cmpDate.setBounds(167, 35, 57, 15);
			contentPanel.add(lbl_cmpDate);

			lbl_cmpDate.setText(date+"");		//일수
		}
		{
			JLabel lbl_cmpPeople = new JLabel("0");
			lbl_cmpPeople.setBounds(167, 60, 57, 15);
			contentPanel.add(lbl_cmpPeople);

			lbl_cmpPeople.setText(pp+"");		//인원수
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uACB0\uC81C\uD558\uAE30");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
						BookingGUI_MsgPur2 bgmp2 = new BookingGUI_MsgPur2();
						bgmp2.setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						BookingGUI bg = new BookingGUI();
						bg.main(null);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}


	}

}
