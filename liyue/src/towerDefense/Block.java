package towerDefense;

import java.awt.*;


public class Block extends Rectangle {
	public int groundID;
	public int airID ;
	
	public Block(int x, int y, int width, int height, int groundID ,int airID){
		setBounds(x,y,width,height);
		this.groundID = groundID;
		this.airID = airID ;
	}

	public void draw(Graphics g)
	{
		System.out.println(groundID);
		//print out the groundID

			//System.out.println(groundID);
			g.drawImage(Screen.tileset_ground[groundID],x,y,width,height,null);//
			//g.drawImage(Screen.tileset_air[airID],x,y,width,height,null);
			
			//g.drawImage(Screen.tileset_ground[1],x,y,width,height,null);


		
		if(airID != Value.airAir)
		{
			g.drawImage(Screen.tileset_air[airID],x,y,width,height,null);
			System.out.println(airID);//执行了 但是 没有打印出来？
			
		}
	}
}
