import warriors.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Process {
    Scanner keyboard=new Scanner(System.in);
    Random random=new Random();
    private static final float PERCENTAGE_OF_HEALTH_POINT=0.05f;
    private static final int NUMBER_OF_NAMES=155;

    public void game() throws FileNotFoundException {
        int numberOfPlayers,warriorNumber;

        do {

            System.out.print("Enter the number of players: ");
            numberOfPlayers =keyboard.nextInt();

        }while (!(numberOfPlayers %2==0));
        System.out.print("\n");

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
            System.out.printf("Type: %s\nHP: %d\nDamage: %d\nSkill: %s\n\n",warriors[i].getType(),warriors[i].getHealthPoint(),warriors[i].getDamage(),warriors[i].getSkill());
        }

        for (int i=0;i<warriors.length-1;i=i+2){
            warriors[i+1].setHealthPoint(warriors[i+1].getHealthPoint()-warriors[i].getDamage());
            System.out.print(warriors[i+1].getHealthPoint()+"\n");




        }


    }

    private void randomHealthPoint(Warrior[] warriors, int i){
        warriors[i].setHealthPoint(random.nextInt(1000));
    }
    private void randomDamage(Warrior[] warriors,int i){
        warriors[i].setDamage(Math.round(warriors[i].getHealthPoint()*PERCENTAGE_OF_HEALTH_POINT));
    }
    private void randomTitle(Warrior[] warriors,int i,int warriorNumber) throws FileNotFoundException {
        Scanner file=new Scanner(new File("names.txt"));
        switch (warriorNumber){
            case 0 -> {
                generateWarriorName(file);
                warriors[i].setType("warriors.Knight"+" "+file.nextLine());
            }
            case 1 -> {
                generateWarriorName(file);
                warriors[i].setType("warriors.Archer"+" "+file.nextLine());
            }
            case 2 -> {
                generateWarriorName(file);
                warriors[i].setType("warriors.Wizard"+" "+file.nextLine());
            }
        }
    }
    private void generateWarriorName(Scanner file){
        int flag=random.nextInt(NUMBER_OF_NAMES+1);
        for (int i=0;i<flag;i++){
            file.nextLine();
        }
    }

}
