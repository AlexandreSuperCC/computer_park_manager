package com.ap4b.util;

/**
 * c'est un outil pour vérifier le string est null ou pas
 * @author 18019
 *
 */
public class StringUtil {

	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isNotEmpty(String str) {
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
