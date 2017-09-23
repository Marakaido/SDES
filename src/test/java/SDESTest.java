/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.*;

public class SDESTest {
    SDES sdes = new SDES();

    @Test public void P10() {
        BitSet key = BitSet.valueOf(new long[]{0b1010000010});
        BitSet result = BitSet.valueOf(new long[]{0b1000001100});

        assertEquals("Wrong permutation", result, sdes.P10(key));
    }

    @Test(expected = IllegalArgumentException.class)
    public void P10ThrowsExceptionOnIncorectBitSize(){
        sdes.P10(new BitSet(11));
    }

    @Test public void LS(){
        BitSet key = BitSet.valueOf(new long[]{0b1000001100});
        BitSet result = BitSet.valueOf(new long[]{0b0000111000});

        assertEquals("Invalid permutation", result, sdes.LS(key));
    }

    @Test public void P8(){
        BitSet key = BitSet.valueOf(new long[]{0b0000111000});
        BitSet result = BitSet.valueOf(new long[]{0b10100100});

        assertEquals("Invalid permutation", result, sdes.P8(key));
    }

    @Test public void IP(){
        BitSet plainText = BitSet.valueOf(new long[]{0b11110011});
        BitSet result = BitSet.valueOf(new long[]{0b10111101});

        assertEquals("Invalid permutation", result, sdes.IP(plainText));
    }

    @Test public void inverseIP(){
        BitSet plainText = BitSet.valueOf(new long[]{0b10111101});
        BitSet result = BitSet.valueOf(new long[]{0b11110011});

        assertEquals("Invalid permutation", result, sdes.inverseIP(plainText));
    }

    @Test public void F(){
        BitSet plainText = BitSet.valueOf(new long[]{0b10111101});
        BitSet result = BitSet.valueOf(new long[]{0b11110011});

        assertEquals("Invalid permutation", result, sdes.F(plainText));
    }
}
