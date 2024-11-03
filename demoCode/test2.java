
import com.sun.xml.internal.ws.util.StringUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sunhang (hang.sun@mobvoi.com)
 * @date 2022/11/10 11:44
 **/
public class test2 {

  public static void main(String[] args) {
    System.out.println(longest(new int[]{1,2,0,1}));
  }

  static int recur(int n) {
    if (n == 1) {
      return 1;
    }
    int res = recur(n - 1);
    return n + res;
  }

//  static int fib(int n) {
//    if (n == 1 || n == 2) {
//      return n - 1;
//    }
//    return fib(n - 1) + fib(n - 2);
//  }

  /* 斐波那契数列：递归 */
  static int fib(int n) {
    // 终止条件 f(1) = 0, f(2) = 1
    if (n == 1 || n == 2) {
      return n - 1;
    }
    // 递归调用 f(n) = f(n-1) + f(n-2)
    int res = fib(n - 1) + fib(n - 2);
    // 返回结果 f(n)
    return res;
  }

  static int longest(int[] nums) {
    int resut = 1;
    List<Integer> list = new ArrayList<>();
    int[] sortedNums = Arrays.stream(nums).sorted().toArray();
    for (int i = 0; i < sortedNums.length - 1; i++) {
      if (sortedNums[i] == sortedNums[i + 1] - 1) {
        resut++;
      } else {
        list.add(resut);
        resut = 1;
      }
      if (i == sortedNums.length - 2) {
        list.add(resut);
      }
    }
    return list.stream().max(Integer::compareTo).orElse(0);
  }
}