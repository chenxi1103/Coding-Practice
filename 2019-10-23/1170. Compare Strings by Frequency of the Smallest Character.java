class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        int[] queries_num = get_f_list(queries);
        int[] words_num = get_f_list(words);
        for (int i = 0; i < queries.length; i++) {
            int counter = 0;
            for (int j = 0; j < words.length; j++) {
                if (queries_num[i] < words_num[j]) counter++;
            }
            result[i] = counter;
        }
        return result;
    }

    private int[] get_f_list(String[] array) {
        int[] result = new int[array.length];
        int counter = 0;
        for (String str : array) {
            if (str == null || str.length() == 0) {
                result[counter++] = 0;
            } else {
                result[counter++] = f(str);
            }
        }
        return result;
    }

    private int f(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        char smallest_char = charArray[0];
        for (char c : charArray) {
            if (c == smallest_char) {
                count += 1;
            } else if (c < smallest_char) {
                smallest_char = c;
                count = 1;
            }
        }
        return count;
    }
}
