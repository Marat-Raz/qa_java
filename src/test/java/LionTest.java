import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;
    @Mock
    Lion lion;
    @Test
    public void lionConstructorTest() {
        String exceptionText = "";
        try {
            new Lion("Самей", feline);
        } catch (Exception exception) {
            exceptionText = exception.getMessage();
        }
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exceptionText);
    }
    @Test
    public void lionGetKittensMockTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        assertEquals(5, lion.getKittens());
    }
    @Test
    public void lionDoesHaveManeMockTest() throws Exception {
        lion.doesHaveMane();
        Mockito.verify(lion).doesHaveMane();
    }
    @Test
    public void lionGetFoodMockTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}