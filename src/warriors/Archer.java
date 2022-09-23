package warriors;

public class Archer extends Warrior {
    private final String FASCINATION_SKILL="Fascination";
    public void doSkill(){

    }
    public String getSkill(){
        return FASCINATION_SKILL;
    }

    public Archer(int healthPoint,int damage,String type){
        super(healthPoint,damage,type);
        setID("archer");
    }
    public Archer(){
        super();
        setID("archer");
    }

}
