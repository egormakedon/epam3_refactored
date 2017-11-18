package by.makedon.epam3.validator;

public class TriangleIndexValidator {
    public boolean validate(int index) {
        final int DOT_AMOUNT = 3;
        return index >= 0 && index < DOT_AMOUNT;
    }
}