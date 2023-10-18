package edu.escuelaing.arep.app.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashGenerator {
    public static String generator(String input) {
        byte[] encodedHash = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            encodedHash = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        StringBuilder hexStr = new StringBuilder();
        for (byte b: encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexStr.append('0');
            hexStr.append(hex);
        }

        return hexStr.toString();
    }
}
