package com.company;

class Ball {
    private double x = 0.0;
    private double y = 0.0;

    Ball (double x, double y) {
        this.x = x;
        this.y = y;
    }
    Ball() {}
    private double getX() {
        return x;
    }
    private double getY() {
        return y;
    }
    private void setX (double x) {
        this.x = x;
    }
    private void setY (double y) {
        this.y = y;
    }
    private void setXY (double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void move (double xDisp, double yDisp) {
        this.x +=xDisp;
        this.y +=yDisp;
    }
    @Override
    public String toString() {
        return "Ball on ("+getX()+";"+getY()+")";
    }
}

public class TestBall {

    public static void main(String[] args) {
	    Ball ball = new Ball(5.0, 3.2);
	    System.out.print(ball.toString()+"\n");
	    ball.move(-2.7, 0.15);
	    System.out.print(ball.toString());
    }
}
