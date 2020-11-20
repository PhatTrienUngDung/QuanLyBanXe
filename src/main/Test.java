package main;

import java.time.LocalDate;

import javax.swing.JFrame;

import ui.Menu;
import ui.SplashScreen;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		SplashScreen slScreen= new SplashScreen();
		slScreen.setVisible(true);
		slScreen.setLocationRelativeTo(null);
		
		Menu m= new Menu();
		for (int i = 0; i < 101; i++) {
			Thread.sleep(60);
			slScreen.lbLoad.setText("Đang tải "+Integer.toString(i)+"%");
			slScreen.progressBar.setValue(i);
			  
			if(i==100) {
				slScreen.setVisible(false);
				m.setVisible(true);
				m.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		}
	}
}
