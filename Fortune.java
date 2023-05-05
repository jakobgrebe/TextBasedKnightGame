public class Fortune implements Attributes {
    private final String name;
    private final int armor;
    private final DiceType type;
    private final int hitModifier;
    private final int hpBonus;

    public Fortune(String name, int hpBonus, int armor,int hitModifier) {
        this(name, hpBonus, armor, hitModifier, null);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.name = name;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.hpBonus = hpBonus;
        this.type = type;
    }



    @Override
    public int getArmor() {
        return armor;
    }

    public String getName(){
        return name;
    }

    @Override
    public int getMaxHP() {
        // TODO Auto-generated method stub
        return hpBonus;
    }

    @Override
    public DiceType getDamageDie() {
        // TODO Auto-generated method stub
        return type;
    }

    @Override
    public int getHitModifier() {
        // TODO Auto-generated method stub
        return hitModifier;
    }
    @Override
    public String toString() {
        String msg = "+======================+\n";
        msg+= String.format("|%-22s|\n",getName());
        msg += String.format("|HP Bonus:%+13d|\n", hpBonus);
        msg += String.format("|AC bonus:%+13d|\n", armor);
        msg += String.format("|Hit bonus:%+12d|\n", hitModifier);
        msg += String.format("|Damage Adj:%11s|\n", getDamageDie()==null? "-":getDamageDie());
        msg += String.format("+======================+\n");
        return msg;
    }
    public static void main(String[] args) {
        Fortune ftn = new Fortune("Fortune Testing", 10, 5, 2, DiceType.D12);
        System.out.println(ftn.toString());
    }

}