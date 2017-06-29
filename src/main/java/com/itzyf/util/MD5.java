//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.itzyf.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class MD5 {
    private static final Log log = LogFactory.getLog(MD5.class);
    private static final String ALGORITHM = "MD5";

    public MD5() {
    }

    public static final String hash(String text) {
        String ptext = Hash.hash(text, "MD5");
        if (log.isDebugEnabled()) {
            log.debug("密文：" + ptext + " 明文：" + text);
        }

        return ptext;
    }

    public static final String hash16(String text) {
        String ptext = Hash.hash(text, "MD5").substring(8, 24);
        if (log.isDebugEnabled()) {
            log.debug("密文：" + ptext + " 明文：" + text);
        }

        return ptext;
    }
}
