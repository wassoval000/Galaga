public class Screens {

    public static boolean end = false;
    public static boolean game = false;
    public static boolean start = true;
    public static boolean lose = false;

    public Screens(){

    }

    public static boolean isLose(){
        return lose;
    }

    public static void lose(){
        lose = true;
        end = false;
        game = false;
        start = false;
    }

    public static boolean isGame(){
        return game;
    }

    public static void game(){
        game = true;
        start = false;
        end = false;
    }

    public static boolean isStart(){
        return start;
    }

    public static void start(){
        start = true;
        game = false;
        end = false;
    }

    public static boolean isEnd(){
        return end;
    }

    public static void end(){

        end = true;
        game = false;
        start = false;

    }

}
