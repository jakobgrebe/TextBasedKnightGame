import java.util.List;
import java.util.Scanner;
public class ConsoleView implements GameView{
    private final Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }


    public boolean checkContinue() {
        System.out.print("Do you want to continue your quest? (y/n): ");
        String input = in.nextLine();
        return input.equalsIgnoreCase("y");
    }


    public String displayMainMenu() {
        System.out.print("What would you like to do? ");
        //System.out.println("Welcome to the Quest Game!");
        //System.out.println("1. Start New Game");
        //System.out.println("2. Load Game");
        //System.out.println("3. Exit");
        //System.out.print("Enter your choice: ");
        String input = in.nextLine();
        input.toLowerCase();
        return input;
    }


    public void endGame() {
    }


    public void knightNotFound() {
        System.out.println("Knight not found.");
    }


    public void listKnights(List<Knight> knights) {
        for (Knight knight : knights) {
            System.out.print(knight.getId() + ": " + knight.getName()+"\n");
            if (knight == knights.get(knights.size()-1)){
                System.out.print("\n");
            }
        }
    }


    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights) {
    }


    public void printBattleText(MOB dead) {
        System.out.println("The " + dead.getName() + " was defeated.");
    }


    public void printDefeated() {
        System.out.println("All knights are defeated.");
        System.out.println();
    }


    public void printFortunes(List<Knight> activeKnights) {
        System.out.println("For this quest, our knights drew the following fortunes!");
        for (Knight knight : activeKnights) {
            System.out.println(knight.getName() + "drew");
            if (knight.getActiveFortune() == null){
                System.out.println("Nope");
            }else {
                System.out.printf("+======================+");
                System.out.printf("|%-22s|\n", knight.getActiveFortune().toString());
                System.out.printf("|HP Bonus:%+13d|\n", knight.getActiveFortune().getMaxHP());
                System.out.printf("|AC Bonus:%+13d|\n", knight.getActiveFortune().getArmor());
                System.out.printf("|Hit Bonus:%+12d|\n", knight.getActiveFortune().getHitModifier());
                System.out.printf("|Damage Adj:%11s|\n", knight.getActiveFortune().getDamageDie() == null ? "-" : knight.getActiveFortune().getDamageDie());
                System.out.println("+======================+");
            }

        }
    }


    public void printHelp() {
        System.out.println("Unsure what to do, here are some options:");
        System.out.println("\tls or list all  - listing the knights");
        System.out.println("\tlist active  - list the active knights knights only");
        System.out.println("\tshow name or id - show the knight details card");
        System.out.println("\tset active name or id - set knight as active (note: only 4 knights can be active)");
        System.out.println("\tremove active name or id - remove a knight from active status (heals knight)");
        System.out.println("\texplore or adventure or quest - find random monsters to fight");
        System.out.println("\tsave filename - save the game to the file name (default: saveData.csv)");
        System.out.println("\texit or goodbye - to leave the game\n");

        System.out.println("Game rules: You can have four active knights. As long as they are active, they won't heal, but they can gain XP by going on adventures.");
        System.out.println("When you make a knight inactive, they will heal. How many monsters can you defeat before, you have to heal?");
    }


    public void setActiveFailed() {
        System.out.println("Failed to set active knight.");
        System.out.println();
   }


    public void showKnight(Knight knight) {
       System.out.println(knight.toString());
       
    }


    public void splashScreen() {
        
    }
}