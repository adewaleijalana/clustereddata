package com.bloomberg.clustereddata.domain.xtras;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;


public enum ID {

    INSTANCE;

    private static final Random RANDOM1;
    private static final Random RANDOM2;
    private static final Random RANDOM3;
    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final long globalProcessID;
    static Logger LOGGER = LoggerFactory.getLogger(ID.class);

    static {
        long time = System.currentTimeMillis();
        long nanoTime = System.nanoTime();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long addressHashCode;
        try {
            InetAddress inetAddress;
            inetAddress = InetAddress.getLocalHost();
            addressHashCode = inetAddress.getHostName().hashCode()
                    ^ inetAddress.getHostAddress().hashCode();
        } catch (Exception err) {
            LOGGER.warn("Unable to get local host information.", err);
            addressHashCode = ID.class.hashCode();
        }
        globalProcessID = time ^ nanoTime ^ freeMemory ^ addressHashCode;
        RANDOM1 = new Random(time);
        RANDOM2 = new Random(nanoTime);
        RANDOM3 = new Random(addressHashCode ^ freeMemory);
    }

    public static void main(String[] arg) {

        for (int i = 0; i < 20; i++) {
            System.out.println(ID.generateUUIDString());

        }
        System.out.println(ID.generateUUIDString());
        System.out.println(ID.generateBigInteger());
        System.out.println(ID.generateBigInteger());
        System.out.println(random(1, 9));
        System.out.println(random(1, 9));
        System.out.println(random(1, 9));
        System.out.println(random(1, 9));
        System.out.println(getGlobalProcessID());

        for (int i = 0; i < 20; i++) {
            generateRandomCharacters(5);

        }

    }

    public static long generateLong() {
        return Math.abs(RANDOM1.nextLong() ^ RANDOM2.nextLong() ^ RANDOM3.nextLong());
    }


    public static String generateUUIDString() {
        UUID uuid = UUID.randomUUID();
//		UUID uuid = getTimeUUID();
        String randomUUIDString = uuid.toString().replaceAll("-", "").toUpperCase();

        return randomUUIDString;

    }

    public static BigInteger generateBigInteger() {
        return BigInteger.valueOf(generateLong());
    }


    /**
     * Gets a process ID that is nearly guaranteed to be globally unique.
     */
    public static long getGlobalProcessID() {
        return globalProcessID;
    }

    public static int random(int min, int max) {
        if (max <= min) {
            return min;
        }
        return Math.abs(RANDOM1.nextInt()) % (max - min) + min;
    }


    public static String generateRandomCharacters(int num, String characterSpace){

        Random r = new Random();
        String generatedString = "";
        for (int i = 0; i < num; i++) {
//			char letter = (abc).charAt(r.nextInt(62));
//			char letter = (abc).charAt(r.nextInt(34));
            char letter = (characterSpace).charAt(RANDOM2.nextInt(characterSpace.length()));
            generatedString += letter;
//            System.out.print("Random Letter " + letter);
        }
        LOGGER.debug("Random generatedString:- {}", generatedString);
        return generatedString;
    }

    public static String generateRandomCharacters(int num) {

        final String abc = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";

        return generateRandomCharacters(num, abc);
    }




}

