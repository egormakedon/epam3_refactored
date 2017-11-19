package by.makedon.epam3.action;

import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleAction {
    private final static Logger LOGGER = LogManager.getLogger(TriangleAction.class);

    public double calculateArea(Triangle triangle) {
        List<Double> sides = calculateSides(triangle);
        double side1 = sides.get(0);
        double side2 = sides.get(1);
        double side3 = sides.get(2);
        double halfPerimeter = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3));
        LOGGER.log(Level.INFO, "triangle " + triangle.toString() + " has area " + area);
        return area;
    }

    public double calculatePerimeter(Triangle triangle) {
        List<Double> sides = calculateSides(triangle);
        double perimeter = sides.get(0) + sides.get(1) + sides.get(2);
        LOGGER.log(Level.INFO, "triangle " + triangle.toString() + " has perimeter " + perimeter);
        return perimeter;
    }

    private List<Double> calculateSides(Triangle triangle) {
        Dot dot1 = triangle.getDot(0);
        Dot dot2 = triangle.getDot(1);
        Dot dot3 = triangle.getDot(2);
        List<Double> sides = new ArrayList<Double>();
        DotAction dotAction = new DotAction();
        sides.add(dotAction.calculateDistance(dot1, dot2));
        sides.add(dotAction.calculateDistance(dot2, dot3));
        sides.add(dotAction.calculateDistance(dot1, dot3));
        return sides;
    }
}