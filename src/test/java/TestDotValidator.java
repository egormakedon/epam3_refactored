import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.validator.DotValidator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDotValidator {
    private DotValidator dotValidator;

    @BeforeTest
    public void set() {
        dotValidator = new DotValidator();
    }

    @AfterTest
    public void destr() {
        dotValidator = null;
    }

    @Test
    public void isDotsComposeTriangleTest() {
        Assert.assertTrue(dotValidator.validate(new Dot(0,0), new Dot(1.10,200), new Dot(-123,213.232)));
    }

    @Test
    public void isDotsNotComposeTriangleTest() {
        Assert.assertFalse(dotValidator.validate(new Dot(0,0), new Dot(1,1), new Dot(-1,-1)));
    }
}