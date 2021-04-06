package shapes.io;

import shapes.IShape;
import shapes.Point;
import shapes.impl.Circle;
import shapes.impl.Hexagon;
import shapes.impl.Square;
import shapes.impl.Triangle;
import storage.ShapeStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public final class ShapeStorageParser {

    public ShapeStorageParser(){}

    /**
     * reads file (fileName) and creates a ShapeStorage
     * catches two exceptions: FileNotFoundEx, parseLine -> ShapeStorageParserEx
     * @param filePath
     * @return shapeStorage
     */
    public static ShapeStorage parse(String filePath) {
        try (final Scanner sc = new Scanner(new File(filePath))){
            ShapeStorage shapeStorage = new ShapeStorage();
            while (sc.hasNextLine()){
                IShape shape = parseLine(sc.nextLine());
                shapeStorage.addShape(shape);
            }
            return shapeStorage;
        } catch (FileNotFoundException ex) {
            System.err.println("A fajl nem talalhato a " + filePath + " utvonalon");
            return null;
        } catch (ShapeStorageParserException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     *takes a line and returns a shape
     * @param line
     * @return a specific shape
     * @throws ShapeStorageParserException if there's an non-existing shape type
     */
    private static IShape parseLine(String line) throws ShapeStorageParserException {
        try(final Scanner sc = new Scanner(line)){
            String type = readNextWithCheck(sc, "ShapeType");

            String centerXString = readNextWithCheck(sc, "CenterX");
            String centerYString = readNextWithCheck(sc, "CenterY");
            float centerX = Integer.parseInt(centerXString);
            float centerY = Integer.parseInt(centerYString);
            Point center = new Point(centerX, centerY);

            String lengthString = readUntilEnd(sc);
            int length = Integer.parseInt(lengthString);

            if("tri".equals(type)){
                return new Triangle(center, length);
            }else if("hex".equals(type)){
                return new Hexagon(center, length);
            }else if("cir".equals(type)){
                return new Circle(center, length);
            }else if("sqr".equals(type)){
                return new Square(center, length);
            }else{
                throw new ShapeStorageParserException("Nem letezo alakzat");
            }
        }
    }

    /**
     * read until end of scanner, and appends spaces if it's needed
     * @param sc
     * @return builder.toString
     */
    private static String readUntilEnd(Scanner sc){
        StringBuilder builder = new StringBuilder();
        while(sc.hasNext()){
            builder.append(sc.next());
            if (sc.hasNext()) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    /**
     * reads next line from scanner, if there's any
     * @param sc
     * @param e
     * @return next string element
     * @throws ShapeStorageParserException if the scanner is empty
     */
    private static String readNextWithCheck(Scanner sc, String e) throws ShapeStorageParserException{
        if(sc.hasNext()){
            return sc.next();
        }else{
            throw new ShapeStorageParserException("Nincs kovetkezo elem.", e);
        }
    }
}
