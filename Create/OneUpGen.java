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

    /**
     * randomly places walls on the board in a way that it's still solveable
     * 
     * @param qty number of wall pairs (for each vertical wall there's a horizontal wall)
     */
    public void placeWalls(int qty) {
        Cell[][] testBoard = currBoard.clone();
        int cnt = 0;
        while (cnt < qty) {
            //place random vertical wall
            int vRow;
            int vCol;
            do{
                int vWall = (int) (Math.random() * (size * (size-1)));
                vRow = vWall / size;
                vCol = vWall % (size-1); //dont place wall on edges
            }while(testBoard[vRow][vCol].wr()); //check if wall already exists
            testBoard[vRow][vCol].wr(true);

            //place random horizontal wall
            int hRow;
            int hCol;
            do{
                if (Math.random()<0.5){ //has to divide the section into same size as its pair (theory untested for more than 1 wall per row/col)
                    hRow = vCol;
                }else{
                    hRow = size-vCol-2; //-2 cuz size-1 & indexation
                }
                hCol = (int) (Math.random() * size);
            }while(testBoard[hRow][hCol].wd()); //check if wall already exists
            testBoard[hRow][hCol].wd(true);

            //check if possible or go back
            if (isSolvable(testBoard)){
                currBoard[vRow][vCol].wr(true);
                currBoard[hRow][hCol].wd(true);
            }else{ //go back
                testBoard[vRow][vCol].wr(false);
                testBoard[hRow][hCol].wd(false);
                cnt--;
            }
            cnt++;
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
        //what if i fill every cell with a list of possible values according to rules and then check the possibilities?
    }


    //secondary methods
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Cell[] r:currBoard){
            //to represent numbers and row walls
            for (Cell c:r){
                if (c.wr()){
                    sb.append(c.num()+"|");
                }else{
                    sb.append(c.num()+" ");
                }
            }
            sb.append("\n");

            //to represent col walls
            for (Cell c2:r){
                if (c2.wd()){
                    sb.append("- ");
                }else{
                    sb.append("  ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
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