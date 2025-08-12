package Create;
//abcdefghijklmnopqrstuvwxyz
//ABCDEFGHIJKLMNOPQRSTUVWXYZ
public class OneUpGen {
    
    private int size;
    private Cell[][] origBoard;
    private Cell[][] currBoard;
    private int[][] moves; //list of moves done (each move is a list of 3 values): 0=row, 1=col, 2=move


    //constructors
    public OneUpGen (int size) {
        this(size, 10);
    }

    public OneUpGen (int size, int wallQty){
        this.size = size;
        origBoard = new Cell[size][size];
        currBoard = new Cell[size][size];
        placeWalls(wallQty);
    }

    //important methods
    public void placeWalls(int qty) {
        for (int i = 0; i < qty; i++) {
            int rnd = (int) (Math.random() * (size * size));
            int row = rnd / size;
            int col = rnd % size;

            if (Math.random() < 0.5) {
                if (col < size - 1) {
                    currBoard[row][col].wr(true);
                    if (isSolvable(currBoard)) {
                        origBoard[row][col].wr(true);
                    } else {
                        currBoard[row][col].wr(false); // undo
                        i--;
                    }
                } else {
                    i--;
                }
            } else {
                if (row < size - 1) {
                    currBoard[row][col].wd(true);
                    if (isSolvable(currBoard)) {
                        origBoard[row][col].wd(true);
                    } else {
                        currBoard[row][col].wd(false); // undo
                        i--;
                    }
                } else {
                    i--;
                }
            }
        }
    }

    public Cell[][] addWalls(Cell[][] board, int row, int col, boolean right, boolean down){
        if(right){
            board[row][col].wr(true);
        }
        if(down){
            board[row][col].wd(true);
        }
        return board;
    }

    public boolean isSolvable(Cell[][] board){
        return true; //TODO
    }


    //secondary methods
    /*public String toString(){
        int[][] b = currBoard;
        boolean[][] rw = rowWalls;
        boolean[][] cw = colWalls;
        StringBuilder sb = new StringBuilder();

        for (int r=0; r<size; r++){
            for (int c=0; c<size; c++){
                //input value
                sb.append(b[r][c]);
                //input wall on right or not
                if (r<size-1 && rw[r][c]){
                    sb.append("|");
                }
                else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            //input space between rows
            if (r<size-1){
                for (boolean w:cw[r]){
                    //input wall on bottom or not
                    if (w){
                        sb.append(" —");
                    }
                    else{
                        sb.append("  ");
                    }
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }*/
}