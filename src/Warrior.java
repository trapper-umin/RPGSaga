public class Warrior {
    private int healthPoint;
    private int damage;
    private String type;
    private boolean flag;

    public void setHealthPoint(int healthPoint){
        this.healthPoint=healthPoint;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public void setType(String type){this.type=type;}
    public void setFlag(boolean flag){
        this.flag=flag;
    }
    public int getHealthPoint(){
        return healthPoint;
    }
    public int getDamage(){
        return damage;
    }
    public String getType(){return type;}
    public boolean getFlag(){
        return flag;
    }

    public Warrior(int healthPoint,int damage,String type){
        this.healthPoint=healthPoint;
        this.damage=damage;
        this.type=type;
    }
    public Warrior(){}
}
