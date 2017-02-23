import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

//class Loginscreen

class LScreen extends JFrame implements ActionListener {

	private JPasswordField PasswordField;
	private JPanel Button_Panel;
	private JPanel Login_Panel;
	private JButton Exit_Button;
	private JPanel Title_Panel;
	private JButton Reset_Button;
	private JPanel Main_LoginPanel;
	private JButton Login_Button;
	private JButton New_User_Button;
	private JTextField Username_TextField;
	private JLabel Password_Label;
	private JLabel Login_Screen_Label;
	private JLabel Title_Label;
	Connection conn;
	Statement stmt;
	ResultSet rs;

	public LScreen() {
		initComponents();
	}

	private void initComponents() {
		Main_LoginPanel = new JPanel();
		Title_Panel = new JPanel();
		Title_Label = new JLabel();
		Login_Panel = new JPanel();
		Login_Screen_Label = new JLabel();
		Username_TextField = new JTextField();
		Password_Label = new JLabel();
		PasswordField = new JPasswordField();
		Button_Panel = new JPanel();
		New_User_Button = new JButton();
		Login_Button = new JButton();
		Reset_Button = new JButton();
		Exit_Button = new JButton();

		getContentPane().setLayout(null);

		setTitle("Chat Login");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});

		Main_LoginPanel.setLayout(null);

		Main_LoginPanel.setBorder(new EtchedBorder(null, Color.darkGray));
		Main_LoginPanel.setToolTipText("Chat Login Screen");
		Title_Panel.setLayout(null);

		Title_Panel.setBorder(new EtchedBorder(null, Color.darkGray));
		Title_Panel.setToolTipText("Chat Login Screen");
		Title_Label.setFont(new Font("Times New Roman", 1, 18));
		Title_Label.setForeground(new Color(204, 0, 0));
		Title_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Title_Label.setText("Welcome To Local Intranet Chat System");
		Title_Label.setToolTipText("Chat Login Screen");
		Title_Panel.add(Title_Label);
		Title_Label.setBounds(10, 10, 340, 30);

		Main_LoginPanel.add(Title_Panel);
		Title_Panel.setBounds(10, 10, 360, 50);

		Login_Panel.setLayout(null);

		Login_Panel.setBorder(new TitledBorder(new EtchedBorder(null,
				Color.darkGray), "Login", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", 1,
						14), new Color(0, 0, 0)));
		Login_Panel.setForeground(new Color(0, 0, 51));
		Login_Panel.setToolTipText("Chat Login Screen");
		Login_Screen_Label.setFont(new Font("Times New Roman", 1, 14));
		Login_Screen_Label.setForeground(new Color(0, 0, 102));
		Login_Screen_Label.setText("Login Id");
		Login_Panel.add(Login_Screen_Label);
		Login_Screen_Label.setBounds(20, 30, 90, 17);

		Username_TextField.setFont(new Font("Times New Roman", 1, 14));
		Username_TextField.setToolTipText("Enter Your Login Id Name");
		Username_TextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, Color.darkGray));
		Login_Panel.add(Username_TextField);
		Username_TextField.setBounds(110, 30, 220, 21);

		Password_Label.setFont(new Font("Times New Roman", 1, 14));
		Password_Label.setForeground(new Color(0, 0, 102));
		Password_Label.setText("Password");
		Login_Panel.add(Password_Label);
		Password_Label.setBounds(20, 60, 70, 17);

		PasswordField.setFont(new Font("Times New Roman", 1, 18));
		PasswordField.setToolTipText("Enter Your Password");
		PasswordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, Color.darkGray));
		Login_Panel.add(PasswordField);
		PasswordField.setBounds(110, 60, 220, 20);

		Main_LoginPanel.add(Login_Panel);
		Login_Panel.setBounds(10, 60, 360, 100);

		Button_Panel.setLayout(null);

		Button_Panel.setBorder(new EtchedBorder(null, Color.darkGray));
		Button_Panel.setToolTipText("Chat Login Screen");
		New_User_Button.setFont(new Font("Times New Roman", 1, 12));
		New_User_Button.setForeground(new Color(0, 0, 102));
		New_User_Button.setMnemonic('N');
		New_User_Button.setText("New User");
		New_User_Button
				.setToolTipText("Click This Button For The New registration");
		New_User_Button.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		Button_Panel.add(New_User_Button);
		New_User_Button.setBounds(10, 10, 70, 30);
		New_User_Button.addActionListener(this);

		Login_Button.setFont(new Font("Times New Roman", 1, 12));
		Login_Button.setForeground(new Color(0, 0, 102));
		Login_Button.setMnemonic('L');
		Login_Button.setText("Login");
		Login_Button
				.setToolTipText("Click This Button To Login Into Chat System");
		Login_Button.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		Button_Panel.add(Login_Button);
		Login_Button.setBounds(100, 10, 70, 30);
		Login_Button.addActionListener(this);

		Reset_Button.setFont(new Font("Times New Roman", 1, 12));
		Reset_Button.setForeground(new Color(0, 0, 102));
		Reset_Button.setMnemonic('R');
		Reset_Button.setText("Reset");
		Reset_Button
				.setToolTipText("Click This Button To Clear All The Entries");
		Reset_Button.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		Button_Panel.add(Reset_Button);
		Reset_Button.setBounds(190, 10, 70, 30);
		Reset_Button.addActionListener(this);

		Exit_Button.setFont(new Font("Times New Roman", 1, 12));
		Exit_Button.setForeground(new Color(0, 0, 102));
		Exit_Button.setMnemonic('x');
		Exit_Button.setText("Exit");
		Exit_Button
				.setToolTipText("Click This Button To Close The Application");
		Exit_Button.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		Button_Panel.add(Exit_Button);
		Exit_Button.setBounds(280, 10, 70, 30);
		Exit_Button.addActionListener(this);

		Main_LoginPanel.add(Button_Panel);
		Button_Panel.setBounds(10, 160, 360, 50);

		getContentPane().add(Main_LoginPanel);
		Main_LoginPanel.setBounds(10, 10, 380, 220);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/records", "root", "");
			stmt = conn.createStatement();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		pack();

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == New_User_Button) {
			Registration regfrm = new Registration();
			this.dispose();
			regfrm.setSize(600, 400);
			regfrm.setResizable(false);
			regfrm.setVisible(true);
		} else if (ae.getSource() == Login_Button) {
			if (!(Username_TextField.getText().equals("") || PasswordField
					.getText().equals(""))) {
				String str = "select * from master where (Login='"
						+ (String) Username_TextField.getText()
						+ "' and password='" + (String) PasswordField.getText()
						+ "')";

				String str_ = "insert into online_user values('"
						+ Username_TextField.getText() + "')";

				try {

					rs = stmt.executeQuery(str);

					if (rs.next()) {
						stmt.executeUpdate(str_);
						ChatScreen chfrm = new ChatScreen(
								Username_TextField.getText());
						this.dispose();
						chfrm.setSize(800, 600);
						chfrm.setResizable(false);
						chfrm.setVisible(true);

					}

					else {
						JOptionPane.showMessageDialog(null,
								"Invalid User ID Or Password....");
						Username_TextField.setText("");
						PasswordField.setText("");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Invalid User Or Password....");
				Username_TextField.setText("");
				PasswordField.setText("");

			}

		}

		else if (ae.getSource() == Reset_Button) {

			Username_TextField.setText("");
			PasswordField.setText("");
		} else if (ae.getSource() == Exit_Button) {
			JOptionPane.showMessageDialog(null, "  Panel is Closing.......  ");
			System.exit(0);
		}
	}

	private void exitForm(WindowEvent evt) {
		JOptionPane.showMessageDialog(null, " Panal is Closeing.......  ");
		System.exit(0);
	}

}

// **********************************************************************************************

