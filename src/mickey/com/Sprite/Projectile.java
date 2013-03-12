package mickey.com.Sprite;

import org.newdawn.slick.Image;

public class Projectile extends Sprite{

	private String owner;
	
	public Projectile(Image image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	

}
