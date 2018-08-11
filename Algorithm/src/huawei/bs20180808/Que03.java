package huawei.bs20180808;

import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-08
 */
public class Que03
{
    public static int result = 0;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] expArr = in.nextLine().split(";");
        String input = in.nextLine();


        Set<String> basicDataTypes = new HashSet<>();
        basicDataTypes.add("bool");
        basicDataTypes.add("char");
        basicDataTypes.add("int");
        basicDataTypes.add("float");
        basicDataTypes.add("double");
        basicDataTypes.add("void");
        basicDataTypes.add("wchar_t");

        Map<String, String> map = new HashMap<>();
        Map<String, String> realMap = new HashMap<>();
        for (String exp : expArr)
        {
            while (true)
            {
                if (exp.startsWith(" ")) exp = exp.substring(1);
                else break;
            }
            String[] tmp = exp.split(" ");
            if (!tmp[0].trim().equals("typedef"))
            {
                System.out.println("none");
                return;
            }
            String str1 = tmp[1].replace("*", "").trim();
            if (!basicDataTypes.contains(str1) && !map.containsKey(str1))
            {
                System.out.println("none");
                return;
            }

            String str2 = tmp[2].trim();
            map.put(str2, str1);
            realMap.put(str2, tmp[1]);
        }

        String result = "";
        while (true)
        {
            if (!map.containsKey(input))
            {
                System.out.println("none");
                return;
            }

            String realStr = realMap.get(input);
            input = map.get(input);
            if (basicDataTypes.contains(realStr.replace("*", "").trim()))
            {
                result = realStr + result;
                break;
            }

            StringBuilder tmp = new StringBuilder();
            for (char c : realStr.toCharArray())
            {
                if (c == '*')
                    tmp.append("*");
            }
            result = result + tmp.toString();
        }

        for (char aChar : result.toCharArray())
        {
            if (aChar == '*')
                System.out.print(" ");
            System.out.print(aChar);
        }
    }
}
