package com.hs.LeetCode02;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * TODO
 *
 * @author 微信公众号《和尚的破功之路》
 * @date 2022/1/19 08:09
 * version: 1.0
 */
public class LT84 {
    public int largestRectangleArea2(int[] heights) {
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int l, r;
            l = r = i;
            while (l > 0 && heights[l - 1] >= heights[i]) {
                l--;
            }

            while (r < heights.length - 1 && heights[r + 1] >= heights[i]) {
                r++;
            }
            ans = Math.max(ans, heights[i] * (r - l + 1));

        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        Deque<Rect> stack = new ArrayDeque<>();
        int ans = 0;
        int[] newHeights = new int[heights.length + 1];
        System.arraycopy(heights, 0, newHeights, 0, heights.length);
        System.out.println(newHeights.length + "--" +Arrays.toString(newHeights));
        newHeights[newHeights.length] = 0;
        for (int height : newHeights) {
            int accWidth = 0;
            while (!stack.isEmpty() && stack.peekLast().height >= height) {
                accWidth += stack.peekLast().width;
                ans = Math.max(ans, accWidth * stack.peekLast().height);
                stack.pollLast();
            }
            stack.addLast(new Rect(accWidth + 1, height));
        }
        return ans;
    }

    class Rect {
        int width;
        int height;

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
