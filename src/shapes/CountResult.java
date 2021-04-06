package shapes;

import storage.ShapeStorage;

public class CountResult {

    /**
     * goes through the shape storage, and looks for the maxes, and mins which were given by the calculatFurtermostPoints method
     * @param shapeStorage
     * @return result - which is an object, that contains the vertex coordinates of the expected rectangle
     */
    public static Result countResult(ShapeStorage shapeStorage){
        if (shapeStorage.getNumberOfShapes() > 0)
        {
            Float[] maxesOfAxes = shapeStorage.getShape(0).calculateFurthermostPoints().clone();
            if (shapeStorage.getNumberOfShapes() > 1) {
                for (int i=1; i<shapeStorage.getNumberOfShapes(); i++){
                    compareMaxes(shapeStorage, maxesOfAxes, i);
                }
            }
            Result result = new Result(maxesOfAxes);
            return result;
        }else{
            System.err.println("Egyetlen alakzat sincs amit vizsgalni lehetne. Ha ugy ertelmezzuk a feladatot, a megoldásnak az osszes csucsa a (0.0, 0.0) pontban van."); //error-ra írjuk ki
            return null;
        }
    }

    /**
     * changes the first four element of the second param, if they're bigger or smaller than the furthermost points of the index-th element of the shape storage
     * @param shapeStorage
     * @param maxesOfAxes
     * @param index
     */
    private static void compareMaxes(ShapeStorage shapeStorage, Float[] maxesOfAxes, Integer index) {
        if (maxesOfAxes[0] < shapeStorage.getShape(index).calculateFurthermostPoints()[0]){
            maxesOfAxes[0] = new Float (shapeStorage.getShape(index).calculateFurthermostPoints()[0]);
        }
        if (maxesOfAxes[1] > shapeStorage.getShape(index).calculateFurthermostPoints()[1]){
            maxesOfAxes[1] = new Float (shapeStorage.getShape(index).calculateFurthermostPoints()[1]);
        }
        if (maxesOfAxes[2] < shapeStorage.getShape(index).calculateFurthermostPoints()[2]){
            maxesOfAxes[2] = new Float (shapeStorage.getShape(index).calculateFurthermostPoints()[2]);
        }
        if (maxesOfAxes[3] > shapeStorage.getShape(index).calculateFurthermostPoints()[3]){
            maxesOfAxes[3] = new Float (shapeStorage.getShape(index).calculateFurthermostPoints()[3]);
        }
    }

}
