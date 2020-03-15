/**
 * 
 */
package com.pranav.lc;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.experimental.max.MaxCore;

/**
 * @author pranavpatel
 *
 */
public class ZZZZZ_codeground {

  static String getInitlaAmount(String transactionAmount, String fee) {
    // DecimalFormat df = new DecimalFormat("#.##").format(number);
    String initalAmount = "";

    double txna = Double.parseDouble(transactionAmount);
    double dfee = Double.parseDouble(fee);

    return new DecimalFormat("#.##").format(txna);

  }

  public static void main(String[] args) {

    String transactionAmount = "10.2171111";
    String fee = "11.2111";

    getInitlaAmount(transactionAmount, fee);

  }
}
