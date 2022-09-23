package warriors;

public class Wizard extends Warrior {
    private final String FIRE_ARROWS_SKILL="Fire Arrows";
    public void doSkill(){

    }
    public String getSkill(){
        return FIRE_ARROWS_SKILL;
    }

    public Wizard(int healthPoint,int damage,String type){
        super(healthPoint,damage,type);
        setID("wizard");
    }
    public Wizard(){
        super();
        setID("wizard");
    }
}
