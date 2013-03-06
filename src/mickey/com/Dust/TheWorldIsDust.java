package mickey.com.Dust;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.AppletGameContainer;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class TheWorldIsDust extends StateBasedGame{
	
	//public static final int STARTMENU = 0;
	public static final int GAMEPLAY = 1;
	//public static final int PAUSEMENU = 2;
	//public static final int CHARACTERSELECT = 3;
	
	public TheWorldIsDust() throws SlickException {
		super("My Game Title");
		
		//this.addState(new StartMenu(STARTMENU));
		this.addState(new GamePlay(GAMEPLAY));
		//this.addState(new PauseMenu(PAUSEMENU));
		//this.addState(new CharacterSelect(CHARACTERSELECT));
	}
	
	public static void main(String args[]) throws SlickException
	{
		AppGameContainer app = new AppGameContainer(new TheWorldIsDust());//new ScalableGame(new Main(), 1280, 768));
		
		//set game window full screen in proper resolution
		int w = app.getScreenWidth();
		int h = app.getScreenHeight();
		app.setDisplayMode(w,h,true);
		//app.setDisplayMode(1280, 1024, false);
		
		app.start();
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		//this.getState(STARTMENU).init(gc, this);
		this.getState(GAMEPLAY).init(gc, this);
		//this.getState(PAUSEMENU).init(gc, this);
		//this.getState(CHARACTERSELECT).init(gc, this);
	}
}
