import java.util.Random;
import java.util.Scanner;

public class Process {
    Scanner keyboard=new Scanner(System.in);
    Random random=new Random();

    public void game(){
        int numberOfPlayers,warriorNumber;

        do {

            System.out.print("Enter the number of players: ");
            numberOfPlayers =keyboard.nextInt();

        }while (numberOfPlayers %2==0);

        Warrior[] warriors=new Warrior[numberOfPlayers];

        for (int i = 0; i<numberOfPlayers; i++){
            warriorNumber=random.nextInt(3);
            switch (warriorNumber) {
                case 0 -> {
                    warriors[i] = new Knight();
                    warriors[i].setHealthPoint(random.nextInt(1000 + 1));
                    warriors[i].setDamage(random.nextInt(100 + 1));
                    warriors[i].setType("Knight");
                }
                case 1 -> warriors[i] = new Archer(random.nextInt(1000), random.nextInt(100 + 1), "Archer");
                case 2 -> warriors[i] = new Wizard(random.nextInt(1000), random.nextInt(100 + 1), "Wizard");
            }
        }


    }
}
