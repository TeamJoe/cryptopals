package com.iovation.cryptopals.hw2;

public class Conversion {
    public static byte[] fromHexdecimalStringToByteArray(String hex) {
        var value = new byte[(hex.length() / 2) + (hex.length() % 2)];
        for(int i = 0; i < hex.length(); i += 2) {
            value[i/2] = (byte)((getBinaryFromHexdecimal(hex.charAt(i)) << 4) + ((i+1) < hex.length() ? getBinaryFromHexdecimal(hex.charAt(i+1)) : 0));
        }
        return value;
    }

    public static String fromByteArrayToHexdecimalString(byte[] value) {
        var result = "";

        for(int i = 0; i < value.length; i++) {
            result += getHexdecimalFromBinary(value[i]);
        }

        return result;
    }

    private static byte getBinaryFromHexdecimal(char hex) {
        return (byte)Character.digit(hex, 16);
    }

    private static String getHexdecimalFromBinary(byte hex) {
        return Integer.toHexString((hex & 0xF0) >>> 4) + Integer.toHexString(hex & 0x0F);
    }
}