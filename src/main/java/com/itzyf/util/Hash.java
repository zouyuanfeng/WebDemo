//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.itzyf.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Hash {
    private static final Log log = LogFactory.getLog(Hash.class);
    private static final String ENCODE = "UTF-8";

    public Hash() {
    }

    public static final byte[] hash2byte(String text, String algorithm) {
        byte[] ptext = (byte[])null;

        try {
            byte[] strTemp = text.getBytes("UTF-8");
            MessageDigest mdt = MessageDigest.getInstance(algorithm);
            if (log.isDebugEnabled()) {
                log.debug("provider:" + mdt.getProvider());
                log.debug("DigestLength:" + mdt.getDigestLength());
            }

            mdt.update(strTemp);
            byte[] md = mdt.digest();
            ptext = md;
        } catch (NoSuchAlgorithmException var6) {
            log.error("摘要算法[" + algorithm + "]法异常!", var6);
        } catch (Exception var7) {
            log.error(var7);
        }

        if (log.isDebugEnabled()) {
            log.debug("密文：" + ptext + " 明文：" + text);
        }

        return ptext;
    }

    public static final String hash(String text, String algorithm) {
        return HexUtil.toHexString(hash2byte(text, algorithm));
    }
}
