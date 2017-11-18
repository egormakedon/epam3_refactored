package by.makedon.epam3.validator;

import java.util.regex.Pattern;

public class DotParserValidator {
    public boolean validate(String data) {
        final String REGEXP_FOR_DOT_VALIDATION = "(-*)\\d{1,}.\\d{1,}\\s" +
                                                 "(-*)\\d{1,}.\\d{1,}\\s" +
                                                 "(-*)\\d{1,}.\\d{1,}\\s" +
                                                 "(-*)\\d{1,}.\\d{1,}\\s" +
                                                 "(-*)\\d{1,}.\\d{1,}\\s" +
                                                 "(-*)\\d{1,}.\\d{1,}";
        Pattern pattern = Pattern.compile(REGEXP_FOR_DOT_VALIDATION);
        return pattern.matcher(data).matches();
    }
}