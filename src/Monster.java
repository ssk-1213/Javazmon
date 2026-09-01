import java.util.ArrayList;

public class Monster {

    ArrayList<MonsterStatus> enemyMonster = new ArrayList<>();
    ArrayList<MonsterStatus> allyMonster = new ArrayList<>();

    int currentEnemyIndex = 0;

    public Monster() {

        enemyMonster.add(enemyMonsterData.slime());
        enemyMonster.add(enemyMonsterData.goblin());
        enemyMonster.add(enemyMonsterData.bigbad());
        enemyMonster.add(enemyMonsterData.wearwolf());
        enemyMonster.add(enemyMonsterData.dragon());

        allyMonster.add(allyMonsterData.suzaku());
        allyMonster.add(allyMonsterData.seiryu());
        allyMonster.add(allyMonsterData.byakko());
        allyMonster.add(allyMonsterData.genbu());
    }


    public int getAllyCount() {
        return allyMonster.size();
    }


    public MonsterStatus getAlly(int index) {

        return allyMonster.get(index);
    }

    public int getAllyTotalHp() {
        int totalHp = 0;

        for (MonsterStatus ally : allyMonster) {
            totalHp += ally.hp;
        }

        return totalHp;
    }
    public int getAllyTotalMaxHp() {
        int totalMaxHp = 0;

        for (MonsterStatus ally : allyMonster) {
            totalMaxHp += ally.maxHp;
        }

        return totalMaxHp;
    }
    public MonsterStatus getCurrentEnemy() {
        if (currentEnemyIndex >= enemyMonster.size()) {
            return null;
        }

        return enemyMonster.get(currentEnemyIndex);
    }

    public void nextEnemy() {
        currentEnemyIndex++;
    }

    public boolean hasNextEnemy() {
        return currentEnemyIndex < enemyMonster.size();
    }

    public ArrayList<MonsterStatus> getAllies() {
        return new ArrayList<>(allyMonster);
    }
}