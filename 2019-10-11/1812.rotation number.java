// Solution 1
public class Solution {
    /**
     * @param n: A Integer
     * @return: return the list of Rotation Number in 1-n
     */
    public List<Integer> RotationNumber(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(rotateValid(i, n)) list.add(i);
        }
        return list;
    }
    private boolean rotateValid(int n, int max) {
        String str = n + "";
        char[] charArray = str.toCharArray();
        char[] rotate = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c != '6' && c != '9' && c != '0' && c != '8') return false;
            else {
                if (c == '6') {
                    rotate[i] = '9';
                } else if (c == '9') {
                    rotate[i] = '6';
                } else {
                    rotate[i] = c;
                }
            }
        }
        int rotateNum = Integer.parseInt(new String(rotate));
        return rotateNum <= max && rotateNum != n;
    }
}

// Much more faster!
public class Solution {
    /**
     * @param n: A Integer
     * @return: return the list of Rotation Number in 1-n
     */
    public List<Integer> RotationNumber(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(rotateValid(i, n)) list.add(i);
        }
        return list;
    }
    private boolean rotateValid(int n, int max) {
        int rotateNum = 0;
        int counter = 0;
        int original = n;
        while (n > 0) {
            int mod = n % 10;
            if (mod != 0 && mod != 8 && mod != 6 && mod != 9) return false;
            else {
                if (mod == 6) {
                    rotateNum += Math.pow(10, counter) * 9;
                } else if (mod == 9) {
                    rotateNum += Math.pow(10, counter) * 6;
                } else {
                    rotateNum += Math.pow(10, counter) * mod;
                }
            }
            counter++;
            n = n / 10;
        }
        return rotateNum != original && rotateNum <= max;
    }
}
