package fr.syalioune.advent.compass;

import fr.syalioune.advent.compass.Compass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class CompassTest {

    @MethodSource("forwardSource")
    @ParameterizedTest
    public void shouldAddTheGivenStepNumberForwardToHorizontalPosition(int initialHorizontalPosition, int initialDepth, int stepNumber, int horizontalPosition) {
        // Arrange
        Compass compass = new Compass(initialHorizontalPosition, initialDepth);

        // Act
        compass.forward(stepNumber);

        // Assert
        Assertions.assertEquals(horizontalPosition, compass.getHorizontalPosition());
    }

    @MethodSource("upSource")
    @ParameterizedTest
    public void shouldDecreaseTheDepthByTheGivenNumberOfSteps(int initialHorizontalPosition, int initialDepth, int stepNumber, int depth) {
        // Arrange
        Compass compass = new Compass(initialHorizontalPosition, initialDepth);

        // Act
        compass.up(stepNumber);

        // Assert
        Assertions.assertEquals(depth, compass.depth());
    }

    @MethodSource("downSource")
    @ParameterizedTest
    public void shouldIncreaseTheDepthByTheGivenNumberOfSteps(int initialHorizontalPosition, int initialDepth, int stepNumber, int depth) {
        // Arrange
        Compass compass = new Compass(initialHorizontalPosition, initialDepth);

        // Act
        compass.down(stepNumber);

        // Assert
        Assertions.assertEquals(depth, compass.depth());
    }

    @MethodSource("instructionsSource")
    @ParameterizedTest
    public void shouldCorrectlyFollowTheInstructions(List<String> instructions, int finalHorizontalPosition, int finalDepth) {
        // Arrange
        Compass compass = new Compass(0, 0);

        // Act
        compass.followInstructions(instructions);

        // Assert
        Assertions.assertEquals(finalHorizontalPosition, compass.getHorizontalPosition());
        Assertions.assertEquals(finalDepth, compass.depth());
        Assertions.assertEquals(finalHorizontalPosition*finalDepth, compass.scalar());
    }

    static Stream<Arguments> forwardSource() {
        return Stream.of(
            Arguments.arguments(0, 0, 0, 0),
            Arguments.arguments(0, 0, 10, 10),
            Arguments.arguments(0, 0, 15, 15),
            Arguments.arguments(10, 0, 15, 25),
            Arguments.arguments(2, 0, 10, 12),
            Arguments.arguments(10, 0, 10, 20)
        );
    }

    static Stream<Arguments> upSource() {
        return Stream.of(
            Arguments.arguments(0, 0, 0, 0),
            Arguments.arguments(0, 0, 10, -10),
            Arguments.arguments(0, 0, 15, -15),
            Arguments.arguments(0, 20, 15, 5),
            Arguments.arguments(0, 10, 5, 5),
            Arguments.arguments(0, 10, 10, 0)
        );
    }

    static Stream<Arguments> downSource() {
        return Stream.of(
            Arguments.arguments(0, 0, 0, 0),
            Arguments.arguments(0, 0, 10, 10),
            Arguments.arguments(0, 0, 15, 15),
            Arguments.arguments(0, 20, 15, 35),
            Arguments.arguments(0, 10, 5, 15),
            Arguments.arguments(0, 10, 10, 20)
        );
    }

    static Stream<Arguments> instructionsSource() {
        return Stream.of(
            Arguments.arguments(List.of("forward 5"), 5, 0),
            Arguments.arguments(List.of("up 5"), 0, -5),
            Arguments.arguments(List.of("down 3"), 0, 3),
            Arguments.arguments(List.of("forward 5", "down 5"), 5, 5),
            Arguments.arguments(List.of("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"), 15, 10)
        );
    }
}
