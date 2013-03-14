package ethan.com.Enemies;

import mickey.com.Sprite.Location;

import org.newdawn.slick.Image;


import ethan.com.path.Path;

public class PathedEnemy extends Enemy{
	Path pat;
	boolean foward;
	int wayPointNum =0;
	
	
	public PathedEnemy(Image image, int r,Path pat1) {
		super(image, r);
		this.pat = pat1;
		setLocation(new Location(300,300));
		this.foward = true;
	}
	

	@Override
	public void act(int delta){
		followPath(delta);
		System.out.println("WayPointNum"  + this.wayPointNum);
	}
	
	public void followPath(int delta){
		if(wayPointNum < pat.getNumberOfWayPoints()-1&&foward){
			
			float deltaX = pat.getX(wayPointNum+1)-getLocation().getX();
			float deltaY = pat.getY(wayPointNum+1)-getLocation().getY();
			
			
			
			if(deltaX>0 && deltaY == 0){
				moveRight(delta);
			}
			else if(deltaX<0 && deltaY == 0){
				moveLeft(delta);
			}
			else if(deltaY>0&& deltaX == 0){
				moveDown(delta);
			}
			else if(deltaY<0 && deltaX == 0){
				moveUp(delta);
			}//diagonals
			else if(deltaX<0&&deltaY<0){
				moveUpLeft(delta);
			}
			else if(deltaX>0&&deltaY<0){
				moveUpRight(delta);
			}
			else if(deltaX>0&&deltaY>0){
				moveDownRight(delta);
			}
			else if(deltaX>0&&deltaY>0){
				moveDownLeft(delta);
			}
			
			
			System.out.println(pat.getNumberOfWayPoints()-1);
			if(Math.abs(deltaX)<5&&Math.abs(deltaY)<5){
				setX(pat.getX(wayPointNum+1));
				setY(pat.getY(wayPointNum+1));
				wayPointNum++;
				
				if(wayPointNum == pat.getNumberOfWayPoints()-1){
					foward = false;
				}
			}
		}
		
		else{
			
			float deltaX = pat.getX(wayPointNum-1)-getLocation().getX();
			float deltaY = pat.getY(wayPointNum-1)-getLocation().getY();
			
			if(deltaX>0 && deltaY == 0){
				moveRight(delta);
			}
			else if(deltaX<0 && deltaY == 0){
				moveLeft(delta);
			}
			else if(deltaY>0&& deltaX == 0){
				moveDown(delta);
			}
			else if(deltaY<0 && deltaX == 0){
				moveUp(delta);
			}//diagonals
			else if(deltaX<0&&deltaY<0){
				moveUpLeft(delta);
			}
			else if(deltaX>0&&deltaY<0){
				moveUpRight(delta);
			}
			else if(deltaX>0&&deltaY>0){
				moveDownRight(delta);
			}
			else if(deltaX>0&&deltaY>0){
				moveDownLeft(delta);
			}
			
			if(Math.abs(deltaX)<5&&Math.abs(deltaY)<5){
				setX(pat.getX(wayPointNum-1));
				setY(pat.getY(wayPointNum-1));
				wayPointNum--;
				
				if(wayPointNum == 0){
					foward = true;
				}
			}
		}
		
	}
}
