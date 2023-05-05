import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public abstract class GameData {
    private static final int MAX_ACTIVE = 4;
    protected final List<Knight> activeKnights;
    protected final List<Fortune> fortunes;
    protected final List<Knight> knights;
    protected final List<MOB> monsters;
    private static final Random random = new Random();

    public GameData() {
        activeKnights = new ArrayList<>();
        fortunes = new ArrayList<>();
        knights = new ArrayList<>();
        monsters = new ArrayList<>();
    }

    public List<Knight> getKnights() {
        return knights;
    }

    public List<Knight> getActiveKnights() {
        return activeKnights;
    }

    public Knight getActive(String nameOrId) {
        return findKnight(nameOrId, activeKnights);
    }

    public Knight getKnight(String nameOrId) {
        return findKnight(nameOrId, knights);
    }

    protected Knight findKnight(String nameOrId, List<Knight> list) {
        for (Knight knight : list) {
            if (knight.getName().toLowerCase().contains(nameOrId.toLowerCase()) ||
                    knight.getId().toString().equals(nameOrId)) {
                return knight;
            }
        }
        return null;
    }

    public Fortune getRandomFortune() {
        int index = random.nextInt(fortunes.size());
        return fortunes.get(index);
    }

    public List<MOB> getRandomMonsters() {
        return getRandomMonsters(activeKnights.size());
    }

    public List<MOB> getRandomMonsters(int number) {
        List<MOB> selectedMonsters = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int index = random.nextInt(monsters.size());
            selectedMonsters.add(monsters.get(index));
        }
        return selectedMonsters;
    }

    public void removeActive(Knight kt) {
        activeKnights.remove(kt);
        kt.resetDamage();
    }

    public abstract void save(String filename);

    public boolean setActive(Knight kt) {
        if (activeKnights.size() <= MAX_ACTIVE) {
            activeKnights.add(kt);
                return true;
            }
            return false;
        }
    }