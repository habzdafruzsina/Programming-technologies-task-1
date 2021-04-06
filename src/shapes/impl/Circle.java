package shapes.impl;

import shapes.AbstractShape;
import shapes.Point;

public class Circle extends AbstractShape {

    public Circle(Point center, Integer length){
        super(center, length);
    }

    @Override
    public Float[] calculateFurthermostPoints(){
        Float[] res = new Float[4];
        res[0] = (center.getY() + length); //fel
        res[1] = (center.getY() - length); //le
        res[2] = (center.getX() + length); //jobbra
        res[3] = (center.getX() - length); //balra
        return res;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center.toString() +
                ", length=" + length +
                '}';
    }
}
