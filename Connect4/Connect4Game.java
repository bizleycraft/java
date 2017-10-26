public class Connect4Game
{
    private char[] pieces = {'O','X'};
    static final char EDGE = '|';
    static final char RAIL = '-';
    
    public Connect4Game(){pieces = new char[] {'O','X'};}
    public Connect4Game(char[] p){pieces = p;}
    public void dropPiece(Connect4Board board, int column)
    {
        for(int i = 0; i < board.height(); i++)
        {
            if(board.get(column-1,i) == 0)
            {
                board.set(column-1,i,board.player()); break;
            }
        }
        checkWin(board);
        board.takeTurns();
    }
    public int canDrop(Connect4Board board, int column)
    {
        //check that the column and player are within range
        int droppable = -1;
        if(column > 0 && column <= board.width())
        {
            int i = 0;
            while(droppable == -1 && i < board.height())
            {
                if(board.get(column-1,i) == 0)
                {
                    droppable = i;
                }
                i++;
            }
        }
        return droppable;
    }
    public void reset(Connect4Board board)
    {
        board.setState(0);
        for(int i = 0; i < board.width(); i++)
        {
            for(int j = 0; j < board.height(); j++)
            {
                board.set(i,j,0);
            }
        }
    }
    private void checkWin(Connect4Board board)
    {
        boolean emptySpaces = false;
        for(int i = 0; i < board.width(); i++)
        {
            for(int j = 0; j < board.height(); j++)
            {
                if(board.get(i,j) != 0)
                {
                    findRowOf4(board,i,j);
                }
                else
                {
                    emptySpaces = true;
                }
            }
        }
        //if there are no empty spaces and no win, the game is drawn
        if(!emptySpaces && board.getState() == 0){board.setState(-1);}
    }
    private void findRowOf4(Connect4Board board, int x, int y)
    {
        int player = board.get(x,y);
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if (i != 0 || j != 0)
                {
                    if(maxInARow(board,x,y,i,j,player,1) >= 4)
                    {
                        //the current player has won the game
                        board.setState(player); 
                        return;
                    };
                }
            }
        }
    }
    private int maxInARow(Connect4Board board, int x,int y, int hori,int vert, int player, int inARow)
    {
        x+=hori;
        y+=vert;
        //if the new coordinates are off the game board
        if(x < 0 || y < 0 || x >= board.width() || y >= board.height()){return inARow;}
        //if you find another of the same player's pieces, keep looking
        if(board.get(x,y) == player){return maxInARow(board,x,y,hori,vert,player,inARow+1);}
        return inARow;
    }
    public void drawBoard(Connect4Board board)
    {
        System.out.println();
        printBoardWidth(board.width());
        for(int i = board.height() - 1; i >= 0; i--)
        {
            System.out.print(EDGE);
            for(int j = 0; j < board.width(); j++)
            {
                printPiece(board.get(j,i));
                printMidRails(board.width(),j);
            }
            System.out.println(EDGE);
        }
        printBoardWidth(board.width());
        System.out.print(EDGE);
        for(int i = 0; i < board.width(); i++)
        {
            System.out.print(i+1);
            printMidRails(board.width(),i);
        }
        System.out.println(EDGE);
        printBoardWidth(board.width());
    }
    private void printBoardWidth(int width)
    {
        System.out.print(EDGE);
        for(int i = 0; i < (width * 2) - 1; i++){System.out.print(RAIL);}
        System.out.println(EDGE);
    }
    private void printPiece(int piece)
    {
        switch(piece)
        {
            case 1: System.out.print(pieces[0]); break;
            case 2: System.out.print(pieces[1]); break;
            default: System.out.print(" ");
        }
    }
    private void printMidRails(int width, int i)
    {
    if(i < width - 1)
        {
            System.out.print(EDGE);
        }
    }
}