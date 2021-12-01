package fr.syalioune.advent.depth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/depth-measurement-input.txt"));
        List<Integer> measurements = lines.stream().map(line -> Integer.parseInt(line)).collect(Collectors.toList());
        DepthMeter depthMeter = new DepthMeter();
        System.out.println(depthMeter.countIncreases(measurements));
    }

}
