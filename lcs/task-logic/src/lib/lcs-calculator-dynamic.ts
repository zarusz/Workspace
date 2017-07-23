import {Matrix2} from "./matrix2";
import {ILCSCalculator} from "./lcs-calculator";

/**
 * The dynamic programming implementation for finding the longest common subsequence for two strings.
 * Pessimistic complexity is O(n*m).
 */
export class DynamicLCSCalculator implements ILCSCalculator{

    calculate(a: string, b: string): string {

        // if any input falsy then return empty string
        if (!a || !b) {
            return '';
        }

        // For algorithm description see: http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/

        let tab = new Matrix2<number>(a.length + 1, b.length + 1);

        for(let i = 0; i <= a.length; i++) {
            for(let j = 0; j <= b.length; j++) {
                let len;
                if (i === 0 || j === 0) {
                    len = 0;
                } else if (a[i-1] === b[j-1]) {
                    len = 1 + tab.getValue(i-1, j-1);
                } else {
                    len = Math.max(tab.getValue(i-1, j), tab.getValue(i, j-1))
                }
                tab.setValue(i, j, len);
            }
        }

        return this.extractSequenceString(tab, a, b);
    }

    private extractSequenceString(tab: Matrix2<number>, a: string, b: string): string {
        // For selection of the actual string see algorithm: http://www.geeksforgeeks.org/printing-longest-common-subsequence/

        // Following code is used to print LCS
        let lcsLength = tab.getValue(a.length, b.length);

        if (lcsLength === 0) {
            // No common sequence
            return '';
        }

        // Create a character array to store the lcs string
        let lcsChars = new Array<string>(lcsLength);
        let lcsIndex = lcsLength - 1;

        // Start from the right/bottom most corner and one by one store characters in tab[]
        let i = a.length
        let j = b.length;
        while (i > 0 && j > 0) {
            // If current character in X[] and Y are same, then current character is part of LCS
            if (a.charAt(i-1) == b.charAt(j-1)) {
                // Put current character in result
                lcsChars[lcsIndex] = a.charAt(i-1);

                // move diagonally up (to left, to up)
                i--;
                j--;

                lcsIndex--;
            } else if (tab.getValue(i-1, j) > tab.getValue(i, j-1)) {
                // If not same, then find the larger of two and
                // go in the direction of larger value
                i--;
            } else {
                j--;
            }
        }

        // concatenate all chars
        return lcsChars.join('');
    }
}