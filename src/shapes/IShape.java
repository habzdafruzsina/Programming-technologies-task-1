package shapes;

public interface IShape {
    Point getCenter();
    Integer getLength();

    Float[] calculateFurthermostPoints();
}
