package roundA;
import java.util.*;
import java.io.*;

public class Allocation {

    public static void main(final String[] args) {

        final Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = s.nextInt();

        for (int ti = 1; ti <= t; ti++) {
            final int n = s.nextInt();
            final int k = s.nextInt();

            final long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = s.nextLong();
            }

            long l = 1;
            long r = arr[1] - arr[0];

            for (int i = 2; i < n; i++) {
                r = Math.max(r, arr[i] - arr[i - 1]);
            }

            long ans = r;

            while (l <= r) {
                final long m = (l + r) / 2;

                int p = 0;
                long session = arr[0];
                int i = 1;

                while (i < n) {
                    if (session + m < arr[i]) {
                        session = session + m;
                        p++;
                    } else {
                        session = arr[i];
                        i++;
                    }
                }

                if (p <= k) {
                    ans = m;
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

            System.out.println("Case #" + ti + ": " + ans);
        }
    }
}