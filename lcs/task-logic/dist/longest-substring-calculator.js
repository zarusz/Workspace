/**
 * Created by tmaruszak on 22/07/2017.
 */
import { Matrix2 } from "./matrix2";
/**
 * The dynamic programming implementation for finding the longest common substring for two strings.
 */
var DynamicLongestSubstringCalculator = (function () {
    function DynamicLongestSubstringCalculator() {
    }
    DynamicLongestSubstringCalculator.prototype.calculate = function (a, b) {
        // For algorithm description see: http://www.geeksforgeeks.org/longest-common-substring/
        // Worst case complexity is O(a.length * b.length)
        var longestSubstringLen = 0;
        var longestSubstringIndex = 0;
        // Will store largest common suffix length between i-th and j-th substrings.
        var longestCommonSuffix = new Matrix2(a.length, b.length);
        for (var i = 0; i <= a.length; i++) {
            for (var j = 0; j <= b.length; j++) {
                var len = 0;
                // Since i and j represent each suffix length, the LCSuffix is non-zero of both i!=0 and j!=0.
                // Furthermore if character suffix match then we can have LCSuffix as 1 + the previous LCSuffix.
                if (i !== 0 && j !== 0 && a[i - 1] === b[j - 1]) {
                    len = 1 + longestCommonSuffix.getValue(i - 1, j - 1);
                    if (len > longestSubstringLen) {
                        // remember what is the longest substring so far
                        longestSubstringLen = len;
                        longestSubstringIndex = i;
                    }
                }
                longestCommonSuffix.setValue(i, j, len);
            }
        }
        var longestSubstring = longestSubstringLen > 0
            ? a.substr(longestSubstringIndex - longestSubstringLen, longestSubstringLen)
            : '';
        return longestSubstring;
    };
    return DynamicLongestSubstringCalculator;
}());
export { DynamicLongestSubstringCalculator };
//# sourceMappingURL=longest-substring-calculator.js.map