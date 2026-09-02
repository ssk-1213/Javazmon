public class MonsterStatus {
    String name;
    int hp;
    int maxHp;
    allElement.Element element;
    int atk;
    int def;

    public MonsterStatus(String name, int hp, int maxHp, allElement.Element element, int atk, int def) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.element = element;
        this.atk = atk;
        this.def = def;
    }
}
