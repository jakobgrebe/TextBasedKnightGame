import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileInputStream;
public class CSVGameData extends GameData {
    public CSVGameData(String gamedata, String saveData) {
        loadGameData(gamedata);
        loadSaveData(saveData);
    }
    void loadSaveData(String saveData) {
        int counter = 0;
        Scanner file = readFile(saveData);
        if(file == null) return;
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(",");
            Knight kt = new Knight(
                    ++counter,
                    line.next().trim(),
                    line.nextInt(),
                    line.nextInt(),
                    line.nextInt(),
                    DiceType.valueOf(line.next()),
                    line.nextInt());
            knights.add(kt);
        }
    }
    private Scanner readFile(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            return new Scanner(fis);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            return null;
        }
    }
    public void loadGameData(String gamedata){
        Scanner ribbit = readFile(gamedata);
        // new scanner to read file
        while (ribbit.hasNextLine()){
            Scanner ribs = new Scanner(ribbit.nextLine());
            parseGameDataLine(ribs);
        }
    }
    
    private void parseGameDataLine(Scanner line){
        line.useDelimiter(",");
        if (line.next().equals( "MOB")){
            String title = line.next();
            int hitPoints = line.nextInt();
            int armor = line.nextInt();
            int hit = line.nextInt();
            DiceType dice = DiceType.valueOf(line.next().toUpperCase());
            MOB mob = new MOB(title,hitPoints,armor,hit,dice);
            super.monsters.add(mob);
        }else{
            String namef = line.next();
            int hpf = line.nextInt();
            int armorf = line.nextInt();
            int hitf = line.nextInt();
            String dicef = line.next();
            if(!dicef.equals("-")){
                Fortune fort =new Fortune(namef,hpf,armorf,hitf, DiceType.valueOf(dicef.toUpperCase()));
                super.fortunes.add(fort);
            }else {
                Fortune fort = new Fortune(namef,hpf,armorf,hitf);
                super.fortunes.add(fort);
            }
        }

    }

    public void save(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            for (Knight knight : knights) {
                fw.write(knight.toCSV() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: Failed to save data");
        }
    }
}