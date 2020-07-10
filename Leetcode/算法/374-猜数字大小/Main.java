/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        double l = 1, r = n;
        while (true) {
            int mid = (int)((l + r) / 2);
            int comp = guess(mid);
            if (comp == 1) {
                l = mid + 1;
            }
            else if (comp == -1) {
                r = mid - 1;
            } else return mid;
        }
    }
}