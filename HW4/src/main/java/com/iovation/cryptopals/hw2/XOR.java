package com.iovation.cryptopals.hw2;

public class XOR {
    public static String xor(String value, String xor) {
        return Conversion.fromByteArrayToHexdecimalString(
                xor(
                        Conversion.fromHexdecimalStringToByteArray(value),
                        Conversion.fromHexdecimalStringToByteArray(xor)
                )
        ).substring(0, value.length());
    }

    public static byte[] xor(byte[] value, byte[] xor) {
        var result = new byte[value.length];
        for(int i = 0; i < value.length; i++) {
            result[i] = (byte)(value[i] ^ xor[i % xor.length]);
        }
        return result;
    }
}
