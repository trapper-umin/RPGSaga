import java.util.Scanner;

public class RPGSaga {
    public static void main(String[] args){
        Scanner keyboard=new Scanner(System.in);
        Process process=new Process();
        boolean flag=true;
        String flagChar;
        process.game();
        while (flag){
            System.out.print("Do you want to play more [y]/[n]: ");
            flagChar = keyboard.next();
            switch (flagChar) {
                case "y" -> process.game();
                case "n" -> flag=false;
            }
        }
    }
}
