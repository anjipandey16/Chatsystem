import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

// ChatScreen

class ChatScreen extends JFrame implements ActionListener {

	private JPanel Button_Panel;
	private JPanel Message_Panel;
	private JPanel User_Online_Panel;
	private JPanel All_Message_Panel;
	private JPanel User_Panel;
	private JPanel Title_Panel;
	private JButton View_Button;
	private JButton Logout_Button;
	private JPanel Main_Panel;
	private JButton Clear_Button;
	private JButton Send_Button;
	private JScrollPane User_Online_ScrollPane;
	private JScrollPane Message_TextArea_ScrollPane;
	private JScrollPane All_Message_TextArea_ScrollPane;
	private JTextArea Message_TextArea;
	private JTextArea All_Message_TextArea;
	private JList Online_User_List;
	private DefaultListModel model;
	private JLabel User_Name_Label;
	private JLabel Title_Label;
	private String jlognam;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String request;

	public ChatScreen(String lognam) {
		initComponents(lognam);

	}

	private void initComponents(String lognam) {

		jlognam = lognam;
		Main_Panel = new JPanel();
		Title_Panel = new JPanel();
		Title_Label = new JLabel();
		User_Panel = new JPanel();
		User_Name_Label = new JLabel();
		All_Message_Panel = new JPanel();
		All_Message_TextArea_ScrollPane = new JScrollPane();
		All_Message_TextArea = new JTextArea();
		User_Online_Panel = new JPanel();

		Message_Panel = new JPanel();
		Message_TextArea_ScrollPane = new JScrollPane();
		User_Online_ScrollPane = new JScrollPane();
		Message_TextArea = new JTextArea();
		Button_Panel = new JPanel();
		Send_Button = new JButton();
		Clear_Button = new JButton();
		Logout_Button = new JButton();
		View_Button = new JButton();
		model = new DefaultListModel();
		Online_User_List = new JList(model);

		getContentPane().setLayout(null);

		setTitle("Intranet Chat Screen");
		setIconImage(getIconImage());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/records", "root", "");
					Statement stmt = conn.createStatement();

					String str_1 = "select login from online_user ";

					ResultSet rs = stmt.executeQuery(str_1);
					if (rs.next()) {

						String user = rs.getString("login");
						System.out.print(user + "\t");
						String str_ = " Delete from online_user where login='"
								+ user + "'";
						stmt.executeUpdate(str_);
						stmt.close();
					}
					rs.close();
					conn.close();
				}

