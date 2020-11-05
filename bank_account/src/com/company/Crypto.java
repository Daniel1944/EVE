package com.company;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Crypto {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    class Ceasar implements BasicCrypto {
        @Override
        public String encryp(String data) {
            char[] arr = data.toCharArray();
            loop1:
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (arr[i] == alphabet[j]) {
                        arr[i] = alphabet[j + 3];
                        continue loop1;
                    }
                }
            }
            return Arrays.toString(arr);
        }

        @Override
        public String decryp(String data) {
            char[] arr = data.toCharArray();
            loop1:
            for (int k = 0; k < arr.length; k++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (arr[k] == alphabet[j]) {
                        arr[k] = alphabet[j - 3];
                        continue loop1;
                    }
                }
            }
            return Arrays.toString(arr);
        }
    }

}
