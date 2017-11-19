package by.makedon.epam3.register;

import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.entity.Triangle;
import by.makedon.epam3.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TriangleRegister {
    private List<Triangle> triangleList = new ArrayList<Triangle>();
    private final static Logger LOGGER = LogManager.getLogger(TriangleRegister.class);

    private TriangleRegister() {}

    private static class SingletonHolder {
        private final static TriangleRegister INSTANCE = new TriangleRegister();
    }

    public static TriangleRegister getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void add(Dot[] dots) {
        Triangle triangle = null;
        try {
            triangle = new Triangle(dots);
        } catch (WrongDataException e) {
            LOGGER.log(Level.ERROR, e);
        }
        triangleList.add(triangle);
    }

    public int size() {
        return triangleList.size();
    }

    public Triangle get(int index) {
        return triangleList.get(index);
    }
}