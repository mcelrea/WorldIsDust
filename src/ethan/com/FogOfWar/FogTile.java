package ethan.com.FogOfWar;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ethan.com.Camera.Camera;

import resources.Images;

import mickey.com.Sprite.Location;

public class FogTile {
	private Location fogLoc;
	private Image tile;
	private boolean draw;
	
	public FogTile(Location loc) throws SlickException{
		this.fogLoc = loc;
		this.tile = Images.fog();
		this.draw = true;
	}

	public Location getFogLocation() {
		return fogLoc;
	}

	public void setFogLocation(Location fogLoc) {
		this.fogLoc = fogLoc;
	}

	public boolean willDraw() {
		return draw;
	}

	public void setDraw(boolean draw) {
		this.draw = draw;
	}	
	
	public Image getTile(){
		return this.tile;
	}
	
	public boolean isCollidingWithCamera(Camera cam){
		  float left1, left2;
          float right1, right2;
          float top1, top2;
          float bottom1, bottom2;

          left1 = fogLoc.getX();
          left2 = cam.getCameraX();
          right1 = fogLoc.getX() + tile.getWidth();
          right2 = cam.getCameraX() + cam.getCameraWidth();
          top1 = fogLoc.getY();
          top2 = cam.getCameraY();
          bottom1 = fogLoc.getY() + tile.getHeight();
          bottom2 = cam.getCameraY() + cam.getCameraHeight();

          if (bottom1 < top2) return false; //no collision
          if (top1 > bottom2) return false; //no collision

          if (right1 < left2) return false; //no collision
          if (left1 > right2) return false; //no collision

          return true; //YES, collision
	}
}
