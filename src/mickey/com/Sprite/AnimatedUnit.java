package mickey.com.Sprite;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class AnimatedUnit extends Sprite{

	Animation downAnim, leftAnim, rightAnim, upAnim, downRightAnim, downLeftAnim, upRightAnim, upLeftAnim;
	
	/*
	 * Precondition: down frames (0-4), left frames (4-7), right frames (8-11), up frames (12-15)
	 * Postcondition: loads the different animations, faces Sprite down
	 */
	public AnimatedUnit(Image image, int r) {
		super(image);
	
		SpriteSheet ss = new SpriteSheet(image, 64, 64);
		//arguments = sheet, start col, start row, end col, end row, duration, update
		downAnim = new Animation(ss, 0, r, 3, r, true, 150, false);
		leftAnim = new Animation(ss, 4, r, 7, r, true, 150, false);
		rightAnim = new Animation(ss, 8, r, 11, r, true, 150, false);
		upAnim = new Animation(ss, 12, r, 15, r, true, 150, false);
		downRightAnim = new Animation(ss, 16, r, 19, r, true, 150, false);
		downLeftAnim = new Animation(ss, 20, r, 23, r, true, 150, false);
		upRightAnim = new Animation(ss, 24, r, 27, r, true, 150, false);
		upLeftAnim = new Animation(ss, 28, r, 31, r, true, 150, false);
		
		direction = DOWN;
	}
	
	public float getHeight(){
		return downAnim.getHeight();
	}
	public float getWidth(){
		return downAnim.getHeight();
	}
	
	@Override
	public void draw(Graphics g)
	{
		if(direction == DOWN)
			downAnim.draw(x,y);
		if(direction == LEFT)
			leftAnim.draw(x,y);
		if(direction == RIGHT)
			rightAnim.draw(x,y);
		if(direction == UP)
			upAnim.draw(x,y);
		if(direction == DOWNRIGHT)
			downRightAnim.draw(x,y);
		if(direction == DOWNLEFT)
			downLeftAnim.draw(x,y);
		if(direction == UPRIGHT)
			upRightAnim.draw(x,y);
		if(direction == UPLEFT)
			upLeftAnim.draw(x,y);
	}
	
	
	
	public void update(int delta)
	{
		if(direction == DOWN)
			downAnim.update(delta);
		if(direction == LEFT)
			leftAnim.update(delta);
		if(direction == RIGHT)
			rightAnim.update(delta);
		if(direction == UP)
			upAnim.update(delta);
		if(direction == DOWNRIGHT)
			downRightAnim.update(delta);
		if(direction == DOWNLEFT)
			downLeftAnim.update(delta);
		if(direction == UPRIGHT)
			upRightAnim.update(delta);
		if(direction == UPLEFT)
			upLeftAnim.update(delta);
	}
	
	
	
	public void startAnimation()
	{
		downAnim.start();
		leftAnim.start();
		rightAnim.start();
		upAnim.start();
	}
	
	public void stopAnimation()
	{
		downAnim.stop();
		leftAnim.stop();
		rightAnim.stop();
		upAnim.stop();
	}

	public void setDirection(int dir)
	{
		direction = dir;
	}
}
