package org.core.base.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		validate("Thebegining", "^The[a-z]*");
		validate("sse", "[^The]*");
		validate("At", "^A");
		validate("end", "end$");
		validate("Start", "\\b[S]\\w*");
		validate("the lion roar", "roar");
		
		validate("abccccc", "abc*");
		validate("ab", "abc*");
		validate("abccc", "abc+");
		validate("ab", "abc+");
		validate("ab", "abc?");
		validate("abc", "abc?");
		validate("abcccc", "abc?");
		validate("abc", "abc{2}");
		validate("abcc", "abc{2}");
		validate("abcccccccc", "abc{2,}");
		validate("abcccccccc", "abc{2,5}");
		validate("abccc", "abc{2,5}");
		validate("abc", "a(bc)*");
		validate("abcb", "a(bc)*");
		validate("abcbcbc", "a(bc)*");
		validate("abcbcbc", "a(bc){2,5}");
		
		validate("ab", "a(b|c)");
		validate("abc", "a(b|c)");
		validate("ab", "a[bc]");
		validate("abc", "a[bcd]");
		
		validate("223", "\\d*");
		validate("223s", "\\d*");
		validate("sasak", "\\w*");
		validate("312_sasak", "\\w*");
		validate("312_@sasak", "\\w*");
		validate("	sa","\\s\\w*");
		validate("qwer", "\\D");
		validate("qwer", "\\D*");
		validate("qwer123", "\\D*");
		validate("%$#", "\\W*");
		validate("$abc", "\\$\\w+");
		validate("@abc", "\\@\\w+");
		validate("abd", ".");
		validate("h", ".");
		validate("hsdfkj", ".*");
		
		validate("abc", "a(bc)+");
		validate("abc", "a(?:bc)+");
		validate("abc", "a(?<gName>bc)+");
		displayGroup("abc", "a(bc)+");
		displayGroup("abc", "a(?:bc)+");
		
		validate("abc", "[abc]*");
		validate("ac", "[abc]");
		validate("b", "[abc]");
		validate("b", "a|b|c");
		validate("abc", "[a-c]*");
		validate("abc012", "[0-9a-zA-Z]*");
		validate("A12", "[^a-z]*");
		validate("Aas12", "[^a-z]*");
		
		validate("<div>simple div</div>", "<.+>");
		validate("<div>simple div</div>", "<.+?>");
		validate("<div>simple div</div>", "<[^<>]+>");
		validate("<div>", "<[^<>]+>");
		
		validate("abc", "\\babc\\b");
		validate("abcd", "\\babc\\b");
		validate("abc", "\\Babc\\B");
		validate("frew", "\\Babc\\B");
		
		validate("abc", "a(?=bc)");
		validate("dr", "d(?=r)");
		
		validate("99", "\\d{1,2}");
		validate("100", "\\d{1,2}");
		
		
	}

	private static void displayGroup(String value, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	private static void validate(String value, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		System.out.println("String = "+value+" | Regex = "+regex+" | matches: "+matcher.matches());
	}

}
