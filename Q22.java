package assessment;

interface Drawable {
    void drawingColor(String color);
    void thickness(int value);
}

interface Fillable {
    void fillingColor(String color);
    void size(int value);
}

class Line implements Drawable {
    public void drawingColor(String color) {
        System.out.println("Line Drawing Color: " + color);
    }

    public void thickness(int value) {
        System.out.println("Line Thickness: " + value);
    }
}

class Circle implements Drawable, Fillable {
    public void drawingColor(String color) {
        System.out.println("Circle Drawing Color: " + color);
    }

    public void thickness(int value) {
        System.out.println("Circle Thickness: " + value);
    }

    public void fillingColor(String color) {
        System.out.println("Circle Filling Color: " + color);
    }

    public void size(int value) {
        System.out.println("Circle Size: " + value);
    }
}

class Square implements Drawable, Fillable {
    public void drawingColor(String color) {
        System.out.println("Square Drawing Color: " + color);
    }

    public void thickness(int value) {
        System.out.println("Square Thickness: " + value);
    }

    public void fillingColor(String color) {
        System.out.println("Square Filling Color: " + color);
    }

    public void size(int value) {
        System.out.println("Square Size: " + value);
    }
}

public class Q22 {
    public static void main(String[] args) {
        Line line = new Line();
        Circle circle = new Circle();
        Square square = new Square();

        System.out.println("Line Details:");
        line.drawingColor("Black");
        line.thickness(2);

        System.out.println("\nCircle Details:");
        circle.drawingColor("Red");
        circle.thickness(3);
        circle.fillingColor("Blue");
        circle.size(10);

        System.out.println("\nSquare Details:");
        square.drawingColor("Green");
        square.thickness(4);
        square.fillingColor("Yellow");
        square.size(8);
    }
}
