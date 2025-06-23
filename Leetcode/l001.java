import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

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
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), i);
        List<Integer> res = new ArrayList<>();
        int prev = -1, max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, map.get(s.charAt(i)));
            if (max == i) {
                res.add(max - prev);
                prev = max;
            }
        }
        return res;
    }

    public int minimumPushes(String word) {
        int[] ans = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int ch = (int) (word.charAt(i) - 'a');
            ans[ch]++;
        }
        Arrays.sort(ans);
        int count = 1;
        int ans1 = 0;
        for (int i = 25; i >= 0; i--) {
            if (ans[i] > 0 && count <= 8) {
                ans1 = ans1 + (1 * ans[i]);
                count++;
            } else if (ans[i] > 0 && (count > 8 && count <= 16)) {
                ans1 = ans1 + (2 * ans[i]);
                count++;
            } else if (ans[i] > 0 && (count > 16 && count <= 24)) {
                ans1 = ans1 + (3 * ans[i]);
                count++;
            } else if (ans[i] > 0 && (count > 24)) {
                ans1 = ans1 + (4 * ans[i]);
                count++;
            }
        }
        return ans1;
    }

    public long putMarbles(int[] weights, int k) {

        int[] arr = new int[weights.length - 1];
        long mn = 0;
        long mx = 0;

        for (int i = 0; i < arr.length; ++i)
            arr[i] = weights[i] + weights[i + 1];

        Arrays.sort(arr);

        for (int i = 0; i < k - 1; ++i) {
            mn += arr[i];
            mx += arr[arr.length - 1 - i];
        }

        return mx - mn;
    }

    public static int LPSS(String str, int i, int j, int[][] dp) {
        if (i >= j) {
            return dp[i][j] = (i == j) ? 1 : 0;
        }

        if (dp[i][j] != 0)
            return dp[i][j];

        if (str.charAt(i) == str.charAt(j))
            return dp[i][j] = LPSS(str, i + 1, j - 1, dp) + 2;
        else
            return dp[i][j] = Math.max(LPSS(str, i + 1, j, dp), LPSS(str, i, j - 1, dp));
    }

    public static int LPSS_DP(String str, int I, int J, int[][] dp) {
        int n = str.length();
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (i >= j) {
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }

                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;// LPSS(str, i + 1, j - 1, dp) + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[I][J];
    }

    public static String LPSS_StringDP(String str) {
        int n = str.length();
        String[][] dp = new String[n][n];
        for (String[] d : dp)
            Arrays.fill(d, "");

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (i >= j) {
                    dp[i][j] = (i == j) ? str.charAt(i) + "" : "";
                    continue;
                }

                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = str.charAt(i) + dp[i + 1][j - 1] + str.charAt(j);
                else
                    dp[i][j] = dp[i + 1][j].length() > dp[i][j - 1].length() ? dp[i + 1][j] : dp[i][j - 1];
            }
        }

        return dp[0][n - 1];
    }

    public int minimumSum(int num) {
        int[] a = { num % 10, (num / 10) % 10, (num / 100) % 10, (num / 1000) % 10 };
        Arrays.sort(a);
        return a[0] * 10 + a[3] + a[1] * 10 + a[2];
    }

    public int tribonacci(int n) {
        if(n<3){
           return n < 1 ? 0 : 1;
        }
        int dp[]=new int[n+1];
        dp[0]=0;dp[1]=1;dp[2]=1;
        for(int i=3;i<=n;i++){
           dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }   
        return dp[n];
       }
       public int missingNumber(int[] nums) {
        int n=nums.length;
        int total=n*(n+1)/2;
        int expect=0;
        for(int num:nums){
         expect+=num;
        }
         return total-expect;
         
     }
     


        private long ret;
        private int count;
        private int k;
        private int n;
    
        public long kMirror(int k, int n) {
            ret = 0;
            count = 0;
            this.k = k;
            this.n = n;
    
            for (int digit = 1; count < n; digit++) {
                travelTenMirrorNumber((long)Math.pow(10, digit - 1), 1, 0);
            }
    
            return ret;
        }
    
        private void travelTenMirrorNumber(long highFactor, long lowFactor, long sum) {
            if (highFactor < lowFactor) {
                if (isKMirror(k, sum)) {
                    ret += sum;
                    count++;
                }
            } else {
                int digit = lowFactor == 1 ? 1 : 0;
                while (count < n && digit < 10) {
                    travelTenMirrorNumber(highFactor / 10, lowFactor * 10, sum + digit++ * (highFactor == lowFactor ? highFactor : highFactor + lowFactor));
                }
            }
        }
    
        private boolean isKMirror(int k, long num) {
            long high = (long)Math.pow(k, (int)(Math.log(num)/Math.log(k)));
            long low = k;
            while (num > 0) {
                if (num / high != num % low) {
                    return false;
                }
                num = num % high / low;
                high /= k * k;
            }
            return true;
        }
    


        class Solution {
            public String[] divideString(String s, int k, char fill) {
                ArrayList<String> list=new ArrayList<>();
                for(int i=0;i<s.length();i+=k){
                    int end=Math.min(i+k,s.length());
                    list.add(s.substring(i,end));
                }
                String l=list.get(list.size()-1);
                if(l.length()<k){
                    for(int i=l.length();i<k;i++){
                        l+=fill;
                    }
                    list.set(list.size()-1,l);
                }
                return list.toArray(new String[0]);
            }
        }
       
        }
    
    
    
    
    
