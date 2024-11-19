package exercise;

// BEGIN
public class ReversedSequence  implements CharSequence {
    private String reverseStr;

    public ReversedSequence(String str) {
        this.reverseStr = new StringBuilder(str).reverse().toString();
    }

    @Override
    public int length() {
        return reverseStr.length();
    }

    @Override
    public char charAt(int index) {
        if (index > reverseStr.length() - 1) {
            index = 0;
        }

        return reverseStr.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (end < start) {
            return null;
        }

        int fixedStart = start;
        if (start < 0) {
            fixedStart = 0;
        }

        int fixedEnd = end;
        if(end > this.length()) {
            fixedEnd = this.length();
        }

        return this.reverseStr.substring(fixedStart, fixedEnd);
    }

    @Override
    public String toString() {
        return reverseStr;
    }
}
// END
