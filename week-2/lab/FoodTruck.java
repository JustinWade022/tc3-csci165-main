
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FoodTruck { 

    public static void main(String[] args) { 

        try{
            String menu_name = "menu.txt";

            File menu = new File("menu.txt");
            File prices = new File("prices.txt");

            Scanner keypress = new Scanner(System.in);

            Scanner scanner_m = new Scanner(menu);
            Scanner scanner_c = new Scanner(menu);
            Scanner scanner_p = new Scanner(prices);

            String[] menu_items;
            float[] price_items;
            int[] num_items;
            double total = 0;
            DecimalFormat dec = new DecimalFormat("#,###,##0.00");
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter formatterd = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            DateTimeFormatter formatterin = DateTimeFormatter.ofPattern("Mdkm");
            DateTimeFormatter formattert = DateTimeFormatter.ofPattern("kk:mm:ss");
            String day = date.format(formatterd);
            String time = date.format(formattert);
            String invoice_info = date.format(formatterin);

            //LocalDateTime parsedDate = LocalDateTime.parse(day, formatter);


            

        
            int i = 0;
            while (scanner_c.hasNextLine()) {
                i++;
                scanner_c.nextLine();
            }
            menu_items = new String[i];
            price_items = new float[i];
            num_items = new int[i];


            int dex = 0;

            while (scanner_p.hasNextLine()) {

            menu_items[dex] = scanner_m.nextLine();
            //System.out.println(menu_items[dex]);
            price_items[dex] = Float.valueOf(scanner_p.nextLine());
            //System.out.println(price_items[dex]);
            dex++;

            }
            System.out.print("Welcome to the CS food truck!\n\nWhat is your name: ");
            Scanner user = new Scanner(System.in);
            String user_firstname = user.next();
            String user_lastname = user.next();
            String userf_upper = user_firstname.toUpperCase();
            String userl_upper = user_lastname.toUpperCase();

            int item_num = 0;
            System.out.println("\nEnter the quantity of each item");
            System.out.println("===============================");

            while (item_num < dex) {

                System.out.print(menu_items[item_num] + " - " + "$" + dec.format(price_items[item_num]) + ": ");
                num_items[item_num] = Integer.parseInt(user.next());
                total += (num_items[item_num] * price_items[item_num]);
                item_num++;


            }
            char n = userl_upper.charAt(0);
            char y = userf_upper.charAt(0);
            char first_first = userf_upper.charAt(0);
            char second_first = userf_upper.charAt(1);
            char first_last = userl_upper.charAt(0);
            char second_last = userl_upper.charAt(1);
            int mathpin = ((n + y) * (userf_upper.length() + userl_upper.length() + 1));
            int count = 0;
            System.out.print("\n\n");
            PrintWriter printwriter = new PrintWriter(Character.toString(first_first) + Character.toString(second_first) + Character.toString(first_last) + Character.toString(second_last) + Integer.toString(mathpin) + invoice_info + ".txt");

            printwriter.printf("%-25.30s%2.2s%.2s%.10s%.20s","Invoice Number:", userf_upper, userl_upper, mathpin, invoice_info);
            printwriter.printf("\n%-25.30s %-10.10s", "Date:", day);
            printwriter.printf("\n%-25.30s %-10.10s","Time:",time);

            printwriter.printf("\n\n%-30.30s %-10.10s %-10.10s  %-10.10s\n", "Item", "Quantity", "Price", "Total");
            System.out.printf("%-30.30s %-10.10s %-10.10s  %-10.10s\n", "Item", "Quantity", "Price", "Total");
            System.out.println("============================================================");
            printwriter.println("============================================================");

            while (count < dex) {
                printwriter.printf("%-30.30s %-10.10s $%-10.10s $%-10.10s\n", menu_items[count], num_items[count], dec.format(price_items[count]), dec.format((num_items[count] * price_items[count])));
                System.out.printf("%-30.30s %-10.10s $%-10.10s $%-10.10s\n", menu_items[count], num_items[count], dec.format(price_items[count]), dec.format((num_items[count] * price_items[count])));
                count++;
                
            }
            printwriter.println("============================================================");

        

            System.out.println("\n\nSubTotal - $" + dec.format(total));
            printwriter.printf("\n\n%-54.30s$%-30.40s", "SubTotal", dec.format(total));
            System.out.println("Tax - $" + dec.format(total * .0625));
            printwriter.printf("\n\n%-54.30s$%-30.40s", "6.25% Sales Tax" , dec.format(total * .0625));
            System.out.println("Total - $" + dec.format(total * 1.0625));
            printwriter.printf("\n\n%-54.30s$%-30.40s", "Total", dec.format(total * 1.0625));
            System.out.println("\n" + day);
            System.out.printf("%.2s%.2s%.10s%.20s", userf_upper, userl_upper, mathpin, invoice_info);

            printwriter.close();

                

            
            
        }
        catch (IOException e){
            System.out.print("There was a problem");
        }

        //System.out.println(Arrays.toString(price_items));
        //System.out.println(price_items[1]);

        

    }
}