package Lesson12;

public class TestWork {
    private static int num = 0;

    public static void calculate(double[] arr) {
        for (var item : arr) {
            item = (item * Math.sin(0.2f + num / 5) * Math.cos(0.2f + num / 5) * Math.cos(0.4f + num / 2));
            num++;
        }
    }
}
