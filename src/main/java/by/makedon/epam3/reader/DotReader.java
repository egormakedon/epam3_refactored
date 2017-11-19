package by.makedon.epam3.reader;

import by.makedon.epam3.entity.Dot;
import by.makedon.epam3.exception.WrongDataException;
import by.makedon.epam3.exception.IncorrectFileException;
import by.makedon.epam3.parser.DotParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DotReader {
    private final static Logger LOGGER = LogManager.getLogger(DotReader.class);

    public List<Dot[]> readFile(String filename, String delimiter) throws IncorrectFileException {
        File file = new File(filename);
        if (file.exists()) {
            LOGGER.log(Level.INFO,filename + " has found");
            Scanner scanner = null;
            List<Dot[]> dotList = new ArrayList<Dot[]>();
            try {
                scanner = new Scanner(new File(filename));
                DotParser dotParser = new DotParser();
                while (scanner.hasNextLine()) {
                    String stringData = scanner.nextLine();
                    try {
                        dotList.add(dotParser.parse(stringData, delimiter));
                        LOGGER.log(Level.INFO, stringData + " has read correct");
                    } catch (WrongDataException e) {
                        LOGGER.log(Level.ERROR, e);
                    }
                }
            } catch (FileNotFoundException exception) {
                LOGGER.log(Level.WARN, "unknown error");
            } finally {
                if (scanner != null) scanner.close();
            }
            if (!dotList.isEmpty()) {
                return dotList;
            } else {
                throw new IncorrectFileException(filename + "filename hasn't correct data");
            }
        } else {
            throw new IncorrectFileException(filename + " hasn't found");
        }
    }
}