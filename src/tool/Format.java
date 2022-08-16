package tool;
//字符串工具类

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Format {
  
  //String is empty
  public static boolean isEmpty(String string) {
    if (string == null || "".equals(string.trim())) {
      return true;
    }
    else {
      return false;
    }
  }
  //String is not empty
  public static boolean isNotEmpty(String string) {
    if (string != null && !"".equals(string.trim())) {
      return true;
    }
    else {
      return false;
    }
  }
  //String only contains letters
  public static boolean nameFormat(String string) {
    String regex = "^([a-zA-Z]+)";
    return string.matches(regex);
  }
  //String must contain letters and numbers
  public static boolean passwordFormat(String string) {
    String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
    return string.matches(regex);
  }
  //Convert the first letter to uppercase and rest to lowercase
  public static String nameConvert(String str) {
    String first = str.substring(0, 1);
    String after = str.substring(1); //获取索引位置1后面所有剩余的字符串
    first = first.toUpperCase();
    after = after.toLowerCase();
    return first + after;
  }
  
  //string to date
  public static LocalDate strToDate(String str) throws IllegalArgumentException {
    try {
      LocalDate date = null;
      date = LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      return date;
    }
    catch (DateTimeException e) {
      throw new IllegalArgumentException("Invalid date");
    }
    
  }
  
  //string to double
  public static double strToDouble(String str) {
    double number = Double.parseDouble(str);
    return number;
  }
  
  public static int strToInt(String str) {
    int number = Integer.parseInt(str);
    return number;
  }
  
  
  

}
