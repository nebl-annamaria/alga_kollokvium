import java.util.*;

public class MCards {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int c = sc.nextInt();
		int n = sc.nextInt();

		List<Pair> card = new ArrayList<>();
		for (int i = 0; i < c * n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			card.add(new Pair(x, y));
		}

		System.out.println(minimumSwaps(c, n, card));
	}

	public static int minimumSwaps(int c, int n, List<Pair> card) {
		int res = Integer.MAX_VALUE;

		List<Integer> color = new ArrayList<>();
		int[] correct = new int[c * n];
		int[] dp = new int[c * n];

		for (int i = 0; i < c; i++) {
			color.add(i + 1);
		}

		do {
			Arrays.fill(dp, 1);
			int maxM = 0;

			for (int i = 0; i < c * n; i++) {
				correct[i] = n * (color.get(card.get(i).first - 1) - 1) + (card.get(i).second - 1);
			}

			for (int i = 0; i < c * n; i++) {
				for (int j = 0; j < i; j++) {
					if (correct[i] > correct[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				maxM = Math.max(maxM, dp[i]);
			}

			res = Math.min(res, c * n - maxM);
		} while (nextPermutation(color));

		return res;
	}

	private static boolean nextPermutation(List<Integer> list) {
		int n = list.size();
		int i = n - 2;

		while (i >= 0 && list.get(i) >= list.get(i + 1)) {
			i--;
		}

		if (i < 0) {
			return false;
		}

		int j = n - 1;
		while (list.get(j) <= list.get(i)) {
			j--;
		}

		Collections.swap(list, i, j);
		Collections.reverse(list.subList(i + 1, n));
		return true;
	}

	public static class Pair {
		int first, second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}
