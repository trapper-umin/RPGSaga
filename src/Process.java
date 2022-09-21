import java.util.Random;
import java.util.Scanner;

public class Process {
    Scanner keyboard=new Scanner(System.in);
    Random random=new Random();
    private static final float PERCENTAGE_OF_HEALTH_POINT=0.05f;

    public void game(){
        int numberOfPlayers,warriorNumber;

        do {

            System.out.print("Enter the number of players: ");
            numberOfPlayers =keyboard.nextInt();

        }while (!(numberOfPlayers %2==0));

        Warrior[] warriors=new Warrior[numberOfPlayers];

        for (int i = 0; i<numberOfPlayers; i++){
            warriorNumber=random.nextInt(3);
            switch (warriorNumber) {
                case 0 -> {
                    warriors[i] = new Knight();
                    randomHealthPoint(warriors, i);
                    randomDamage(warriors, i);
                    randomTitle(warriors, i, warriorNumber);
                }
                case 1 -> {
                    warriors[i] = new Archer();
                    randomHealthPoint(warriors, i);
                    randomDamage(warriors, i);
                    randomTitle(warriors, i, warriorNumber);
                }
                case 2 -> {
                    warriors[i] = new Wizard();
                    randomHealthPoint(warriors, i);
                    randomDamage(warriors, i);
                    randomTitle(warriors, i, warriorNumber);
                }
            }
        }

        for (int i=0;i<warriors.length;i++){
            System.out.printf("Type: %s\nHP: %d\nDamage: %d\n\n",warriors[i].getType(),warriors[i].getHealthPoint(),warriors[i].getDamage());
        }
    }

    private void randomHealthPoint(Warrior[] warriors, int i){
        warriors[i].setHealthPoint(random.nextInt(1000));
    }
    private void randomDamage(Warrior[] warriors,int i){
        warriors[i].setDamage(Math.round(warriors[i].getHealthPoint()*PERCENTAGE_OF_HEALTH_POINT));
    }
    private void randomTitle(Warrior[] warriors,int i,int warriorNumber){
        int nameID=random.nextInt(155+1);
        switch (warriorNumber){
            case 0 -> warriors[i].setType("Knight");
            case 1 -> warriors[i].setType("Archer");
            case 2 -> warriors[i].setType("Wizard");
        }
    }
}
