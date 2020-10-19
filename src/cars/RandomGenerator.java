package cars;

public class RandomGenerator {

    private static int lastRandom;
    private static int random;

    public static int pickCol() {

        random = (int) Math.round(Math.random() * 3);

        if (lastRandom == random) {
            return pickCol();
        }

        switch (random) {

            case 1:
                lastRandom = 1;
                return 220;

            case 2:
                lastRandom = 2;
                return 320;

            case 3:
                lastRandom = 3;
                return 420;

            default:
                lastRandom = 0;
                return 520;
        }
    }

}

