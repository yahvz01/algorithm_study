import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

abstract class CaesarChar {
    public static CaesarChar getInstance(int data) {
        if(isUpperCase(data)) 
            return new Upper(data);
        else if(isLowerCase(data))
            return new Lower(data);
        else
            return new Space(data);
    }

    final int originData;

    public CaesarChar( int originData ) {
        this.originData = originData;
    }

    public abstract int converted( int convertNumber );
    
    private static boolean isUpperCase( int data ) {
        if( 65 <= data && data <= 90 ) return true;
        else return false;
    }

    private static boolean isLowerCase( int data ) {
        if( 97 <= data && data <= 122 ) return true;
        else return false;
    }

    private static boolean isSpace( int data ) {
        return (data == 32);
    }
}

class Upper extends CaesarChar {
    public Upper( int originData ) { super(originData); }

    public int converted( int convertNumber ) {
        int preconverted = ((this.originData + convertNumber) % 91);
        if(preconverted < 65)
            return preconverted + 65;
        else
            return preconverted;
    }
}

class Lower extends CaesarChar {
    public Lower( int originData ) { super(originData); }

    public int converted( int convertNumber ) {
        int preconverted = ((this.originData + convertNumber) % 123);
        if(preconverted < 97)
            return preconverted + 97;
        else
            return preconverted;
    }
}

class Space extends CaesarChar {
    public Space( int originData ) { super(originData); }

    public int converted( int convertNumber ) {
        return this.originData;
    }
}


class Solution {
    public String solution( String s, int n) {
        
        char[] charArr = s.toCharArray();
        char[] convertedCharArr = new char[charArr.length];
        for( var idx = 0; idx < charArr.length; ++idx) {
            convertedCharArr[idx] = (char)CaesarChar.getInstance((int)charArr[idx]).converted(n);
        }
        return new String(convertedCharArr);

    }
}
