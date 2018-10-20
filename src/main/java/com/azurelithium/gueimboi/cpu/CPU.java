package com.azurelithium.gueimboi.cpu;

import com.azurelithium.gueimboi.memory.MMU;

public class CPU {

    private Registers registers;
    private ISA isa;

    private MMU mmu;

    public CPU(MMU _mmu) {
        registers = new Registers();
        isa = new ISA(registers);
        mmu = _mmu;
    }

    public void runInstruction() {
        Instruction instruction = isa.getInstruction(0x7F);
        if (instruction == null) {
            System.out.println("Unrecognized operation, aborting...");
            System.exit(1);
        }
        instruction.execute();
        System.exit(0);        
    }
}