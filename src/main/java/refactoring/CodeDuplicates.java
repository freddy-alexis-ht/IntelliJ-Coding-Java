package refactoring;

public class CodeDuplicates {

    public void method(int a, int b) {
        int c = a + b;
        int d = b + c;
        System.out.printf("d is %d", d);
    }


    private int add(int a, int b) {
        var c =  a + b;
        int i = 1;
        int s = i + b;
        int d = b + c;
        System.out.printf("d is %d", d);
        return d;
    }
}
