package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class ClosestIntSameWeight {
	@EpiTest(testDataFile = "closest_int_same_weight.tsv")
	public static long closestIntSameBitCount(long x) {
		for (int i = 0; i <= 63; i++) {
			long ith = (x >>> i) & 1;
			long ip1th = (x >>> (i + 1)) & 1;
			if (ith != ip1th) {
				long mask = (1l << i) | (1l << (i + 1));
				return x ^ mask;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "ClosestIntSameWeight.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
