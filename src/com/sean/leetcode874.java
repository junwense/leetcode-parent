package com.sean;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName leetcode874
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/25
 * @Version V1.0
 **/
public class leetcode874 {


    public static void main(String[] args) {
        new leetcode874().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}});
    }

    /**
     * 时间复杂度 O(1)
     * 空间复杂度 O(n)
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        Set<Long> error = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            int[] obstacle = obstacles[i];
            error.add(getHash(obstacle[0], obstacle[1]));
        }
        int dir = 0;
        int x = 0;
        int y = 0;
        int[] xdir = new int[]{0, 1, 0, -1};
        int[] ydir = new int[]{1, 0, -1, 0};
        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                dir = (dir + 4 - 1) % 4;
            } else {
                for (int i = 1; i <= command; i++) {
                    if (error.contains(getHash(x + xdir[dir], y + ydir[dir]))) {
                        break;
                    }
                    x += xdir[dir];
                    y += ydir[dir];
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }

    /**
     * hash 函数，数组的二维寻址
     */
    private Long getHash(int x, int y) {
        return y * 60001L + x;
    }

}
