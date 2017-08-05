
public class StringIterator {

    private char[] str = null;
    private int len = 0;
    private int index = 0;
    private char cur = '0';
    private int counter = 0;

    public StringIterator(String compressedString) {
        str = compressedString.toCharArray();
        len = str.length;
    }
    
    public static void main(String[] args) {
		StringIterator si = new StringIterator("x6");
		System.out.println(si.next());
		System.out.println(si.next());
		System.out.println(si.next());
		System.out.println(si.hasNext());
		System.out.println(si.next());
		System.out.println(si.next());
		System.out.println(si.next());
		System.out.println(si.next());
		System.out.println(si.next());
		System.out.println(si.next());
		System.out.println(si.next());
		System.out.println(si.next());
		System.out.println(si.next());
	}
    
    public char next() {
        System.out.println("index: " + index);
        if (!hasNext()) {
            return ' ';
        }
        if (counter <= 0) {
            // locate next char
            cur = str[index];
            // load existing time
            counter = 0;
            index++;
            if (index >= len) {
            	return ' ';
            }
            while (index < len && str[index] >= '0' && str[index] <= '9') {
                counter = counter * 10 + str[index] - '0';
                index++;
            }
            System.out.println("counter: " + counter);
        }
        counter--;
        return cur;
    }
    
    public boolean hasNext() {
        if (counter <= 0 && index >= len) {
            return false;
        }
        return true;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */