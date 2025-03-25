public class Solution {
    public int solution(int[] wallet, int[] bill) {
        int folds = 0;
        
        int walletSmall = Math.min(wallet[0], wallet[1]);
        int walletLarge = Math.max(wallet[0], wallet[1]);

        while (Math.min(bill[0], bill[1]) > walletSmall ||
               Math.max(bill[0], bill[1]) > walletLarge) {
            if (bill[0] >= bill[1]) {
                bill[0] = bill[0] / 2;
            } else {
                bill[1] = bill[1] / 2;
            }
            folds++;
        }
        return folds;
    }
}
