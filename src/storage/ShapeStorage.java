package storage;

import shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public class ShapeStorage {

    private final List<IShape> shapes;

    public ShapeStorage() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
    }

    public IShape getShape(Integer index) {return shapes.get(index);}

    public Integer getNumberOfShapes() {return shapes.size();}

    public void printProperties(){
        for (IShape shape : shapes)
        {
            System.out.println(shape.toString());
        }
    }
}
