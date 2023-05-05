import java.util.List;
import java.util.Random;

public class CombatEngine{
    private final GameData data;
    private final GameView view;
    private final DiceSet dice;
    private final Random rnd;

    public CombatEngine(GameData data, GameView view){
        this.data = data;
        this.view = view;
        this.dice = new DiceSet();
        this.rnd = new Random();
    }
    public void runCombat(){
        System.out.println("Not initilized!");
    }
    public void initialize(){
        List<Knight> activeKnights = data.getActiveKnights();
       for (Knight knight: activeKnights){
           knight.setActiveFortune(data.getRandomFortune());
       }
       view.printFortunes(activeKnights);
    }

    public void clear(){
        List<Knight> activeKnights = data.getActiveKnights();
        for (Knight i : activeKnights){
            i.setActiveFortune(null);
        }
    }
}