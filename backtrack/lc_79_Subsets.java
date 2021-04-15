// 链接：https://leetcode-cn.com/problems/subsets/
// 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        dfs(nums, 0, len, stack, res);
        return res;
    }
    private void dfs(int[] nums, int index, int len, Stack<Integer> stack,
                     List<List<Integer>> res){
        if (index == len){
            // stack是一个引用，一直在变化，因此以stack当前状态创建一个ArrayList加入res
            res.add(new ArrayList<>(stack));
            return;
        }
        
        // 若不选择加入当前位置的元素（nums[index]），则直接进入下一层递归（index + 1）
        // 递归前无操作
        dfs(nums, index + 1, len, stack, res);
        //递归后也无操作

        // 选择加入当前位置的元素（nums[index]）
        // 进入下一层递归前做了什么操作，递归之后也要做相应的逆操作
        // 递归前加入当前元素
        stack.add(nums[index]);
        dfs(nums, index + 1, len, stack, res);
        // 递归后移除当前元素
        stack.pop();
    }
}