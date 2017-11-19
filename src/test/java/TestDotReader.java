import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.exception.WrongDataException;
import by.makedon.epam3.exception.IncorrectFileException;
import by.makedon.epam3.reader.DotReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDotReader {
    private DotReader rF;

    @BeforeTest
    public void set() {
        rF = new DotReader();
    }

    @AfterTest
    public void destr() {
        rF = null;
    }

    @Test (expectedExceptions = IncorrectFileException.class)
    public void fileNotExistTest() throws IncorrectFileException {
        String fileName = "thisFileNotExist.txt";
        rF.readFile(fileName, " ");
    }

    @Test
    public void readFileTest() throws WrongDataException, IncorrectFileException {
        String fileName = "in/in.txt";
        List<Dot[]> result = rF.readFile(fileName, " ");
        List<Dot[]> expectedList = new ArrayList<Dot[]>();

        expectedList.add(new Dot[3]);
        expectedList.get(0)[0] = new Dot(2, 3);
        expectedList.get(0)[1] = new Dot(3, 2);
        expectedList.get(0)[2] = new Dot(4, 5);

        Assert.assertEquals(result.get(4), expectedList.get(0));
    }
}
