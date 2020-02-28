import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class ElectionDriver {
	
	
	public static CountyResults2016[] results = new CountyResults2016[3141];
	
	public static void fillArray() {
		try {
			String file = "2016_US_County_Level_Presidential_Results.csv";
			FileReader fr = new FileReader(file);
			Scanner s = new Scanner(fr);
			s.nextLine();
			for (int i = 0; i < 3141; i++) {
				String line = s.nextLine();
				String[] v = line.split(",");
				
				if (v.length == 12) {
					double v1 = Double.parseDouble(v[1]);
					double v2 = Double.parseDouble(v[2]);
					double v3 = Double.parseDouble(v[3]);
					double v4 = Double.parseDouble(v[4]);
					double v5 = Double.parseDouble(v[5]);
					v[6] += v[7];
					v[6] = v[6].replace("\"", "");
					double v6 = Double.parseDouble(v[6]);
					v[8] = v[8].replace("%", "");
					double v7 = Double.parseDouble(v[8]);
					int    v8 = Integer.parseInt(v[11]);
					results[i] = new CountyResults2016(v1, v2, v3, v4, v5, v6, v7, v[9], v[10], v8);
				}
				else if (v.length == 11) {
					double v1 = Double.parseDouble(v[1]);
					double v2 = Double.parseDouble(v[2]);
					double v3 = Double.parseDouble(v[3]);
					double v4 = Double.parseDouble(v[4]);
					double v5 = Double.parseDouble(v[5]);
					v[6] = v[6].replace("\"", "");
					double v6 = Double.parseDouble(v[6]);
					v[7] = v[7].replace("%", "");
					double v7 = Double.parseDouble(v[7]);
					int    v8 = Integer.parseInt(v[10]);
					results[i] = new CountyResults2016(v1, v2, v3, v4, v5, v6, v7, v[8], v[9], v8);
					
				}
				else {
					double v1 = Double.parseDouble(v[1]);
					double v2 = Double.parseDouble(v[2]);
					double v3 = Double.parseDouble(v[3]);
					double v4 = Double.parseDouble(v[4]);
					double v5 = Double.parseDouble(v[5]);
					v[6] += v[7];
					v[6] += v[8];
					v[6] = v[6].replace("\"", "");
					double v6 = Double.parseDouble(v[6]);
					v[9] = v[9].replace("%", "");
					double v7 = Double.parseDouble(v[9]);
					int    v8 = Integer.parseInt(v[12]);
					results[i] = new CountyResults2016(v1, v2, v3, v4, v5, v6, v7, v[10], v[11], v8);
					
				}
				
				
			}
			
			fr.close();
			s.close();
		}
		
		catch(IOException ioe) {
			System.out.print("Error Not Found");
		}
		
	}
	
	public static CountyResults2016 findLargestMargin() {
		CountyResults2016 largest = results[1];
		for(int i = 0; i < 3141; i++) {
			if (results[i].getDifference() > largest.getDifference()) {
				largest = results[i];
			}
			
		}
		return largest;
	}
	
	public static CountyResults2016 findLargestMargin(String state) {
		int size = 0;
		CountyResults2016[] states = new CountyResults2016[1000];
		for(int i = 0; i < 3141; i++) {
			if (results[i].getState().equals(state)) {
				states[size] = results[i];
				size++;
			}
		}
		CountyResults2016 largest = states[0];
		for(int j = 0; j < size ; j++) {
			if (states[j].getDifference() > largest.getDifference()) {
				largest = states[j];
			}
			
		}
		return largest;
	}
	
		
		
		
	//}
	
	
	public static void main(String[] args) {
		fillArray();
		CountyResults2016 j = findLargestMargin("NY");
		double n = j.difference;
		double u = results[2003].difference;
		System.out.print(j.toString());
	}
	
	

}
