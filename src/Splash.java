import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;




// Splash Screen

public class Splash {
	public static void main(String args[]) {
		showSplash(1000);

		LScreen login = new LScreen();
		login.setSize(410, 270);
		login.setResizable(false);
		login.setVisible(true);
	}

	public static void showSplash(int duration) {
		JWindow splash = new JWindow();
		JPanel content = (JPanel) splash.getContentPane();

		int width = 520;
		int height = 225;

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		splash.setBounds(x, y, width, height);

		JLabel pic = new JLabel(new ImageIcon("logo.jpg"));
		JLabel name = new JLabel("  WELCOME TO MULTI CLIENT CHAT SYSTEM  ");
		JLabel name_ = new JLabel("  Loading.......  ");
		
		content.add(pic, BorderLayout.CENTER);
		content.add(name, BorderLayout.PAGE_START);
		content.add(name_, BorderLayout.PAGE_END);
		
		

		splash.setVisible(true);
		try {
			Thread.sleep(duration);

		} catch (Exception e) {
		}
		splash.setVisible(false);

	}
}
//*/ **********************************************************************************************
