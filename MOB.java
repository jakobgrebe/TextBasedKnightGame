public class MOB implements Attributes {
    private final String name;
    protected int maxHP;
    protected int armor;
    protected DiceType damageDie;
    protected int hitModifier;
    protected int damage = 0;

    @Override
    public int getArmor() {
        // TODO Auto-generated method stub
        return armor;
    }

    @Override
    public int getMaxHP() {
        // TODO Auto-generated method stub
        return maxHP;
    }

    @Override
    public DiceType getDamageDie() {
        // TODO Auto-generated method stub
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        // TODO Auto-generated method stub
        return hitModifier;
    }
    public String getName(){
        return name;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }
    public int getHP() {
        return getMaxHP() - getDamage();
    }
    public int getDamage(){
        return damage;
    }

    public void resetDamage(){
        damage = 0;
    }

    public MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie) {
        this.name = name;
        this.maxHP = hp;
        this.armor = armor;
        this.damageDie = damageDie;
        this.hitModifier = hitModifier;

    }



    @Override
    public String toString() {
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                "|                            |\n" +
                String.format("|         Health: %-10d |%n", getHP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }
    public MOB copy() {
        return new MOB(this.name, this.maxHP, this.armor, this.hitModifier, this.damageDie);
    }
    public static void main(String[] args) {
        //MOB mob = new MOB("sexy",115,5,2,DiceType.D12);
        //System.out.println("Testing to string \n"+mob.toString());
    }
}