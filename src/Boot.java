import shapes.CountResult;
import shapes.Result;
import shapes.impl.Triangle;
import shapes.impl.Circle;
import shapes.io.ShapeStorageParser;
import storage.ShapeStorage;


public class Boot {

    public static void main(String[] args) {

            ShapeStorage shapeStorage;
            ShapeStorageParser shapeStorageParser = new ShapeStorageParser();

            //initShapeStorage(shapeStorage);
            shapeStorage = shapeStorageParser.parse("tobbdb.txt");

            System.out.println("Properties: ");
            shapeStorage.printProperties();
            System.out.println();

            Result result = CountResult.countResult(shapeStorage);
            System.out.println(result.toString());

        /*if (args.length > 0) {
            ShapeStorage shapeStorage;
            ShapeStorageParser shapeStorageParser = new ShapeStorageParser();

            //initShapeStorage(shapeStorage);
            shapeStorage = shapeStorageParser.parse(args[1]);

            System.out.println("Properties: ");
            shapeStorage.printProperties();
            System.out.println();

            Result result = countResult(shapeStorage);
            System.out.println(result.toString());
        } else {
            throw new RuntimeException("Szukseg van egy bemeneti fajl argumentumra!");
        }*/
    }

    /*private static void initShapeStorage(ShapeStorage shapeStorage)
    {
        Point p = new Point(1f,2f);
        shapeStorage.addShape(new Triangle(p,3));
        Point p2 = new Point(1.4f,-0.3f);
        shapeStorage.addShape(new Circle(p2,2));
    }*/


}