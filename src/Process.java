import warriors.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
        //вывод всех воинов
        for (int i=0;i<warriors.length;i++){
            System.out.printf("Type: %s\nHP: %d\nDamage: %d\nSkill: %s\n\n",warriors[i].getType(),warriors[i].getHealthPoint(),warriors[i].getDamage(),warriors[i].getSkill());
        }

        List<Warrior> warriorsCollection=new ArrayList<>();
        int counter=0;

        for (int i=0;i<warriors.length-1;i=i+2){

            while (true){
                counter+=1;
                //удар первого воина по второму
                warriors[i+1].setHealthPoint(warriors[i+1].getHealthPoint()-warriors[i].getDamage());
                if(warriors[i+1].getHealthPoint()<=0){
                    warriors[i+1].setHealthPoint(0);
                    System.out.printf("%s inflicted "+warriors[i].getDamage()+" damage and %s left "+warriors[i+1].getHealthPoint()+" HP\n",warriors[i].getType(),warriors[i+1].getType());
                    System.out.printf("%s WIN IN %d ROUND\n",warriors[i].getType(),counter);
                    System.out.println();
                    warriorsCollection.add(warriors[i]);
                    break;
                }else System.out.printf("%s inflicted "+warriors[i].getDamage()+" damage and %s left "+warriors[i+1].getHealthPoint()+" HP\n",warriors[i].getType(),warriors[i+1].getType());
                //удар второго воина по первому
                warriors[i].setHealthPoint(warriors[i].getHealthPoint()-warriors[i+1].getDamage());
                if(warriors[i].getHealthPoint()<=0){
                    warriors[i].setHealthPoint(0);
                    System.out.printf("%s inflicted "+warriors[i+1].getDamage()+" damage and %s left "+warriors[i].getHealthPoint()+" HP\n",warriors[i+1].getType(),warriors[i].getType());
                    System.out.printf("%s WIN IN %d ROUND\n",warriors[i+1].getType(),counter);
                    System.out.println();
                    warriorsCollection.add(warriors[i+1]);
                    break;
                }else System.out.printf("%s inflicted "+warriors[i+1].getDamage()+" damage and %s left "+warriors[i].getHealthPoint()+" HP\n",warriors[i+1].getType(),warriors[i].getType());
                System.out.println();
            }





        }
        System.out.println(warriorsCollection.get(0).getHealthPoint());

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
                warriors[i].setType("Knight"+" "+file.nextLine());
            }
            case 1 -> {
                generateWarriorName(file);
                warriors[i].setType("Archer"+" "+file.nextLine());
            }
            case 2 -> {
                generateWarriorName(file);
                warriors[i].setType("Wizard"+" "+file.nextLine());
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
