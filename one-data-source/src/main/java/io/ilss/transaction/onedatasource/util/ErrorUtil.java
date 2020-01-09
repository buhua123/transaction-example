package io.ilss.transaction.onedatasource.util;

/**
 * @author feng
 */
public class ErrorUtil {
    public static void err(String msg) {
        throw new RuntimeException(msg);
    }
}
