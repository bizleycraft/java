public class Connect4Referee
{
    Connect4Game c4;
    Connect4Board c4B;
    Connect4AI c4AI;
    
    public Connect4Referee(){configure();}
    public void startGame()
    {
        System.out.println("\nConnect 4 Application booting up...");
        while(true)
        {
            c4.drawBoard(c4B);
            if (c4B.getState() == 0){continueGame();}
            else
            {
                switch(c4B.getState())
                {
                    case 1: System.out.println("You won!"); break;
                    case 2: System.out.println("You lost!"); break;
                    default: System.out.println("There is no winner.");
                }
                endGame();
            }
        }
    }
    private void continueGame()
    {
        if(c4B.player() == 1)
        {
            System.out.println("Choose a column to drop a piece in.");
            int x; int y;
            while(true)
            {
                x = getIntInRange(1,c4B.width());
                y = c4.canDrop(c4B,x);
                if(y != -1){c4.dropPiece(c4B,x); break;}
                else{System.out.println("Try again.");}
            }
        }
        else
        {
            System.out.print("Calculating...");
            c4.dropPiece(c4B,c4AI.makeMove(c4B));
            System.out.println();
        }
    }
    private void endGame()
    {
        System.out.println("Do you want to continue playing?");
        Boolean b = getBoolean();
        if(b == false){System.exit(1);}
        System.out.println("Would you like to change the settings for the next game? (y/n)");
        b = getBoolean();
        if(b == true){configure();}
        else{c4.reset(c4B);}
    }
    private void configure()
    {
        System.out.println("How wide should the board be? (4-9)");
        int w = getIntInRange(Connect4Board.MIN_SIZE,Connect4Board.MAX_SIZE);
        System.out.println("How tall should the board be? (4-9)");
        int h = getIntInRange(Connect4Board.MIN_SIZE,Connect4Board.MAX_SIZE);
        System.out.println("Do you want to go first? (y/n)");
        boolean f = getBoolean();
        System.out.println("Please type the letter or symbol for your pieces...");
        char a = getChar();
        System.out.println("Please type the letter or symbol for the AI's pieces...");
        char b = getChar();
        System.out.println("How many turns ahead should the AI be able to calculate? (1-6)");
        int d = getIntInRange(1,Connect4AI.MAX_DIFFICULTY);
        System.out.println("Starting game now...\n");
        c4 = new Connect4Game(new char[] {a,b});
        c4B = new Connect4Board(w,h,f);
        c4AI = new Connect4AI(d);
    }
    private char getChar()
    {
        String s = IO.getUserInput(">>");
        while(true)
        {
            if(s.length() > 0){return s.charAt(0);}
            else{s = IO.getUserInput(">Try again>");}
        }
    }
    private boolean getBoolean()
    {
        String s = IO.getUserInput(">>");
        while(true)
        {
            if(s.length() > 0 && s.charAt(0) == 'y'){return true;}
            else if(s.length() > 0 && s.charAt(0) == 'n'){return false;}
            else{s = IO.getUserInput(">Try again>");}
        }
    }
    private int getIntInRange(int min, int max)
    {
        int i;
        String s = IO.getUserInput(">>");
        while(true)
        {
            try
            {
                i = Integer.parseInt(s);
                if(i >= min && i <= max){break;}
                else{s = IO.getUserInput(">Try again>");}
            }
            catch(Exception e){s = IO.getUserInput(">Try again>");}
        }
        return i;
    }
}