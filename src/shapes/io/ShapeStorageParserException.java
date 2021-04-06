package shapes.io;

public class ShapeStorageParserException extends Exception {

    public ShapeStorageParserException(String message){
        super(message);
    }

    public ShapeStorageParserException(String message, String a){
        super(message + " (" + a + ")");
    }
}
