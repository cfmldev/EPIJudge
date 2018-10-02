package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SwapBits {
	@EpiTest(testDataFile = "swap_bits.tsv")
	public static long swapBits(long x, int i, int j) {
		// Compare ith and jth bits. If both are same, no changes. If different flip
		// both the bits.
		long ithBitSet = (x >>> i) & 1;
		long jthBitSet = (x >>> j) & 1;
		if (ithBitSet != jthBitSet) {
			long mask = (1l << i) | (1l << j);
			x = x ^ mask;
		}
		return x;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "SwapBits.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
