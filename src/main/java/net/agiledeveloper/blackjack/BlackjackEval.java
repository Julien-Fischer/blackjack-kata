package net.agiledeveloper.blackjack;

public class BlackjackEval {

    public static String determineOutcome(String[] args) {
        int value = evaluateHand(args);
        if (value == 21 && args.length == 2) {
            return "Blackjack!";
        } else if (value > 21) {
            return "Bust!";
        } else if (value >= 17) {
            return "Stand";
        } else {
            return "Hit";
        }
    }

    public static int evaluateHand(String[] hand) {
        int total = 0;
        int aceCount = 0;
        int i = 0;

        while (i < hand.length) {
            String card = hand[i];
            if (card == null) {
                System.out.println("Null card detected");
                i++;
                continue;
            }
            if (card.equals("Ace")) {
                aceCount = aceCount + 1;
                total = total + 11;
            } else if (card.equals("2")) {
                total = total + 2;
            } else if (card.equals("3")) {
                total = total + 3;
            } else if (card.equals("4")) {
                total = total + 4;
            } else if (card.equals("5")) {
                total = total + 5;
            } else if (card.equals("6")) {
                total = total + 6;
            } else if (card.equals("7")) {
                total = total + 7;
            } else if (card.equals("8")) {
                total = total + 8;
            } else if (card.equals("9")) {
                total = total + 9;
            } else if (card.equals("10") || card.equals("Jack") || card.equals("Queen") || card.equals("King")) {
                total = total + 10;
            } else {
                System.out.println("Unknown card: " + card);
            }

            if (card.equals("Ace")) {
                if (total > 21) {
                    total = total - 10;
                    aceCount = aceCount - 1;
                }
            }
            i++;
        }

        while(total > 21 && aceCount > 0){
            total = total - 10;
            aceCount--;
        }
        if (total == 21 && hand.length == 2) {
            System.out.println("Blackjack detected during evaluation.");
        }
        return total;
    }

}
