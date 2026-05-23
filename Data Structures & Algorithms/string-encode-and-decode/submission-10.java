class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs)
        {
            int strLength = s.length();
            sb.append(strLength);
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int lenIndex = 0;
        int strLength = 0;
        List<String> list = new ArrayList<>();
        char[] charArr = str.toCharArray();
        int i=0;
        while(i < charArr.length)
        {
            StringBuilder lengthSb = new StringBuilder();
            while(charArr[i] != '#')
            {
                lengthSb.append(charArr[i]);
                i++;
            }
            strLength = Integer.parseInt(lengthSb.toString());
            i++;
            StringBuilder wordSb = new StringBuilder();
            while(strLength > 0 && i<charArr.length)
            {
                wordSb.append(charArr[i]);
                strLength--;
                i++;
            }
            list.add(wordSb.toString());
        }
        return list;
    }
}
