package blind75;

public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] test1 = {7, 1, 5, 3, 6, 4};
		int[] test2 = {7, 6, 5, 4, 3};
		
		System.out.println(maxProfit(test1));
		System.out.println(maxProfit(test2));
	}

	public static int maxProfit(int[] prices) {
		int currBuy = prices[0];
		int maxProfit = 0;
		
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < currBuy) {
				currBuy = prices[i];
			}
			else {
				maxProfit = Math.max(maxProfit, prices[i] - currBuy);
			}
		}
		
		return maxProfit;
	}
}
