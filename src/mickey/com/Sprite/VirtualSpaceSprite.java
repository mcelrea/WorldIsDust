package mickey.com.Sprite;

import mickey.com.Map.Area;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;


public class VirtualSpaceSprite extends Sprite{
	
	private float virtualX;
	private float virtualY;
	private boolean debug;

	public VirtualSpaceSprite(Image image) {
		super(image);
		// TODO Auto-generated constructor stub
	}
	
	public VirtualSpaceSprite(Image image, float x, float y)
	{
		super(image, x, y);
		virtualX = x;
		virtualY = y;
	}
	
	/*
	 * works on 360 degrees.  I need to write one that is 8-way directional.
	 */
	public void moveForward(Area map, GameContainer gc, StateBasedGame sb, int delta)
	{
		virtualX += moveXByAngle(angle)*delta*speed;
		virtualY += moveYByAngle(angle)*delta*speed;
		
		if(virtualX < gc.getWidth()/2)
		{
			x += moveXByAngle(angle)*delta*speed;
			map.x = 0;
		}
		//3000 - SCREEN_WIDTH/2 is the equation for the end of the map on the right
		else if (virtualX > (map.getMap().getWidth()*map.getMap().getTileWidth()) - gc.getWidth()/2)
		{
			x += moveXByAngle(angle)*delta*speed;
			map.x = -(map.getMap().getWidth()*map.getMap().getTileWidth() - gc.getWidth());
		}
		else
		{
			map.x -= moveXByAngle(angle)*delta*speed;
		}
		
		if(virtualY < gc.getHeight()/2)
		{
			y += moveYByAngle(angle)*delta*speed;
			map.y = 0;
		}
		else if (virtualY > (map.getMap().getHeight()*map.getMap().getTileWidth()) - gc.getHeight()/2)
		{
			y += moveYByAngle(angle)*delta*speed;
			map.y = -(map.getMap().getHeight()*map.getMap().getTileHeight() - gc.getHeight());
		}
		else
		{
			map.y -= moveYByAngle(angle)*delta*speed;
		}
		
	}

	public void draw(Graphics g)
	{
		image.setRotation(angle);
		g.drawImage(image, x, y);
		
		if(debug)
		{
			g.drawString("screen loc: (" + x + "," + y + ")", 200, 0);
			g.drawString("virtual loc: (" + virtualX + "," + virtualY + ")", 200, 15);
		}
	}
}
