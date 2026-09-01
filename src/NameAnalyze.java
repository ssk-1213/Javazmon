public class NameAnalyze {
    public static String playerName;
    public static void inputName() {
        while (true) {
            IO.print("名前を入力してください：");
            playerName = IO.readln();

            if (playerName == null || playerName.isBlank()) {
                IO.println("【エラー】名前を入力してください。");
                continue;
            }
            break;
        }
    }
}