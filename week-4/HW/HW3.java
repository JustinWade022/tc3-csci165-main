import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

public class HW3{

    public static void main(String[] args){
        String filename1 = "number_list.txt";
        int[] array = new int[countfilelines(filename1)];
        fillArray(array);
        int[] perc_ar = percentChange(array);
        System.out.print(perc_ar[34]);








    }

    public static void fillArray(int[] array){
        int i = 0;
        try{
            FileReader fr1 = new FileReader("number_list.txt");
            Scanner scan1 = new Scanner(fr1);

            while (scan1.hasNextLine()){
                array[i] = Integer.parseInt(scan1.nextLine());
                ++i;


            }
            fr1.close();
            scan1.close();
        }
        catch(IOException ioe){
                System.out.println("No such file");

        }

        

    }

    public static int findMax(int[] array){
        int max_num = array[0];
        for (int j = 0; j <= (array.length - 1); j++){
            if (array[j] > max_num){
                max_num = array[j];
            }


        }
        return max_num;

    }

    public static int findMin(int[] array){
        int min_num = array[0];
        for (int k = 0; k <= (array.length - 1); k++){
            if (array[k] < min_num){
                min_num = array[k];
            }


        }
        return min_num;

    }

    public static int[] percentChange(int[] array){
        int[] per_array = new int[array.length - 1];
        for(int l = 0; l <= (array.length - 2); l++){
            double per = (((array[l + 1] - array[l]) / array[l]) * 100);
            int per_int = (int)per;
            per_array[l] = per_int;

        }
        return per_array;
    }


    public static int countfilelines(String filename){
        int numLines = 0;
        

        try{
            FileReader fr = new FileReader(filename);
            Scanner Scan = new Scanner(fr);


            while (Scan.hasNextLine()){
                ++numLines;
                Scan.nextLine();
            }
            fr.close();
            Scan.close();
            return numLines;

        }
        catch(IOException ioe){
            System.out.println("No Such File");
        }

        return numLines;
        
    }
}
