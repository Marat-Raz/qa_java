import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String sex;
    private final boolean hasMane;
    Feline feline = new Feline();
    public LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] getTestParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Test
    public void lionConstructorExceptionTest() {
        String exceptionText = "";
        try {
            new Lion("Самей", feline);
        } catch (Exception exception) {
            exceptionText = exception.getMessage();
        }
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exceptionText);
    }
    @Test
    public void lionGetKittensParametrizedTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(1, lion.getKittens());
    }
    @Test
    public void lionDoesHaveManeParametrizedTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }
    @Test
    public void lionGetFoodParametrizedTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, lion.getFood());
    }
}

