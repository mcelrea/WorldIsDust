package mickey.com.Sprite;

import mickey.com.Map.Area;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class VirtualSpaceAnimatedSprite extends AnimatedUnit{

	private float virtualX;
	private float virtualY;

	public VirtualSpaceAnimatedSprite(Image image, int r) {
		super(image, r);
		// TODO Auto-generated constructor stub
	}

	public VirtualSpaceAnimatedSprite(Image image, int r, float x, float y)
	{
		super(image, r);
		virtualX = x;
		virtualY = y;
		this.x = x;
		this.y = y;
	}

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

	public void moveDown(Area map, int delta, GameContainer gc)
	{
		virtualY += delta*speed;

		//check to see if the character has reached the end of the map on the right side
		if (virtualY > (map.getMap().getHeight()*map.getMap().getTileHeight()) - gc.getHeight()/2)
		{
			y += delta*speed;
			map.y = -(map.getMap().getHeight()*map.getMap().getTileHeight() - gc.getHeight());
		}
		//if the character is not int he middle of the screen
		else if(y < gc.getHeight()/2 - 32)
		{
			y += delta*speed;
		}
		//otherwise just move the map, player is in the middle and has not reached the end
		//of the screen
		else
		{
			map.y -= delta*speed;
		}

		//x += speed * delta;
		direction = DOWN;
	}

	public void moveDownRight(Area map, int delta, GameContainer gc)
	{
		virtualY += delta*speed/2;

		//check to see if the character has reached the end of the map on the right side
		if (virtualY > (map.getMap().getHeight()*map.getMap().getTileHeight()) - gc.getHeight()/2)
		{
			y += delta*speed/2;
			map.y = -(map.getMap().getHeight()*map.getMap().getTileHeight() - gc.getHeight());
		}
		//if the character is not int he middle of the screen
		else if(y < gc.getHeight()/2 - 32)
		{
			y += delta*speed/2;
		}
		//otherwise just move the map, player is in the middle and has not reached the end
		//of the screen
		else
		{
			map.y -= delta*speed/2;
		}
		
		virtualX += delta*speed/2;

		//check to see if the character has reached the end of the map on the right side
		if (virtualX > (map.getMap().getWidth()*map.getMap().getTileWidth()) - gc.getWidth()/2)
		{
			x += delta*speed/2;
			map.x = -(map.getMap().getWidth()*map.getMap().getTileWidth() - gc.getWidth());
		}
		//if the character is not int he middle of the screen
		else if(x < gc.getWidth()/2 - 32)
		{
			x += delta*speed/2;
		}
		//otherwise just move the map, player is in the middle and has not reached the end
		//of the screen
		else
		{
			map.x -= delta*speed/2;
		}

		direction = DOWNRIGHT;
	}

	public void moveDownLeft(Area map, int delta, GameContainer gc)
	{
		virtualY += delta*speed/2;

		//check to see if the character has reached the end of the map on the right side
		if (virtualY > (map.getMap().getHeight()*map.getMap().getTileHeight()) - gc.getHeight()/2)
		{
			y += delta*speed/2;
			map.y = -(map.getMap().getHeight()*map.getMap().getTileHeight() - gc.getHeight());
		}
		//if the character is not int he middle of the screen
		else if(y < gc.getHeight()/2 - 32)
		{
			y += delta*speed/2;
		}
		//otherwise just move the map, player is in the middle and has not reached the end
		//of the screen
		else
		{
			map.y -= delta*speed/2;
		}
		
		virtualX -= delta*speed/2;

		if(virtualX < gc.getWidth()/2)
		{
			x -= delta*speed/2;
			map.x = 0;
		}
		else if(x > gc.getWidth()/2 - 32)
		{
			x -= delta*speed/2;
		}
		else
		{
			map.x += delta*speed/2;
		}
		
		direction = DOWNLEFT;
	}

	public void moveUpRight(Area map, int delta, GameContainer gc)
	{
		virtualY -= delta*speed/2;

		if(virtualY < gc.getHeight()/2)
		{
			y -= delta*speed/2;
			map.y = 0;
		}
		else if(y > gc.getHeight()/2 - 32)
		{
			y -= delta*speed/2;
		}
		else
		{
			map.y += delta*speed/2;
		}
		
		virtualX += delta*speed/2;

		//check to see if the character has reached the end of the map on the right side
		if (virtualX > (map.getMap().getWidth()*map.getMap().getTileWidth()) - gc.getWidth()/2)
		{
			x += delta*speed/2;
			map.x = -(map.getMap().getWidth()*map.getMap().getTileWidth() - gc.getWidth());
		}
		//if the character is not int he middle of the screen
		else if(x < gc.getWidth()/2 - 32)
		{
			x += delta*speed/2;
		}
		//otherwise just move the map, player is in the middle and has not reached the end
		//of the screen
		else
		{
			map.x -= delta*speed/2;
		}
		
		direction = UPRIGHT;
	}

	public void moveUpLeft(Area map, int delta, GameContainer gc)
	{
		virtualY -= delta*speed/2;

		if(virtualY < gc.getHeight()/2)
		{
			y -= delta*speed/2;
			map.y = 0;
		}
		else if(y > gc.getHeight()/2 - 32)
		{
			y -= delta*speed/2;
		}
		else
		{
			map.y += delta*speed/2;
		}
		
		virtualX -= delta*speed/2;

		if(virtualX < gc.getWidth()/2)
		{
			x -= delta*speed/2;
			map.x = 0;
		}
		else if(x > gc.getWidth()/2 - 32)
		{
			x -= delta*speed/2;
		}
		else
		{
			map.x += delta*speed/2;
		}
		
		direction = UPLEFT;
	}

	public void moveUp(Area map, int delta, GameContainer gc)
	{
		virtualY -= delta*speed;

		if(virtualY < gc.getHeight()/2)
		{
			y -= delta*speed;
			map.y = 0;
		}
		else if(y > gc.getHeight()/2 - 32)
		{
			y -= delta*speed;
		}
		else
		{
			map.y += delta*speed;
		}

		direction = UP;
	}

	public void moveLeft(Area map, int delta, GameContainer gc)
	{
		virtualX -= delta*speed;

		if(virtualX < gc.getWidth()/2)
		{
			x -= delta*speed;
			map.x = 0;
		}
		else if(x > gc.getWidth()/2 - 32)
		{
			x -= delta*speed;
		}
		else
		{
			map.x += delta*speed;
		}

		direction = LEFT;
	}

	public void moveRight(Area map, int delta, GameContainer gc)
	{
		virtualX += delta*speed;

		//check to see if the character has reached the end of the map on the right side
		if (virtualX > (map.getMap().getWidth()*map.getMap().getTileWidth()) - gc.getWidth()/2)
		{
			x += delta*speed;
			map.x = -(map.getMap().getWidth()*map.getMap().getTileWidth() - gc.getWidth());
		}
		//if the character is not int he middle of the screen
		else if(x < gc.getWidth()/2 - 32)
		{
			x += delta*speed;
		}
		//otherwise just move the map, player is in the middle and has not reached the end
		//of the screen
		else
		{
			map.x -= delta*speed;
		}

		//x += speed * delta;
		direction = RIGHT;
	}
}
