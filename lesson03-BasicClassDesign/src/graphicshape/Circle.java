package graphicshape;

import graphicshape.Shape;

/**
 * Created by hackeru on 2/5/2017.
 */
public class Circle extends Shape{
   int x,y;
   private int radius;
//קונסטרקטור מפורש
    public Circle(int x,int y,int radius)
    {
        if(x>=0)
        this.x=x;
        if(y>=0)
        this.y=y;
        if(radius>=0)
        this.radius=radius;
    }
    public Circle(int radius)
    {//קריאה לקונסטרקטור חייבת להיות השורה הראשונה -רק אחריו אפשר להוסיף עוד שורות קוד.
        this(20,20,radius);
    }
    public Circle()
    {
       this(10);
    }

    @Override
    public String toString() {
        return "center = ("+x + ","+y+") and radius :" +radius;
    }
    @Override
   public double area(){
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*radius*Math.PI;
    }

    void fill()
    {}
}
