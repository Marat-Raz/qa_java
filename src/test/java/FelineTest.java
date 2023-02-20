import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    Feline feline;
    @Test
    public void felineEatMeatReturnPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void felineGetFoodAnimalKindIsPredatorReturnPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.getFood("Хищник");
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void felineGetFoodAnimalKindIsHerbivoreReturnHerbivoreFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedResult = List.of("Трава", "Различные растения");
        List<String> actualResult = feline.getFood("Травоядное");
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void felineGetFamilyMockTest() {
        feline.getFamily();
        Mockito.verify(feline).getFamily();
    }
    @Test
    public void felineGetFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void felineGetKittensTest() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
    @Test
    public void felineGetKittensCountTest() {
        Feline feline = new Feline();
        Random random = new Random();
        int lionKittens = random.nextInt(10);
        assertEquals(lionKittens, feline.getKittens(lionKittens));
          }
}