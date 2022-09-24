import warriors.Archer;
import warriors.Knight;
import warriors.Warrior;
import warriors.Wizard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProcessTest {
    public static void main(String[] args) throws FileNotFoundException{
        testCreateCollection();
    }

    public static void testPolymorphism(){
        Warrior warrior=new Knight(1000,100,"warriors.Knight");
        warrior.doSkill();
        System.out.print(warrior.getDamage()+warrior.getType());
    }
    public static void testGenerics(){

        Warrior knight=new Knight(100,10,"Knight");
        Wizard wizard=new Wizard(100,10,"Wizard");
        Warrior archer =new Archer(100,10,"Archer");

        List<Warrior> warriors=new ArrayList<>();
        warriors.add(knight);
        warriors.add(wizard);
        warriors.add(archer);

        for (int i=0;i<warriors.size();i++){
            System.out.print(warriors.get(i).getType().toUpperCase()+"\n");
        }
    }

    public static void testCreateCollection() throws FileNotFoundException {
        Scanner file =new Scanner(new File("names.txt"));
        Random random =new Random();

        int numberOfPeople=2, warriorNumber;

        List<Warrior> warriors=new ArrayList<>();

        for (int i=0;i<numberOfPeople;i++){
            warriorNumber=random.nextInt(3);
            switch (warriorNumber){
                case 0 -> {
                    warriors.add(new Knight());
                    warriors.get(i).setHealthPoint(1000);
                    warriors.get(i).setDamage(100);
                    warriors.get(i).setType("Knight "+shuffle(file));
                }
                case 1 -> warriors.add(new Archer(1000,100,"Archer "+shuffle(file)));
                case 2 -> warriors.add(new Wizard(1000,100,"Wizard "+shuffle(file)));
            }
        }
        printCollection(warriors);

        List<Knight> knights=new ArrayList<>();
        knights.add(new Knight(100,10,"Knight"));
        printCollection(knights);

    }
    private static String shuffle(Scanner file){
        Random random =new Random();
        for (int i=0;i<random.nextInt(155+1);i++){
            file.nextLine();
        }
        return file.nextLine();
    }
    private static void printCollection(List<? extends Warrior> warriors){
        for (Warrior warrior : warriors){
            System.out.print("Type: "+warrior.getType()+"\nHP: "+warrior.getHealthPoint()+"\nDamage: "+warrior.getDamage()+"\n\n");

        }
    }
}
