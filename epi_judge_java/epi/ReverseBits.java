package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class ReverseBits {
	@EpiTest(testDataFile = "reverse_bits.tsv")
	public static long reverseBits(long x) {
		int index = 0;
		while (index < 32) {
			x = swapBits(x, index, (64 - index - 1));
			index++;
		}
		return x;
	}

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
		System.exit(GenericTest.runFromAnnotations(args, "ReverseBits.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
