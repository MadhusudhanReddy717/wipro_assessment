package assessment;

public class Q13and14 {

    static class Worker {
        String name;
        double salaryRate;

        Worker(String name, double salaryRate) {
            this.name = name;
            this.salaryRate = salaryRate;
        }

        double pay(int hours) {
            return 0;
        }
    }

    static class DailyWorker extends Worker {
        DailyWorker(String name, double rate) {
            super(name, rate);
        }

        double pay(int days) {
            return days * salaryRate;
        }
    }

    static class SalariedWorker extends Worker {
        SalariedWorker(String name, double rate) {
            super(name, rate);
        }

        double pay(int hours) {
            return 40 * salaryRate;
        }
    }

    static class Shape {
        public double area(double side) {
            return side * side;
        }

        public double area(double l, double b) {
            return l * b;
        }

        public double perimeter(double side) {
            return 4 * side;
        }

        public double perimeter(double l, double b) {
            return 2 * (l + b);
        }
    }

    public void q13() {
        DailyWorker q13a = new DailyWorker("John", 100);
        SalariedWorker q13b = new SalariedWorker("Jane", 200);
        System.out.println("Q13: Worker Pay Calculation:");
        System.out.println("DailyWorker Pay: " + q13a.pay(5));
        System.out.println("SalariedWorker Pay: " + q13b.pay(50));
    }

    public void q14() {
        Shape shape = new Shape();
        System.out.println("Q14: Shape Calculations:");
        System.out.println("Area of square: " + shape.area(5));
        System.out.println("Area of rectangle: " + shape.area(4, 6));
        System.out.println("Perimeter of square: " + shape.perimeter(5));
        System.out.println("Perimeter of rectangle: " + shape.perimeter(4, 6));
    }

    public static void main(String[] args) {
        Q13and14 q = new Q13and14();
        q.q13();
        System.out.println();
        q.q14();
    }
}

/*
Q13: Worker Pay Calculation:
DailyWorker Pay: 500.0
SalariedWorker Pay: 8000.0

Q14: Shape Calculations:
Area of square: 25.0
Area of rectangle: 24.0

Perimeter of square: 20.0
Perimeter of rectangle: 20.0
*/


