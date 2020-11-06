package com.company;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Crypto {
    static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public class Caesar implements BasicCrypto {
        @Override
        public String encrypt(String data) {
            data = data.toLowerCase();
            char[] arr = data.toCharArray();
            loop1:
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (arr[i] == alphabet[j] & j < 23) {
                        arr[i] = alphabet[j + 3];
                        continue loop1;
                    } else if (arr[i] == alphabet[j] & j > 22) {
                        arr[i] = alphabet[(j + 3) - alphabet.length];
                        continue loop1;
                    }
                }
            }
            return Arrays.toString(arr);
        }

        @Override
        public String decrypt(String data) {
            char[] arr = data.toCharArray();
            loop1:
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (arr[i] == alphabet[j] & j < 3) {
                        arr[i] = alphabet[alphabet.length - 3 + j];
                        continue loop1;
                    }else if (arr[i] == alphabet[j] & j > 2) {
                        arr[i] = alphabet[j - 3];
                        continue loop1;
                    }
                }
            }
            return Arrays.toString(arr);
        }


    }
}
