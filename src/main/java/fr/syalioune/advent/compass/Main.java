package fr.syalioune.advent.compass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> instructions = Files.readAllLines(Path.of("src/main/resources/compass-input.txt"));
        Compass compass = new Compass(0,0);
        compass.followInstructions(instructions);
        System.out.println(compass.scalar());
    }

}
