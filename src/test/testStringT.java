package test;

import String_T.StringT;
import String_T.myStringT;
import String_T.stringTException;

import java.util.Scanner;

public class testStringT {
    
    public void testConCat(StringT S) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a second string to concatenate: ");
        String secondInput = scanner.nextLine();
        StringT String2 = new myStringT(secondInput.toCharArray());
        
        StringT result = S.ConCat(String2);
        char[] expected = new char[S.Length() + String2.Length()];
        
        for (int i = 0; i < S.Length(); i++) {
            expected[i] = S.CharAt(i);
        }
        for (int i = 0; i < String2.Length(); i++) {
            expected[S.Length() + i] = String2.CharAt(i);
        }
        
        boolean match = true;
        char[] resultArray = result.ToArray();
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] != expected[i]) {
                match = false;
                break;
            }
        }
        System.out.println(result.ToArray());
        System.out.println("testConCat: " + (match ? "Passed" : "Failed"));
    }
    
    public void testBefore(StringT S) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an index for Before test: ");
        int index = scanner.nextInt();
        
        StringT result = S.Before(index);
        char[] expected = new char[index];
        
        for (int i = 0; i < index; i++) {
            expected[i] = S.CharAt(i);
        }
        
        boolean match = true;
        char[] resultArray = result.ToArray();
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] != expected[i]) {
                match = false;
                break;
            }
        }
        System.out.println(result.ToArray());
        System.out.println("testBefore: " + (match ? "Passed" : "Failed"));
    }
    
    public void testAfter(StringT S) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an index for After test: ");
        int index = scanner.nextInt();
        
        StringT result = S.After(index);
        char[] expected = new char[S.Length() - index];
        
        for (int i = index, j = 0; i < S.Length(); i++, j++) {
            expected[j] = S.CharAt(i);
        }
        
        boolean match = true;
        char[] resultArray = result.ToArray();
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] != expected[i]) {
                match = false;
                break;
            }
        }
        System.out.println(result.ToArray());
        System.out.println("testAfter: " + (match ? "Passed" : "Failed"));
    }
    
    public void testLength(StringT S) {
        int result = S.Length();
        System.out.println("String length: " + result);
        System.out.println("testLength: " + (result == S.ToArray().length ? "Passed" : "Failed"));
        
    }
    
    public void testClone(StringT S) {
        StringT result = S.Clone();
        System.out.println(result.ToArray());
        System.out.println("testClone: " + (S != result && new String(S.ToArray()).equals(new String(result.ToArray())) ? "Passed" : "Failed"));
    }
    
    public void testCharAt(StringT S) {
        Scanner scann = new Scanner(System.in);
        System.out.println("enter an index to test");
        int i = scann.nextInt();
        
        try {
            char result = S.CharAt(i);
            System.out.println(result);
            System.out.println("testCharAt: " + (result == S.ToArray()[i] ? "Passed" : "Failed"));
        } catch (stringTException e) {
            System.out.println("testCharAt: Failed with exception: " + e.getMessage());
        }
        
    }
    
    public void testToArray(StringT S) {
        char[] original = S.ToArray();
        char[] expected = new char[S.Length()];
        
        for (int i = 0; i < S.Length(); i++) {
            expected[i] = S.CharAt(i);
        }
        
        boolean match = true;
        for (int i = 0; i < original.length; i++) {
            if (original[i] != expected[i]) {
                match = false;
                break;
            }
        }
        System.out.println(original);
        System.out.println("testToArray: " + (match ? "Passed" : "Failed"));
    }
    
    public void testSubString(StringT S) {
        Scanner scann = new Scanner(System.in);
        System.out.println("enter an index to start at");
        int i = scann.nextInt();
        System.out.println("enter another index to end at");
        int j = scann.nextInt();
        
        try {
            StringT result = S.SubString(i, j);
            System.out.println(result.ToArray());
            System.out.println("testSubString: " + (new String(result.ToArray()).equals(new String(S.ToArray(), i, j - i)) ? "Passed" : "Failed"));
        } catch (stringTException e) {
            System.out.println("testSubString: Failed with exception: " + e.getMessage());
        }
    }
    
    
    public void testReverse(StringT S) {
        StringT reversed = S.reverse();
        char[] expected = new char[S.Length()];
        
        for (int i = 0; i < S.Length(); i++) {
            expected[i] = S.CharAt(S.Length() - 1 - i);
        }
        
        boolean match = true;
        char[] resultArray = reversed.ToArray();
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] != expected[i]) {
                match = false;
                break;
            }
        }
        System.out.println(reversed.ToArray());
        System.out.println("testReverse: " + (match ? "Passed" : "Failed"));
    }
    
    public void testCharCount(StringT S) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter character for CharCount test: ");
        char c = scanner.next().charAt(0);
        
        int expectedCount = 0;
        for (int i = 0; i < S.Length(); i++) {
            if (Character.toLowerCase(S.CharAt(i)) == Character.toLowerCase(c)) {
                expectedCount++;
            }
        }
        
        int resultCount = S.charCount(c);
        System.out.println(resultCount);
        System.out.println("testCharCount: " + (resultCount == expectedCount ? "Passed" : "Failed"));
    }
    
    public void testIterator(StringT S) {
        
        char[] expected = S.ToArray();
        int index = 0;
        boolean match = true;
        
        for (char c : S.ToArray()) {
            if (c != expected[index]) {
                match = false;
                break;
            }
            index++;
        }
        
        System.out.println("testIterator: " + (match ? "Passed" : "Failed"));
        
    }
    
    
    public static void main(String[] args) {
        testStringT tester = new testStringT();
        
        Scanner scann = new Scanner(System.in);
        System.out.println("Enter a string to test with");
        String input = scann.nextLine();
        StringT testString = new myStringT(input.toCharArray());
        
        while (true) {
            System.out.println("please choose a test case");
            System.out.println("1. Concatenation");
            System.out.println("2. Before");
            System.out.println("3. After");
            System.out.println("4. Length");
            System.out.println("5. Clone");
            System.out.println("6. CharAt");
            System.out.println("7. ToArray");
            System.out.println("8. SubString");
            System.out.println("9. Reverse");
            System.out.println("10. CharCount");
            System.out.println("11. Iterator");
            System.out.println("12. Test Suite (ALL TESTS)");
            System.out.println("0. Exit");
            
            
            Scanner scann2 = new Scanner(System.in);
            int choice = scann2.nextInt();
            
            switch (choice) {
                case 1:
                    tester.testConCat(testString);
                    System.out.println(" ");
                    break;
                
                case 2:
                    tester.testBefore(testString);
                    System.out.println(" ");
                    break;
                
                case 3:
                    tester.testAfter(testString);
                    System.out.println(" ");
                    break;
                
                case 4:
                    tester.testLength(testString);
                    System.out.println(" ");
                    break;
                
                case 5:
                    tester.testClone(testString);
                    System.out.println(" ");
                    break;
                
                case 6:
                    tester.testCharAt(testString);
                    System.out.println(" ");
                    break;
                
                case 7:
                    tester.testToArray(testString);
                    System.out.println(" ");
                    break;
                
                case 8:
                    tester.testSubString(testString);
                    System.out.println(" ");
                    break;
                
                case 9:
                    tester.testReverse(testString);
                    System.out.println(" ");
                    break;
                
                case 10:
                    tester.testCharCount(testString);
                    System.out.println(" ");
                    break;
                
                case 11:
                    tester.testIterator(testString);
                    System.out.println(" ");
                    
                    break;
                
                case 12:
                    tester.testConCat(testString);
                    tester.testBefore(testString);
                    tester.testAfter(testString);
                    tester.testLength(testString);
                    tester.testClone(testString);
                    tester.testCharAt(testString);
                    tester.testToArray(testString);
                    tester.testSubString(testString);
                    tester.testReverse(testString);
                    tester.testCharCount(testString);
                    tester.testIterator(testString);
                    System.out.println(" ");
                    break;
                
            }
        }
        
        
    }
    
}
