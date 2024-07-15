import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static String[] alpha;
    static Set<String> answer = new HashSet<>();
    static Set<Character> gather = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        alpha = br.readLine().split(" ");

        Arrays.sort(alpha);
//        System.out.println(Arrays.toString(alpha));
        backtrack(new StringBuilder(), 0, 0, 0);

        answer.stream().sorted().forEach(System.out::println);
    }

    static void backtrack(StringBuilder s, int index, int gatherCount, int vowelCount) {
        if (s.length() == n) {
            if (gatherCount >= 1 && vowelCount >= 2) {
                answer.add(s.toString());
            }
            return;
        }

        for (int i = index; i < m; i++) {
            char currentChar = alpha[i].charAt(0);
            s.append(currentChar);
            if (gather.contains(currentChar)) {
                backtrack(s, i + 1, gatherCount + 1, vowelCount);
            } else {
                backtrack(s, i + 1, gatherCount, vowelCount + 1);
            }
            s.deleteCharAt(s.length() - 1);
        }
    }
}
