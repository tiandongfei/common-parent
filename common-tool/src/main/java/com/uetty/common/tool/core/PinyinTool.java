package com.uetty.common.tool.core;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 汉字拼音工具
 * 使用pinyin4j库
 * @author vince
 */
public class PinyinTool {
	
	private static final int HANYU_START = Integer.valueOf("4E00", 16);
	private static final int HANYU_END = Integer.valueOf("9FA5", 16);
	
	/**
	 * 汉字转为小写拼音
	 */
	public static String toPinyinString(String str) {
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= HANYU_START && c <= HANYU_END) {
				try {
					String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c, format);
					sb.append(pinyins[0]);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 汉字转拼音，带音标
	 */
	public static String toPinyinWithTone(String str) {
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
		format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= HANYU_START && c <= HANYU_END) {
				try {
					String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c, format);
					sb.append(pinyins[0]);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 汉字转为大写拼音首字母
	 */
	public static String toPinyinAbbreviation(String name) {
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (c >= HANYU_START && c <= HANYU_END) {
				try {
					String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c, format);
					sb.append(pinyins[0].substring(0, 1));
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(toPinyinAbbreviation("慕容风"));
		System.out.println(toPinyinWithTone("耶律和"));
		System.out.println(toPinyinWithTone("慕容风"));
		System.out.println(toPinyinString("耶律和"));
	}
}
