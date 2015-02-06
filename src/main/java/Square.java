import lombok.Getter;
import lombok.Setter;

/**
 * Created by Максим on 03.02.2015.
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



    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

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


}
