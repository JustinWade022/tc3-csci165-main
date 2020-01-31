public class HelloWorld2{

    // main method is the starting point of any Java app
    public static void main(String[] args){
        String n = "";
        for (String s : args)
            n += " " + s;
            
        System.out.println("Hello " + n + ". Nice Work Processing the arguments!");
        
    }
}