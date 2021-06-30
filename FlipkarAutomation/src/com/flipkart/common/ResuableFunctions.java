package com.flipkart.common;

public class ResuableFunctions {
	 //String starts with:

    public Boolean StringStartsWith (String InputString, String StartsWithString) {

         

          return InputString.startsWith(StartsWithString);

    }
    public Boolean StringEndsWith (String InputString, String EndsWithString) {

        

        return InputString.startsWith(EndsWithString);

  }
 public Boolean StringContains (String InputString, String EndsWithString) {

        

        return InputString.contentEquals(EndsWithString);

  }
 public Boolean StringEquals (String InputString, String EndsWithString) {

     

     return InputString.equals(EndsWithString);

}
}
