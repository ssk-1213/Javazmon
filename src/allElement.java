public class allElement {
    public enum Element{
        FIRE("$", 1),
        WATER("~", 6),
        WIND("@", 2),
        EARTH("#", 3),
        LIFE("&", 5),
        EMPTY(" ", 0);

        private final String symbol;
        private final int code;

        private Element(String symbol, int code){
            this.symbol = symbol;
            this.code = code;
        }

        public String getSymbol(){
            return symbol;
        }

        public int getCode(){
            return code;
        }
    }
}
