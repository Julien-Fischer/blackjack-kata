package blackjack.net.agiledeveloper;

import net.agiledeveloper.blackjack.BlackjackEval;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class BlackjackEvalTest {

    @Test
    void app_runs() {
        assertThatNoException()
                .isThrownBy(BlackjackEval::new);
    }
}

