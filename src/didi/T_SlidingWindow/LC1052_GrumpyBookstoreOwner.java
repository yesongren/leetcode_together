package src.didi.T_SlidingWindow;

public class LC1052_GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if (customers.length == 0) return 0;
        int openTime = customers.length;
        int save = 0, totalCustomer = 0, totalGrumpy = 0;
        int maxSave = Integer.MIN_VALUE;

        for (int i = 0; i < openTime; i++) {
            totalCustomer += customers[i];
            totalGrumpy += customers[i] * grumpy[i];
            save += customers[i] * grumpy[i];
            if (i + 1 > X) {
                save -= customers[i - X] * grumpy[i - X];
            }
            maxSave = Math.max(save, maxSave);
        }

        return totalCustomer - totalGrumpy + maxSave;
    }
}
