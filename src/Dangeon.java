class Dangeon {
    public static void goDangeon() {

        Monster monster = new Monster();
        int totalHp = monster.getAllyTotalHp();

        IO.println(NameAnalyze.playerName + "(HP:"+ totalHp +")はダンジョンに到着した");
        IO.println("<パーティー編成>----------------------");

        for (int i = 0; i < monster.getAllyCount(); i++){
            MonsterStatus ally = monster.getAlly(i);

            IO.println(ally.name + " HP = " + ally.hp + " 攻撃 = " + ally.atk + " 防御 " + ally.def);
        }

        IO.println("-----------------------------------");
        Battle.doBattle();
    }
}
