package shapes;

import java.util.Arrays;

public class Result {

    private Point[] vertexCoordinates;
    private static final int NUM_OF_VERTEXES = 4;

    public Result(Float[] maxesOfAxes) {
        vertexCoordinates = new Point[NUM_OF_VERTEXES];
        this.vertexCoordinates[0] = new Point(maxesOfAxes[2],maxesOfAxes[0]);
        this.vertexCoordinates[1] = new Point(maxesOfAxes[3],maxesOfAxes[0]);
        this.vertexCoordinates[2] = new Point(maxesOfAxes[3],maxesOfAxes[1]);
        this.vertexCoordinates[3] = new Point(maxesOfAxes[2],maxesOfAxes[1]);
    }

    @Override
    public String toString() {
        return "Result: " +
                "vertexCoordinates=" + Arrays.toString(vertexCoordinates);
    }
}
