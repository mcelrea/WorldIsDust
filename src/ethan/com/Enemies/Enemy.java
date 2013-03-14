package ethan.com.Enemies;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import ethan.com.path.Path;

import mickey.com.Sprite.AnimatedUnit;

public class Enemy extends AnimatedUnit{
	
	private int baseArmor;
	private int baseAttack;
	private int baseAccuracy;
	private int health;
	
	public Enemy(Image image, int r) {
		super(image, r);
		// TODO Auto-generated constructor stub
	}
	
	public float damageOutput(){
		return 0f;
	}
	
	public void HealthBar(Graphics g){
		
	}
	
	public void takeDamage(float damage){
		
	}
	
	public void act(int delta){
		
	}
	
}
