package resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Images {
	private static Image fogTile;
	
	public static Image fog() throws SlickException{
		if(fogTile == null){
			fogTile = new Image("images/MapElements/fogTile.png");
		}
		return fogTile;
	}
}
