package assessment;

public class Q32 {
    public static void main(String[] args) {
        try {
            int[] arr = new int[-5];
        } catch (NegativeArraySizeException e) {
            System.out.println("Caught NegativeArraySizeException");
            e.printStackTrace();
        }

        try {
            int[] arr = new int[3];
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }

        try {
            String str = "abc";
            System.out.println(str.charAt(5));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
            e.printStackTrace();
        }

        try {
            String[] list = new String[2];
            System.out.println(list[5]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException");
            e.printStackTrace();
        }

        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
            e.printStackTrace();
        }

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
            e.printStackTrace();
        }
    }
}
