import java.util.Scanner;

/**
 * Created by Максим on 03.02.2015.
 */


public class RevServer {

public static void main(String [] args) {
    Field field = new Field();

    Scanner input = new Scanner(System.in);
    int col;
    int x;
    int y;

    /*field.move(field.checkMove(Square.StatusType.BLACK,2,3),2,3);
    field.drawField();*/

    while (true) {
        System.out.println("Move Color, x,y");
        col = input.nextInt();
        x = input.nextInt();
        y = input.nextInt();
        if (x > 7 || x < 0 || y > 7 || y < 0) {
            System.out.println("X and Y must be [0-7]");
            return;
        }
        field.move(field.checkMove(Field.fromInt(col),x,y),x,y);
        field.drawField();
    }


}
}
