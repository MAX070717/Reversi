<<<<<<< HEAD
/**
 * Created by Максим on 13.02.2015.
=======
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Максим on 03.02.2015.
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
 */
public class Square {
    public enum StatusType {WHITE, BLACK, EMPTY}

    private int x;
    private int y;

    /*@Getter @Setter*/
    private StatusType status = StatusType.EMPTY;


    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public void setStatus(StatusType newStatus) {
        this.status = newStatus;
    }

    public StatusType getStatus() {return this.status;}

<<<<<<< HEAD
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
=======

>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32

    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

<<<<<<< HEAD
    public Square() {}
=======
>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
    //инвертирует цвет
    public static StatusType invertStatus(StatusType status)
    {
        return (status == StatusType.EMPTY ? StatusType.EMPTY : (status == StatusType.BLACK ? StatusType.WHITE : StatusType.BLACK));
    }


    public static StatusType fromInt(int st)
    {
        switch (st)
        {
            case 0: return StatusType.EMPTY;
            case 1: return StatusType.WHITE;
            case 2: return StatusType.BLACK;
        }
        return StatusType.EMPTY;
    }
<<<<<<< HEAD
=======


>>>>>>> 8df33d5ad4b7fe3a02319568e477f71060351c32
}
