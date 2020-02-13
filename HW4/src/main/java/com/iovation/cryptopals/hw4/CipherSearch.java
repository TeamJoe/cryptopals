package com.iovation.cryptopals.hw4;

import com.iovation.cryptopals.hw2.Conversion;
import com.iovation.cryptopals.hw2.XOR;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CipherSearch {
    private static final String frequency = "ETAOIN SHRDLU";

    private static IntStream of(byte[] s) {
        return IntStream.range(0, s.length).map(idx -> s[idx]);
    }

    private static int score(byte[] s) {
        return of(s).map(bite -> frequency.length() - frequency.indexOf(bite)).sum();
    }

    public static String SearchSingleXOR(String hex) {
        var bytes = Conversion.fromHexdecimalStringToByteArray(hex);
        byte[] result = {};
        int score = Integer.MIN_VALUE;
        for(int i = 0; i <= 255; i++) {
            var r2 = XOR.xor(bytes, new byte[] {(byte)i});
            var s2 = score(r2);
            if (s2 > score) {
                result = r2;
                score = s2;
            }
        }

        return new String(result, StandardCharsets.US_ASCII);
    }

    public static String SearchSingleXOR(String[] hexs) {
        var result = new AtomicReference<>("");
        var score = new AtomicInteger(Integer.MIN_VALUE);
        Stream.of(hexs).forEach(hex -> {
            var r2 = SearchSingleXOR(hex);
            var s2 = score(r2.getBytes(StandardCharsets.US_ASCII));
            if (s2 > score.get()) {
                result.set(r2);
                score.set(s2);
            }
        });

        return result.get();
    }
}