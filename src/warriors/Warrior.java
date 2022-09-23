package warriors;

public class Warrior implements WarriorMethods {
    private int healthPoint;
    private int damage;
    private String type,id;

    public void doSkill(){}
    public String getSkill(){
        return null;
    }

    public void setHealthPoint(int healthPoint){
        this.healthPoint=healthPoint;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public void setType(String type){this.type=type;}
    public void setID(String id){this.id=id;}
    public int getHealthPoint(){
        return healthPoint;
    }
    public int getDamage(){
        return damage;
    }
    public String getType(){return type;}
    public String getID(){return id;}

    public Warrior(int healthPoint,int damage,String type){
        this.healthPoint=healthPoint;
        this.damage=damage;
        this.type=type;
    }
    public Warrior(){}
}
