package warriors;

public class Knight extends Warrior {

    private final String RELATION_STRIKE_SKILL="Relation Strike";
    public void doSkill(){

        setDamage(Math.round(getDamage()*1.3f));

    }
    public String getSkill(){
        return RELATION_STRIKE_SKILL;
    }

    public Knight(int healthPoint,int damage,String type){
        super(healthPoint,damage,type);
        setID("knight");
    }
    public Knight(){
        super();
        setID("knight");
    }

}
