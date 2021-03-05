import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;

public class ContainerTest {
    private Container<Double> container;
    @Before
    public void init(){
        container = new Container<Double>();
    }
    @Test
    public void testRepository(){
        Double[] expectedArr = {1.0, 2.0, 4.0, 5.0, 6.0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 17.0};
        container.add(1.0);
        container.add(2.0);
        container.add(3.0);
        container.add(4.0);
        container.add(5.0);
        container.add(6.0);
        container.delete(2);
        container.setOnIndex(17.0,22);
        Assert.assertTrue(Arrays.equals(expectedArr,container.container));

    }
}
