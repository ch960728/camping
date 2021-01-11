package Login;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;


public class Explain1GUI extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Explain1GUI frame = new Explain1GUI();
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
	public Explain1GUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 15, 563, 50);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 81, 538, 306);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("./images/맨위로고.jpg"));
		lblNewLabel_1.setBounds(0, 0, 558, 50);
		panel.add(lblNewLabel_1);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("./images/캠핑장설명.jpg"));
		lblNewLabel_2.setBounds(0, 0, 538, 306);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("\uC124\uBA85");
		lblNewLabel.setBounds(294, 5, 36, 21);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("./images/약도4.jpg"));
		lblNewLabel_3.setBounds(25, 399, 532, 330);
		contentPane.add(lblNewLabel_3);
	}
}
