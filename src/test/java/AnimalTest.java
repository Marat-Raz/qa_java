import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
    public void familyAnimalTest() {
        Animal animal = new Animal();
        Assert.assertEquals("Существует несколько семейств: заячьи," +
                " беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}
