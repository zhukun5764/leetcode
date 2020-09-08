package leetcode;

import java.util.*;

public class test {

    public static final ListNode listNode = new ListNode(1);

    public static void main(String[] args) {

        System.out.println(12312);
        System.out.println(2222);
        System.out.println(333);
        System.out.println(4444);
//        TestAbstract testAbstract = new TestAbstractImpl();

        TestAbstractImpl.load();

        System.out.println(listNode.val);
//        listNode.setVal(2);
//        System.out.println(listNode.val);



//        HashMap<String, String> map = new HashMap<>();
//        map.put(null, "qwe");
//        map.put("1", "qwe");
//        map.put("2", "qwe");
////
////        System.out.println(map.get("1"));
//
//        Tostring tostring = new Tostring();
//        tostring.setAs(1);
//        System.out.println("asda".equals(null));

//
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("test", TestEnum.test2);
//
//        TestEnum testEnum = (TestEnum) map.get("test21");
//        System.out.println(testEnum);

//        longestCommonPrefix(new String[]{"flower","flow","flight"});
//        addTwoNumbers(getListNode(8,8,8), getListNode(9,9,9));
//        sortArrayByParity(new int[]{3,2,1,4});
//        System.out.println(mySqrt(19));
//        asteroidCollision(new int[]{-2,-2,1,-2});
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
//        findLongestWord("abpcplea", list);
//        compareVersion("7.5.2.4", "7.5.3");
//        largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2}, 6);
//        validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2});
//        nextGreaterElement(12222333);
//        checkPossibility(new int[]{3,4,2,4,3});
//        System.out.println("asdasd".substring(0, 5));
//        maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1});
//        System.out.println("aaaa".lastIndexOf("v"));
//        containsNearbyAlmostDuplicate(new int[]{2147483647,-2147483647}, 1, 2147483647);
//        repeatedStringMatch("abc", "cabcabca");
//        validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
//        findMaxAverage(new int[]{1,12,-5,-6,50,3}, 1);
//        pivotIndex(new int[]{-1,-1,-1,-1,-1,0});
    }

    private void test123(Boolean f1, Boolean f2){
        if ((f1 == null && f2 == null)
                || ((f1 != null && f1 || (f2 != null && f2)))) {
            System.out.println(1231231);
        }
    }

    private static boolean isasd(int n){
        return false;
    }

    public static int firstBadVersion(int n) {
        int l = 1, r = n, mod = l;
        while (l <= r){
            mod = l + (l + r) / 2;
            if(isasd(mod)){
                r = mod;
            }else {
                l = mod + 1;
            }
        }
        return l;
    }

    public static int pivotIndex(int[] nums) {
        if(nums.length < 2){
            return -1;
        }
        int sumLeft = 0;
        int sumRight = 0;
        for(int i = 0; i < nums.length; i ++){
            sumRight += nums[i];
        }
        if(sumLeft == sumRight){
            return 0;
        }
        for(int n = 1; n < nums.length - 1; n++){
            sumLeft = sumLeft + nums[n-1];
            sumRight = sumRight - nums[n];
            if(sumLeft == sumRight){
                return n;
            }
        }
        return -1;
    }

    public static double findMaxAverage(int[] nums, int k) {
        double max = 0, temp = 0;
        int i = 0;
        for(; i < k && i < nums.length; i++){
            max += nums[i];
            temp = max;
        }
        for(; i < nums.length ; i ++){
            temp += nums[i]-nums[i-k];
            max = Math.max(max, temp);
        }
        return max / k;
    }

