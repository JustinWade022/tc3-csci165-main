import java.lang.Math;
import java.lang.Integer;

public class Primitives{
    
    public static void main(String[] args){


        boolean bool = true;
        byte num = 120;
        char character = 'j';
        char digit = '9';
        short sho = 32700;
        int integer = 58;
        long lo = 1234567;
        float decimal = 24.698f;
        double long_dec = 12.343575435648654;

        System.out.printf("%b%n", bool);
        System.out.printf("%d%n",num);
        System.out.printf("%c%n", character);
        System.out.printf("%c%n", digit);
        System.out.printf("%d%n", sho);
        System.out.printf("%d%n", integer);
        System.out.printf("%d%n", lo);
        System.out.printf("%f%n", decimal);
        System.out.printf("%f%n", long_dec);

        int answer = Integer.parseInt(args[0]);
        int power = 2;

        System.out.print("\n\nPart2:\n\n");

        System.out.println(Float.isFinite(answer));

        while (power <= 4){
            System.out.print(Math.pow(answer, power) + "\n");

            power++;
        }

        System.out.print("\n\nPart3a\n\n");

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);


        System.out.print("\n\nPart3b\n\n");

        System.out.println(Integer.compareUnsigned(5, 10));
        System.out.println(Integer.compare(-10, 5));
        //Comparing signed and unsigned comes down to whether or not there is a 
        //negative number in the comparing numbers, signed will compare with a
        //negative number while an unsigned will not



    }
}

