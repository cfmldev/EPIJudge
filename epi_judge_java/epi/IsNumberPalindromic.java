package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsNumberPalindromic {
	@EpiTest(testDataFile = "is_number_palindromic.tsv")
	public static boolean isPalindromeNumber(int x) {
		if (x < 0) {
			return false;
		}
		// Get the number of digits in a number
		int numDigits = (int) Math.floor(Math.log10(x)) + 1;
		int mask = (int) Math.pow(10, numDigits - 1);
		for (int i = 0; i < numDigits / 2; i++) {
			if (x / mask != x % 10) {
				return false;
			}
			x = x % mask;
			x = x / 10;
			mask = mask / 100;
		}
		return true;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "IsNumberPalindromic.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
