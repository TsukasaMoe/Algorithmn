package moe.tsukasa.algorithmns.leetcode.solution.tree;

import java.util.Arrays;

/**
 * <p>
 * Class/Interface/Enum/Annotation description
 * </p>
 *
 * @package: moe.tsukasa.algorithmns.leetcode.solution.tree
 * @description: Description message
 * @author: Tsukasa
 * @date: Created in 2021/6/15 22:18
 * @copyright: Copyright (c) 2021
 * @version: V1.0
 * @modified: Tsukasa
 */
public class Solution322 {
    int[] coins;
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        memo = new int[amount + 1];
        Arrays.fill(memo, 0);
        int r = dp(amount);
        return r;
    }

    private int dp(int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != 0) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subProblem = dp(amount - coins[i]);
            // 子问题无解则跳过
            if (subProblem == -1) {
                continue;
            } else {
                res = Math.min(1 + subProblem, res);
            }
        }

        if (res != Integer.MAX_VALUE) {
            memo[amount] = res;
            return memo[amount];
        } else {
            memo[amount] = -1;
            return -1;
        }
    }

    /**
     * 迭代数组dp解法
     */
    public int coinChange2(int[] coins, int amount) {

        return 1;
    }
}
