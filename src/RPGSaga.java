import java.io.FileNotFoundException;
import java.util.Scanner;

public class RPGSaga {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard=new Scanner(System.in);
        Process process=new Process();
        boolean flag=true;
        String flagChar;
        do{
            process.game();
            System.out.print("Do you want to play more [y]/[n]: ");
            flagChar=keyboard.next();
            switch (flagChar){
                case "y" -> flag=true;
                case "n" -> flag=false;
            }
        }while (flag);
    }
}
