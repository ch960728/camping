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

public class Explain2CaravanAGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Explain2CaravanAGUI dialog = new Explain2CaravanAGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Explain2CaravanAGUI() {
		setTitle("카라반A 설명");
		setSize(450, 450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblcaravan1 = new JLabel();
		lblcaravan1.setIcon(new ImageIcon("./images/카라반A설명.jpg"));
		lblcaravan1.setBounds(0, 0, 434, 378);
		contentPanel.add(lblcaravan1);
		
		JLabel lblcaravan2 = new JLabel();
		lblcaravan2.setIcon(new ImageIcon("./images/카라반설명.jpg"));
		lblcaravan2.setBounds(0, 0, 434, 378);
		contentPanel.add(lblcaravan2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnNewButton_1 = new JButton("\u25C0");
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override 
				public void mouseClicked(MouseEvent e) {
					lblcaravan1.setVisible(true);
				}
			}); 
			btnNewButton_1.setBackground(Color.WHITE);
			buttonPane.add(btnNewButton_1);
			
			JButton btnNewButton = new JButton("\u25B6");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblcaravan1.setVisible(false);
					lblcaravan2.setVisible(true);
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
