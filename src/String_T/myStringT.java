package String_T; //defines package

import java.util.Iterator; //imports iterator for implementing iterable interface

/**
 * Implementation of the custom StringT interface.
 * Provides functionality for string-like operations using a character array.
 * This class serves as an alternative to Java's built-in String class and supports
 * a range of operations, including concatenation, slicing, reversing, and character counting.
 */
public class myStringT implements StringT, Iterable<Character> {
    private final char[] chars; // stores the chars of the input string in an immutable array
    
    
    /**
     * Constructs a new instance of the myStringT class using the provided character array.
     *
     * @param input the character array used to initialize the instance. Cannot be null.
     * @throws stringTException if the input array is null.
     */
    public myStringT(char[] input) {
        if (input == null) {
            throw new stringTException("Null input not allowed");
        }
        chars = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            chars[i] = input[i];
        }
        
    }
    
    /**
     * Concatenates this StringT object with the provided StringT, resulting in a new StringT
     * that represents the combination of the two strings.
     *
     * @param S the StringT to concatenate with this StringT. Cannot be null.
     * @return a new StringT containing the concatenated contents of this StringT and the provided StringT.
     * @throws stringTException if the provided StringT is null.
     */
    @Override
    public StringT ConCat(StringT S) {
        if (S == null) {
            throw new stringTException("Cannot cancatonate null");
        }
        
        char[] otherChars = S.ToArray();
        char[] newChars = new char[chars.length + otherChars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[i] = chars[i];
        }
        
        for (int i = 0; i < S.Length(); i++) {
            newChars[i + chars.length] = otherChars[i];
        }
        
        return new myStringT(newChars);
        
        
    }
    
    @Override
    public StringT Before(int i) {
        
        if (i < 0 || i >= chars.length) {
            throw new stringTException("index out of bounds");
        }
        
        char[] newChars = new char[i];
        for (int j = 0; j < i; j++) {
            newChars[j] = chars[j];
        }
        
        
        return new myStringT(newChars);
    }
    
    @Override
    public StringT After(int i) {
        if (i < 0 || i >= chars.length) {
            throw new stringTException("index out of bounds");
        }
        
        char[] newChars = new char[chars.length - i];
        for (int j = i, k = 0; j < chars.length; j++, k++) {
            newChars[k] = chars[j];
        }
        
        
        return new myStringT(newChars);
    }
    
    @Override
    public int Length() {
        return chars.length;
    }
    
    @Override
    public StringT Clone() {
        
        char[] clonedChars = new char[this.chars.length];
        
        for (int i = 0; i < this.chars.length; i++) {
            clonedChars[i] = this.chars[i];
        }
        
        return new myStringT(clonedChars);
    }
    
    @Override
    public char CharAt(int i) {
        if (i < 0 || i >= chars.length) {
            throw new stringTException("index out of bounds");
        }
        
        return chars[i];
    }
    
    @Override
    public char[] ToArray() {
        
        char[] copy = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            copy[i] = chars[i];
        }
        
        return copy;
    }
    
    @Override
    public StringT SubString(int i, int j) {
        if (i < 0 || i >= chars.length || j < 0 || j >= chars.length || i >= j) {
            throw new stringTException("invalid range");
        }
        
        char[] newChars = new char[j - i];
        for (int k = i; k < j; k++) {
            newChars[k - i] = chars[k];
        }
        
        return new myStringT(newChars);
    }
    
    @Override
    public StringT reverse() {
        
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        
        return new myStringT(reversed);
    }
    
    @Override
    public int charCount(char c) {
        
        char[] lower = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            lower[i] = Character.toLowerCase(chars[i]);
        }
        
        int count = 0;
        for (int i = 0; i < lower.length; i++) {
            if (lower[i] == c) {
                count++;
            }
        }
        
        
        return count;
    }
    
    @Override
    public Iterator<Character> iterator() {
        return new stringTIterator(this);
    }
}