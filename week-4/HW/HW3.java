import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

public class HW3{

    public static void main(String[] args){
        String filename1 = "number_list.txt";
        int[] array = new int[countfilelines(filename1)];
        fillArray(array);
        int[] perc_ar = percentChange(array);
        int[][] num_matrix = new int[50][20];
        fillArray1(num_matrix);
        
        //printRow(num_matrix, 49, 20);
        //System.out.print(smallestChange(num_matrix));
        








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
        	int first = array[l];
        	int next = array[l + 1];
            float per = (next - first);
            per /= first;
            per *= 100;
            int per_int = (int)per;
            per_array[l] = per_int;

        }
        return per_array;
    }
    
    public static void fillArray1(int[][] matrix) {
        try{
            FileReader fr2 = new FileReader("number_list.txt");
            Scanner scan2 = new Scanner(fr2);

            for(int m = 0; m < 50; ++m) {
            	for(int n = 0; n < 20; ++n) {
            		matrix[m][n] = Integer.parseInt(scan2.nextLine());
            	}
            }
            fr2.close();
            scan2.close();
        }
        catch(IOException ioe){
                System.out.println("No such file");

        }
    	
    }
    
    public static int findMax1(int[][] matrix) {
    	int max = matrix[0][0];
    	
    	for(int o = 0; o < 50; ++o) {
    		for(int p = 0; p < 20; ++p) {
    			if (matrix[o][p] > max) {
    				max = matrix[o][p];
    			}
    		}
    	}
    	return max;
    }
    
    public static int findMin1(int[][] matrix) {
    	int min = matrix[0][0];
    	
    	for(int q = 0; q < 50; ++q) {
    		for(int r = 0; r < 20; ++r) {
    			if (matrix[q][r] < min) {
    				min = matrix[q][r];
    			}
    		}
    	}
    	return min;
    	
    }
    
    public static int findMaxOfRow(int[][] matrix, int row) {
    	int max = matrix[row][0];
    	
    	for(int i = 0; i < 20; ++i) {
    		if (matrix[row][i] > max) {
    			max = matrix[row][i];
    			
    		}
    		
    	}
    	return max;
    }
    
    public static int findMinOfRow(int[][] matrix, int row) {
    	int min = matrix[row][0];
    	
    	for(int i = 0; i < 20; ++i) {
    		if (matrix[row][i] < min) {
    			min = matrix[row][i];
    			
    		}
    		
    	}
    	return min;
    }
    
    public static int findMaxOfColumn(int[][] matrix, int column) {
    	int max = matrix[0][column];
    	
    	for(int i = 0; i < 50; ++i) {
    		if (matrix[i][column] > max) {
    			max = matrix[i][column];
    		}
    	}
    	return max; 
    }
    
    public static int findMinOfColumn(int[][] matrix, int column) {
    	int min = matrix[0][column];
    	
    	for(int i = 0; i < 50; ++i) {
    		if (matrix[i][column] < min) {
    			min = matrix[i][column];
    		}
    	}
    	return min; 
    	
    }

    public static void fillArray2(int[][] matrix) {
        try{
            FileReader fr2 = new FileReader("number_list.txt");
            Scanner scan2 = new Scanner(fr2);

            for(int m = 0; m < 20; ++m) {
            	for(int n = 0; n < 50; ++n) {
            		matrix[n][m] = Integer.parseInt(scan2.nextLine());
            	}
            }
            fr2.close();
            scan2.close();
        }
        catch(IOException ioe){
                System.out.println("No such file");

        }
    	
    }
    
    public static void printRow(int[][] matrix, int row, int num_cols) {
    	for(int i = 0; i < num_cols - 1; ++i) {
    		System.out.print(matrix[row][i] + " ");
    		
    	}
    }
    
    public static int smallestChange(int[][] matrix) {
    	int total = 0;
    	int[] avg_c = new int[50];
    	for(int i = 0; i < 50; ++i) {
    		int[] change = percentChange(matrix[i]);
    		for(int j = 0; j < 20; ++j) {
    			total += j;
    			
    		}
    		avg_c[i] = (int)(total / 20);
    		
    	}
    	double lowest_row = findMin(avg_c);
    	int integer_l =  (int)lowest_row;
    	return integer_l;
    }
    
    public static void positiveChange(int[] array) {
    	for(int i = 0; i < 20; ++i) {
    		if array[i] < array[i + 1] {
    			
    		}
    		
    	}
    	
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
