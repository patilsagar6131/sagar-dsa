public class LongestCommonPrefix {
    public static void main(String[] args) {
        var longest = new LongestCommonPrefix();
        String[] arr = { "flower", "flight", "flow" };
        System.out.println(longest.longestCommonPrefix(arr));
    }
    // outer loop creates substring from strs[0] like first f then fl then flo then
    // flow
    // inner loop check if each element inside strs strats with substring
    // finally return the ans as sub(p1,p2-1) as will always be trying to find the
    // match so it needs to be reduced by 1.

    public String longestCommonPrefix(String[] strs) {
        int p1 = 0;
        int p2 = 1;
        while (p2 <= strs[0].length()) {
            String sub = strs[0].substring(p1, p2);
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(sub)) {
                    sub = strs[0].substring(p1, p2 - 1);
                    return sub;
                }
            }
            p2++;
        }
        return strs[0];
    }

}
