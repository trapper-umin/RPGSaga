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
    private static final int NUMBER_OF_NAMES=154;

    public void game() throws FileNotFoundException {
        int numberOfWarriors,warriorNumber;

        do {

            System.out.print("Enter the number of players: ");
            numberOfWarriors =keyboard.nextInt();

        }while (!(numberOfWarriors %2==0));
        System.out.print("\n");

        List<Warrior> warriors=new ArrayList<>();
        List<String>hashCodeIndex=new ArrayList<>();

        for (int i = 0; i<numberOfWarriors; i++){
            warriorNumber=random.nextInt(3);
            switch (warriorNumber) {
                case 0 -> {
                    //создание воина с помощью колекции
                    warriors.add(new Knight());
                    randomHealthPoint(warriors,i);
                    randomDamage(warriors,i);
                    randomTitle(warriors,i,warriorNumber);
                }
                case 1 -> {
                    warriors.add(new Archer());
                    randomHealthPoint(warriors,i);
                    randomDamage(warriors,i);
                    randomTitle(warriors,i,warriorNumber);
                }
                case 2 -> {
                    warriors.add(new Wizard());
                    randomHealthPoint(warriors,i);
                    randomDamage(warriors,i);
                    randomTitle(warriors,i,warriorNumber);
                }
            }
        }
        //вывод всех воинов
        for (int i=0;i<warriors.size();i++){
            System.out.printf("Type: %s\nHP: %d\nDamage: %d\nSkill: %s\n\n",warriors.get(i).getType(),warriors.get(i).getHealthPoint(),warriors.get(i).getDamage(),warriors.get(i).getSkill());
        }


        int counter=0,flag=0;
        int warriorsSize=warriors.size();

        for (int i=0;i<warriorsSize-1;i=i+2){

            while (true){
                counter+=1;

                //удар первого воина по второму
                warriors.get(i+1).setHealthPoint(warriors.get(i+1).getHealthPoint()-warriors.get(i).getDamage());
                if(warriors.get(i+1).getHealthPoint()<=0){
                    warriors.get(i+1).setHealthPoint(0);
                    System.out.printf("%s inflicted "+warriors.get(i).getDamage()+" damage and %s left "+warriors.get(i+1).getHealthPoint()+" HP\n",warriors.get(i).getType(),warriors.get(i+1).getType());
                    System.out.printf("%s WIN IN %d ROUND\n",warriors.get(i).getType(),counter);
                    System.out.println();
                    hashCodeIndex.add(warriors.get(i+1).toString());
                    break;
                }else System.out.printf("%s inflicted "+warriors.get(i).getDamage()+" damage and %s left "+warriors.get(i+1).getHealthPoint()+" HP\n",warriors.get(i).getType(),warriors.get(i+1).getType());

                //удар второго воина по первому
                warriors.get(i).setHealthPoint(warriors.get(i).getHealthPoint()-warriors.get(i+1).getDamage());
                if(warriors.get(i).getHealthPoint()<=0){
                    warriors.get(i).setHealthPoint(0);
                    System.out.printf("%s inflicted "+warriors.get(i+1).getDamage()+" damage and %s left "+warriors.get(i).getHealthPoint()+" HP\n",warriors.get(i+1).getType(),warriors.get(i).getType());
                    System.out.printf("%s WIN IN %d ROUND\n",warriors.get(i+1).getType(),counter);
                    System.out.println();
                    hashCodeIndex.add(warriors.get(i).toString());
                    break;
                }else System.out.printf("%s inflicted "+warriors.get(i+1).getDamage()+" damage and %s left "+warriors.get(i).getHealthPoint()+" HP\n",warriors.get(i+1).getType(),warriors.get(i).getType());
                System.out.println();
            }
            flag+=1;

        }

        for(int i=0;i<warriors.size();i++){
            for (int j=0;j<hashCodeIndex.size();j++){

                if(warriors.get(i).toString().equals(hashCodeIndex.get(j))){
                    warriors.remove(warriors.get(i));
                }

            }
        }

        for (int i=0; i<warriors.size();i++){
            System.out.print(warriors.get(i).getType()+" "+warriors.get(i).getHealthPoint()+"\n");
        }
    }

    private void randomHealthPoint(Warrior[] warriors, int i){
        warriors[i].setHealthPoint(random.nextInt(1000+1));
    }
    private void randomHealthPoint(List<Warrior> warriors,int i){
        warriors.get(i).setHealthPoint(random.nextInt(1000+1));
    }
    private void randomDamage(Warrior[] warriors,int i){
        warriors[i].setDamage(Math.round(warriors[i].getHealthPoint()*PERCENTAGE_OF_HEALTH_POINT));
    }
    private void randomDamage(List<Warrior> warriors,int i){
        warriors.get(i).setDamage(Math.round(warriors.get(i).getHealthPoint()*PERCENTAGE_OF_HEALTH_POINT));
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
    private void randomTitle(List<Warrior> warriors,int i,int warriorNumber) throws FileNotFoundException{
        Scanner file=new Scanner(new File("names.txt"));
        switch (warriorNumber){
            case 0 -> {
                generateWarriorName(file);
                warriors.get(i).setType("Knight"+" "+file.nextLine());
            }
            case 1 -> {
                generateWarriorName(file);
                warriors.get(i).setType("Archer"+" "+file.nextLine());
            }
            case 2 -> {
                generateWarriorName(file);
                warriors.get(i).setType("Wizard"+" "+file.nextLine());
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
