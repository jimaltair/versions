package com.reflectoring.io.java17;

import java.util.Arrays;
import java.util.HexFormat;

public class HexFormatTesting {
    public static void main(String[] args) {
        // позволяет отформатировать, например, массив байтов в виде шестнадцатеричной строчки
        HexFormat format = HexFormat
                .ofDelimiter(":")
                .withUpperCase()
                .withPrefix("[")
                .withSuffix("]");
        byte[] input = {(byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE};
        String asString = format.formatHex(input);
        System.out.println(asString);
        // [CA]:[FE]:[BA]:[BE]
        byte[] output = format.parseHex(asString);
        assert Arrays.equals(input, output);
    }
}
