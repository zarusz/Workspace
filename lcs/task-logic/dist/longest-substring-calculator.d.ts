/**
 * Finding the longest common substring for two strings.
 */
export interface ILongestSubstringCalculator {
    calculate(a: string, b: string): string;
}
/**
 * The dynamic programming implementation for finding the longest common substring for two strings.
 */
export declare class DynamicLongestSubstringCalculator implements ILongestSubstringCalculator {
    calculate(a: string, b: string): string;
}
