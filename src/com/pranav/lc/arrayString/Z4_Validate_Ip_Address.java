/**
 * 
 */
package com.pranav.lc.arrayString;

/**
 * @author pranavpatel
 * 
 * 
 * https://leetcode.com/problems/validate-ip-address/submissions/
 * 
 * https://leetcode.com/problems/validate-ip-address/discuss/95491/Java-Simple-Solution
 * 
 * https://www.youtube.com/watch?v=8eqC8yp5UeI
 * 
 * 
 * Time Complexity O(N)
 * Space Complexity O(1)
 *
 */
public class Z4_Validate_Ip_Address {
  public String validIPAddress(String IP) {
    if (isValidIPv4(IP))
      return "IPv4";
    else if (isValidIPv6(IP))
      return "IPv6";
    else
      return "Neither";
  }

  public boolean isValidIPv4(String ip) {
    
    
    // 1. String level validations 
    // 1.1.1.1 so if length is less than 7 return false;
    if (ip.length() < 7) return false;
    // if first char '.' 
    if (ip.charAt(0) == '.') return false;
    // if last char is '.'
    if (ip.charAt(ip.length() - 1) == '.') return false;

    
    // 2. token level validations 
    // split the string as '.' and '\' is escaping char use both
    String[] tokens = ip.split("\\.");
    
    if (tokens.length != 4) return false;
    for (String token : tokens) {
      if (!isValidIPv4Token(token))
        return false;
    }
    return true;
  }

  public boolean isValidIPv4Token(String token) {
    
    // if token starts with '0' and length is greater than 1;
    // 0 is valid 01 is not
    if (token.startsWith("0") && token.length() > 1)
      return false;
    try {
      
      int parsedInt = Integer.parseInt(token);
      
      // number should be between 0 and 255
      if (parsedInt < 0 || parsedInt > 255) return false;
      
      // if number is 0 first char is always 0 and only zero length check done above 
      if (parsedInt == 0 && token.charAt(0) != '0')
        return false;
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  public boolean isValidIPv6(String ip) {

    // min length is 15 
    if (ip.length() < 15) return false;
    // first and last char at String can no be ":"
    if (ip.charAt(0) == ':')
      return false;
    if (ip.charAt(ip.length() - 1) == ':')
      return false;
    
    // split the tokens
    String[] tokens = ip.split(":");
    //minimum 8 tokens
    if (tokens.length != 8)
      return false;
    
    for (String token : tokens) {
      if (!isValidIPv6Token(token))
        return false;
    }
    return true;
  }

  public boolean isValidIPv6Token(String token) {
    
    if (token.length() > 4 || token.length() == 0) return false;
    
    char[] chars = token.toCharArray();
    for (char c : chars) {

      if(!Character.isDigit(c) && !isHex(c)) return false;
      
    }
    return true;

  }
  
  public boolean isHex(char ch) {
    
    return (ch >= 'a' && ch <= 'f') ||(ch >= 'A' && ch <= 'F');
     
  }
}
