package lotto.view.outputView;

public class YieldOutputView {
    public static void showYield(double yield) {
        StringBuffer yieldInfo = new StringBuffer();
        yieldInfo.append("총 수익률은 ")
                .append(yield)
                .append("%입니다.");
        System.out.println(yieldInfo);
    }
}
