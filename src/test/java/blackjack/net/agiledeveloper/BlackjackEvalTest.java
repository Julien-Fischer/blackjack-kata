package blackjack.net.agiledeveloper;

import net.agiledeveloper.blackjack.BlackjackEval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlackjackEvalTest {

    @Test
    void testEvaluateHand() {
        BlackjackEval eval = new BlackjackEval();
        // Test Blackjack (Ace + King)
        String[] hand1 = {"Ace", "King"};
        assertEquals(21, eval.evaluateHand(hand1));
        // Test soft 17 (Ace + 6)
        String[] hand2 = {"Ace", "6"};
        assertEquals(17, eval.evaluateHand(hand2));
        // Test hard 13 (Ace + 8 + 4)
        String[] hand3 = {"Ace", "8", "4"};
        assertEquals(13, eval.evaluateHand(hand3));
        // Test bust (7 + 10 + 6)
        String[] hand4 = {"7", "10", "6"};
        assertEquals(23, eval.evaluateHand(hand4));
        // Test 21 with three cards (8 + 7 + 6)
        String[] hand5 = {"8", "7", "6"};
        assertEquals(21, eval.evaluateHand(hand5));
        // Test unknown card label - it will print a warning but still calculate total from valid cards
        String[] hand6 = {"Ace", "Joker"};
        assertEquals(11, eval.evaluateHand(hand6));
    }

    @Test
    void testBlackjack() {
        String[] hand = {"Ace", "King"};
        assertEquals("Blackjack!", BlackjackEval.determineOutcome(hand));
    }

    @Test
    void testBust() {
        String[] hand = {"King", "Queen", "Jack"};
        assertEquals("Bust!", BlackjackEval.determineOutcome(hand));
    }

    @Test
    void testStand_Exactly17() {
        String[] hand = {"10", "7"};
        assertEquals("Stand", BlackjackEval.determineOutcome(hand));
    }

    @Test
    void testStand_Above17() {
        String[] hand = {"9", "9"};
        assertEquals("Stand", BlackjackEval.determineOutcome(hand));
    }

    @Test
    void testHit() {
        String[] hand = {"5", "6"};
        assertEquals("Hit", BlackjackEval.determineOutcome(hand));
    }

}






