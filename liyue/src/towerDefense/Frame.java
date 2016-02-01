package towerDefense;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
	public static String title="Tower";
	public static Dimension size = new Dimension(700 ,550);
	
	public Frame(){
		setTitle(title);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
	}
	
	public void init(){
		setLayout(new GridLayout(1,1,0,0));
		
		Screen screen = new Screen();
		add(screen);
		
		setVisible(true);
	}
	
	public static void main(String args[]){
	
		int a =2;
		Frame frame = new Frame();
		
		
//		Thread thread = new Thread(Screen);  

//		thread.start();

	}//main
	
}
