package mickey.com.Sprite;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Sprite {
	
	public static int UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4, DOWNRIGHT = 5, DOWNLEFT = 6, UPRIGHT = 7, UPLEFT = 8;

	protected Image image;
	protected float x, y;
	protected boolean alive;
	protected float speed;
	protected float turnSpeed;
	protected float xvel, yvel;
	protected float angle;
	protected int direction;
	
	public Sprite(Image image)
	{
		this.image = image;
	}
	
	public Sprite(Image image, float x, float y)
	{
		this.image = image;
		this.x = x;
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public Location getLocation(){
		return new Location(x,y);
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public double getXvel() {
		return xvel;
	}

	public void setXvel(float xvel) {
		this.xvel = xvel;
	}

	public float getYvel() {
		return yvel;
	}

	public void setYvel(float yvel) {
		this.yvel = yvel;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
	

	public float getTurnSpeed() {
		return turnSpeed;
	}

	public void setTurnSpeed(float turnSpeed) {
		this.turnSpeed = turnSpeed;
	}

	@Override
	public String toString() {
		return "Sprite [image=" + image + ", x=" + x + ", y=" + y + ", alive="
				+ alive + ", speed=" + speed + ", xvel=" + xvel + ", yvel="
				+ yvel + ", angle=" + angle + "]";
	}
	
	public void draw(Graphics g)
	{
		image.setRotation(angle);
		g.drawImage(image, x, y);
	}
	
	public void moveDown(int delta)
	{
		y += speed * delta;
		direction = DOWN;
	}
	
	public void moveDownRight(int delta)
	{
		y += speed/2 * delta;
		x += speed/2 * delta;
		direction = DOWNRIGHT;
	}
	
	public void moveDownLeft(int delta)
	{
		y += speed/2 * delta;
		x -= speed/2 * delta;
		direction = DOWNLEFT;
	}
	
	public void moveUpRight(int delta)
	{
		y -= speed/2 * delta;
		x += speed/2 * delta;
		direction = UPRIGHT;
	}
	
	public void moveUpLeft(int delta)
	{
		y -= speed/2 * delta;
		x -= speed/2 * delta;
		direction = UPLEFT;
	}
	
	public void moveUp(int delta)
	{
		y -= speed * delta;
		direction = UP;
	}
	
	public void moveLeft(int delta)
	{
		x -= speed * delta;
		direction = LEFT;
	}
	
	public void moveRight(int delta)
	{
		x += speed * delta;
		direction = RIGHT;
	}
	
	public float moveXByAngle(float angle)
    {
        return (float)Math.cos(Math.toRadians(angle));
    }

    public double moveYByAngle(float angle)
    {
        return (float)Math.sin(Math.toRadians(angle));
    }
	
    public void turnLeft(int delta)
    {
    	angle -= turnSpeed * delta;
    }
    
    public void turnRight(int delta)
    {
    	angle += turnSpeed * delta;
    }
    
	public void moveForward(int delta)
	{
		x += moveXByAngle(angle)*delta*speed;
		y += moveYByAngle(angle)*delta*speed;
	}
}
