class Solution {
    private Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return match(0, 0, s, p);
    }

    private boolean match(int i, int j, String s, String p) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean result;

        if (j == p.length()) {
            result = (i == s.length());
        } else {
            boolean firstMatch = (i < s.length()) &&
                    (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                result = match(i, j + 2, s, p) ||
                        (firstMatch && match(i + 1, j, s, p));
            } else {
                result = firstMatch &&
                        match(i + 1, j + 1, s, p);
            }
        }

        memo[i][j] = result;
        return result;
    }
}