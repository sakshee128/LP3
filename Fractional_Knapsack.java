import java.util.*;
class Fractional_Knapsack {
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class PairComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            double v1 = (double) p1.first / p1.second;
            double v2 = (double) p2.first / p2.second;

            if (v1 > v2) {
                return -1;
            } else if (v1 < v2) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of items:");
        int n = scanner.nextInt();
        ArrayList<Pair> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
        	System.out.println("Enter value of item:");
            int first = scanner.nextInt();
        	System.out.println("Enter weight of item:");
            int second = scanner.nextInt();
            a.add(new Pair(first, second));
        }
    	System.out.println("Enter weight of knapsack:");
        int w = scanner.nextInt();
        scanner.close();

        a.sort(new PairComparator());
        double ans = 0.0;

        for (int i = 0; i < n; i++) {
            if (w >= a.get(i).second) {
                ans += a.get(i).first;
                w -= a.get(i).second;
            } else {
                double vw = (double) a.get(i).first / a.get(i).second;
                ans += vw * w;
                w = 0;
                break;
            }
        }

        System.out.println(ans);
    }
}