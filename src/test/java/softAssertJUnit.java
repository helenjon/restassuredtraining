import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class softAssertJUnit {

    @Test
    public void test001() {
        List<String> testStrings = new ArrayList<>();
        testStrings.add("test1");
        testStrings.add("test");
        testStrings.add("test1");
        SoftAssertions softy = new SoftAssertions();
        for (int i = 0; i <= 2; i++) {
            softy.assertThat(testStrings.get(i)).as(String.format("FAILED. %s on stage %s", i, testStrings.get(i))).isEqualTo("test1");
        }
        softy.assertAll();
    }

}
