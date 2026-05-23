class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l=0,r=0;
        while(l <= r && r < prices.length)
        {
            while(prices[l] > prices[r])
                l++;

            res = Math.max(res, prices[r] - prices[l]);
            r++;
        }
        return res;
    }
}
