import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Assignment3Q8 {
    public static void main(String[] args)
    {
        Map<String, String> cityCode = new HashMap<String, String>();
        cityCode.put("Canberra", "Australia");
        cityCode.put("Lucknow", "India");
        cityCode.put("London", "UK");

        Iterator iterator = cityCode.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(cityCode.get(iterator.next()));
            cityCode.put("Sharjah", "UAE");
        }
    }
} 