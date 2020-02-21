import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

class Drawer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public Drawer() {
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("2D Drawing");
        window.setSize(844, 480);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        MapDataDrawer.drawMap(g);
        MapDataDrawer.drawAllPaths(g, 479);
        MapDataDrawer.drawLeastResis(g);
    }

    private void doDrawing(Graphics g) {

        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation
            Grey Scale colors are scaled in matching set of 3 numeric values
        */

        Graphics2D g2d = (Graphics2D) g;

        int x = 10, y = 10;
        for(int i = 0; i < 30; ++i){
            g2d.drawRect(x, y, 10, 10);
            y += 15;
        }

        g2d.setColor(new Color(0, 0, 0));
        y = 10; x += 15;
        for(int i = 0; i < 30; ++i){
            g2d.fillRect(x, y, 20, 10);
            y += 15;
        }

        g2d.setColor(new Color(128, 128, 128));
        y = 10; x += 15;
        for(int i = 0; i < 30; ++i){
            g2d.fillRect(x, y, 10, 10);
            y += 15;
        }

        g2d.setColor(new Color(200, 200, 200));
        y = 10; x += 15;
        for(int i = 0; i < 30; ++i){
            g2d.fillOval(x, y, 10, 10);
            y += 15;
        }

        int width = getWidth();
        int height = getHeight();
        g2d.setColor(Color.GREEN);
        String s = "I'm a graphics programmer now!!";
        g2d.drawString(s, (width / 2) - s.length() * 3 , height / 2);

        g2d.setColor(Color.RED);
        Random random = new Random();
        for(int i = 0; i < 2000; i++){
            x = Math.abs(random.nextInt()) % width;
            y = Math.abs(random.nextInt()) % height;
            g2d.drawLine(x, y, x + 2, y + 2);
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                Drawer ex = new Drawer();
                ex.setVisible(true);
            }
        });
    } // end main
} // end class
class MapDataDrawer {
	public static int[][] MapDataDrawers(String filename) {
		int cols = (Integer.parseInt(filename.substring(filename.indexOf("_") + 1, filename.indexOf("x"))));
		int rows = (Integer.parseInt(filename.substring(filename.indexOf("x") + 1, filename.indexOf("."))));
		int[][] matrix = new int[rows][cols];
		try{
            FileReader fr2 = new FileReader(filename);
            Scanner scan2 = new Scanner(fr2);

            for(int m = 0; m < rows; ++m) {
            	for(int n = 0; n < cols; ++n) {
            		matrix[m][n] = scan2.nextInt();
            	}
            }
            fr2.close();
            scan2.close();
        }
        catch(IOException ioe){
                System.out.println("No such file");

        }
		return matrix;
	}
	
	static int[][] mapdata = MapDataDrawers("Colorado_844x480.dat");
	
	
	public static int findMin() {
		int min = mapdata[0][0];
    	
    	for(int q = 0; q < mapdata.length; ++q) {
    		for(int r = 0; r < mapdata[0].length; ++r) {
    			if (mapdata[q][r] < min) {
    				min = mapdata[q][r];
    			}
    		}
    	}
    	return min;
		
	}
	
	public static int findMax() {
		int max = mapdata[0][0];
    	
    	for(int o = 0; o < mapdata.length; ++o) {
    		for(int p = 0; p < mapdata[0].length; ++p) {
    			if (mapdata[o][p] > max) {
    				max = mapdata[o][p];
    			}
    		}
    	}
    	return max;
	}
	
	public static void drawMap(Graphics g) {
		
		
		int min = findMin();
		int max = findMax();
		float diff = (max - min);
		
		for (int o = 0; o < mapdata.length; ++o) {
			for (int p = 0; p < mapdata[0].length; ++p) {
				int num = mapdata[o][p];
				float num1 = num - min;
				float num2 = (num1 / diff);
				
				float val = (num2 * 255);
				int gray_val = (int) val;
				g.setColor(new Color(gray_val, gray_val, gray_val));
				g.fillRect(p, o, 1, 1);
				
			}
		}
	}
	
	public static int indexOfMinRow(int col) {
		int ind = 0;
		int min_num = mapdata[0][col];
        for (int k = 0; k < mapdata.length; k++){
            if (mapdata[k][col] < min_num){
                min_num = mapdata[k][col];
                ind = k;
            }
        }
        return ind;
	}
	public static int findMinIndex(int[] array){
		Random rand = new Random();
		int num = 0;
		int ind1 = 0;
        int min_num = findMax() + 1;
        for (int j = 0; j < (array.length); j++){
            if (array[j] < min_num){
                min_num = array[j];
                ind1 = j;
            }
        }
        for (int k = 0; k < (array.length); k++) {
        	if ((array[k] == min_num) && (k != ind1)) {
        		if ((k == 1) || (ind1 == 1)) {
        			return 1;
        			
        		}
        		else {
        			num = rand.nextInt(1);
        			if (num == 0) {
        				return 0;
        			}
        			else {
        				return 2;
        			}
        		}
        	}
        }
        return ind1;
	}
	public static int[][] diffens = new int[480][844];
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
	
	public static double resis(int[] perc) {
		int sum = 0;
		for (int i = 0; i < perc.length; i++) {
			sum += Math.abs(perc[i]);
		}
		return (sum / perc.length);
	}
	public static void drawLeastResis(Graphics g) {
		
		int row = 0;
		double min_resis = resis(diffens[0]);
		for (int i = 1; i < diffens.length - 1; i++) {
			if (resis(diffens[i]) < min_resis) {
				min_resis = resis(diffens[i]);
				row = i;
			}
		}
		drawLowestElevPath(g, row, 0, 255, 0);
	}
	public static int drawLowestElevPath(Graphics g, int startRow, int c1, int c2, int c3) {
		int[] diff = new int[3];
		int row = startRow;
		for(int i = 0; i < mapdata[0].length - 1; ++i) {
			if (row == (mapdata.length - 1)) {
				diff[0] = Math.abs(mapdata[row][i] - mapdata[row - 1][i + 1]);
				diff[1] = Math.abs(mapdata[row][i] - mapdata[row][i + 1]);
				diff[2] = findMax();
			}
			else if (row == 0) {
				diff[0] = findMax();
				diff[1] = Math.abs(mapdata[row][i] - mapdata[row][i + 1]);
				diff[2] = Math.abs(mapdata[row][i] - mapdata[row + 1][i + 1]);
			}
			else {
				diff[0] = Math.abs(mapdata[row][i] - mapdata[row - 1][i + 1]);
				diff[1] = Math.abs(mapdata[row][i] - mapdata[row][i + 1]);
				diff[2] = Math.abs(mapdata[row][i] - mapdata[row + 1][i + 1]);
			}
			row += (-1 + findMinIndex(diff));
			g.setColor(new Color(c1, c2, c3));
			g.fillRect((i + 1), row, 1, 1);
			diffens[startRow][i] = diff[findMinIndex(diff)];
			
			
			
			
		}
		return row;
	}
	public static void drawAllPaths(Graphics g, int maxrows) {
		for (int i = 0; i < maxrows; ++i) {
			drawLowestElevPath(g, i, 255, 0, 0);
		}
	}
}