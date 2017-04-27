package graphicshape;

/**
 * Created by hackeru on 2/6/2017.
 */
public class Rectangle extends Shape{
    private int width;
    private int height;


    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }




    public Rectangle(int width, int height)
    {
        setHeight(height);
        setWidth(width);
    }


    @Override
    public double area() {
        return height*width;
    }

    @Override
    public double perimeter() {
        return 2*(height+width);
    }
}
