/**
 * Created by hackeru on 2/12/2017.
 */
public class Shape {

    private Color color=new Color(4,4,5);

    public static class Color{
        int green,red,blue;

        public Color(int green, int red, int blue) {
            this.green = green;
            this.red = red;
            this.blue = blue;
        }

        public int getGreen() {
            return green;
        }

        public void setGreen(int green) {
            this.green = green;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getBlue() {
            return blue;
        }

        public void setBlue(int blue) {
            this.blue = blue;
        }
    }
}
