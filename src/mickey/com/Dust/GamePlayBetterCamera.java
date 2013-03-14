package mickey.com.Dust;

import mickey.com.Map.Area;
import mickey.com.Sprite.AnimatedUnit;
import mickey.com.Sprite.Location;
import mickey.com.Sprite.Projectile;
import mickey.com.Sprite.Sprite;
import mickey.com.Sprite.VirtualAnimatedEnemy;
import mickey.com.Sprite.VirtualSpaceAnimatedSprite;
import mickey.com.Sprite.VirtualSpaceSprite;

import java.io.File;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;

import ethan.com.Camera.Camera;
import ethan.com.Enemies.PathedEnemy;
import ethan.com.FogOfWar.FogOfWar;
import ethan.com.path.Path;
import ethan.com.path.WayPoint;

public class GamePlayBetterCamera extends BasicGameState{

	int stateID = -1;
	public static AnimatedUnit player;
	
	ParticleSystem part;
	ParticleSystem part2;
	Rectangle viewPort = new Rectangle(0,0,800,600);
	Area testArea;
	Camera camera;
	FogOfWar fog;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	PathedEnemy enmy;
	ArrayList<WayPoint> ldfs;
	Path path;
	
	public GamePlayBetterCamera(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		// TODO Auto-generated method stub
		initPlayer(gc, sb);
		camera = new Camera(player.getLocation());
		testArea = new Area(new TiledMap("data/testArea2.tmx"));
		camera.setMinBoundingBox(0, 0);
		camera.setMaxBoundingBox(testArea.getMap().getWidth()*testArea.getMap().getTileWidth()-gc.getWidth(), testArea.getMap().getHeight()*testArea.getMap().getTileHeight()-gc.getHeight());
		fog = new FogOfWar(camera.getMinBoundingBox(),camera.getMaxBoundingBox());
		ldfs = new ArrayList<WayPoint>();
		ldfs.add(new WayPoint(300,300));
		ldfs.add(new WayPoint(500,300));
		ldfs.add(new WayPoint(500,600));
		ldfs.add(new WayPoint(700,600));
		ldfs.add(new WayPoint(900,800));
		path = new Path(ldfs);
	}

	public void initPlayer(GameContainer gc, StateBasedGame sb)
			throws SlickException {
		// TODO Auto-generated method stub
		player = new AnimatedUnit(new Image("images/characterSpriteSheet.png"), 0);
		player.setSpeed(0.2f);
		
		enmy = new PathedEnemy(new Image("images/characterSpriteSheet.png"), 0,path);
		enmy.setSpeed(0.15f);
		//player.setX(gc.getWidth()/2 - 32);
		//player.setY(gc.getHeight()/2 - 32);
		
		//enemy = new VirtualAnimatedEnemy(new Image("images/characterSpriteSheet.png"), 0, gc.getWidth()/2 - 32, gc.getHeight()/2 - 32);
	   //enemy.setSpeed(0.2f);

		Image temp = new Image("images/particle.png", false);
		part = new ParticleSystem(temp, 1500);

		temp = new Image("images/particle2.png", false);
		part2 = new ParticleSystem(temp, 1500);

		try{
			File xmlFile = new File("data/test_emitter.xml");
			ConfigurableEmitter emitter = ParticleIO.loadEmitter(xmlFile);
			emitter.setPosition(20,600);
			part.addEmitter(emitter);

			xmlFile = new File("data/test_emitter2.xml");
			ConfigurableEmitter emitter2 = ParticleIO.loadEmitter(xmlFile);
			emitter2.setPosition(500,700);
			part2.addEmitter(emitter2);
		}
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}

		part.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
		part2.setBlendingMode(ParticleSystem.BLEND_COMBINE);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		camera.drawCamera(g);
		testArea.draw(g);
		//g.translate(-viewPort.getX(), -viewPort.getY());//Written by  Ethan
		g.setColor(new Color(44,155,26));
		//g.fillRect(0,0, gc.getWidth(), gc.getHeight());
		g.drawString("Gameplay better camera", 300, 10);
		
		renderProjectiles(gc, sb, g);
		
		player.draw(g);
		enmy.draw(g);
		//enemy.draw(g);
		part.render();
		part2.render();
		path.debugPath(g);//draws debugging path
		fog.drawFog(g, camera);
	}
	
	public void renderProjectiles(GameContainer gc, StateBasedGame sb, Graphics g)
			throws SlickException {
		
		for(Projectile p: projectiles)
		{
			p.draw(g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		Input input = gc.getInput();
		
		enmy.act(delta);
		enmy.update(delta);
		
		part.update(delta);
		part2.update(delta);
		//enemy.act(testArea, delta, gc);
		if(input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_D))
		{
			player.moveDownRight(delta);
			player.update(delta);
		}
		else if(input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_A))
		{
			player.moveDownLeft(delta);
			player.update(delta);
		}
		else if(input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_D))
		{
			player.moveUpRight(delta);
			player.update(delta);
		}
		else if(input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A))
		{
			player.moveUpLeft(delta);
			player.update(delta);
		}
		else if(input.isKeyDown(Input.KEY_S))
		{
			//viewPort.setY((float) (viewPort.getY()+(0.18*delta)));//written by Ethan
			//player.moveDown(delta);
			//player.moveForward(testArea, gc, sb, delta);
			player.moveDown(delta);
			player.update(delta);
		}
		else if(input.isKeyDown(Input.KEY_D))
		{
			//viewPort.setX((float) (viewPort.getX()+(0.18*delta)));//written by Ethan
			player.moveRight(delta);
			player.update(delta);
		}	
		else if(input.isKeyDown(Input.KEY_A))
		{
			//viewPort.setX((float) (viewPort.getX()-(0.18*delta)));//written by Ethan
			//player.moveLeft(delta);
			player.moveLeft(delta);
			player.update(delta);
		}
		else if(input.isKeyDown(Input.KEY_W))
		{
			//viewPort.setY((float) (viewPort.getY()-(0.18*delta)));//written by Ethan
			//player.moveUp(delta);
			player.moveUp(delta);
			player.update(delta);
		}
		
		if(input.isKeyPressed(Input.KEY_SPACE))
		{
			Projectile ar = new Projectile(new Image("images/arrow.png"));
			ar.setOwner("player");
			ar.setAlive(true);
			ar.setSpeed(0.5f);
			ar.setX(player.getX());
			ar.setY(player.getY());
			ar.setAngle(player.getDirection()*45-90);
			projectiles.add(ar);
		}
		
		updateProjectiles(gc, sb, delta);
		
		camera.CameraMove(player.getLocation());
		fog.removeFog(player);

		//exit the game
		if(input.isKeyPressed(Input.KEY_ESCAPE))
		{
			System.out.println("Game exited due to escape key.");
			System.exit(0);
		}
	}
	
	public void updateProjectiles(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		
		for(Projectile p: projectiles)
		{
			p.moveForward(delta);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
