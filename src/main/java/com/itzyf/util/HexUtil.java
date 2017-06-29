//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.itzyf.util;

public class HexUtil {
    private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public HexUtil() {
    }

    public static String toHexString(byte[] bytes) {
        char[] value = (char[])null;
        int j = bytes.length;
        value = new char[j * 2];
        int k = 0;

        for(int i = 0; i < j; ++i) {
            byte byte0 = bytes[i];
            value[k++] = hexDigits[byte0 >>> 4 & 15];
            value[k++] = hexDigits[byte0 & 15];
        }

        return new String(value);
    }
}
