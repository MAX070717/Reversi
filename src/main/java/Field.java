<<<<<<< HEAD
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

=======
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 * Created by Максим on 13.02.2015.
=======
 * Created by Максим on 03.02.2015.
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
 */
public class Field {
    private Square field[][] = new Square[8][8];
    public Square [] [] getField() {return this.field;}
    public void setField(Square [] []field) {this.field = field;}


<<<<<<< HEAD


=======
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
    public Field() {
        field = new Square[8][8];
        initField();
    }


    public static Square.StatusType fromInt(int st)
    {
        switch (st)
        {
            case 0: return Square.StatusType.EMPTY;
            case 1: return Square.StatusType.WHITE;
            case 2: return Square.StatusType.BLACK;
        }
        return Square.StatusType.EMPTY;
    }

    public boolean internalFiltr(Square.StatusType col, int x, int y,  ArrayList<Square> list)
    {

        Square.StatusType myColor = col;
        System.out.println("MyColor = "+myColor);
        Square.StatusType enemyColor=Square.invertStatus(myColor);
        System.out.println("Enemy = "+enemyColor);

        if (field[x][y].getStatus() == myColor)
<<<<<<< HEAD
        {
            return false;
        }

        if (field[x][y].getStatus() == enemyColor) {
            list.add(field[x][y]);
        }

        if (field[x][y].getStatus() == Square.StatusType.EMPTY) {
            list.clear();
=======
        {/*
            System.out.println("[" + i + "," + j + "].st=" + field[i][j].getStatus());
            System.out.println("In Right way same color");
            System.out.println("");
           */
            //break;
            return false;

        }



        if (field[x][y].getStatus() == enemyColor) {
            list.add(field[x][y]);
            /*System.out.println("[" + i + "," + j + "].st=" + field[i][j].getStatus());
            System.out.println("In Right way enemy- in list");
            System.out.println("");*/
        }

        if (field[x][y].getStatus() == Square.StatusType.EMPTY) {
            /*System.out.println("[" + i + "," + j + "].st=" + field[i][j].getStatus());
            System.out.println("In Right way empty- clear list Right");
            System.out.println("");*/
            list.clear();
            //break;
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
            return false;
        }
        return true;
    }





<<<<<<< HEAD
    public List<Square> checkMove(Square.StatusType col, int x, int y)
=======
    public  List<Square> checkMove(Square.StatusType col, int x, int y)
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
    {
        List<Square> right, left, down, up, mddown, mdup, sddown, sdup;

        right =new ArrayList<Square>();
        left =new ArrayList<Square>();
        down =new ArrayList<Square>();
        up =new ArrayList<Square>();
        mddown =new ArrayList<Square>();
        mdup =new ArrayList<Square>();
        sddown =new ArrayList<Square>();
        sdup= new ArrayList<Square>();

        //initial params
        int i = x; int j = y;

        Square.StatusType myColor = col;
        System.out.println("MyColor = "+myColor);
        Square.StatusType enemyColor=Square.invertStatus(myColor);
        System.out.println("Enemy = "+enemyColor);


        //move right
        for (i = x + 1, j=y; i < 8; i++)
            if (!internalFiltr(col,i,j, (ArrayList<Square>) right)) break;
        //move left
        for (i = x - 1 , j = y; i >= 0; i--)
            if (!internalFiltr(col,i,j,(ArrayList<Square>) left)) break;
        //move down
        for (j = y + 1, i = x; j < 8; j++)
            if (!internalFiltr(col,i,j, (ArrayList<Square>) down)) break;
        //move up
        for (j = y - 1, i = x; j >= 0; j--)
            if (!internalFiltr(col,i,j, (ArrayList<Square>) up)) break;

        //move main diagonal down
        for (i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++)
            if (!internalFiltr(col,i,j, (ArrayList<Square>) mddown)) break;
        //move main diagonal up
        for (i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--)
            if (!internalFiltr(col,i,j, (ArrayList<Square>) mdup)) break;
        //move SecoD diagonal down
        for (i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++)
<<<<<<< HEAD
            if (!internalFiltr(col,i,j, (ArrayList<Square>) sddown)) break;
=======
           if (!internalFiltr(col,i,j, (ArrayList<Square>) sddown)) break;
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
        //move SecoD diagonal up
        for (i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--)
            if (!internalFiltr(col,i,j, (ArrayList<Square>) sdup)) break;



        System.out.println();
        ArrayList<Square> result = new ArrayList<Square>();

        result.addAll(right);
        result.addAll(left);

        result.addAll(down);
        result.addAll(up);

        result.addAll(mddown);
        result.addAll(mdup);

        result.addAll(sddown);
        result.addAll(sdup);

        System.out.println(result);
        return result;
    }


    public boolean move(List<Square> toBeat, int x, int y)
    {
        if (toBeat.isEmpty()) return false;
        for (Square enemySquare : toBeat)
            enemySquare.setStatus(Square.invertStatus(enemySquare.getStatus()));
        field[x][y].setStatus(toBeat.get(0).getStatus());
        return true;
    }


<<<<<<< HEAD

    public Circle createCircle(int col)
    {
        Circle circle = new Circle();
        //circle.setLayoutX(26.0f);
        //circle.setLayoutY(21.0f);
        // circle.setLayoutX(x);
        //circle.setLayoutY(y);
        circle.setRadius(18.0f);
        circle.setStrokeType(StrokeType.INSIDE);
        if (col==2) {
            circle.setFill(Color.BLACK);}
        if (col==1) {
            circle.setFill(Color.GRAY);}

        return circle;

    }

    public  void drawFieldWin (Square [][]field, GridPane gp)
    {
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                switch (field[i][j].getStatus()) {
                    case EMPTY:
                        break;
                    case WHITE:
                        gp.add(createCircle(1), i, j);
                        break;
                    case BLACK:
                        gp.add(createCircle(2), i, j);
                        break;
                }
            }
            System.out.println();
        }
    }


=======
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
    public void drawField (/*Square [][]field*/)
    {
        System.out.println("FIELD:");
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                switch (field[i][j].getStatus()) {
                    case EMPTY:
                        System.out.print("~ ");
                        break;
                    case WHITE:
                        System.out.print("O ");
                        break;
                    case BLACK:
                        System.out.print("@ ");
                        break;
                }
            }
            System.out.println();
        }
    }

    public void initField()
    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j] = new Square(i, j);
            }
        }
        field[3][3].setStatus(Square.StatusType.WHITE);
        field[4][4].setStatus(Square.StatusType.WHITE);
        field[4][3].setStatus(Square.StatusType.BLACK);
        field[3][4].setStatus(Square.StatusType.BLACK);

        drawField ();
        System.out.println("field is created suxesfully");
    }

<<<<<<< HEAD
=======

>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
}
