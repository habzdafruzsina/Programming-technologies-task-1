package shapes.impl;

import shapes.AbstractShape;
import shapes.Point;

public class Triangle extends AbstractShape{

    public Triangle(Point center, Integer length){
        super(center, length);
    }

    @Override
    public Float[] calculateFurthermostPoints(){
        Float[] res = new Float[4];
        res[0] = (center.getY() + ((float)(length)*(float)(Math.sqrt(3)) / 2) / 3 * 2); //fel
        res[1] = (center.getY() - ((float)(length*Math.sqrt(3)) / 2) / 3); //le
        res[2] = (center.getX() + ((float)(length) / (float)(2))); //jobbra
        res[3] = (center.getX() - ((float)(length) / (float)(2))); //balra
        return res;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "center=" + center.toString() +
                ", length=" + length +
                '}';
    }
}
