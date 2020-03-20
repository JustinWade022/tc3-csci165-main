

public class MyPointDriver {


    public static void main(String[] args){


        MyPoint[] points = new MyPoint[10];
        for (int i = 0; i < 10; i++){
            points[i] = new MyPoint(i+1, i+1);
            System.out.println(points[i]);
        }

        MyCircle[] circles = new MyCircle[10];
        for (int j = 0; j < 10; j++){
            circles[j] = new MyCircle(points[j], 1.0);
            System.out.println(circles[j]);
        }

        Cylinder cyl1 = new Cylinder();
        Cylinder cyl2 = new Cylinder(4.5);
        Cylinder cyl3 = new Cylinder(2.0, 5.7);
        Cylinder cyl4 = new Cylinder(points[2], 5.5, 13.4);

        MyCircle[] newcircs = new MyCircle[10];

        newcircs[0] = circles[0];
        newcircs[1] = circles[1];
        newcircs[2] = circles[2];
        newcircs[3] = circles[3];
        newcircs[4] = circles[4];
        newcircs[5] = cyl1;
        newcircs[6] = cyl2;
        newcircs[7] = cyl3;
        newcircs[8] = cyl4;
        newcircs[9] = new Cylinder(points[4], 7.9, 15.7);

        for (int k = 0; k < 10; k++){
            System.out.println(newcircs[k]);
        }

        Object[] objs = new Object[11];

        objs[0] = new MyPoint(5, 7);
        objs[1] = new MyPoint(9, 5);
        objs[2] = new MyPoint(12, 4);
        objs[3] = new MyCircle(3, 5, 5.5);
        objs[4] = new MyCircle(7.8);
        objs[5] = new MyCircle(points[7], 5.9);
        objs[6] = new Cylinder();
        objs[7] = new Cylinder(2.3, 6.8);
        objs[8] = new Cylinder(points[8], 1.2, 3.3);
        objs[9] = new Address("Caswell Rd", "Freeville", "NY", "13068");
        objs[10] = new Customer("Justin", "Wade");

        for (int l = 0; l < 11; l++){
            System.out.println(objs[l]);
        }


    }
    
    

            




}