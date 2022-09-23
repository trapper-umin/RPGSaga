import warriors.Archer;
import warriors.Knight;
import warriors.Warrior;
import warriors.Wizard;

import java.util.ArrayList;
import java.util.List;

public class ProcessTest {
    public static void main(String[] args) {
        testGenerics();
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
            System.out.print(warriors.get(i).getType()+"\n");
        }
    }
}
