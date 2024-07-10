import java.util.*;

class Solution {
    public String reformatDate(String date) {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        String[] segments = date.split(" ");
        String year = segments[2];
        String month = months.get(segments[1]);
        int index = 0;
        while (Character.isDigit(segments[0].charAt(index))) {
            index++;
        }
        int day = Integer.parseInt(segments[0].substring(0, index));
        return String.format("%s-%s-%02d", year, month, day);
    }
}
