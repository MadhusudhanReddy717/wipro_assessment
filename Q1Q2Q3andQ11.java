package assessment;

public class Q1Q2Q3andQ11 {

    public void arithmeticOperation() {
        int num = 2345;
        int result = ((num + 8) / 3) % 5 * 5;
        System.out.println("Q1 result: " + result);
    }

    public void assignmentOperators() {
        int num = 2345;
        num += 8;
        num /= 3;
        num %= 5;
        num *= 5;
        System.out.println("Q2 result: " + num);
    }

    public void girlswithgradeA() {
        int totalStudents = 90;
        int totalGradeA = totalStudents / 2;
        int boyswithgradeA = 20;
        int girlswithgradeA = totalGradeA - boyswithgradeA;
        System.out.println("Q3:Girls who got grade A: " + girlswithgradeA);
    }

    public void add(int a, int b) {
        System.out.println("Q11 Add: " + (a + b));
    }

    public void diff(int a, int b) {
        System.out.println("Q11 Diff: " + (a - b));
    }

    public void mul(int a, int b) {
        System.out.println("Q11 Mul: " + (a * b));
    }

    public void div(int a, int b) {
        if (b != 0)
            System.out.println("Q11 Div: " + ((double) a / b));
        else
            System.out.println("Q11 Div: Cannot divide by zero");
    }

    public static void main(String[] args) {
        Q1Q2Q3andQ11 q1 = new Q1Q2Q3andQ11();
        Q1Q2Q3andQ11 q2 = new Q1Q2Q3andQ11();
        Q1Q2Q3andQ11 q3 = new Q1Q2Q3andQ11();
        Q1Q2Q3andQ11 q11 = new Q1Q2Q3andQ11();

        q1.arithmeticOperation();
        q2.assignmentOperators();
        q3.girlswithgradeA();

        q11.add(10, 5);
        q11.diff(10, 5);
        q11.mul(10, 5);
        q11.div(10, 5);
    }
}
