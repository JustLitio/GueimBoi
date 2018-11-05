package com.azurelithium.gueimboi.memory;

import java.nio.ByteOrder;
import org.apache.commons.lang3.ArrayUtils;

public class MMU {

    private static final ByteOrder BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;

    private RAM ram;    

    public MMU() {
        ram = new RAM();
        ram.writeBytes(0x0000, ROM.GAMEBOY_ROM);
        ram.writeBytes(0x0104, ROM.NINTENDO_LOGO);
    }

    public int readByte(int address) {
        return ram.readByte(address);
    }

    public void writeByte(int address, int value) {
        ram.writeByte(address, value);
    }

    public int[] readBytes(int address, int count) {
        int[] bytes = ram.readBytes(address, count);
        if (BYTE_ORDER == ByteOrder.LITTLE_ENDIAN) {
            ArrayUtils.reverse(bytes);
        }
        return bytes;
    }

    public void writeBytes(int address, int[] bytes) {
        if (BYTE_ORDER == ByteOrder.LITTLE_ENDIAN) {
            ArrayUtils.reverse(bytes);
        }
        ram.writeBytes(address, bytes);
    }

}
