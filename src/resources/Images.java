package resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Images {
	private static Image fogTile;
	private static Image grass;
	
	public static Image fog() throws SlickException{
		if(fogTile == null){
			fogTile = new Image("images/MapElements/fogTile.png");
		}
		return fogTile;
	}
	
	public static Image grass() throws SlickException{
		if(grass == null){
			grass = new Image("images/Plants/grass.png");
		}
		return grass;
	}
	
}
