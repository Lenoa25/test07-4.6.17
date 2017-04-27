package graphicshape;

/**
 * Created by hackeru on 2/5/2017.
 */
public abstract class Shape {
public void refresh()
{
    System.out.println("refreshing");
}
public abstract double area();
public abstract double perimeter();

}

