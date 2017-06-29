//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.itzyf.util;

import java.util.Collection;
import java.util.Map;

public final class NullUtil {
    private NullUtil() {
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(String obj) {
        return obj == null || "".equals(obj);
    }

    public static boolean isNull(Collection obj) {
        return obj == null || obj.size() == 0;
    }

    public static boolean isNull(Map obj) {
        return obj == null || obj.size() == 0;
    }

    public static boolean isNull(Object[] objs) {
        boolean flag = false;
        if (objs != null && objs.length != 0) {
            Object[] var5 = objs;
            int var4 = objs.length;

            for(int var3 = 0; var3 < var4; ++var3) {
                Object obj = var5[var3];
                flag = isNull(obj);
                if (flag) {
                    break;
                }
            }

            return flag;
        } else {
            flag = true;
            return flag;
        }
    }

    public static boolean isNull(String... objs) {
        boolean flag = false;
        if (objs != null && objs.length != 0) {
            String[] var5 = objs;
            int var4 = objs.length;

            for(int var3 = 0; var3 < var4; ++var3) {
                String obj = var5[var3];
                flag = isNull(obj);
                if (flag) {
                    break;
                }
            }

            return flag;
        } else {
            flag = true;
            return flag;
        }
    }
}
