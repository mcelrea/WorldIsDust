package ethan.com.Forester;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import ethan.com.Camera.Camera;

import resources.Images;

import mickey.com.Sprite.AnimatedUnit;
import mickey.com.Sprite.Sprite;

public class Forester {
	private AnimatedUnit player;
	private ArrayList<Sprite> plants;
	private int grassDensity;
	private int ForestRadius;
	
	public Forester(AnimatedUnit player1, int grassD, int radius){
		this.player = player1;
		this.plants = new ArrayList<Sprite>();
		this.grassDensity = grassD;
		this.ForestRadius = radius;
	}
	
	public void populateForester() throws SlickException{
		Random rand = new Random();
		while(checkDensity()){
			int X = rand.nextInt(this.ForestRadius);
			int Y = rand.nextInt(this.ForestRadius);
			int makeNegative = rand.nextInt(4);
			
			if(makeNegative == 1){
				X *= -1;
			}
			if(makeNegative == 2){
				Y *= -1;
			}
			
			plants.add(new Sprite(Images.grass(),player.getX()+X,player.getY()+Y));
		}
	}
	
	public boolean checkDensity(){
		int numberOfGrassImages = 0;
		for(Sprite s: plants){
			float dist = s.getLocation().distance(player.getLocation());
			if(dist<this.ForestRadius){
				numberOfGrassImages++;
			}
		}
		
		if(numberOfGrassImages < this.grassDensity){
			return true;
		}
		return false;
	}
	
	public void drawForest(Graphics g, Camera cam){
		for(Sprite s : plants){
			if(s.isCollidingWithCamera(cam)){
				s.draw(g);
			}
		}
	}
}
