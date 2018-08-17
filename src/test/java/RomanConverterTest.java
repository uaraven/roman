import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class RomanConverterTest {

    private RomanConverter converter;

    @Before
    public void setUp() {
        this.converter = new RomanConverter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailOnNegativeNumbers() {
        this.converter.convertToRoman(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailOnZero() {
        this.converter.convertToRoman(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailOnLargeNumber() {
        this.converter.convertToRoman(5001);
    }

    @Test
    public void shouldConvertDirectMapped() {
        String result = this.converter.convertToRoman(5);
        assertThat(result, is("V"));

        result = this.converter.convertToRoman(1);
        assertThat(result, is("I"));

        result = this.converter.convertToRoman(1000);
        assertThat(result, is("M"));
    }

    @Test
    public void shouldConvertSingleDigits() {
        String result = this.converter.convertToRoman(3);
        assertThat(result, is("III"));

        result = this.converter.convertToRoman(6);
        assertThat(result, is("VI"));

        result = this.converter.convertToRoman(17);
        assertThat(result, is("XVII"));
    }

    @Test
    public void shouldConvertNumbersWithSubtractiveNotation() {
        String result = this.converter.convertToRoman(4);
        assertThat(result, is("IV"));

        result = this.converter.convertToRoman(45);
        assertThat(result, is("XLV"));
    }

    @Test
    public void shouldConvertExamplesFromWikipedia() {
        String result = this.converter.convertToRoman(1776);
        assertThat(result, is("MDCCLXXVI"));

        result = this.converter.convertToRoman(1954);
        assertThat(result, is("MCMLIV"));

        result = this.converter.convertToRoman(1990);
        assertThat(result, is("MCMXC"));

        result = this.converter.convertToRoman(2014);
        assertThat(result, is("MMXIV"));
    }
}
