import static java.lang.Math.rint;
import static java.lang.Math.round;

public class TestRound {

    public static void main(String[] args) {
//        System.out.println((29 % 30));
//        System.out.println(round(31/30));
//        System.out.println(round(59/30));

        System.out.println(convertEpoiDaysToMonth(29));
        System.out.println(convertEpoiDaysToMonth(31));
        System.out.println(convertEpoiDaysToMonth(59));
        System.out.println(convertEpoiDaysToMonth(61));

//        System.out.println(29./30.);
//        System.out.println(31./30.);
//        System.out.println(round(29./30));


    }

    static Long convertEpoiDaysToMonth(Integer epoi) {

        return round(epoi/30.0);
    }

}
