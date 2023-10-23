import java.util.*;

public class three_num_in_array_sum {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
//        int[] nums = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
//        int[] nums = {-2,0,1,1,2};
//        int[] nums = {-1, 0, -1,};
//        int[] nums = {-1, -1, -1, 1};
//        int[] nums = {0, 0, 0, 0};

        List<List<Integer>> list = new Solution().threeSum(nums);
        System.out.print("[");
        for (var e : list) {
            System.out.print(e + ", ");
        }
        System.out.print("]\n");
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            if (nums.length < 3)
                return ret;

            Arrays.sort(nums);


            for (int left = 0; left < nums.length - 1; left++) {
                if (left >= 2 && nums[left] == nums[left - 1] && nums[left] == nums[left - 2])
                    continue;

                for (int right = nums.length - 1; right > left + 1; right--) {
//                    if (ret.size() >= 1 && nums[left] == ret.get(ret.size() - 1).get(0) && nums[right] == ret.get(ret.size() - 1).get(2))
//                        break;
                    if (right < nums.length - 2 && nums[right] == nums[right + 1] && nums[right] == nums[right + 2])
                        continue;
                    int sum = nums[left] + nums[right];
//                    boolean found = false;
                    if (sum > 0) {
                        for (int mid = left + 1; mid < right; mid++) {
//                            if (mid >= 2 && nums[mid] == nums[mid - 1] && nums[mid] == nums[mid - 2])
//                                continue;
                            if (sum + nums[mid] == 0) {
//                                if (!(ret.size() > 0 && nums[left] == ret.get(ret.size() - 1).get(0) && nums[right] == ret.get(ret.size() - 1).get(2) && nums[mid] == ret.get(ret.size() - 1).get(1)))
                                    ret.add(List.of(nums[left], nums[mid], nums[right]));
//                                found = true;
                                break;
                            }
                            if (sum + nums[mid] > 0)
                                break;
                        }
//                        if (found)
//                            break;
                    } else {
                        for (int mid = right - 1; mid > left; mid--) {
//                            if (mid < nums.length - 2 && nums[mid] == nums[mid + 1] && nums[mid] == nums[mid + 2])
//                                continue;
                            if (sum + nums[mid] == 0) {
//                                if (!(ret.size() > 0 && nums[left] == ret.get(ret.size() - 1).get(0) && nums[right] == ret.get(ret.size() - 1).get(2) && nums[mid] == ret.get(ret.size() - 1).get(1)))
                                    ret.add(List.of(nums[left], nums[mid], nums[right]));
//                                found = true;
                                break;
                            }
                            if (sum + nums[mid] < 0)
                                break;
                        }
//                        if (found)
//                            break;
                    }
                }

            }
            ret.sort((e1, e2) -> e1.get(0) * 100 + e1.get(1) * 10 + e1.get(2) - e2.get(0) * 100 - e2.get(1) * 10 - e2.get(2));
            for (int i = ret.size() - 2; i >= 0; i--) {
                var curr = ret.get(i);
                var last = ret.get(i + 1);
                if (Objects.equals(curr.get(0), last.get(0)) && Objects.equals(curr.get(1), last.get(1)) && Objects.equals(curr.get(2), last.get(2)))
                    ret.remove(i);
            }


            return ret;

        }
    }


}

//            while (left < right - 1) {
//                int sum = nums[left] + nums[right];
//
//                if (sum >= 0) {
//                    for (int mid = left + 1; mid < right; mid++) {
//                        if (sum + nums[mid] == 0) {
//                            ret.add(List.of(nums[left], nums[mid], nums[right]));
//                            left++;
//                            right--;
//                            break;
//                        } else if (sum + nums[mid] > 0) {
//                            do {
//                                right--;
//                            } while (left < right - 1 && nums[right] != nums[right + 1]);
//
//                            break;
//                        }
//                    }
//                } else {
//                    for (int mid = right - 1; mid > left; mid--) {
//                        if (sum + nums[mid] == 0) {
//                            ret.add(List.of(nums[left], nums[mid], nums[right]));
//                            left++;
//                            right--;
//                            break;
//                        } else if (sum + nums[mid] < 0) {
//                            do {
//                                left++;
//                            } while (left < right - 1 && nums[left] != nums[left - 1]);
//
//                            break;
//                        }
//                    }
//                }
//
//
//            }
