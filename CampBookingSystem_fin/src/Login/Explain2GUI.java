package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Explain2GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Explain2GUI frame = new Explain2GUI();
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
	public Explain2GUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 800);
		setLocationRelativeTo(null);
		setTitle("¼÷¹Ú ¾È³»");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 231, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 568, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 11, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		panel.setLayout(null);
		contentPane.add(panel_1);
		
		
		JButton btn_room1_img = new JButton("");
		btn_room1_img.setIcon(new ImageIcon("./images/µ¥Å©»çÀÌÆ®.jpg"));
		btn_room1_img.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Explain2DeckGUI dk = new Explain2DeckGUI();
				dk.setVisible(true);
			}
		});
		btn_room1_img.setForeground(Color.BLACK);
		btn_room1_img.setBackground(Color.WHITE);
		btn_room1_img.setBounds(0, 0, 568, 221);
		btn_room1_img.setFont(new Font("±¼¸²", Font.BOLD, 13));
		panel.add(btn_room1_img);
		
		
		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, panel_2);
		panel_1.setLayout(null);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 503, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		

		JButton btn_room2_img = new JButton("");
		btn_room2_img.setIcon(new ImageIcon("./images/Ä«¶ó¹ÝA.jpg"));
		btn_room2_img.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Explain2CaravanAGUI ca = new Explain2CaravanAGUI();
				ca.setVisible(true);
			}
		});
		btn_room2_img.setBackground(Color.WHITE);
		btn_room2_img.setBounds(0, 0, 568, 255);
		btn_room2_img.setForeground(Color.BLACK);
		btn_room2_img.setFont(new Font("±¼¸²", Font.BOLD, 13));
		panel_1.add(btn_room2_img);
		
		
		JButton btn_room3_img = new JButton("");
		btn_room3_img.setIcon(new ImageIcon("./images/Ä«¶ó¹ÝB.jpg"));
		btn_room3_img.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Explain2CaravanBGUI cb = new Explain2CaravanBGUI();
			cb.setVisible(true);
			}
		});
		btn_room3_img.setBounds(0, 0, 564, 228);
		btn_room3_img.setFont(new Font("±¼¸²", Font.BOLD, 13));
		btn_room3_img.setBackground(Color.WHITE);
		btn_room3_img.setForeground(Color.BLACK);
		panel_2.add(btn_room3_img);
		
		
	}
}