    public static boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        int count = 1;
        while (l < r){
            if(s.charAt(l) != s.charAt(r)){
                count--;
                if(s.charAt(l+1) == s.charAt(r) &&  s.charAt(l + 2) == s.charAt(r - 1)){
                    l++;
                }else if(s.charAt(l) == s.charAt(r - 1) && s.charAt(l + 1) == s.charAt(r - 2)){
                    r--;
                }else {
                    return false;
                }
            }
            if(count < 0){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++){
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int t = nums[i] + nums[r] + nums[r];
                if(Math.abs(t - target) < Math.abs(closeSum - target)){
                    closeSum = t;
                }
                if(t == target){
                    return target;
                }else if(t < target){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return closeSum;
    }

    public static int repeatedStringMatch(String A, String B) {
        int lastIndex = A.lastIndexOf(B.charAt(0));
        if(lastIndex < 0){
            return -1;
        }
        int i = (int)Math.ceil((double)(A.length() + B.length()) / A.length());
        String t = A;
        for(int j = 1; j <=i; j++){
            if(A.lastIndexOf(B) != -1){
                return j;
            }
            A += t;
        }
        return -1;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i< nums.length; i++){
            Long v = set.ceiling((long)nums[i] - t);
            if(v != null && v <= ((long)nums[i] + t)){
                return true;
            }
            set.add((long)nums[i]);
            if(set.size() == k + 1){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while(cur != null){
            ListNode curP = preHead;
            ListNode preCurP = preHead;
            while(curP != null && curP.val <= cur.val){
                preCurP = curP;
                curP = curP.next;
            }
            ListNode tmp = cur.next;
            preCurP.next = cur;
            cur.next = curP;
            cur = tmp;
        }
        return preHead.next;
    }

    public static int maxWidthRamp(int[] A) {
        int max = 0;
        for(int i=0; i < A.length; i++){
            if(i + max >= A.length){
                break;
            }
            for(int j = A.length - 1; j >= i + max + 1; j-- ){
                if(A[j] >= A[i]){
                    max = j - i;
                    break;
                }
            }
        }
        return max;
    }

    public static int subarraysDivByK(int[] A, int K) {
        int r = 0;
        int sum = 0, temp = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            temp = sum;
            for(int j = 0; j <= i; j++){
                if(temp % K == 0){
                    r++;
                }
                temp -= A[j];
            }
        }
        return r;
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum = ((sum << 1) + A[i]) % 5;
            list.add(sum == 0);
        }
        return list;
    }

    public static int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
            if(n == first || n == second || n == third){
                continue;
            }
            if(n > first){
                third = second;
                second = first;
                first = n;
            }else if(n > second){
                third = second;
                second = n;
            }else if(n > third){
                third = n;
            }
        }
        return set.size() < 3 ? first : third;
    }

    public static int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int res = A[n-1] - A[0];
        for (int i=1;i<n;i++) {
            int min = Math.min(A[0]+K,A[i]-K);
            int max = Math.max(A[n-1]-K,A[i-1]+K);
            res = Math.min(max-min,res);
        }
        return res;
    }

    public static boolean checkPossibility(int[] nums) {
        if(nums.length < 2){
            return true;
        }
        int count = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1] > nums[i]){
                count ++;
                if(count > 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] singleNumber(int[] nums) {
        int temp = 0;
        for(int n : nums){
            temp ^= n;
        }
        String s = Integer.toBinaryString(temp);
        int index = s.length() - s.lastIndexOf("1") - 1;
        int[] r = new int[2];
        for(int n : nums){
            if(((n >> index) & 1) == 1){
                r[0] ^= n;
            }else {
                r[1] ^=n;
            }
        }
        return r;
    }

    public static int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        List<Integer> list = new ArrayList<>();
        list.add( n % 10);
        boolean findSuccess = false;
        int i = s.length() - 2, j = 0;
        int temp = 0;
        n = n / 10;
        for(; i >=0; i--){
            temp = n % 10;
            for(; j < list.size(); j++){
                if(temp < list.get(j)){
                   findSuccess = true;
                   break;
                }
            }
            if(findSuccess){
                break;
            }
            list.add(temp);
            n = n / 10;
            j = 0;
        }
        if(!findSuccess){
            return -1;
        }

        StringBuilder sb = new StringBuilder()
                .append(s.substring(s.length() - list.size(), s.length() - j - 1))
                .append(temp)
                .append(s.substring(s.length() - j, s.length()));
        Double d = Double.parseDouble(s.substring(0, i)
                + list.get(j)
                + sb.reverse().toString());
        return d > Integer.MAX_VALUE ? -1 : d.intValue();
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i =0 , j=0;
        while (j<popped.length){
            if(stack.isEmpty()){
                stack.add(pushed[i++]);
            }else {
                int temp = stack.pop();
                if(temp != popped[j]){
                    stack.add(temp);
                    stack.add(pushed[i++]);
                }else {
                    j++;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int singleNonDuplicate(int[] nums) {
        for(int i = 1; i < nums.length - 1; i+=2){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }
        return nums[nums.length - 1];
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int r = 0;
        int start = 0, end = 0, sum = 1;
        while (end < nums.length){
            sum *= nums[end++];
            while (start < end && sum>=k){
                sum /= nums[start++];
            }
            r += end - start + 1;
        }
        return r;
    }

    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int s = 0;
        int i= 0;
        for(; i < A.length && A[i] < 0 ; i++){
            if( K ==0){
                break;
            }else {
                s += Math.abs(A[i]);
            }
            K--;
        }
        if(K > 0){
            s += A[i];
            int min = i == 0 ? A[i] : Math.min(Math.abs(A[i - 1]), A[i]);
            s -= (K % 2== 0 ?  -2 * min : 0);
            i++;
        }
        for(; i < A.length; i++){
            s += A[i];
        }
        return s;
    }

    public static int numMatchingSubseq(String S, String[] words) {
        int r = 0;
        for(String s : words){
            int i = 0, j = 0;
            while (i < s.length() && j < S.length()){
                if(s.charAt(i) == S.charAt(j)){
                    i++;
                    j++;
                }else {
                    j++;
                }
            }
            if(i == s.length()){
                r++;
            }
        }
        return r;
    }

    public static int[] productExceptSelf(int[] nums) {
        if(nums.length < 2){
            return nums;
        }
        int[] r = new int[nums.length];
        r[0] = 1;
        int s = 1;
        for(int i = 0; i < nums.length - 1; i++){
            s *= nums[i];
            r[i + 1] = s;
        }
        s = 1;
        for(int j = nums.length - 1; j>0;j--){
            s *= nums[j];
            r[j - 1] = r[j - 1] * s;
        }
        return r;
    }

    public static int compareVersion(String version1, String version2) {
        List<String> v1 = Arrays.asList(version1.split("\\."));
        List<String> v2 = Arrays.asList(version2.split("\\."));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String s : v1){
            sb1.append(s.replaceAll("^(0+)", ""));
        }
        for(String s : v2){
            sb2.append(s.replaceAll("^(0+)", ""));
        }
        String r1 = sb1.toString().replaceAll("0+$", "");
        String r2 = sb2.toString().replaceAll("0+$", "");
        if(r1.equals(r2)){
            return 0;
        }
        return sb1.toString().compareTo(sb2.toString()) > 0 ? 1 : -1;
    }

    public static String findLongestWord(String s, List<String> d) {
        String r = "";
        int length = s.length();
        for(String ss : d){
            int i = 0, j=0;
            while (j<length && i<ss.length()){
                if(ss.charAt(i) == s.charAt(j)){
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
            if(i == ss.length()){
                if(ss.length() > r.length()){
                    r = ss;
                }else if(ss.length() == r.length()){
                    r = ss.compareTo(r) >= 0 ? r : ss;
                }
            }
        }
        return r;
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids){
            if(a >= 0 || stack.isEmpty() || stack.peek() < 0){
                stack.add(a);
            }else {
                boolean isAdd = true;
                while (!stack.isEmpty()){
                    int t = stack.pop();
                    if(t < 0){
                        stack.add(t);
                        stack.add(a);
                        break;
                    }
                    if(t > Math.abs(a)){
                        stack.add(t);
                        break;
                    }else if(t == Math.abs(a)){
                        isAdd = false;
                        break;
                    }
                }
                if(isAdd && stack.isEmpty()){
                    stack.add(a);
                }
            }
        }
        int l = stack.size();
        int[] r = new int[l];
        while (!stack.isEmpty()){
            r[--l] = stack.pop();
        }
        return r;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                set.add(a + b);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(set);
    }

    public static boolean isPowerOfTwo(int n) {
        return ((int) Math.pow(2, 30)) % n == 0;
    }

    public static int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x < 3){
            return 1;
        }
        int start = 1;
        int end = x;
        while (start <= end){
            int mod = start + (end - start) / 2;
            if(mod * mod == x){
                return mod;
            }else if(mod * mod < x){
                start = mod + 1;
            }else {
                end = mod - 1;
            }
        }
        return start - 1;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j){
            if(numbers[i] + numbers[j] == target){
                break;
            }else if(numbers[i] + numbers[j] < target){
                i++;
            }else {
                j--;
            }
        }
        return new int[]{i, j};
    }

