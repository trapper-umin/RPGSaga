package Testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import warriors.*;


public class WarriorTest {
    Warrior knight=new Knight(50,5,"KNIGHT");
    Warrior wizard=new Wizard(40,4,"WIZARD");
    Warrior archer=new Archer(30,3,"ARCHER");
    @Test
    void testGetHealthPointMethod(){

        assertEquals(50,knight.getHealthPoint());
        assertEquals(40,wizard.getHealthPoint());
        assertEquals(30,archer.getHealthPoint());
    }
    @Test
    void testGetDamageMethod(){

        assertEquals(5,knight.getDamage());
        assertEquals(4,wizard.getDamage());
        assertEquals(3,archer.getDamage());
    }
    @Test
    void testGetTypeMethod(){

        assertEquals("KNIGHT",knight.getType());
        assertEquals("WIZARD",wizard.getType());
        assertEquals("ARCHER",archer.getType());
    }
    @Test
    void testGetIDMethod(){

        assertEquals("knight",knight.getID());
        assertEquals("wizard",wizard.getID());
        assertEquals("archer",archer.getID());
    }
}
