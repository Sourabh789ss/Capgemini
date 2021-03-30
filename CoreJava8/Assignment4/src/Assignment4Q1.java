import java.util.Scanner;

interface Add
{
    public double addition(int num1,int num2);
}

interface Subtract
{
    public double subtraction(int num1,int num2);
}

interface Multiple
{
    public double multiplication(int num1,int num2);
}

interface Divide
{
    public double division(int num1,int num2);
}
public class Assignment4Q1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int a,b;
        a=scan.nextInt();
        b=scan.nextInt();

        Add Addition=(int x, int y)->{ return x+y; };
        System.out.println(Addition.addition(a,b));

        Subtract Subtraction=(int x, int y)->{ return x-y; };
        System.out.println(Subtraction.subtraction(a, b));

        Multiple Multiplication=(int x, int y)->{ return x*y; };
        System.out.println(Multiplication.multiplication(a, b));

        Divide Division=(int x, int y)->{ return (double)x/y;};
        System.out.println(Division.division(a, b));
    }
}