import java.util.Scanner;

public class GameController {
    private final GameData data;
    private final GameView view;
    private final CombatEngine engine;

    public GameController(GameData data, GameView view, CombatEngine engine) {
        this.data = data;
        this.view = view;
        this.engine = engine;
    }

    public void start() {
        view.splashScreen();

        boolean continueGame = true;
        while (continueGame == true) {
            continueGame = processCommand(view.displayMainMenu());
        }

        view.endGame();
    }
    public String getinput(){
        Scanner scan = new Scanner(System.in);
        String S = scan.nextLine();
        S.toLowerCase();
        return S;
    }

    protected boolean processCommand(String command) {
        if (command.contains("exit") || command.contains("bye")) {
            return false;
        } else if (command.equals("ls") || command.equals("list all")) {
            view.listKnights(data.getKnights());
        } else if (command.equals("list active")) {
            view.listKnights(data.getActiveKnights());
        } else if (command.startsWith("show ")) {
            String nameOrId = command.substring(5);
            processShowKnight(nameOrId);
            return false;
        } else if (command.startsWith("set active ")) {
            String nameOrId = command.substring(10).trim();
            processSetActive(nameOrId);
            //if (getinput().equals("bye")){
            //    return false;
            //}
        } else if (command.startsWith("remove ")) {
            String nameOrId = command.substring(7);
            processRemoveActive(nameOrId);
        } else if (command.startsWith("save")) {
            String file = null;
            // creates a file = null
            if (command.length()>4){
                file = command.substring(5).trim();
            }
            if( (file != null) && (file.isEmpty())){
                data.save(file);
                //this works
            }else{
                data.save("saveData.csv");
            }
        } else if (command.contains("explore") || command.contains("adventure") || command.contains("quest")) {
            engine.initialize();
            engine.runCombat();
            engine.clear();
        } else {
            view.printHelp();
            System.out.println("");
        }
        return true;
    }

    private void processRemoveActive(String remove) {
        Knight knightToRemove = data.getActive(remove);
        if (knightToRemove == null) {
            view.knightNotFound();
        } else {
            data.removeActive(knightToRemove);
        }
    }

    private void processSetActive(String active) {
        Knight knight = data.getKnight(active);
        if (knight == null) {
            view.knightNotFound();
        } else {
            boolean success = data.setActive(knight);
            if (!success) {
                view.setActiveFailed();
            }
        }
    }



    private void processShowKnight(String nameOrId) {
        Knight knight = data.getKnight(nameOrId);
        if (knight != null) {
            view.showKnight(knight);
        } else {
            view.knightNotFound();
        }
    }
}