package mickey.com.Sprite;

import java.util.ArrayList;
import java.util.Random;

import mickey.com.Map.Area;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;


public class VirtualAnimatedEnemy extends VirtualSpaceAnimatedSprite {

	Random rand = new Random();
	
	public VirtualAnimatedEnemy(Image image, int r) {
		super(image, r);
		// TODO Auto-generated constructor stub
	}
	
	public VirtualAnimatedEnemy(Image image, int r, float x, float y)
	{
		super(image, r, x, y);
	}
	
	public void act(Area map, int delta, GameContainer gc)
	{
		int choice = 1 + rand.nextInt(8);
		
		if(choice == 1)
			moveUp(map, delta, gc);
		else if (choice == 2)
			moveDown(map, delta, gc);
		else if (choice == 3)
			moveLeft(map, delta, gc);
		else if (choice == 4)
			moveRight(map, delta, gc);
		else if (choice == 5)
			moveDownLeft(map, delta, gc);
		else if (choice == 6)
			moveDownRight(map, delta, gc);
		else if (choice == 7)
			moveUpRight(map, delta, gc);
		else
			moveUpLeft(map, delta, gc);
	}
	
	public void moveDown(Area map, int delta, GameContainer gc)
	{
		y += delta*speed;

		//x += speed * delta;
		direction = DOWN;
	}

	public void moveDownRight(Area map, int delta, GameContainer gc)
	{
		y += delta*speed/2;
		x += delta*speed/2;

		direction = DOWNRIGHT;
	}

	public void moveDownLeft(Area map, int delta, GameContainer gc)
	{
		y += delta*speed/2;
		x -= delta*speed/2;

		direction = DOWNLEFT;
	}

	public void moveUpRight(Area map, int delta, GameContainer gc)
	{
		y -= delta*speed/2;	
		x += delta*speed/2;

		
		direction = UPRIGHT;
	}

	public void moveUpLeft(Area map, int delta, GameContainer gc)
	{
		y -= delta*speed/2;
		
		direction = UPLEFT;
	}

	public void moveUp(Area map, int delta, GameContainer gc)
	{
		y -= delta*speed;

		direction = UP;
	}

	public void moveLeft(Area map, int delta, GameContainer gc)
	{
		x -= delta*speed;

		direction = LEFT;
	}

	public void moveRight(Area map, int delta, GameContainer gc)
	{
		x += delta*speed;

		direction = RIGHT;
	}

}
