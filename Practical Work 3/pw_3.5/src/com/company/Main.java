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

class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    MovableRectangle (int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft = new MovablePoint(x1,y1,xSpeed,ySpeed);
        bottomRight =new MovablePoint(x2,y2,xSpeed,ySpeed);
        if (!check()) {
            bottomRight.xSpeed = topLeft.xSpeed;
            bottomRight.ySpeed = topLeft.ySpeed;
        }
    }
    @Override
    public String toString() {
        return "MovableRectangle{ topLeft=" + topLeft + ", bottomRight=" + bottomRight +'}';
    }
    @Override
    public void moveUp() {
        topLeft.y++;
        bottomRight.y++;
    }
    @Override
    public void moveDown() {
        topLeft.y--;
        bottomRight.y--;
    }
    @Override
    public void moveLeft() {
        topLeft.x--;
        bottomRight.x--;
    }
    @Override
    public void moveRight() {
        topLeft.x++;
        bottomRight.x++;
    }
    boolean check() {
        if (topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed) return true;
        else return false;
    }
}

public class Main {

    public static void main(String[] args) {
    MovableRectangle rect = new MovableRectangle(2,5,10,0,2,3);
    System.out.print(rect.toString() +"\n");
    rect.moveLeft();
    rect.moveLeft();
    rect.moveUp();
    System.out.print(rect.toString());
    }
}
