

public class MyCircle {

    MyPoint center = new MyPoint(0,0);
    double radius = 1.0;

    public MyCircle(){}

    public MyCircle(double radius){
        this.radius = radius;
    }

    public MyCircle(int x, int y, double radius){
        center.setX(x);
        center.setY(y);
        this.radius = radius;
    }

    public MyCircle(MyPoint center, double radius){
        this.center = center;
        this.radius = radius;
    }

    public MyCircle(MyCircle toClone){
        this.center    = toClone.center;
        this.radius  = toClone.radius;
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public MyPoint getCenter(){
        return center;
    }

    public void setCenter(MyPoint center){
        this.center = center;
    }

    public int getCenterX(){
        return center.getX();
    }

    public void setCenterX(int x){
        center.setX(x);
    }

    public int getCenterY(){
        return center.getY();
    }

    public void setCenterY(int y){
        center.setY(y);
    }

    public int[] getCenterXY(){
        return center.getXY();
    }

    public void setCenterXY(int x, int y){
        center.setXY(x, y);
    }

    public String toString(){
        return "MyCircle[radius=" + radius + ", center=" + center + "]";
    }

    public double getArea(){
        return Math.pow((Math.PI * radius), 2);
    }

    public double getCircumference(){
        return Math.PI * radius * 2;
    }

    public double distance(MyCircle another){
        return center.distance(another.center);
    }

    @Override
    public boolean equals(Object obj){
        
        if (this == obj)        return true;

        if (obj == null)        return false;

        if (getClass() != obj.getClass())   return false;

        MyCircle other = (MyCircle) obj;
        return this.center.equals(other.center) &&
                this.radius == other.radius;
    }

}