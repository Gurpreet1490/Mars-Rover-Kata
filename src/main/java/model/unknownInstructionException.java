package model;

public class unknownInstructionException extends RuntimeException {
    public unknownInstructionException(char instruction) {
        super("Unknown instruction " + instruction + "!");
    }
}
