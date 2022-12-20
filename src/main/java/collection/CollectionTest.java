package collection;

import java.util.List;
import java.util.ArrayList;
/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    List newList=new ArrayList();
    if(input.size()!=0){
    for (int i=0;i<input.size();i++){
      Double op=Math.pow(((input.get(i)*2)+3),5);
      newList.add(op);
    }
    }
    return newList;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    List newList=new ArrayList();
    if(input.size()!=0){
      if(input.get(0).length()==0){newList.add("");}
      else{
        String element=input.get(0);
        String allString=Character.toUpperCase(element.charAt(0))+element.substring(1,element.length());
        newList.add(allString+allString);
      }
    }
    return newList;
  }

}
