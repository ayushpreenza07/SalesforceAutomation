package Salesforce;

import java.math.BigDecimal;

public class demo {

    public static void main(String[] args) {

        BigDecimal balanceBeforeBetDecimal = new BigDecimal("117.63");
        BigDecimal balanceAfterBetDecimal = new BigDecimal("117.33");

        BigDecimal netPosition = new BigDecimal("0.30");
        BigDecimal maxLossDecimal = balanceBeforeBetDecimal.subtract(netPosition);

        System.out.println(maxLossDecimal);
        System.out.println(balanceAfterBetDecimal.compareTo(maxLossDecimal));
    }
}