//    public static int removeDuplicates(int[] nums) {
//
//    }

    public static boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.sqrt(c);
        double eps = 1e-10;
        for(int i = 0; i<=sqrt; i++){
            int b = c - i*i;
            if(Math.sqrt(b) - Math.floor(Math.sqrt(b)) < eps){
                return true;
            }
        }
        return false;
    }

    public static boolean isPowerOfThree(int n) {
        if(n < 3){
            return false;
        }
        int r = n % 10;
        if(r==1 || r==3 || r==7 || r==9){
            return n % 7 != 0;
        }
        return false;
    }

    public static int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j){
            if(A[i] % 2 == 0){
                i++;
            }
            if(A[j] % 2 !=0){
                j--;
            }
            if(i >= j){
                break;
            }
            if(A[i] % 2 != 0 && A[j] % 2 == 0){
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                i++;
                j--;
            }
        }
        return A;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode r = new ListNode(0);
        ListNode temp = r;
        while (head !=null){
            if(head.val != val){
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }
        return r.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (!s1.isEmpty() || !s2.isEmpty()){
            int sum = carry;
            if(!s1.isEmpty()){
                sum += s1.pop();
            }
            if(!s2.isEmpty()){
                sum+= s2.pop();
            }
            carry = sum / 10;
            sum = sum % 10;
            stringBuilder.append(sum);
        }
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        if(carry == 1){
            temp.next = new ListNode(1);
            temp = temp.next;
        }

        for(Character c : stringBuilder.reverse().toString().toCharArray()){
            temp.next = new ListNode(Integer.parseInt(c + ""));
            temp = temp.next;
        }
        return listNode.next;
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < strs[0].length(); i++){
            Character c = strs[0].charAt(i);
            int j = 1;
            for(; j < strs.length; j++){
                if(strs[j].length() - 1 < i || strs[j].charAt(i) != c){
                    return stringBuilder.toString();
                }
            }
            if(j == strs.length){
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private static ListNode getListNode(int v1, int v2, int v3){
        ListNode root = new ListNode(1);
        ListNode n1 = new ListNode(v1);
        ListNode n2 = new ListNode(v2);
        ListNode n3 = new ListNode(v3);
        n2.next=n3;
        n1.next=n2;
        root.next=n1;
        return root;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}