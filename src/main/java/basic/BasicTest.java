package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {

    if(i<0 || n<0){return Option.none();}
    if(i==0){if(n==0){return Option.of(1);}else{return Option.of(0);}}
    if(i>0 && n==0){return Option.of(1);}
    if(i>0 && n>0){
      try{
      int y[]=new int[100];
			y[1]=i;
			for(int j=2;j<=n;j++){
			y[j]=y[j-1]*y[1];
			}
      return Option.of(y[n]);
			}
			catch(Exception e) {
			return Option.none();
			}
    }
    return null;
  }




}
