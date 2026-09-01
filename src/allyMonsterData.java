public class allyMonsterData {

    public static MonsterStatus suzaku() {
        return new MonsterStatus(
                "\u001B[3" + allElement.Element.FIRE.getCode() + "m"+ allElement.Element.FIRE.getSymbol() + "朱雀" + allElement.Element.FIRE.getSymbol() + "\u001B[0m",
                150,
                150,
                allElement.Element.FIRE,
                25,
                10
        );
    }

    public static MonsterStatus seiryu() {
        return new MonsterStatus(
                "\u001B[3" + allElement.Element.WIND.getCode() + "m"+ allElement.Element.WIND.getSymbol() + "青龍" + allElement.Element.WIND.getSymbol() + "\u001B[0m",
                150,
                150,
                allElement.Element.WIND,
                15,
                10
        );
    }

    public static MonsterStatus byakko() {
        return new MonsterStatus(
                "\u001B[3" + allElement.Element.EARTH.getCode() + "m"+ allElement.Element.EARTH.getSymbol() + "白虎" + allElement.Element.EARTH.getSymbol() + "\u001B[0m",
                150,
                150,
                allElement.Element.EARTH,
                20,
                5
        );
    }

    public static MonsterStatus genbu() {
        return new MonsterStatus(
                "\u001B[3" + allElement.Element.WATER.getCode() + "m"+ allElement.Element.WATER.getSymbol() + "玄武" + allElement.Element.WATER.getSymbol() + "\u001B[0m",
                150,
                150,
                allElement.Element.WATER,
                20,
                15
        );
    }
}
