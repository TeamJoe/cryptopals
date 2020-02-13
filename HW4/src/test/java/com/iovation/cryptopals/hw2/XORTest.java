package com.iovation.cryptopals.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XORTest {
    @Test
    void singleTest_String() {
        assertEquals("7", XOR.xor("1", "6"));
    }

    @Test
    void evenTest_String() {
        assertEquals("74", XOR.xor("1c", "68"));
    }

    @Test
    void oddTest_String() {
        assertEquals("746", XOR.xor("1c0", "686"));
    }

    @Test
    void longTest_String() {
        assertEquals("746865206b696420646f6e277420706c6179", XOR.xor("1c0111001f010100061a024b53535009181c", "686974207468652062756c6c277320657965"));
    }

    @Test
    void singleTest_ByteArray() {
        assertArrayEquals(new byte[]{ 0x7 }, XOR.xor(new byte[]{ 0x1 }, new byte[]{ 0x6 }));
    }

    @Test
    void evenTest_ByteArray() {
        assertArrayEquals(new byte[]{ 0x74 }, XOR.xor(new byte[]{ 0x1c }, new byte[]{ 0x68 }));
    }

    @Test
    void oddTest_ByteArray() {
        assertArrayEquals(new byte[]{ 0x74, 0x6 }, XOR.xor(new byte[]{ 0x1c, 0x0 }, new byte[]{ 0x68, 0x6 }));
    }

    @Test
    void longTest_ByteArray() {
        assertArrayEquals(new byte[]{ 0x74, 0x68, 0x65, 0x20 }, XOR.xor(new byte[]{ 0x1c, 0x01, 0x11, 0x00 }, new byte[]{ 0x68, 0x69, 0x74, 0x20 }));
    }
}
