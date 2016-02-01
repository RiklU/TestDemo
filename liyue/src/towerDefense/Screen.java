package towerDefense;

import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;

import javax.swing.*;

public class Screen extends JPanel implements Runnable{
	
	public Thread thread = new Thread(this);
	
	public static Image[] tileset_ground = new Image[100];
	public static Image[] tileset_air = new Image[100];
	
	public static int myWidth,myHeight;
	
	public static boolean isFirst = true;
	
	public static Room room;
	
	public static Save save;
	
	public Screen()
	{
		
		//setBackground(Color.black);
		thread.start();
	}
	
	public void define(){
		
		room = new Room();
		save = new Save();
		
		for(int i=0;i<tileset_ground.length;i++)
		{
			tileset_ground[i] = new ImageIcon("res/tileset_ground.png").getImage();//
			tileset_ground[i] =createImage(new FilteredImageSource(tileset_ground[i].getSource(),new CropImageFilter(0,26*i,26,26)));
		}
		
		for(int i=0;i<tileset_air.length;i++)
		{
			tileset_air[i] = new ImageIcon("res/tileset_air.png").getImage();
			tileset_air[i] =createImage(new FilteredImageSource(tileset_air[i].getSource(),new CropImageFilter(0,26*i,26,26)));
		}
		
		save.loadSave(new File("save/mission1.ulixava"));
		
	}

	public void  paintComponent(Graphics g)
	{
		if(isFirst){
			myWidth = getWidth();
			myHeight = getHeight();
			
			define();
			
			isFirst =false;
			
		}
		
		g.clearRect(0, 0, getWidth(), getHeight());//delete all the painting
		
		room.draw(g); //draw the room
	}
	
	public void run(){
		while(true){
		//System.out.println("Hello!");
			
		if(!isFirst){
				room.physic();
				
			}
				
			repaint();
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
		}//while
	}
	
}

