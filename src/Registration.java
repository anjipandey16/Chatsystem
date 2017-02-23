import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

// class Registration

class Registration extends JFrame implements ActionListener {

	private JPasswordField Re_PasswordField;
	private JPasswordField Password_TextField;
	private JPanel Note_Panel;
	private JPanel Button_Panel;
	private JPanel Registration_Form_Panel;
	private JPanel Title_Panel;
	private JButton Continue_Button;
	private JPanel Main_Panel;
	private JButton Clear_Button;
	private JButton Submit_Button;
	private JComboBox Desigination_ComboBox;
	private JComboBox Department_ComboBox;
	private JLabel Note3_Label;
	private JLabel Star4_Label;
	private JTextField Login_Id_TextField;
	private JLabel Note2_1_Label;
	private JTextField Last_Name_TextField;
	private JLabel Note2_Label;
	private JLabel Star2_Label;
	private JTextField Middle_Name_TextField;
	private JLabel Note1_1_Label;
	private JLabel Star1_Label;
	private JTextField First_Name_TextField;
	private JLabel Note1_Label;
	private JLabel Re_Password_Label;
	private JLabel Password_Label_2nd;
	private JLabel Password_Label;
	private JLabel Desigination_Label;
	private JLabel Login_Id_Label;
	private JLabel Department_Label;
	private JLabel Last_Name_Label;
	private JLabel Star3_Label;
	private JLabel Middle_Name_Label;
	private JLabel First_Name_;
	private JLabel Title_Label;
	Connection conn;
	Statement stmt;
	ResultSet rs;

	public Registration() {
		initComponents();
	}

