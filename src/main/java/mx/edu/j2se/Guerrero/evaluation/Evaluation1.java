package mx.edu.j2se.Guerrero.evaluation;

public class Evaluation1 {

    public static void main(String[] args) {


        try {
            Circle objeto1 = new Circle(-2);
        } catch (IllegalArgumentException e ){
            System.out.println("El radio no puede ser negativo");
        }

        Circle[] array = new Circle[3];
        array[0] = new Circle(3);
        array[1] = new Circle(6);
        array[2] = new Circle(9);

        System.out.println(array[biggestCircle(array)].getRadius());
    }

    private static int biggestCircle(Circle[] array) {
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i].getRadius() > array[maxIndex].getRadius()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
