package ethan.com.Camera;

import mickey.com.Dust.GamePlayBetterCamera;
import mickey.com.Dust.TheWorldIsDust;
import mickey.com.Sprite.Location;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

public class Camera {
	private Rectangle viewPort;
	private Location minBoundingBox;
	private Location maxBoundingBox;
	
	public Camera(Location loc){
		viewPort = new Rectangle(loc.getX(),loc.getY(),TheWorldIsDust.app.getWidth(),TheWorldIsDust.app.getHeight());
	}
	
	public void setMaxBoundingBox(float x, float y){
		maxBoundingBox = new Location(x,y);
	}
	
	public void setMinBoundingBox(float x, float y){
		minBoundingBox = new Location(x,y);
	}
	
	private boolean isWithinBounds(Location loc){
		if(minBoundingBox != null && maxBoundingBox != null){
			if(minBoundingBox.getX()<loc.getX()&&minBoundingBox.getY()<loc.getY()){
				if(maxBoundingBox.getX()<loc.getX()&&maxBoundingBox.getY()<loc.getY()){
					return true;
				}
				return false;
			}
			return false;
		}
		return true;
	}
	
	
	
	
	public void drawCamera(Graphics g){
		
		g.translate(-viewPort.getX(), -viewPort.getY());
	}
	
	public void CameraMove(Location loc){
			
		
			viewPort.setX(loc.getX()-(TheWorldIsDust.app.getWidth()/2)+GamePlayBetterCamera.player.getWidth());
			viewPort.setY(loc.getY()-(TheWorldIsDust.app.getHeight()/2)+GamePlayBetterCamera.player.getHeight());
		
			if(viewPort.getX()<minBoundingBox.getX()){
				viewPort.setX(minBoundingBox.getX());
			}
			
			if(viewPort.getY()<minBoundingBox.getY()){
				viewPort.setY(minBoundingBox.getY());
			}
			
			if(viewPort.getX()>maxBoundingBox.getX()){
				viewPort.setX(maxBoundingBox.getX());
			}
			
			if(viewPort.getY()>maxBoundingBox.getY()){
				viewPort.setY(maxBoundingBox.getY());
			}
	}
}
