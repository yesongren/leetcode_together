package src.category.JianZhiOffer.didi;

public class JZ11_MinArray {
    public int minArray(int[] a) {
        int l = 0, r = a.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < a[r]) r = mid;
            else if (a[mid] > a[r]) l = mid + 1;
            else {
                if (r != 0 && a[r] >= a[r - 1])
                    r--;
                else
                    return a[r];
            }
        }

        return a[r];
    }
}
