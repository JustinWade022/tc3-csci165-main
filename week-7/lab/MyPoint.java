
public class MyPoint {

    int x = 0;
    int y = 0;

    public MyPoint(){}

    public MyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public MyPoint(MyPoint toClone){
        this.x    = toClone.x;
        this.y  = toClone.y;
    }


    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int[] getXY(){
        int[] point = {x, y};
        return point;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public double distance(int x, int y){
        return Math.pow((Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2)), (1/2));
    }

    public double distance(MyPoint another){
        return Math.pow((Math.pow((another.getX() - this.x), 2) + Math.pow((another.getY() - this.y), 2)), (1/2));
    }

    public double distance(){
        return (Math.pow((Math.pow(x,2)) + (Math.pow(y,2)),(1/2)));
    }

    @Override
    public boolean equals(Object obj){
        
        if (this == obj)        return true;

        if (obj == null)        return false;

        if (getClass() != obj.getClass())   return false;

        MyPoint other = (MyPoint) obj;
        return this.x == other.x &&
                this.y == other.y;
    }

    



}