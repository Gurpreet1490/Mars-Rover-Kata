package model;

import java.util.ArrayList;

public class RoverInstruction {
    private String instruction;

    public RoverInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Instruction[] getInstruction(){
        ArrayList<Instruction> result = new ArrayList<Instruction>();
        for (char c: instruction.toCharArray()) {
            switch (c) {
                case 'L':
                    result.add(Instruction.LEFT);
                    break;
                case 'R':
                    result.add(Instruction.MOVE);
                    break;
                case 'M':
                    result.add(Instruction.MOVE);
                    break;
                default:
                    throw new unknownInstructionException(c);
            }
        }
        return result.toArray(new Instruction[result.size()]);
    }
}
