package com.iovation.cryptopals;

import com.iovation.cryptopals.hw4.CipherSearch;
import com.iovation.cryptopals.hw4.FileLoader;

public class Main {
    public static int main(String args[]) throws Throwable {
        System.out.println(CipherSearch.SearchSingleXOR(FileLoader.getLines("hw4.txt")));
        return 0;
    }
}
