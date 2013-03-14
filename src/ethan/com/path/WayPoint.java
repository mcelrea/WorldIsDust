package ethan.com.path;

import mickey.com.Sprite.Location;

public class WayPoint {
	private Location waypoint;
	
	public WayPoint(Location loc){
		this.waypoint = loc;
	}
	
	public WayPoint(float x, float y){
		this.waypoint = new Location(x,y);
	}

	public Location getWaypoint() {
		return waypoint;
	}

	public void setWaypoint(Location waypoint) {
		this.waypoint = waypoint;
	}
	
	
}
