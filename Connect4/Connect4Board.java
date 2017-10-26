public class Connect4Board
{
    private int[][] board;
    private int player;//whose turn it currently is, human is 1
    private int state = 0;//-1 = draw, 1 = won by 1, 2 means won by 2
    private int width;
    private int height;
    
    public static final int MIN_SIZE = 4;
    public static final int MAX_SIZE = 9;
    
    public Connect4Board()
    {
        width = 7;
        height = 6;
        board = new int[width][height];
        player = 1;
    }
    public Connect4Board(Connect4Board b)
    {
        width = b.width();
        height = b.height();
        board = new int[width][height];
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                board[i][j] = b.get(i,j);
            }
        }
        player = b.player();
        state = b.state();
    }
    public Connect4Board(int w, int h, boolean b)
    {
        if(w >= MIN_SIZE && h >= MIN_SIZE && w <= MAX_SIZE && h <= MAX_SIZE)
        {
            width = w;
            height = h;
        }
        else
        {
            width = 4;
            height = 4;
        }
        board = new int[width][height];
        if(b == true){player = 1;}
        else{player = 2;}
    }
    public int width(){return width;}
    public int height(){return height;}
    public int player(){return player;}
    public int state(){return state;}
    public int get(int x, int y){return board[x][y];}
    public void set(int x, int y, int n)
    {
        if(x >= 0 && y >= 0 && x < board.length && y < board.length)
        {
            board[x][y] = n;
        }
    }
    public int getState(){return state;}
    public void setState(int x)
    {
        if(x >= -1 && x <= 2)
        {
            state = x;
        }
    }
    public void takeTurns()
    {
        if(player == 1){player = 2;}
        else{player = 1;}
    }
}