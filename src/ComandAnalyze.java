public class ComandAnalyze {
    public static String playComand;
    public static void inputComand(){
        while (true){
            IO.print("コマンド >");
            playComand = IO.readln();

            if (playComand == null || playComand.isBlank()) {
                IO.println("【エラー】コマンドを入力してください");
                continue;
            }
            if (playComand.length() != 2){
                IO.println("【エラー】二文字のコマンドを入力してください");
                continue;
            }
            if (playComand.matches(".*[a-z].*")) {
                IO.println("【エラー】小文字は使用できません");
                continue;
            }
            if (!playComand.matches("[A-N]{2}")){
                IO.println("【エラー】コマンドの範囲外です");
                continue;
            }
            if (playComand.charAt(0) == playComand.charAt(1)) {
                IO.println("【エラー】同じ文字は使用できません");
                continue;
            }
            break;
        }
    }
}
