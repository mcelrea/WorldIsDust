package mickey.com.Map;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.tiled.TiledMap;


public class Area {

	TiledMap map;
	public float x, y;
	private boolean debug;
	
	public Area (TiledMap map)
	{
		this.map = map;
	}
	
	public void draw(Graphics g)
	{
		map.render((int)x,(int)y);
		if(debug)
		{
			g.drawString("map loc: (" + x + "," + y + ")", 500, 0);
			g.drawString("" + (map.getWidth() * map.getTileWidth()), 500, 15);
		}
	}

	public TiledMap getMap() {
		return map;
	}

	public void setMap(TiledMap map) {
		this.map = map;
	}
	
	
}
