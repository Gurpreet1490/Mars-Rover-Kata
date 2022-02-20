package model;

import java.util.ArrayList;

public class Instructions {
    private String instructions;

    public Instructions(String instructions) {
        this.instructions = instructions;
    }

    public InstructionType[] getInstruction(){
        ArrayList<InstructionType> result = new ArrayList<InstructionType>();
            for (char c: instructions.toCharArray()) {
                switch (c) {
                    case 'L':
                        result.add(InstructionType.LEFT);
                        break;
                    case 'R':
                        result.add(InstructionType.RIGHT);
                        break;
                    case 'M':
                        result.add(InstructionType.MOVE);
                        break;
                    default:
                        throw new UnknownInstructionException(c);
                }
            }
        return result.toArray(new InstructionType[result.size()]);
    }
}