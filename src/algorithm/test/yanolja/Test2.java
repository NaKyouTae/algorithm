package algorithm.test.yanolja;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

public class Test2 {
    public static void main(String[] args) {

    }

    @Test
    public void shouldInvert() {
        Assert.assertEquals(Inverter.invert("a"), "a");
        Assert.assertEquals(Inverter.invert(null), "");
        Assert.assertEquals(Inverter.invert("abcd"), "dcba");

        Assert.fail();
    }

    @Test
    @Description("invert 함수에 들어가는 인자앖의 길이가 1글자 인경우 입력된 글자를 그대로 반환한다.")
    public void inputStringParamLengthOne() {
        Assert.assertEquals(Inverter.invert("a"), "a");
    }

    @Test
    @Description("invert 함수에 들어가는 인자값이 null일 경우 빈 문자열을 반환하다.")
    public void inputNull() {
        Assert.assertEquals(Inverter.invert(null), "");
    }

    @Test
    @Description("invert 함수에 입력되는 인자갑의 길이가 1글자 이상일 경우 글자의 위치를 반전하여 반환하다.")
    public void inputStringParamInvert() {
        Assert.assertEquals(Inverter.invert("abcd"), "dcba");
    }

    public static class Inverter {
        public static String invert(String str) {
            if(str == null || str.equals("")) return "";

            StringBuilder sb = new StringBuilder();
            sb.append(str).reverse();
            return sb.toString();
        }
    }
}
