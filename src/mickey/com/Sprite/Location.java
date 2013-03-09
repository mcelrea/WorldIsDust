package mickey.com.Sprite;

public class Location {
	
	private float x;
	private float y;
	
	public Location(float x, float y)
	{
		this.x = x;
		this.y = y;
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
	
	public float distance(Location loc){
		return (float) Math.sqrt((Math.pow((loc.getX() - x),2) + Math.pow((loc.getY() - y),2)));
	}

}
