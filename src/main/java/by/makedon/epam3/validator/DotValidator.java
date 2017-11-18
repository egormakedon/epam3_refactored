package by.makedon.epam3.validator;

import by.makedon.epam3.action.DotAction;
import by.makedon.epam3.entity.Dot;

public class DotValidator {
    public boolean validate(Dot dot1, Dot dot2, Dot dot3) {
        DotAction dotAction = new DotAction();
        double side1 = dotAction.calculateDistance(dot1, dot2);
        double side2 = dotAction.calculateDistance(dot2, dot3);
        double side3 = dotAction.calculateDistance(dot1, dot3);
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }
}