	private void initComponents() {
		Main_Panel = new JPanel();
		Title_Panel = new JPanel();
		Title_Label = new JLabel();
		Registration_Form_Panel = new JPanel();
		First_Name_ = new JLabel();
		First_Name_TextField = new JTextField();
		Middle_Name_Label = new JLabel();
		Middle_Name_TextField = new JTextField();
		Last_Name_Label = new JLabel();
		Last_Name_TextField = new JTextField();
		Login_Id_Label = new JLabel();
		Login_Id_TextField = new JTextField();
		Password_Label = new JLabel();
		Password_TextField = new JPasswordField();
		Re_Password_Label = new JLabel();
		Re_PasswordField = new JPasswordField();
		Star1_Label = new JLabel();
		Star2_Label = new JLabel();
		Star3_Label = new JLabel();
		Department_Label = new JLabel();
		Department_ComboBox = new JComboBox();
		Desigination_Label = new JLabel();
		Desigination_ComboBox = new JComboBox();
		Button_Panel = new JPanel();
		Submit_Button = new JButton();
		Clear_Button = new JButton();
		Continue_Button = new JButton();
		Password_Label_2nd = new JLabel();
		Note_Panel = new JPanel();
		Note1_Label = new JLabel();
		Note1_1_Label = new JLabel();
		Note2_Label = new JLabel();
		Note3_Label = new JLabel();
		Note2_1_Label = new JLabel();
		Star4_Label = new JLabel();
		Note3_Label = new JLabel();

		getContentPane().setLayout(null);

		setTitle("Registration Form");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});

		Main_Panel.setLayout(null);

		Main_Panel.setBorder(new EtchedBorder(null, Color.darkGray));
		Main_Panel.setToolTipText("Registration Form");
		Title_Panel.setBorder(new EtchedBorder(null, Color.darkGray));
		Title_Panel.setToolTipText("Registration Form");
		Title_Label.setFont(new Font("Times New Roman", 1, 24));
		Title_Label.setForeground(new Color(201, 0, 0));
		Title_Label.setText("  Welcome to Local Intranet Chat System  ");
		Title_Panel.add(Title_Label);

		Main_Panel.add(Title_Panel);
		Title_Panel.setBounds(15, 7, 550, 40);

		Registration_Form_Panel.setLayout(null);

		Registration_Form_Panel.setBorder(new TitledBorder(new EtchedBorder(
				null, Color.darkGray), "Registration Form",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", 1,
						14)));
		Registration_Form_Panel.setToolTipText("Registration Form");
		First_Name_.setFont(new Font("Times New Roman", 1, 14));
		First_Name_.setForeground(new Color(0, 0, 204));
		First_Name_.setText("First Name");
		Registration_Form_Panel.add(First_Name_);
		First_Name_.setBounds(10, 30, 70, 17);

		First_Name_TextField.setFont(new Font("Times New Roman", 1, 14));
		First_Name_TextField.setToolTipText("Enter First Name");
		First_Name_TextField.setBorder(new BevelBorder(BevelBorder.LOWERED,
				null, null, null, Color.darkGray));
		Registration_Form_Panel.add(First_Name_TextField);
		First_Name_TextField.setBounds(100, 30, 200, 20);

		Middle_Name_Label.setFont(new Font("Times New Roman", 1, 14));
		Middle_Name_Label.setForeground(new Color(0, 0, 201));
		Middle_Name_Label.setText("Middle Name");
		Registration_Form_Panel.add(Middle_Name_Label);
		Middle_Name_Label.setBounds(10, 60, 80, 17);

		Middle_Name_TextField.setFont(new Font("Times New Roman", 1, 14));
		Middle_Name_TextField.setToolTipText("Enter Middle Name");
		Middle_Name_TextField.setBorder(new BevelBorder(BevelBorder.LOWERED,
				null, null, null, Color.darkGray));
		Registration_Form_Panel.add(Middle_Name_TextField);
		Middle_Name_TextField.setBounds(100, 60, 200, 21);

		Last_Name_Label.setFont(new Font("Trebuchet MS", 1, 14));
		Last_Name_Label.setForeground(new Color(0, 0, 201));
		Last_Name_Label.setText("Last Name");
		Registration_Form_Panel.add(Last_Name_Label);
		Last_Name_Label.setBounds(10, 90, 70, 18);

		Last_Name_TextField.setFont(new Font("Times New Roman", 1, 14));
		Last_Name_TextField.setToolTipText("Enter Last Name");
		Last_Name_TextField.setBorder(new BevelBorder(BevelBorder.LOWERED,
				null, null, null, Color.darkGray));
		Registration_Form_Panel.add(Last_Name_TextField);
		Last_Name_TextField.setBounds(100, 90, 200, 21);

		Login_Id_Label.setFont(new Font("Trebuchet MS", 1, 14));
		Login_Id_Label.setForeground(new Color(0, 0, 201));
		Login_Id_Label.setText("Login ID");
		Registration_Form_Panel.add(Login_Id_Label);
		Login_Id_Label.setBounds(10, 120, 70, 18);

		Login_Id_TextField.setFont(new Font("Times New Roman", 1, 14));
		Login_Id_TextField.setToolTipText("Enter Login ID");
		Login_Id_TextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, Color.darkGray));
		Registration_Form_Panel.add(Login_Id_TextField);
		Login_Id_TextField.setBounds(100, 120, 200, 21);

		Password_Label.setFont(new Font("Times New Roman", 1, 14));
		Password_Label.setForeground(new Color(0, 0, 201));
		Password_Label.setText("Password");
		Registration_Form_Panel.add(Password_Label);
		Password_Label.setBounds(10, 150, 70, 17);

		Password_TextField.setFont(new Font("Times New Roman", 1, 18));
		Password_TextField.setToolTipText("Enter Password");
		Password_TextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, Color.darkGray));
		Registration_Form_Panel.add(Password_TextField);
		Password_TextField.setBounds(100, 150, 200, 20);

		Re_Password_Label.setFont(new Font("Times New Roman", 1, 14));
		Re_Password_Label.setForeground(new Color(0, 0, 201));
		Re_Password_Label.setText("Re Enter ");
		Registration_Form_Panel.add(Re_Password_Label);
		Re_Password_Label.setBounds(10, 180, 80, 17);

		Re_PasswordField.setFont(new Font("Times New Roman", 1, 18));
		Re_PasswordField.setToolTipText("Re Enter Password");
		Re_PasswordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, Color.darkGray));
		Registration_Form_Panel.add(Re_PasswordField);
		Re_PasswordField.setBounds(100, 180, 200, 20);

		Star1_Label.setFont(new Font("Dialog", 1, 24));
		Star1_Label.setForeground(new Color(255, 0, 0));
		Star1_Label.setText("*");
		Registration_Form_Panel.add(Star1_Label);
		Star1_Label.setBounds(300, 120, 10, 20);

		Star2_Label.setFont(new Font("Dialog", 1, 24));
		Star2_Label.setForeground(new Color(255, 0, 0));
		Star2_Label.setText("*");
		Registration_Form_Panel.add(Star2_Label);
		Star2_Label.setBounds(300, 180, 10, 20);

		Star3_Label.setFont(new Font("Dialog", 1, 24));
		Star3_Label.setForeground(new Color(255, 0, 0));
		Star3_Label.setText("*");
		Registration_Form_Panel.add(Star3_Label);
		Star3_Label.setBounds(300, 150, 10, 20);

		Department_Label.setFont(new Font("Times New Roman", 1, 14));
		Department_Label.setForeground(new Color(0, 0, 201));
		Department_Label.setText("Department");
		Registration_Form_Panel.add(Department_Label);
		Department_Label.setBounds(10, 230, 80, 17);

		Department_ComboBox.setFont(new Font("Times New Roman", 1, 14));
		Department_ComboBox.setToolTipText("Select The Departmanet Name");
		Department_ComboBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
		Registration_Form_Panel.add(Department_ComboBox);
		Department_ComboBox.setBounds(100, 220, 200, 30);

		Desigination_Label.setFont(new Font("Times New Roman", 1, 14));
		Desigination_Label.setForeground(new Color(0, 0, 201));
		Desigination_Label.setText("Desigination");
		Registration_Form_Panel.add(Desigination_Label);
		Desigination_Label.setBounds(10, 260, 80, 17);

		Desigination_ComboBox.setFont(new Font("Times New Roman", 1, 14));
		Desigination_ComboBox.setToolTipText("Select Your Desigination");
		Desigination_ComboBox.setBorder(new BevelBorder(BevelBorder.LOWERED));
		Registration_Form_Panel.add(Desigination_ComboBox);
		Desigination_ComboBox.setBounds(100, 260, 200, 30);

		Button_Panel.setLayout(null);

		Button_Panel.setBorder(new EtchedBorder(null, Color.darkGray));
		Button_Panel.setToolTipText("Registration Form");
		Submit_Button.setFont(new Font("Times New Roman", 1, 14));
		Submit_Button.setForeground(new Color(0, 0, 201));
		Submit_Button.setMnemonic('S');
		Submit_Button.setText("Submit");
		Submit_Button.setToolTipText("Click Here To Register Your Self");
		Submit_Button.setBorder(new BevelBorder(BevelBorder.RAISED));
		Button_Panel.add(Submit_Button);
		Submit_Button.setBounds(10, 10, 60, 50);
		Submit_Button.addActionListener(this);

		Clear_Button.setFont(new Font("Times New Roman", 1, 14));
		Clear_Button.setForeground(new Color(0, 0, 201));
		Clear_Button.setMnemonic('C');
		Clear_Button.setText("Clear");
		Clear_Button.setToolTipText("Clear All The Entries");
		Clear_Button.setBorder(new BevelBorder(BevelBorder.RAISED));
		Button_Panel.add(Clear_Button);
		Clear_Button.setBounds(80, 10, 70, 50);
		Clear_Button.addActionListener(this);

		Continue_Button.setFont(new Font("Times New Roman", 1, 14));
		Continue_Button.setForeground(new Color(0, 0, 201));
		Continue_Button.setMnemonic('x');
		Continue_Button.setText("Continue");
		Continue_Button.setToolTipText("Close The Application");
		Continue_Button.setBorder(new BevelBorder(BevelBorder.RAISED));
		Button_Panel.add(Continue_Button);
		Continue_Button.setBounds(160, 10, 70, 50);
		Continue_Button.addActionListener(this);

		Registration_Form_Panel.add(Button_Panel);
		Button_Panel.setBounds(310, 220, 240, 70);

		Password_Label_2nd.setFont(new Font("Times New Roman", 1, 14));
		Password_Label_2nd.setForeground(new Color(0, 0, 201));
		Password_Label_2nd.setText("  Password");
		Registration_Form_Panel.add(Password_Label_2nd);
		Password_Label_2nd.setBounds(0, 200, 70, 17);

		Note_Panel.setLayout(null);

		Note_Panel.setBorder(new TitledBorder(new EtchedBorder(null,
				Color.darkGray), "Note", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", 1,
						14), new Color(0, 0, 0)));
		Note_Panel.setToolTipText("Registration Form");
		Note1_Label.setFont(new Font("Times New Roman", 1, 14));
		Note1_Label.setForeground(new Color(150, 0, 0));
		Note1_Label.setText("1. All The Entries Must Be");
		Note_Panel.add(Note1_Label);
		Note1_Label.setBounds(10, 30, 220, 17);

		Note1_1_Label.setFont(new Font("Times New Roman", 1, 14));
		Note1_1_Label.setForeground(new Color(150, 0, 0));
		Note1_1_Label.setText("    Completed");
		Note_Panel.add(Note1_1_Label);
		Note1_1_Label.setBounds(10, 50, 210, 17);

		Note2_Label.setFont(new Font("Times New Roman", 1, 14));
		Note2_Label.setForeground(new Color(150, 0, 0));
		Note2_Label.setText("2. Entries Mark With \"  \" Must Be");
		Note_Panel.add(Note2_Label);
		Note2_Label.setBounds(10, 80, 220, 17);

		Note2_1_Label.setFont(new Font("Times New Roman", 1, 14));
		Note2_1_Label.setForeground(new Color(150, 0, 0));
		Note2_1_Label.setText("   Written In SMALL Characters");
		Note_Panel.add(Note2_1_Label);
		Note2_1_Label.setBounds(10, 100, 210, 17);

		Star4_Label.setFont(new Font("Times New Roman", 1, 18));
		Star4_Label.setForeground(new Color(255, 0, 0));
		Star4_Label.setText("*");
		Note_Panel.add(Star4_Label);
		Star4_Label.setBounds(150, 80, 10, 22);

		Note3_Label.setFont(new Font("Times New Roman", 1, 14));
		Note3_Label.setForeground(new Color(150, 0, 0));
		Note3_Label.setText("3. No Blank Entries will be Accepted");
		Note_Panel.add(Note3_Label);
		Note3_Label.setBounds(10, 130, 230, 17);

		Registration_Form_Panel.add(Note_Panel);
		Note_Panel.setBounds(310, 20, 240, 190);

		Main_Panel.add(Registration_Form_Panel);
		Registration_Form_Panel.setBounds(10, 50, 560, 300);

		getContentPane().add(Main_Panel);
		Main_Panel.setBounds(10, 10, 580, 360);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/records", "root", "");
			stmt = conn.createStatement();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			rs = stmt.executeQuery("Select desigination from desigination ");
			while (rs.next())
				Desigination_ComboBox.addItem(rs.getString("desigination"));

			rs = stmt.executeQuery("Select department from department ");
			while (rs.next())
				Department_ComboBox.addItem(rs.getString("department"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		pack();
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Submit_Button) {
			if (First_Name_TextField.getText().equals("")
					|| Last_Name_TextField.getText().equals("")
					|| Login_Id_TextField.getText().equals("")
					|| Password_TextField.getText().equals("")
					|| Re_PasswordField.getText().equals(""))
				JOptionPane.showMessageDialog(null,
						"Some Fields are Left Empty...");
			else if (Password_TextField.getText()
					.equals(Re_PasswordField.getText())) {
				String sTr = "Select * from master Where(Login='"
						+ (String) Login_Id_TextField.getText() + "')";

				try {
					rs = stmt.executeQuery(sTr);
					if (!rs.next()) {
						if (!Login_Id_TextField.getText().equals(""))
							Login_Id_TextField.setText(Login_Id_TextField.getText());

						String sQl = "insert into master values('"
								+ First_Name_TextField.getText() + "','"
								+ Middle_Name_TextField.getText() + "','"
								+ Last_Name_TextField.getText() + "','"
								+ Login_Id_TextField.getText() + "','"
								+ Password_TextField.getText() + "','"
								+ Department_ComboBox.getSelectedItem() + "','"
								+ Desigination_ComboBox.getSelectedItem()
								+ "')";
						stmt.executeUpdate(sQl);
						JOptionPane.showMessageDialog(null,
								"Data Has Been Saved....");
					} else {
						JOptionPane.showMessageDialog(null,
								"Login Exist . Please Enter New Login ....");
					}

				} catch (Exception e3) {
					e3.printStackTrace();
				}
			} else {
				JOptionPane
						.showMessageDialog(null,
								"Passward Do Not Match. Both The Password Must Be Same....");
				Password_TextField.setText("");
				Re_PasswordField.setText("");
			}

		} else if (ae.getSource() == Clear_Button) {

			First_Name_TextField.setText("");
			Middle_Name_TextField.setText("");
			Last_Name_TextField.setText("");
			Login_Id_TextField.setText("");
			Password_TextField.setText("");
			Re_PasswordField.setText("");

		} else if (ae.getSource() == Continue_Button) {
			if(!Login_Id_TextField.getText().equals("")){
				String sTr = "Select * from master Where(Login='"
						+ (String) Login_Id_TextField.getText() + "')";
				
				String str_ = "insert into online_user values('"
						+ Login_Id_TextField.getText() + "')";

				try {
					rs = stmt.executeQuery(sTr);
					if (rs.next()) {	
						
						stmt.executeUpdate(str_);
			
			ChatScreen chfrm = new ChatScreen(Login_Id_TextField.getText());
			this.dispose();

			chfrm.setSize(800, 600);
			chfrm.setResizable(false);
			chfrm.setVisible(true);
					}
				}
					catch (Exception e4) {
						e4.printStackTrace();
					}

			}
			else{JOptionPane
				.showMessageDialog(null,
						"Enter Your Login Id Please....  ");}
		}
	}

	private void exitForm(WindowEvent evt) {
		this.dispose();

		LScreen login = new LScreen();
		login.setSize(410, 270);
		login.setResizable(false);
		login.setVisible(true);
	}
}

// **********************************************************************************************
