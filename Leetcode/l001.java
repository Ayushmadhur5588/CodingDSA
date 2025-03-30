package Leetcode;

public class l001 {
    
        public int maxProduct(int[] nums) {
            int ans = -(int) 1e9;
            int cPro = 1;
    
            for (int i = 0; i < nums.length; i++) {
                cPro *= nums[i];
                ans = Math.max(ans, cPro);
                if (cPro == 0) {
                    cPro = 1;
                }
            }
            cPro = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                cPro *= nums[i];
                ans = Math.max(ans, cPro);
                if (cPro == 0) {
                    cPro = 1;
                }
            }
    
            return ans;
        }

        public List<Integer> partitionLabels(String s) {
            Map<Character,Integer> map = new HashMap<>();
            for(int i=0;i<s.length();i++)
                map.put(s.charAt(i),i);
            List<Integer> res = new ArrayList<>();
            int prev = -1,max = 0;
            for(int i=0;i<s.length();i++)
            {
                max = Math.max(max,map.get(s.charAt(i)));
                if(max == i)
                {
                    res.add(max - prev);
                    prev = max;
                }
            }
            return res;
        }
    }

