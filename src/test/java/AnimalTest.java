import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    @Mock
    Animal animal;
    @Test
    public void animalGetFamilyMockTest() {
        animal.getFamily();
        Mockito.verify(animal).getFamily();
    }
    @Test
    public void animalGetFamilyTest() {
        Animal animal = new Animal();
        assertEquals("Существует несколько семейств: заячьи," +
                " беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
    @Test
    public void animalGetFoodWithPredatorTest() throws Exception {
        Animal animal = new Animal();
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = animal.getFood("Хищник");
        assertEquals(expected, actual);
    }
    @Test
    public void animalGetFoodWithHerbivoreTest() throws Exception {
        Animal animal = new Animal();
        List<String> expected = Arrays.asList("Трава", "Различные растения");
        List<String> actual = animal.getFood("Травоядное");
        assertEquals(expected, actual);
    }
    @Test
    public void animalGetFoodExceptionTest() {
        Animal animal = new Animal();
        String expected = "";
        try {
            animal.getFood("Анимал");
        } catch (Exception exception) {
            expected = exception.getMessage();
        }
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", expected);
    }
}
