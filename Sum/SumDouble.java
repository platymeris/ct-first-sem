public class SumDouble {
    public static void main(String[] args) {
        double result = 0;
        int start = 0;
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[i].length(); j++) {
                if ((!Character.isWhitespace(args[i].charAt(j)))) {
                        start = j;
                        while ((j < args[i].length()) && (!Character.isWhitespace(args[i].charAt(j)))) {
                            j++;
                        }
                        result += Double.parseDouble(args[i].substring(start, j));
                }
            }
        }
        System.out.println(result);
    }
} 