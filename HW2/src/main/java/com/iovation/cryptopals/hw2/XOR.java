package com.iovation.cryptopals.hw2;

public class XOR {
    public static String xor(String value, String xor) {
        return toHex(xor(toBin(value), toBin(xor))).substring(0, value.length());
    }

    public static byte[] xor(byte[] value, byte[] xor) {
        var result = new byte[value.length];
        for(int i = 0; i < value.length; i++) {
            result[i] = (byte)(value[i] ^ xor[i % xor.length]);
        }
        return result;
    }

    private static byte[] toBin(String hex) {
        var value = new byte[(hex.length() / 2) + (hex.length() % 2)];
        for(int i = 0; i < hex.length(); i += 2) {
            value[i/2] = (byte)((getBinaryFromHex(hex.charAt(i)) << 4) + ((i+1) < hex.length() ? getBinaryFromHex(hex.charAt(i+1)) : 0));
        }
        return value;
    }

    private static String toHex(byte[] value) {
        var result = "";

        for(int i = 0; i < value.length; i++) {
            result += getHexFromBinary(value[i]);
        }

        return result;
    }

    private static byte getBinaryFromHex(char hex) {
        return (byte)Character.digit(hex, 16);
    }

    private static String getHexFromBinary(byte hex) {
        return Integer.toHexString((hex & 0xF0) >>> 4) + Integer.toHexString(hex & 0x0F);
    }
}
