package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class ReverseDigits {
	@EpiTest(testDataFile = "reverse_digits.tsv")
	public static long reverse(int x) {
		long r = Math.abs(x);
		long reverse = 0;
		while (r != 0) {
			reverse = (reverse * 10) + (r % 10);
			r = r / 10;
		}
		return x < 0 ? -reverse : reverse;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "ReverseDigits.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
