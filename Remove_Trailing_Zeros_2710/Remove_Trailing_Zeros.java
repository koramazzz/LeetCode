import java.util.Scanner;

public class Remove_Trailing_Zeros {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        String inputNum = input.next();

        String result = removeTrailingZeros(inputNum);

        System.out.println("Result without trailing zeros: " + result);
    }

    public static String removeTrailingZeros(String num) {
        // Reverse the string and find the first non-zero character
        StringBuilder numReversed = new StringBuilder(num).reverse();
        int index = 0;

        for (int i = 0; i < numReversed.length(); i++) {
            if (numReversed.charAt(i) != '0') {
                index = i;
                break;
            }
        }

        // Return the reversed string from the first non-zero character onwards
        return new StringBuilder(numReversed.substring(index)).reverse().toString();
    }
}