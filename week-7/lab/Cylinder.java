
public class Cylinder extends MyCircle {
    
    private double height;


    public Cylinder() {
        super();
        height = 1.0;
    }

    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double radius, double height){
        super(radius);
        this.height = height;
    }

    public Cylinder(MyPoint center, double radius, double height){
        super(center, radius);
        this.height = height;
    }

    public Cylinder(Cylinder toClone){
        this.height  = toClone.height;
    }

    public double getHeight(){
        return height;
    }

    public double getVolume(){
        return getArea() * height;
    }

    public String toString(){
        return super.toString() + " height=" + height;
    }

    @Override
    public boolean equals(Object obj){

        Cylinder other = (Cylinder) obj;

        if (!super.equals(other))   return false;
        
        if (this == obj)        return true;

        if (obj == null)        return false;

        if (getClass() != obj.getClass())   return false;

        return this.height == other.height;

    }

    
}