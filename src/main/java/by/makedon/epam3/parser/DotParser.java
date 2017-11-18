package by.makedon.epam3.parser;

import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.exception.WrongDataException;
import by.makedon.epam3.validator.DotParserValidator;
import by.makedon.epam3.validator.DotValidator;

public class DotParser {
    public Dot[] parse(String data, String delimiter) throws WrongDataException {
        DotParserValidator dotParserValidator = new DotParserValidator();
        if (dotParserValidator.validate(data)) {
            final int DOT_AMOUNT = 3;
            String[] strings = data.split(delimiter);

            if (strings.length == 6) {
                Dot[] dots = new Dot[DOT_AMOUNT];
                dots[0] = new Dot((Double.parseDouble(strings[0])), Double.parseDouble(strings[1]));
                dots[1] = new Dot((Double.parseDouble(strings[2])), Double.parseDouble(strings[3]));
                dots[2] = new Dot((Double.parseDouble(strings[4])), Double.parseDouble(strings[5]));

                DotValidator dotValidator = new DotValidator();
                if (dotValidator.validate(dots[0], dots[1], dots[2])) {
                    return dots;
                } else {
                    throw new WrongDataException(data + " hasn't read: dots don't compose a triangle");
                }
            } else {
                throw new WrongDataException(data + " hasn't read: number of parameters not equal " + DOT_AMOUNT);
            }
        } else {
            throw new WrongDataException(data + " hasn't read: wrong parameters");
        }
    }
}