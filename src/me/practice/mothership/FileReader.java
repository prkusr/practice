package me.practice.mothership;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public static final String RESOURCE_PATH = "src/me/practice/resources/";

    public static List<Number> readNumbersFromFile(String fileName, Class<? extends Number> t) throws IllegalArgumentException, IOException {
        if (fileName == null || fileName.isBlank())
            throw new IllegalArgumentException(fileName + " is not valid");

        if (t == null || !Parsers.parsers.containsKey(t)) {
            throw new IllegalArgumentException(t.getClass() + " is not valid number");
        }

        Function<String, Number> fn = Parsers.parsers.get(t);
        List<Number> lines;

        Path path = Paths.get(RESOURCE_PATH + fileName);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            Stream<String> stream = reader.lines();
            lines = stream
                    .flatMap((s) -> Stream.of(s.split(",")))
                    .map(s -> s.replaceAll(" ", ""))
                    .map(fn)
                    .collect(Collectors.toList());
            stream.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return lines;
    }

    public static List<String> readFromFile(String fileName) throws IllegalArgumentException {
        if (fileName == null || fileName.isBlank())
            throw new IllegalArgumentException(fileName + " is not valid");

        List<String> lines;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            lines = stream
                    .map((s) -> s.split(","))
                    .flatMap(Stream::of)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return lines;
    }
}
