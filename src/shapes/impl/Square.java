package shapes.impl;

import shapes.AbstractShape;
import shapes.Point;

public class Square extends AbstractShape{

    public Square(Point center, Integer length){
        super(center, length);
    }

    @Override
    public Float[] calculateFurthermostPoints(){
        Float[] res = new Float[4];
        res[0] = (center.getY() + ((float)(length) / (float)(2))); //fel
        res[1] = (center.getY() - ((float)(length) / (float)(2))); //le
        res[2] = (center.getX() + ((float)(length) / (float)(2))); //jobbra
        res[3] = (center.getX() - ((float)(length) / (float)(2))); //balra
        return res;
    }

    @Override
    public String toString() {
        return "Square{" +
                "center=" + center.toString() +
                ", length=" + length +
                '}';
        }
}


