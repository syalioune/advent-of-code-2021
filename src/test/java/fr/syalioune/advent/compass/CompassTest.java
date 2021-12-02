package fr.syalioune.advent.compass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class CompassTest {

    @MethodSource("forwardSource")
    @ParameterizedTest
    public void shouldAddTheGivenStepNumberForwardToHorizontalPosition(int initialHorizontalPosition, int initialDepth, int initialAim, int stepNumber, int horizontalPosition, int depth) {
        // Arrange
        Compass compass = new Compass(initialHorizontalPosition, initialDepth, initialAim);

        // Act
        compass.forward(stepNumber);

        // Assert
        Assertions.assertEquals(horizontalPosition, compass.getHorizontalPosition());
        Assertions.assertEquals(depth, compass.depth());
    }

    @MethodSource("upSource")
    @ParameterizedTest
    public void shouldDecreaseTheDepthByTheGivenNumberOfSteps(int initialHorizontalPosition, int initialDepth, int initialAim, int stepNumber, int depth) {
        // Arrange
        Compass compass = new Compass(initialHorizontalPosition, initialDepth, initialAim);

        // Act
        compass.up(stepNumber);

        // Assert
        Assertions.assertEquals(depth, compass.aim());
    }

    @MethodSource("downSource")
    @ParameterizedTest
    public void shouldIncreaseTheDepthByTheGivenNumberOfSteps(int initialHorizontalPosition, int initialDepth, int initialAim, int stepNumber, int depth) {
        // Arrange
        Compass compass = new Compass(initialHorizontalPosition, initialDepth, initialAim);

        // Act
        compass.down(stepNumber);

        // Assert
        Assertions.assertEquals(depth, compass.aim());
    }

    @MethodSource("instructionsSource")
    @ParameterizedTest
    public void shouldCorrectlyFollowTheInstructions(List<String> instructions, int finalHorizontalPosition, int finalDepth, int finalAim) {
        // Arrange
        Compass compass = new Compass(0, 0, 0);

        // Act
        compass.followInstructions(instructions);

        // Assert
        Assertions.assertEquals(finalHorizontalPosition, compass.getHorizontalPosition());
        Assertions.assertEquals(finalDepth, compass.depth());
        Assertions.assertEquals(finalAim, compass.aim());
        Assertions.assertEquals(finalHorizontalPosition*finalDepth, compass.scalar());
    }

    static Stream<Arguments> forwardSource() {
        return Stream.of(
            Arguments.arguments(0, 0, 0, 0, 0, 0),
            Arguments.arguments(0, 0, 0, 10, 10, 0),
            Arguments.arguments(0, 0, 0, 15, 15, 0),
            Arguments.arguments(10, 0, 10, 15, 25, 150),
            Arguments.arguments(2, 5, 10, 10, 12, 105)
        );
    }

    static Stream<Arguments> upSource() {
        return Stream.of(
            Arguments.arguments(0, 0, 0, 0, 0),
            Arguments.arguments(0, 0, 0, 10, -10),
            Arguments.arguments(0, 0, 0, 15, -15),
            Arguments.arguments(0, 20, 20, 15, 5),
            Arguments.arguments(0, 10, 10, 5, 5),
            Arguments.arguments(0, 10, 10, 10, 0)
        );
    }

    static Stream<Arguments> downSource() {
        return Stream.of(
            Arguments.arguments(0, 0, 0, 0, 0),
            Arguments.arguments(0, 0, 0, 10, 10),
            Arguments.arguments(0, 0, 0, 15, 15),
            Arguments.arguments(0, 20, 20, 15, 35),
            Arguments.arguments(0, 10, 10, 5, 15),
            Arguments.arguments(0, 10, 10, 10, 20)
        );
    }

    static Stream<Arguments> instructionsSource() {
        return Stream.of(
            Arguments.arguments(List.of("forward 5"), 5, 0, 0),
            Arguments.arguments(List.of("down 5"), 0, 0, 5),
            Arguments.arguments(List.of("up 3"), 0, 0, -3),
            Arguments.arguments(List.of("forward 5", "down 5", "forward 8"), 13, 40, 5),
            Arguments.arguments(List.of("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"), 15, 60, 10)
        );
    }
}
