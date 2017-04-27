package com.company;

/**
 * Created by hackeru on 2/12/2017.
 */
public class Rectangel {

    int width,hieght;
    public Rectangel makeMeSquare(){
        class Square extends Rectangel {
        public Square(int side){
            this.width=side;
        }
        public int getSide(){
            return this.width;
        }

            @Override
            public String toString() {
                return "square";
            }
        }
        return new Square(width);
    }
}
