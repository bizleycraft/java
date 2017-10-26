/*
 * Debug-beautifying class by Joshua Bizley
 * October 26th, 2017
 */
public class BizleyTest
{
    private BizleyTest(){}
    public static void test(String s)
    {
        System.out.println(HAMMER[0]);
        System.out.println(HAMMER[1]);
        System.out.println(HAMMER[2]);
        System.out.print(HAMMER[3]);
        System.out.println(" Testing " + s);
        System.out.println(HAMMER[4]);
    }
    public static void print(String s)
    {
        int r = (int)(Math.random() * BUTTERFLIES.length);
        System.out.println(BUTTERFLIES[r][0]);
        System.out.println(BUTTERFLIES[r][1]);
        System.out.print(BUTTERFLIES[r][2]);
        System.out.println(" " + s);
        System.out.println(BUTTERFLIES[r][3]);
    }
    public static void success()
    {
        for(String s : SUCCESS){System.out.println(s);}
    }
    public static void end()
    {
        System.out.println("\nCredits:");
        System.out.println("ascii-art.de/ascii/ab/butterfly.txt");
        System.out.println("success.ascii.uk");
        System.out.println("ascii-art.de/ascii/ghi/hammer.txt");
    }
    //Source: http://www.ascii-art.de/ascii/ghi/hammer.txt
    public static String[] HAMMER = {"  ,",
                                       " /(  ___________",
                                       "|  >:===========`",
                                       " )(",
                                       " \"\""};
    //Source: http://success.ascii.uk/
    public static String[] SUCCESS = {" ___ _   _  ___ ___ ___  ___ ___ ",
                                       "/ __| | | |/ __/ __/ _ \\/ __/ __|",
                                       "\\__ \\ |_| | (_| (_|  __/\\__ \\__ \\",
                                       "|___/\\__,_|\\___\\___\\___||___/___/"};
    //Source: http://www.ascii-art.de/ascii/ab/butterfly.txt
    public static String[][] BUTTERFLIES = {{" __   __",
                                             "(  \\,/  )",
                                             " \\_ | _/",
                                             " (_/ \\_)"},
                                            {" ___   ___",
                                             "( @ \\Y/ @ )",
                                             " \\__+|+__/",
                                             "  {_/ \\_}"},
                                            {" ___   ___",
                                             "((o)\\,/(o))",
                                             " \\__ | __/",
                                             "  {_/'\\_}"},
                                            {" ___   ___",
                                             "( @ \\v/ m )",
                                             " \\__+|+__/",
                                             "  {_/ \\_}"},
                                            {" ___   ___",
                                             "{ ~ \\,/ ~ }",
                                             " \\_~_|_~_/",
                                             "  (_/'\\_)"},
                                            {" __   __",
                                             "(()\\,/  )",
                                             " \\_ | _/",
                                             " { /'\\*}"},
                                            {" __ Y __",
                                             "(()\\o/())",
                                             " \\_ I _/",
                                             "  (/I\\)"},
                                            {"  __   __",
                                             "( s \\Y/ s )",
                                             " \\_<>|<>_/",
                                             "  (_/'\\_)"},
                                            {" ___   ___",
                                             "( q \\,/ p )",
                                             " \\_ 6|9 _/",
                                             "  {_/ \\_} "}};
}