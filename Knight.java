public class Knight extends MOB {
    protected final int id;
    private Fortune activeFortune;
    protected int xp;

    public Knight(int id, String name, int hp, int armor,int hitmodifier,DiceType damageDie, int xp ) {
        super(name, hp, armor, hitmodifier, damageDie);
        this.id = id;
        this.xp = xp;
    }
    @Override
    public int getArmor() {
        if (getActiveFortune()==null){
            return super.getArmor();
        }
        // fortune bonus armor plus mob armor
        else {
            return super.armor + getActiveFortune().getArmor();
        }
    }
    @Override
    public int getMaxHP(){
        if (getActiveFortune() == null) {
            return super.getMaxHP();
        } else {
            int com =super.getMaxHP() + getActiveFortune().getMaxHP();
            return com;
        }
    }


    @Override
    public DiceType getDamageDie(){
        if (getActiveFortune() == null) {
            return super.getDamageDie();
        } else {
            return getActiveFortune().getDamageDie();
        }
    }

    @Override
    public int getHitModifier(){
        if (getActiveFortune() == null) {
            return super.getHitModifier();
        } else {
            return super.getHitModifier() + getActiveFortune().getHitModifier();
        }
    }
//the == works better than the =! for some reason


    public int getXP() {
        return xp;
    }

    public Fortune getActiveFortune() {
        return activeFortune;
    }

    public void setActiveFortune(Fortune activeFortune) {
        this.activeFortune = activeFortune;
    }

    public void addXP(int xp) {
        this.xp += xp;
    }

    public Integer getId() {
        return Integer.valueOf(id);
    }

    @Override
    public String toString(){
        String msg = "";
        msg += "\n+============================+\n";
        msg+= String.format("| %-27s|\n",getName());
        msg+= String.format("| id: %-23d|\n",getId());
        msg+= "|                            |\n";
        msg+= String.format("| Health: %-6dXP: %-9d|\n",getHP(),getXP());
        msg+= String.format("|  Power: %-5s Armor: %-6d|\n",getDamageDie().toString(),getArmor());
        msg+= "|                            |\n";
        msg+= "+============================+";
        return msg;
    }

    public String toCSV(){
        String com = "";
        com += (getName() + ","+getMaxHP()+","+getArmor()+","+getHitModifier()+","+getDamageDie()+","+getXP());
        return com;
    }




    public static void main(String[] args) {
        // Knight arthur = new Knight(15, "Arthur", 40, 16, 2, DiceType.D8,3);
        //System.out.println(arthur.toString());
        //System.out.println(arthur.toCSV());
        //Fortune ftn = new Fortune("Fortune Testing", 10, 5, 2, DiceType.D12);
        //System.out.println(ftn.toString());
        //Knight cron = new Knight(12,"bob",45,14,3,DiceType.D12,23);
        //System.out.println("Testing \n"+ cron.toString());

        //Knight(int id, String name, int hp, int armor,int hitmodifier,DiceType damageDie, int xp )



    }

}