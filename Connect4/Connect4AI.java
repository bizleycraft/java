import java.util.ArrayList;

public class Connect4AI
{
    private Connect4Game game = new Connect4Game();
    private int choice;
    private int difficulty;
    
    public static final int MAX_DIFFICULTY = 6;
    
    public Connect4AI(int d)
    {
        if(d >= 1 && d <= MAX_DIFFICULTY){difficulty = d;}
        else{difficulty = 1;}
    }
    
    public int makeMove(Connect4Board board)
    {
        miniMax(new Connect4Board(board),0);
        return choice;
    }
    private int miniMax(Connect4Board board, int depth)
    {
        if (board.getState() != 0 || depth > difficulty){return score(board,depth);}
        depth += 1;
        ArrayList<Integer> moves = new ArrayList<Integer>();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        
        for(int i = 1; i <= board.width(); i++)
        {
            if(game.canDrop(board,i) != -1)
            {
                Connect4Board b = new Connect4Board(board);
                game.dropPiece(b,i);
                scores.add(miniMax(b,depth));
                moves.add(i);
            }
        }
        int index;
        if(board.player() == 1){index = max(scores);}
        else{index = min(scores);}
        choice = moves.get(index);
        return scores.get(index);
    }
    private int max(ArrayList<Integer> array)
    {
        int ideal = 0;
        for(int i = 1; i < array.size(); i++)
        {
            if(array.get(i) > array.get(ideal))
            {
                ideal = i;
            }
        }
        return ideal;
    }
    private int min(ArrayList<Integer> array)
    {
        int ideal = 0;
        for(int i = 1; i < array.size(); i++)
        {
            if(array.get(i) < array.get(ideal))
            {
                ideal = i;
            }
        }
        return ideal;
    }
    private int score(Connect4Board board, int depth)
    {
        if(board.getState() == 1){return 10 - depth;}
        else if(board.getState() == 2){return depth - 10;}
        else{return 0;}
    }
}