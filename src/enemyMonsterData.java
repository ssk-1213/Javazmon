public class enemyMonsterData {

    public static MonsterStatus slime() {
        return new MonsterStatus(
                "\u001B[3" + allElement.Element.WATER.getCode() + "m"+ allElement.Element.WATER.getSymbol() + "スライム" + allElement.Element.WATER.getSymbol() + "\u001B[0m",
                100,
                100,
                allElement.Element.WATER,
                10,
                10
        );
    }

    public static MonsterStatus goblin() {
        return new MonsterStatus(
                "\u001B[3" + allElement.Element.EARTH.getCode() + "m"+ allElement.Element.EARTH.getSymbol() + "ゴブリン" + allElement.Element.EARTH.getSymbol() + "\u001B[0m",
                200,
                200,
                allElement.Element.EARTH,
                20,
                15
        );
    }

    public static MonsterStatus bigbad() {
        return new MonsterStatus(
                "\u001B[3" + allElement.Element.WIND.getCode() + "m"+ allElement.Element.WIND.getSymbol() + "オオコウモリ" + allElement.Element.WIND.getSymbol() + "\u001B[0m",
                300,
                300,
                allElement.Element.WIND,
                30,
                25
        );
    }

    public static MonsterStatus wearwolf() {
        return new MonsterStatus(
                "\u001B[3" + allElement.Element.WIND.getCode() + "m"+ allElement.Element.WIND.getSymbol() + "ウェアウルフ" + allElement.Element.WIND.getSymbol() + "\u001B[0m",
                400,
                400,
                allElement.Element.WIND,
                40,
                30
        );
    }

    public static MonsterStatus dragon() {
        return new MonsterStatus(
                "\u001B[3" + allElement.Element.FIRE.getCode() + "m"+ allElement.Element.FIRE.getSymbol() + "ドラゴン" + allElement.Element.FIRE.getSymbol() + "\u001B[0m",
                800,
                800,
                allElement.Element.FIRE,
                50,
                40
        );
    }
}