				catch (Exception e1) {
					e1.printStackTrace();
				}

				
				exitForm(evt);
			}
		});

		Main_Panel.setLayout(null);

		Main_Panel.setBorder(new EtchedBorder(null, Color.darkGray));
		Main_Panel.setToolTipText("Local Intranet Chat System");
		Title_Panel.setLayout(null);

		Title_Panel.setBorder(new EtchedBorder(null, Color.darkGray));
		Title_Panel.setToolTipText("Local Intranet Chat System");
		Title_Label.setFont(new Font("Times New Roman", 1, 36));
		Title_Label.setForeground(new Color(201, 0, 0));
		Title_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Title_Label.setText("Welcome To Local Intranet Chat System");
		Title_Label.setToolTipText("Local Intranet Chat System");
		Title_Panel.add(Title_Label);
		Title_Label.setBounds(20, 20, 720, 50);

		Main_Panel.add(Title_Panel);
		Title_Panel.setBounds(10, 10, 760, 90);

		User_Panel.setLayout(null);

		User_Panel.setBorder(new EtchedBorder(null, Color.darkGray));
		User_Panel.setToolTipText("Local Intranet Chat System");
		User_Name_Label.setFont(new Font("Times New Roman", 1, 14));
		User_Name_Label.setForeground(new Color(102, 0, 102));
		User_Name_Label.setHorizontalAlignment(SwingConstants.LEFT);
		User_Name_Label.setText("User Name :" + lognam);
		User_Panel.add(User_Name_Label);
		User_Name_Label.setBounds(10, 10, 280, 17);

		All_Message_Panel.setLayout(null);

		All_Message_Panel.setBorder(new TitledBorder(new EtchedBorder(null,
				Color.darkGray), "Messages",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", 1,
						14), new Color(102, 0, 102)));
		All_Message_TextArea.setLineWrap(true);
		All_Message_TextArea
				.setToolTipText("Messages Send by You and Others Users Online");
		All_Message_TextArea.setBorder(new BevelBorder(BevelBorder.LOWERED,
				null, null, null, Color.darkGray));
		All_Message_TextArea.setEditable(false);
		All_Message_TextArea.setFont(new Font("Dialog", 1, 12));
		All_Message_TextArea_ScrollPane.setViewportView(All_Message_TextArea);

		All_Message_Panel.add(All_Message_TextArea_ScrollPane);
		All_Message_TextArea_ScrollPane.setBounds(13, 20, 540, 200);

		User_Panel.add(All_Message_Panel);
		All_Message_Panel.setBounds(10, 30, 560, 230);

		User_Online_Panel.setLayout(null);
		User_Online_Panel.setBorder(new TitledBorder(new EtchedBorder(null,
				Color.darkGray), "User Online",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", 1,
						14), new Color(102, 0, 102)));
		User_Online_Panel.setToolTipText("Local Intranet Chat System");

		User_Online_Panel.add(User_Online_ScrollPane);
		User_Online_ScrollPane.setBounds(13, 20, 145, 200);

		Online_User_List.setBorder(new BevelBorder(BevelBorder.LOWERED));
		Online_User_List.setToolTipText("List Of Online Users");
		Online_User_List.setMinimumSize(new Dimension(1, 10));
		User_Online_Panel.add(Online_User_List);
		Online_User_List.setBounds(70, 60, 0, 0);
		User_Panel.add(User_Online_Panel);
		User_Online_Panel.setBounds(580, 30, 170, 230);

		Message_Panel.setLayout(null);
		Message_Panel.setBorder(new TitledBorder(new EtchedBorder(null,
				Color.darkGray), "Write Message",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", 1,
						14), new Color(102, 0, 102)));
		Message_Panel.setToolTipText("Local Intranet Chat System");
		Message_TextArea.setLineWrap(true);
		Message_TextArea.setToolTipText("Write Messasge to Send");
		Message_TextArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, Color.darkGray));
		Message_TextArea_ScrollPane.setViewportView(Message_TextArea);

		Message_Panel.add(Message_TextArea_ScrollPane);
		Message_TextArea_ScrollPane.setBounds(10, 20, 720, 40);

		User_Panel.add(Message_Panel);
		Message_Panel.setBounds(10, 260, 740, 70);

		Button_Panel.setLayout(null);

		Button_Panel.setBorder(new EtchedBorder(null, Color.darkGray));
		Button_Panel.setToolTipText("Local Intranet Chat System");

		View_Button.setFont(new Font("Times New Roman", 1, 14));
		View_Button.setForeground(new Color(0, 0, 201));
		View_Button.setMnemonic('V');
		View_Button.setText("View OnLine Users");
		View_Button.setToolTipText("View Online Users");
		View_Button.setBorder(new BevelBorder(BevelBorder.RAISED));
		Button_Panel.add(View_Button);
		View_Button.setBounds(550, 10, 150, 30);
		View_Button.addActionListener(this);

		Send_Button.setFont(new Font("Times New Roman", 1, 14));
		Send_Button.setForeground(new Color(0, 0, 201));
		Send_Button.setMnemonic('S');
		Send_Button.setText("Send");
		Send_Button.setToolTipText("Send The Message");
		Send_Button.setBorder(new BevelBorder(BevelBorder.RAISED));
		Button_Panel.add(Send_Button);
		Send_Button.setBounds(40, 10, 150, 30);
		Send_Button.addActionListener(this);

		Clear_Button.setFont(new Font("Times New Roman", 1, 14));
		Clear_Button.setForeground(new Color(0, 0, 201));
		Clear_Button.setMnemonic('C');
		Clear_Button.setText("Clear");
		Clear_Button.setToolTipText("Clear The Message");
		Clear_Button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, Color.darkGray));
		Button_Panel.add(Clear_Button);
		Clear_Button.setBounds(210, 10, 150, 30);
		Clear_Button.addActionListener(this);

		Logout_Button.setFont(new Font("Times New Roman", 1, 14));
		Logout_Button.setForeground(new Color(0, 0, 201));
		Logout_Button.setMnemonic('L');
		Logout_Button.setText("Logout");
		Logout_Button.setToolTipText("Close The Application");
		Logout_Button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, Color.darkGray));
		Button_Panel.add(Logout_Button);
		Logout_Button.setBounds(380, 10, 150, 30);
		Logout_Button.addActionListener(this);

		User_Panel.add(Button_Panel);
		Button_Panel.setBounds(10, 340, 740, 50);

		Main_Panel.add(User_Panel);
		User_Panel.setBounds(10, 110, 760, 410);

		getContentPane().add(Main_Panel);
		Main_Panel.setBounds(10, 10, 780, 530);

		pack();

		try {
			socket = new Socket(InetAddress.getLocalHost(), 8001);
			out = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			request = ("Login#" + (String) jlognam);
			out.println(request);

			out.flush();
			All_Message_TextArea.setEditable(true);
			All_Message_TextArea.append(in.readLine() + "\n");
			All_Message_TextArea.setEditable(false);

			out.flush();
			out.close();
			in.close();
			socket.close();
		} catch (IOException i1) {
			i1.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Send_Button) {
			try {
				socket = new Socket(InetAddress.getByName("anji-lappy"), 8001);
				out = new PrintWriter(new OutputStreamWriter(
						socket.getOutputStream()));
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));

				request = (jlognam + " Say : " + (String) Message_TextArea
						.getText());
				out.println(request);
				out.flush();

				All_Message_TextArea.setEditable(true);

				String msg = in.readLine();
				StringTokenizer st = new StringTokenizer(msg, "#");
				All_Message_TextArea.setText("");
				while (st.hasMoreTokens()) {
					String displ = st.nextToken();
					All_Message_TextArea.append(displ + "\n");
				}
				All_Message_TextArea.setEditable(false);
				out.flush();
				in.close();
				out.close();
				socket.close();
			} catch (IOException i2) {
				i2.printStackTrace();
			}

		} else if (ae.getSource() == Clear_Button) {
			Message_TextArea.setText("");
		} else if (ae.getSource() == View_Button) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/records", "root", "");
				Statement stmt = conn.createStatement();

				String str_ = "Select login from online_user ";
				model.clear();
				ResultSet rs = stmt.executeQuery(str_);
				while (rs.next()) {
				String user =rs.getString("login");
					if(!user.equals(jlognam)){
					model.addElement(rs.getString("login"));
				}
					User_Online_ScrollPane.setViewportView(Online_User_List);
				}

				conn.close();
			}

			catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (ae.getSource() == Logout_Button) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/records", "root", "");
				Statement stmt = conn.createStatement();

				String str_1 = "select login from online_user ";

				ResultSet rs = stmt.executeQuery(str_1);
				if (rs.next()) {

					String user = rs.getString("login");
					System.out.print(user + "\t");
					String str_ = " Delete from online_user where login='"
							+ user + "'";
					stmt.executeUpdate(str_);
					stmt.close();
				}
				rs.close();
				conn.close();
			}

			catch (Exception e1) {
				e1.printStackTrace();
			}
			this.dispose();

			LScreen login = new LScreen();
			login.setSize(410, 270);
			login.setResizable(false);
			login.setVisible(true);

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
