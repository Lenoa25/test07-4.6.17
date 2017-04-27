package com.company.Lesson05;

/**
 * Created by hackeru on 2/13/2017.
 */
public class Point {
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public  boolean isRight(Point point){
        return this.x<point.x;
    }
    public  boolean isLeft(Point point){
        return this.x>point.x;
    }
    public  boolean isUnder(Point point){
        return this.y<point.y;
    }
    public  boolean isAbove(Point point){
        return this.y>point.y;
    }

    @Override
    public boolean equals(Object obj) {
        Point p= (Point) obj;
        return this.x  ==p.x&&this.y==p.y;
    }
//    public double distance(Point point){
//return 3/7;
//    }

}
