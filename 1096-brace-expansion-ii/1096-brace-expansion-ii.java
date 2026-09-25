import java.util.*;

class Solution {

    String s;
    int n;
    int idx = 0;

    Set<String> getUnit() {
        Set<String> result = new TreeSet<>();

        if (s.charAt(idx) == '{') {
            idx++;
            result = performUnion();
        } else { // alphabet
            result.add(String.valueOf(s.charAt(idx)));
        }

        idx++;
        return result;
    }

    Set<String> performConcat() {
        Set<String> result = new TreeSet<>();
        result.add(""); // initially empty string

        while (idx < n && (s.charAt(idx) == '{' ||
                           Character.isLetter(s.charAt(idx)))) {

            Set<String> temp = getUnit();

            Set<String> concatResult = new TreeSet<>();

            for (String left : result) {
                for (String right : temp) {
                    concatResult.add(left + right);
                }
            }

            result = concatResult;
        }

        return result;
    }

    Set<String> performUnion() {
        Set<String> result = new TreeSet<>();

        while (true) {

            Set<String> temp = performConcat();

            result.addAll(temp);

            if (idx < n && s.charAt(idx) == ',') {
                idx++;
            } else {
                break;
            }
        }

        return result;
    }

    public List<String> braceExpansionII(String expression) {

        n = expression.length();
        s = expression;
        idx = 0;

        Set<String> st = performUnion();

        return new ArrayList<>(st);
    }
}