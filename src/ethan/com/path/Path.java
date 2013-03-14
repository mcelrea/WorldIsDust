package ethan.com.path;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import mickey.com.Sprite.Location;

public class Path {
	ArrayList<WayPoint> path;

	public Path(ArrayList<WayPoint> pat){
		this.path = pat;
	}

	public Path(){
		path = new ArrayList<WayPoint>();
	}

	public void addWayPoint(Location loc){
		path.add(new WayPoint(loc));
	}

	public void removeWayPoint(WayPoint way){
		path.remove(way);
	}

	public void debugPath(Graphics g){

		for(int i = 0; i< path.size(); i++){
			float x = path.get(i).getWaypoint().getX();
			float y = path.get(i).getWaypoint().getY();
			g.fillRect(x, y, 16, 16);
		
		}

		for(int i = 0; i< path.size(); i++){

			if(i+1<path.size()){
				float x1 = path.get(i).getWaypoint().getX();
				float y1 = path.get(i).getWaypoint().getY();
				
				float x2 = path.get(i+1).getWaypoint().getX();
				float y2 = path.get(i+1).getWaypoint().getY();
				
				g.drawLine(x1+8, y1+8, x2+8, y2+8);
			}

		}
	}
	
	public int getNumberOfWayPoints(){
		return path.size();
	}

	public Location getLocationFromPath(int x){
		return path.get(x).getWaypoint();
	}
	
	public float getX(int n){
	  return getLocationFromPath(n).getX();
	}
	public float getY(int n){
		  return getLocationFromPath(n).getY();
		}
}
