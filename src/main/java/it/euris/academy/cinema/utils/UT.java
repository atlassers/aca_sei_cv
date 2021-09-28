package it.euris.academy.cinema.utils;

public class UT {
    public static Long toLong(String value) {
        return value == null ? null : Long.parseLong(value);
    }
    
    public static String toString(Long value) {
      return value == null ? null : value.toString();
    }
    
}
