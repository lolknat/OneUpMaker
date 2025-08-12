package Create;

public class Cell {
    
    private int number; //0 = empty
    private boolean wallRight; //wall right of this cell
    private boolean wallDown; //wall below this cell

    public Cell(){
        this(0);
    }

    public Cell(int n){
        number = n;
        wallRight = false;
        wallDown = false;
    }

    public int num(){
        return number;
    }
    public void num(int n){
        number = n;
    }

    public boolean wr(){
        return wallRight;
    }

    public void wr(boolean wr){
        wallRight = wr;
    }

    public boolean wd(){
        return wallDown;
    }

    public void wd(boolean wd){
        wallDown = wd;
    }
}
