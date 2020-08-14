class Solution {
    public int getSum(int a, int b) {
        return (a^b)+(2*(a&b));
    }
}
