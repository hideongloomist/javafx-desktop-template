package com.example.javadesktop.shared;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String toMD5(String data) throws NoSuchAlgorithmException {

        // Static getInstance method is called with hashing MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        // digest() method is called to calculate message digest
        // of an input digest() return array of byte
        byte[] messageDigest = md.digest(data.getBytes());
        // Convert byte array into signal representation
        BigInteger no = new BigInteger(1, messageDigest);
        // Convert message digest into hex value
        StringBuilder hashText = new StringBuilder(no.toString(16));
        while (hashText.length() < 32) {
            hashText.insert(0, "0");
        }
        return hashText.toString();

    }

    public static String toSHA25(String data) throws NoSuchAlgorithmException {
        return toHexString(getSHA(data, "SHA-256"));
    }

    public static byte[] getSHA(String input, String algorithm) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance(algorithm);

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
