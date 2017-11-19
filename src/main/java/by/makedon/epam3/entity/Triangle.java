package by.makedon.epam3.entity;

import by.makedon.epam3.action.DotAction;
import by.makedon.epam3.exception.WrongDataException;
import by.makedon.epam3.validator.DotValidator;
import by.makedon.epam3.validator.TriangleIndexValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Observable;

public class Triangle extends Observable {
    private Dot[] dots;
    private final int DOT_AMOUNT = 3;
    private final static Logger LOGGER = LogManager.getLogger(Triangle.class);

    public Triangle(Dot dot1, Dot dot2, Dot dot3) throws WrongDataException {
        DotValidator dotValidator = new DotValidator();
        if(dotValidator.validate(dot1, dot2, dot3)) {
            dots = new Dot[DOT_AMOUNT];
            dots[0] = dot1;
            dots[1] = dot2;
            dots[2] = dot3;
            LOGGER.log(Level.INFO, this.toString() + " create successfully");
        } else {
            throw new WrongDataException("Triangle hasn't created: wrong parameters");
        }
    }

    public Triangle(Dot[] dots) throws WrongDataException {
        DotValidator dotValidator = new DotValidator();
        if(dotValidator.validate(dots[0], dots[1], dots[2])) {
            this.dots = new Dot[DOT_AMOUNT];
            this.dots[0] = dots[0];
            this.dots[1] = dots[1];
            this.dots[2] = dots[2];
            LOGGER.log(Level.INFO, this.toString() + " create successfully");
        } else {
            throw new WrongDataException("Triangle hasn't created: wrong parameters");
        }
    }

    public void replaceDot(Dot newDot, int index) {
        TriangleIndexValidator triangleIndexValidator = new TriangleIndexValidator();
        if (triangleIndexValidator.validate(index)) {
            Dot currDot = dots[index];
            dots[index] = newDot;
            DotValidator dotValidator = new DotValidator();
            if (dotValidator.validate(dots[0], dots[1], dots[2])) {
                super.setChanged();
                this.notifyObservers();
            } else {
                dots[index] = currDot;
                LOGGER.log(Level.ERROR, "Can't replace " + dots[index].toString() + " to " + newDot.toString() + " in " + this.toString());
            }
        } else {
            LOGGER.log(Level.ERROR, "Wrong index: " + index);
        }
    }

    public Dot getDot(int index) {
        TriangleIndexValidator triangleIndexValidator = new TriangleIndexValidator();
        if (triangleIndexValidator.validate(index)) {
            return dots[index];
        } else {
            return null;
        }
    }

    public boolean isRect() {
        DotAction dotAction = new DotAction();
        return (dotAction.isRectangle(dots[1], dots[0], dots[2]) ||
                dotAction.isRectangle(dots[0], dots[1], dots[2]) ||
                dotAction.isRectangle(dots[1], dots[2], dots[0]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (DOT_AMOUNT != triangle.DOT_AMOUNT) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(dots, triangle.dots);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(dots);
        result = 31 * result + DOT_AMOUNT;
        return result;
    }

    @Override
    public String toString() {
        return dots[0].toString() + " " + dots[1].toString() + " " + dots[2].toString();
    }
}