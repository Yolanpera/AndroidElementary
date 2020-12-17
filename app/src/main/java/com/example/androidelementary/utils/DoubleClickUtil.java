package com.example.androidelementary.utils;

/**
 * Describe determines the tool class for continuous clicks
 * 1. Default double-click interval is 500ms
 * 2.setDefaultDuration () changes the default interval, and all using isDoubleClick (int viewId) uses the default interval
 * 3.isDoubleClick (int viewId,long duration) uses custom intervals
 * created at 16/11/21.
 */
public class DoubleClickUtil {
    private DoubleClickUtil() {
    }

    private static int sTag = -1;
    private static long sLastClick = 0;
    private static long sDuration = 500;

    /**
     * update the tag
     */
    private static void updateTag(int viewId) {
        if (sTag != viewId) {
            sTag = viewId;
            sLastClick = 0;
        }
    }

    /**
     * default duration
     * params viewID = R.id.xxx
     */
    public static boolean isDoubleClick(int viewId) {
        updateTag(viewId);
        return compare(sDuration);
    }

    /**
     * custom duration
     * params duration = 500
     */
    public static boolean isDoubleClick(int viewId, long duration) {
        updateTag(viewId);
        return compare(duration);
    }

    /**
     * compare the duration between two clicks
     */
    private static boolean compare(long duration) {
        long currentClick = System.currentTimeMillis();
        boolean isDouble = (currentClick - sLastClick) < duration;
        if (!isDouble) {
            sLastClick = currentClick;
        }
        return isDouble;
    }

    /**
     * set the default duration
     */
    public static void setDefaultDuration(long duration) {
        sDuration = duration;
    }

}

