import java.util.ArrayList;

class Battle {

    public static int deadEnemyMonster = 0;

    public static void doBattle() {

        Monster monster = new Monster();

        int totalHp = monster.getAllyTotalHp();
        int totalMaxHp = monster.getAllyTotalMaxHp();

        Gem.createGems();

        while (monster.hasNextEnemy()) {

            MonsterStatus enemy = monster.getCurrentEnemy();

            IO.println(enemy.name + "が現れた");

            while (enemy.hp > 0 && totalHp > 0) {

                IO.println(NameAnalyze.playerName + "のターン");
                IO.println("-----------------------------------");

                IO.println("              " + enemy.name);
                IO.println("              HP = " + enemy.hp);
                IO.println();

                ArrayList<MonsterStatus> allies = monster.getAllies();

                for (MonsterStatus ally : allies) {
                    IO.print("  " + ally.name + "  ");
                }

                IO.println();

                IO.println("              HP = " + totalHp);

                IO.println("-----------------------------------");

                Gem.printGems();

                IO.println("-----------------------------------");

                ComandAnalyze.inputComand();

                int from =
                        ComandAnalyze.playComand.charAt(0) - 'A';

                int to =
                        ComandAnalyze.playComand.charAt(1) - 'A';

                Gem.moveGem(from, to);

                totalHp = processGems(enemy, totalHp, totalMaxHp, allies);

                if (enemy.hp <= 0) {
                    break;
                }

                IO.println();

                IO.println(enemy.name + "のターン");

                int enemyDamage = Attack.enemyAttack(enemy, allies);

                IO.println(enemyDamage + "のダメージを受けた");

                totalHp -= enemyDamage;

                IO.println();
            }

            if (enemy.hp <= 0) {

                IO.println(enemy.name + "を倒した");

                deadEnemyMonster++;

                IO.println(NameAnalyze.playerName + "はさらに先に進んだ");

                monster.nextEnemy();

                Gem.createGems();

            } else if (totalHp <= 0) {

                DangeonOver.dangeonover();

                return;
            }
        }

        DangeonClear.dangeonclear();
    }


    public static int processGems(MonsterStatus enemy, int totalHp, int totalMaxHp, ArrayList<MonsterStatus> allies) {

        int combo = 0;
        int allDamage = 0;

        while (true) {

            int matchedCount = Gem.removeMatches();

            if (matchedCount == 0) {
                break;
            }

            for (int i = 0; i < matchedCount; i++) {

                combo++;

                allElement.Element element = Gem.getMatchedElement(i);

                int gemCount = Gem.getMatchedGemCount(i);


                IO.println();

                IO.println("========== " + combo + "コンボ！ ==========");

                if (element == allElement.Element.LIFE) {

                    int heal = Attack.heal(allies, gemCount, combo);

                    if (heal > 0) {

                        if (totalHp < totalMaxHp) {

                            totalHp += heal;

                            if (totalHp > totalMaxHp) {
                                totalHp = totalMaxHp;
                            }

                        } else {

                            IO.println("体力が満タンのためこれ以上回復できない");
                        }
                    }

                } else {

                    int damage = Attack.attack(enemy, allies, gemCount, combo, element);

                    enemy.hp -= damage;

                    allDamage += damage;
                }
            }

            Gem.printGems();

            IO.println();

            Gem.dropGems();

            IO.println();

            Gem.refillGems();

            IO.println();
        }

        if (combo > 0) {

            IO.println();

            IO.println("合計 " + combo + " コンボ！");

            IO.println("合計 " + allDamage + " ダメージ！");
        }

        return totalHp;
    }
}
