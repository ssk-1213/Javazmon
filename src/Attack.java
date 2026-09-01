import java.util.ArrayList;
import java.util.Random;

public class Attack {

    public static double getElementRate(allElement.Element attack, allElement.Element defense) {

        if (attack == allElement.Element.FIRE && defense == allElement.Element.WIND) {
            return 2.0;
        }

        if (attack == allElement.Element.WIND && defense == allElement.Element.EARTH) {
            return 2.0;
        }

        if (attack == allElement.Element.EARTH && defense == allElement.Element.WATER) {
            return 2.0;
        }

        if (attack == allElement.Element.WATER && defense == allElement.Element.FIRE) {
            return 2.0;
        }

        if (attack == allElement.Element.FIRE && defense == allElement.Element.WATER) {
            return 0.5;
        }

        if (attack == allElement.Element.WIND && defense == allElement.Element.FIRE) {
            return 0.5;
        }

        if (attack == allElement.Element.EARTH && defense == allElement.Element.WIND) {
            return 0.5;
        }

        if (attack == allElement.Element.WATER && defense == allElement.Element.EARTH) {
            return 0.5;
        }


        return 1.0;
    }

    public static int attack(MonsterStatus enemy, ArrayList<MonsterStatus> allies, int gemCount, int combo, allElement.Element element) {

        int totalDamage = 0;

        for (MonsterStatus ally : allies) {

            if (ally.element != element) {
                continue;
            }

            int baseDamage = ally.atk - enemy.def;

            if (baseDamage < 1) {
                baseDamage = 1;
            }

            double elementRate = getElementRate(element, enemy.element);

            double comboRate = Math.pow(1.5, gemCount - 3 + combo);

            Random random = new Random();

            double randomRate = 0.9 + random.nextDouble() * 0.2;

            int damage = (int)(baseDamage * elementRate * comboRate * randomRate);

            IO.println();

            IO.println(ally.name + "が攻撃！");

            IO.println("属性：" + element);

            IO.println("Gem：" + gemCount + "個");

            IO.println("ATK：" + ally.atk);

            IO.println("敵DEF：" + enemy.def);

            if (elementRate == 2.0) {

                IO.println("属性相性：抜群！");

            } else if (elementRate == 0.5) {

                IO.println("属性相性：いまひとつ……");

            } else {

                IO.println("属性相性：普通");
            }

            IO.println("コンボ補正：" + comboRate);

            IO.println("→ " + damage + "ダメージ！");

            totalDamage += damage;
        }

        return totalDamage;
    }

    public static int heal(ArrayList<MonsterStatus> allies, int lifeCount, int combo) {

        if (lifeCount == 0) {
            return 0;
        }

        Random random = new Random();

        double comboRate = Math.pow(1.5, lifeCount - 3 + combo);

        double randomRate = 0.9 + random.nextDouble() * 0.2;

        int heal = (int)(20 * lifeCount * comboRate * randomRate);

        IO.println();

        IO.println(NameAnalyze.playerName + "が回復！");

        IO.println("LIFE Gem：" + lifeCount + "個");

        IO.println("コンボ補正：" + comboRate);

        IO.println("→ " + heal + "回復！");

        return heal;
    }

    public static int enemyAttack(MonsterStatus enemy, ArrayList<MonsterStatus> allies) {

        int totalDef = 0;

        for (MonsterStatus ally : allies) {
            totalDef += ally.def;
        }

        int baseDamage = enemy.atk - totalDef;

        if (baseDamage < 0) {
            baseDamage = 1;
        }

        Random random = new Random();

        double randomRate = 0.9 + random.nextDouble() * 0.2;

        int damage = (int)(baseDamage * randomRate);

        if (damage <= 0){
            damage = 1;
        }

        IO.println(enemy.name + "の攻撃！");

        IO.println("敵ATK：" + enemy.atk);

        IO.println("パーティDEF：" + totalDef);

        IO.println("→ " + damage + "のダメージ！");

        return damage;
    }
}
