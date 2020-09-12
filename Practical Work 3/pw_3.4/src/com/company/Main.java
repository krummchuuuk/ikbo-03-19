package com.company;
import com.company.Movable.Movable;

class MovablePoint implements Movable {
    public int x;
    public int y;
    public int xSpeed;
    public int ySpeed;

    MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    @Override
    public String toString() {
        return "MovablePoint{ x=" + x +", y=" + y +", xSpeed=" + xSpeed +", ySpeed=" + ySpeed +'}';
    }
    @Override
    public void moveUp() {
        y += ySpeed;
    }
    @Override
    public void moveDown() {
        y -=ySpeed;
    }
    @Override
    public void moveLeft() {
        x-=xSpeed;
    }
    @Override
    public void moveRight() {
        x +=xSpeed;
    }
}

class MovableCircle implements Movable{
    private int radius;
    private MovablePoint center;

    MovableCircle( int x, int y, int xSpeed, int ySpeed, int radius) {
        center = new MovablePoint(x,y,xSpeed,ySpeed);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "MovableCircle{" + "radius=" + radius + ", center=" + center +'}';
    }
    @Override
    public void moveUp() {
        center.y += center.ySpeed;
    }
    @Override
    public void moveDown() {
        center.y -=center.ySpeed;
    }
    @Override
    public void moveLeft() {
        center.x-=center.xSpeed;
    }
    @Override
    public void moveRight() {
        center.x +=center.xSpeed;
    }
}

public class Main {

    public static void main(String[] args) {
	MovableCircle  circle = new MovableCircle(0,0,4,2,5);
	circle.moveDown();
	circle.moveLeft();
	circle.moveLeft();
	System.out.print(circle.toString());
    }
}
