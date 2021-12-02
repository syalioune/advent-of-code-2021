package fr.syalioune.advent.compass;

import java.util.List;

public class Compass {

    private int horizontalPosition = 0;
    private int depth = 0;
    private int aim = 0;

    public Compass(int initialHorizontalPosition, int initialDepth, int initialAim) {
        this.horizontalPosition = initialHorizontalPosition;
        this.depth = initialDepth;
        this.aim = initialAim;
    }


    public void forward(int stepNumber) {
        this.horizontalPosition += stepNumber;
        this.depth += this.aim*stepNumber;
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public void up(int stepNumber) {
        this.aim -= stepNumber;
    }

    public void down(int stepNumber) {
        this.aim += stepNumber;
    }

    public int depth() {
        return depth;
    }

    public void followInstructions(List<String> instructions) {
        for (int i = 0; i < instructions.size(); i++) {
            String instruction = instructions.get(i);
            if(instruction.startsWith("forward")) {
                forward(Integer.parseInt(instruction.split(" ")[1]));
            } else if(instruction.startsWith("up")) {
                up(Integer.parseInt(instruction.split(" ")[1]));
            } else if(instruction.startsWith("down")) {
                down(Integer.parseInt(instruction.split(" ")[1]));
            }
        }
    }

    public int scalar() {
        return this.depth * this.horizontalPosition;
    }

    public int aim() {
        return this.aim;
    }
}
