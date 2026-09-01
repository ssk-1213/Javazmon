import java.util.Random;

public class Gem {

    static allElement.Element[] gems = new allElement.Element[14];

    static int[] removedCount = new int[7];

    static allElement.Element[] matchedElements = new allElement.Element[14];

    static int[] matchedGemCounts = new int[14];

    static int matchedCount = 0;

    public static void createGems() {

        Random random = new Random();

        allElement.Element[] elements = {
                allElement.Element.FIRE,
                allElement.Element.WATER,
                allElement.Element.WIND,
                allElement.Element.EARTH,
                allElement.Element.LIFE
        };

        for (int i = 0; i < gems.length; i++) {

            int index = random.nextInt(elements.length);

            gems[i] = elements[index];
        }
    }


    public static void printGems() {

        for (int i = 0; i < gems.length; i++) {

            char label = (char) ('A' + i);

            IO.print(label + " ");
        }

        IO.println();

        for (int i = 0; i < gems.length; i++) {

            IO.print("\u001B[3" + gems[i].getCode() + "m" + gems[i].getSymbol() + "\u001B[0m ");
        }

        IO.println();
    }


    public static void moveGem(int from, int to) {

        if (from < to) {

            for (int i = from; i < to; i++) {

                printGems();

                allElement.Element temp = gems[i];

                gems[i] = gems[i + 1];

                gems[i + 1] = temp;

                IO.println();
            }

        } else if (from > to) {

            for (int i = from; i > to; i--) {

                printGems();

                allElement.Element temp = gems[i];

                gems[i] = gems[i - 1];

                gems[i - 1] = temp;

                IO.println();
            }
        }
    }

    public static int removeMatches() {

        for (int i = 0; i < removedCount.length; i++) {

            removedCount[i] = 0;
        }

        matchedCount = 0;

        int count = 1;

        for (int i = 1; i <= gems.length; i++) {

            if (i == gems.length || gems[i] != gems[i - 1]) {

                if (count >= 3 && gems[i - 1] != allElement.Element.EMPTY) {

                    allElement.Element element = gems[i - 1];

                    matchedElements[matchedCount] = element;

                    matchedGemCounts[matchedCount] = count;

                    matchedCount++;

                    removedCount[element.getCode()] += count;

                    for (int j = i - count; j < i; j++) {

                        gems[j] = allElement.Element.EMPTY;
                    }
                }

                count = 1;

            } else {

                count++;
            }
        }

        return matchedCount;
    }

    public static allElement.Element
    getMatchedElement(int index) {

        return matchedElements[index];
    }

    public static int getMatchedGemCount(int index) {

        return matchedGemCounts[index];
    }


    public static void dropGems() {

        while (true) {

            boolean moved = false;

            for (int i = 0; i < gems.length; i++) {

                if (gems[i] == allElement.Element.EMPTY) {

                    int rightEmpty = i;

                    while (rightEmpty + 1 < gems.length && gems[rightEmpty + 1] == allElement.Element.EMPTY) {

                        rightEmpty++;
                    }

                    if (rightEmpty + 1 < gems.length && gems[rightEmpty + 1] != allElement.Element.EMPTY) {

                        allElement.Element temp = gems[rightEmpty];

                        gems[rightEmpty] = gems[rightEmpty + 1];

                        gems[rightEmpty + 1] = temp;

                        moved = true;
                    }

                    i = rightEmpty;
                }
            }

            if (moved) {

                printGems();

                IO.println();

            } else {

                break;
            }
        }
    }


    public static void refillGems() {

        Random random = new Random();

        allElement.Element[] elements = {
                allElement.Element.FIRE,
                allElement.Element.WATER,
                allElement.Element.WIND,
                allElement.Element.EARTH,
                allElement.Element.LIFE
        };

        for (int i = 0; i < gems.length; i++) {

            if (gems[i] == allElement.Element.EMPTY) {

                int index = random.nextInt(
                                elements.length);

                gems[i] = elements[index];
            }
        }

        printGems();
    }
}