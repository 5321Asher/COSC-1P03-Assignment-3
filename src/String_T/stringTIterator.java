package String_T;
import java.util.Iterator;

public class stringTIterator implements Iterator<Character> {
    private final char[] chars;
    private int index;
    
    public stringTIterator(myStringT stringT) {
        this.chars = stringT.ToArray();
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return index < chars.length;
    }
    
    @Override
    public Character next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        return chars[index++];
    }
}