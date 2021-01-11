package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListModel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

public class userInfoGUI extends JFrame {
	private DefaultListModel<String> listmodel; // Jlsit�� ������ ����ϱ� ���� ��ü Jlist�� �� �� �ʿ�!
	private JPanel contentPane;
	private JFrame frame;
	private ArrayList<Camp> camps;//
	private JList<String> list;
	UserDAO ud = new UserDAO();
	CampDAO cd = new CampDAO();
	private JTable table;
	private JTable table_1;

	//��� ���� ����?
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInfoGUI frame = new userInfoGUI();
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
	public userInfoGUI() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 256, 100);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btn_logo = new JButton("logo");
		btn_logo.setIcon(new ImageIcon("./images/�����������ΰ�.jpg"));
		btn_logo.addMouseListener(new MouseAdapter() {
			@Override // �ΰ�Ŭ��
			public void mouseClicked(MouseEvent arg0) {
				// main�� ���ư��� (����â���� �����ʿ�)
				CampingGUI.main(null);
				// userInfoGUIâ �ݱ�
				dispose();
			}
		});
		btn_logo.setBounds(12, 10, 232, 80);
		panel.add(btn_logo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(280, 10, 292, 100);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		// ������ ��� ����id ���
		JLabel lbl_userInfo = new JLabel("����");
		lbl_userInfo.setBounds(12, 60, 268, 30);
		panel_1.add(lbl_userInfo);
		lbl_userInfo.setText(ud.getUID + "�� ȯ���մϴ�");

		JButton btn_back = new JButton("");
		btn_back.setBackground(Color.WHITE);
		btn_back.setIcon(new ImageIcon("./images/�����������ڷΰ���.jpg"));
		btn_back.addMouseListener(new MouseAdapter() {
			@Override // �ڷΰ��� Ŭ��
			public void mouseClicked(MouseEvent e) {
				// ķ��GUI�� ���ư���
//				CampingGUI.main(null);
				// userInfoGUIâ �ݱ�
				dispose();
			}
		});
		btn_back.setBounds(145, 10, 135, 30);
		panel_1.add(btn_back);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 121, 256, 50);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setIcon(new ImageIcon("./images/����������ID.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 232, 20);
		panel_2.add(lblNewLabel);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(280, 121, 292, 50);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		// �α����� ȸ���� ���̵�
		JLabel lbl_ID = new JLabel("gugu");
		lbl_ID.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ID.setBounds(12, 10, 268, 30);
		panel_1_1.add(lbl_ID);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(12, 181, 256, 50);
		panel_2_1.setLayout(null);
		contentPane.add(panel_2_1);

		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984(name) :");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon("./images/�����������̸�.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 232, 20);
		panel_2_1.add(lblNewLabel_1);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(12, 241, 256, 50);
		panel_2_2.setLayout(null);
		contentPane.add(panel_2_2);

		JLabel lblNewLabel_2 = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638(H.P) :");
		lblNewLabel_2.setIcon(new ImageIcon("./images/�����������ڵ�����ȣ.jpg"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 10, 232, 30);
		panel_2_2.add(lblNewLabel_2);

		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBounds(148, 377, 256, 60);
		panel_2_3.setLayout(null);
		contentPane.add(panel_2_3);

		JLabel lblNewLabel_3 = new JLabel("<< \uC608\uC57D\uC815\uBCF4(Reservation Info) >>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 10, 232, 40);
		panel_2_3.add(lblNewLabel_3);
		panel_2_3.setBackground(Color.WHITE);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(Color.WHITE);
		
		panel_1_1_1.setBounds(280, 181, 292, 50);
		panel_1_1_1.setLayout(null);
		contentPane.add(panel_1_1_1);

		// �α����� id�� �̸�
		JLabel lbl_name = new JLabel("New label");
		lbl_name.setBackground(Color.WHITE);
		lbl_name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_name.setBounds(12, 10, 268, 30);
		panel_1_1_1.add(lbl_name);

		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBackground(Color.WHITE);
		panel_1_1_2.setBounds(280, 241, 292, 50);
		panel_1_1_2.setLayout(null);
		contentPane.add(panel_1_1_2);

		// �α����� id�� �ڵ�����ȣ
		JLabel lbl_phone = new JLabel("New label");
		lbl_phone.setBackground(Color.WHITE);
		lbl_phone.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_phone.setBounds(12, 10, 268, 30);
		panel_1_1_2.add(lbl_phone);

		lbl_ID.setText(ud.getUID);
		lbl_name.setText(ud.getUname);
		lbl_phone.setText(ud.getUphone);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 462, 560, 346);
		contentPane.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);

		JScrollPane scrollPane = new JScrollPane();
		sl_panel_3.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, scrollPane, 550, SpringLayout.WEST, panel_3);
		panel_3.add(scrollPane);

		CampDAO cd = new CampDAO();
		UserDAO ud = new UserDAO();
		//���� DB���� �������°ŷ� �ٲ�������ʳ���?
		
		
		ArrayList<Camp> campList = cd.Select_user_num(ud.getGetUnum());

		System.out.println(campList.size());
		String[] cols = { "ķ����ȣ", "����ȣ", "����ݾ�", "�ο���", "�Խ�", "���"};
		String[][] rows = new String[campList.size()][cols.length];

		// rows�迭�� �����͸� ����
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < cols.length; j++) {
				//i -> j
				if (j == 0) {
					rows[i][j] = "" + (campList.get(i).getCamp_num());
				} else if (j == 1) {
					rows[i][j] = "" + (campList.get(i).getUser_num());
				} else if (j == 2) {
					rows[i][j] = "" + campList.get(i).getCamp_payment();
				} else if (j == 3) {
					rows[i][j] = "" + campList.get(i).getUser_people();
				} else if (j == 4) {
					rows[i][j] = "" + campList.get(i).getCamp_date_in();
				} else if (j == 5) {
					rows[i][j] = "" + campList.get(i).getCamp_date_out();
				}
			}
		}
		
		table_1 = new JTable(rows, cols);
		scrollPane.setViewportView(table_1);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setBackground(Color.WHITE);
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBounds(12, 307, 256, 50);
		contentPane.add(panel_2_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uACC4\uC88C \uC794\uACE0 :");
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(12, 10, 232, 30);
		panel_2_2_1.add(lblNewLabel_2_1);
		
		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setBackground(Color.WHITE);
		panel_1_1_2_1.setLayout(null);
		panel_1_1_2_1.setBounds(280, 307, 292, 50);
		contentPane.add(panel_1_1_2_1);
		
		JLabel lbl_account = new JLabel((String) null);
		lbl_account.setBackground(Color.WHITE);
		lbl_account.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_account.setBounds(12, 10, 268, 30);
		panel_1_1_2_1.add(lbl_account);
		
		lbl_ID.setText(ud.getUID);
		lbl_name.setText(ud.getUname);
		lbl_phone.setText(ud.getUphone);
		lbl_account.setText(ud.getUaccount + "");
	}
}