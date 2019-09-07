package com.prt.util;

import org.apache.commons.lang3.StringUtils;

public final class Util {

    public static String sanitizeString(final String inputString) {
	String result = inputString;
	if (StringUtils.isNotEmpty(result))
	    result = result.trim();
	return result;
    }

    public static boolean isNullOrEmpty(final String inputString) {
	return StringUtils.isEmpty(inputString);
    }

}
