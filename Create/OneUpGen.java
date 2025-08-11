package Create;

public class OneUpGen {
    
    private int size;
    private int[][] origBoard;
    private int[][] currBoard;
    private boolean[][] rowWalls; //if cell has wall to its right
    private boolean[][] colWalls; //if cell has wall below
    private int[][] moves;

    public OneUpGen (int size) {
        this(size, 10);
    }

    public OneUpGen (int size, int wallQty){
        this.size = size;
        origBoard = new int[size][size];
        currBoard = new int[size][size];
        rowWalls = new boolean[size][size-1];
        colWalls = new boolean[size][size-1];
        placeWalls(wallQty);
    }

    public void placeWalls(int qty){
        for (int i = 0; i < qty; i++) {
            if (Math.random() < 0.5){
                rowWalls[(int) Math.random()*size][(int) Math.random()*(size-1)] = true;
            }
            else {
                colWalls[(int) Math.random()*size][(int) Math.random()*(size-1)] = true;
            }
        }
    }

    public String toString(){
        int[][] b = currBoard;
        boolean[][] rw = rowWalls;
        boolean[][] cw = colWalls;
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<size; r++){
            for (int c=0; c<size; c++){
                sb.append(b[r][c]);
                if (r<size-1 && rw[r][c]){
                    sb.append("|");
                }
                else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            for (boolean w:cw[r]){
                if (w){
                    sb.append(" —");
                }
                else{
                    sb.append("  ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}