package fr.syalioune.advent.depth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class DepthMeterTest {

    @Test
    public void shouldThrowAnExceptionWhenProvidedWithANullMeasurementList() {
        // Arrange
        DepthMeter depthMeter = new DepthMeter();

        // Act
        Assertions.assertThrows(IllegalArgumentException.class, () -> depthMeter.countIncreases(null));


        // Assert
        // Nothing to be done here
    }

    @Test
    public void shouldReturnZeroWithAnEmptyMeasurementList() {
        // Arrange
        DepthMeter depthMeter = new DepthMeter();

        // Act
        int result = depthMeter.countIncreases(Collections.emptyList());

        // Assert
        Assertions.assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("listWithLessThanFourElements")
    public void shouldReturnZeroWithAListWithLessThanFourElements(List<Integer> measurements, int increaseCount) {
        // Arrange
        DepthMeter depthMeter = new DepthMeter();

        // Act
        int result = depthMeter.countIncreases(measurements);

        // Assert
        Assertions.assertEquals(increaseCount, result);
    }

    @ParameterizedTest
    @MethodSource("listWithMoreThanFourElements")
    public void shouldReturnZeroWithAListWithMoreThanFourElements(List<Integer> measurements, int increaseCount) {
        // Arrange
        DepthMeter depthMeter = new DepthMeter();

        // Act
        int result = depthMeter.countIncreases(measurements);

        // Assert
        Assertions.assertEquals(increaseCount, result);
    }

    static Stream<Arguments> listWithLessThanFourElements() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(199), 0),
                Arguments.arguments(Arrays.asList(199, 200), 0),
                Arguments.arguments(Arrays.asList(199, 200, 201), 0)
        );
    }

    static Stream<Arguments> listWithMoreThanFourElements() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(607,618,618,617,647,716,769,792), 5),
                Arguments.arguments(Arrays.asList(199,200,208,210), 1)
        );
    }

}
