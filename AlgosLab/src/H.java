import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bufferedReader.readLine();
            String[] s2 = s1.split(" ");
            int n = Integer.parseInt(s2[0]);
            int m = Integer.parseInt(s2[1]);
            int k = Integer.parseInt(s2[2]);
            String[] source = new String[n];
            for (int i = 0; i < n; i++) {
                source[i] = bufferedReader.readLine();
            }
            bufferedReader.close();
            StringBuilder stringBuilder = new StringBuilder();
            for (String s: radixSort(source, k, m)) {
                stringBuilder.append(s).append('\n');
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] radixSort(String[] source, int m, int k) {
        for (int i = 0; i < m; i++) {
            String[] array = new String[source.length];
            int[] count = new int['z' - 'a'];
            for (String s : source) {
                count[s.charAt(k - 1 - i) - 'a']++;
            }
            int[] p = new int[count.length];
            int sum = 0;
            for (int j = 0; j < count.length; j++) {
                p[j] = sum;
                sum += count[j];
            }
            for (int j = 0; j < source.length; j++) {
                array[p[source[j].charAt(k - 1 - i) - 'a']] = source[j];
                p[source[j].charAt(k - 1 - i) - 'a']++;
            }
            source = array;
        }
        return source;
    }
}
