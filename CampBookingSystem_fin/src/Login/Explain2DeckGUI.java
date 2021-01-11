package Login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Explain2DeckGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Explain2DeckGUI dialog = new Explain2DeckGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Explain2DeckGUI() {
		setTitle("데크사이트 설명");
		setSize(450, 450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbldeck1 = new JLabel();
		lbldeck1.setIcon(new ImageIcon("./images/데크설명1.jpg"));
		lbldeck1.setBounds(0, 0, 434, 378);
		contentPanel.add(lbldeck1);
		
		JLabel lbldeck2 = new JLabel();
		lbldeck2.setIcon(new ImageIcon("./images/데크설명2.jpg"));
		lbldeck2.setBounds(0, 0, 434, 378);
		contentPanel.add(lbldeck2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnNewButton_1 = new JButton("\u25C0");
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override 
				public void mouseClicked(MouseEvent e) {
					lbldeck1.setVisible(true);
				}
			}); 
			btnNewButton_1.setBackground(Color.WHITE);
			buttonPane.add(btnNewButton_1);
			
			JButton btnNewButton = new JButton("\u25B6");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lbldeck1.setVisible(false);
					lbldeck2.setVisible(true);
				}
			});
			btnNewButton.setBackground(Color.WHITE);
			buttonPane.add(btnNewButton);
			{
				JButton cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Explain2GUI ex = new Explain2GUI();
						ex.setVisible(true);
						dispose();
					}
				});
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
