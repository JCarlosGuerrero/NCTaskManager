package mx.edu.j2se.Guerrero.evaluation;

public class Evaluation1 {

    public static void main(String[] args) {

        Circle objeto1 = new Circle();
        Circle objeto2 = new Circle(-2);

        objeto1.getRadius();
        objeto2.getRadius();

        objeto1.setRadius(2);
        objeto2.setRadius(3);

        System.out.println(objeto1.getArea());
        System.out.println(objeto2.getArea());

        Circle array[] = new Circle[3];
        array[0] = new Circle(3);
        array[1] = new Circle(6);
        array[2] = new Circle(9);

        //System.out.println("The biggest circle is: " + biggestCircle(array[]));
    }

    public static<T> int biggestCircle(T[] array,Circle big) {

        for (int i = 0; i < array.length; i++) {
            big.getRadius();
            if(big.getRadius() > big.getRadius()) {
                return i;
            }
        } return 0;
    }
}
