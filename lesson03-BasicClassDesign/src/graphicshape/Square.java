package graphicshape;

/**
 * Created by hackeru on 2/6/2017.
 */
public class Square extends Rectangle {

    public Square(int side) {
        super(side,side);
    }

    public void setSide(int side){
        super.setWidth(side);
        super.setHeight(side);
    }
    public int getSide(){
        return getHeight();
    }

    @Override
    public void setWidth(int width) {
        setSide(width);
    }

    @Override
    public void setHeight(int height) {
        setSide(height);
    }
}
