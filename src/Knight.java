public class Knight extends Warrior{


    public void retaliationStrike(){

        setDamage(Math.round(getDamage()*1.3f));

    }

    public Knight(int healthPoint,int damage,String type){
        super(healthPoint,damage,type);
    }
    public Knight(){
        super();
    }

}
