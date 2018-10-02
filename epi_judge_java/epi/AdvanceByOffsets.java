package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvanceByOffsets {
	@EpiTest(testDataFile = "advance_by_offsets.tsv")
	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		return stepsToReach(maxAdvanceSteps, 0, 1, new HashMap<>()) != Integer.MAX_VALUE;
	}

	public static int stepsToReach(List<Integer> maxAdvanceSteps, int currentIndex, int completedSteps,
			Map<Integer, Integer> maxSteps) {
		if (maxAdvanceSteps.size() == 1) {
			return 1;
		}
		if (maxSteps.get(currentIndex) != null) {
			return maxSteps.get(currentIndex);
		}
		if (currentIndex >= maxAdvanceSteps.size()) {
			return completedSteps;
		}
		Integer maxStepsFromCurrentIndex = maxAdvanceSteps.get(currentIndex);
		if (maxStepsFromCurrentIndex == 0) {
			return Integer.MAX_VALUE;
		}
		int minSteps = Integer.MAX_VALUE;
		for (int i = 1; i <= maxStepsFromCurrentIndex; i++) {
			minSteps = Math.min(minSteps,
					stepsToReach(maxAdvanceSteps, currentIndex + i, completedSteps + 1, maxSteps));
		}
		maxSteps.put(currentIndex, minSteps);
		return minSteps;
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "AdvanceByOffsets.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
