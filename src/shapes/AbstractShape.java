package shapes;


public abstract class AbstractShape implements IShape {

    protected final Point center;
    protected final Integer length;

    protected AbstractShape(Point center, Integer length) {
        this.center = center;
        this.length = Math.abs(length);
    }

    @Override
    public Point getCenter() {
        return center;
    }

    @Override
    public Integer getLength() {
        return length;
    }

    /**
     * Calculate the furthermost points of the shape in the four directions(up, down, right, left)
     * @return and returns an array of four elements (also: up, down, right, left)
     */
    public abstract Float[] calculateFurthermostPoints();

}
