public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight","flane"};
        System.out.print(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs){

        String commonPrefix = strs[0];

        for (int i = 1; i < strs.length; i++){

            while (!strs[i].startsWith(commonPrefix)){

                commonPrefix = commonPrefix.substring(0,commonPrefix.length()-1);

                if (commonPrefix.isEmpty()) return "";
            }
        }

        return commonPrefix;
    }
}