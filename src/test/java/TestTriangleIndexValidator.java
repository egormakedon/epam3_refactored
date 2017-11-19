import by.makedon.epam3.validator.TriangleIndexValidator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTriangleIndexValidator {
    private TriangleIndexValidator triangleIndexValidator;

    @BeforeTest
    public void set() {
        triangleIndexValidator = new TriangleIndexValidator();
    }

    @AfterTest
    public void destr() {
        triangleIndexValidator = null;
    }

    @Test
    public void validationIndexTest() {
        int index = 2;
        Assert.assertTrue(triangleIndexValidator.validate(index));
    }

    @Test
    public void validationIndexWrongTest1() {
        int index = 100;
        Assert.assertFalse(triangleIndexValidator.validate(index));
    }

    @Test
    public void validationIndexWrongTest2() {
        int index = -100;
        Assert.assertFalse(triangleIndexValidator.validate(index));
    }
}