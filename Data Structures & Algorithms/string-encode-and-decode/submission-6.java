class Solution {

    public String encode(List<String> strs) {   
        StringBuilder str = new StringBuilder();
        for(String s : strs)
        {
            int length = s.length();
            str.append(length);
            str.append("#");
            str.append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while(i < str.length())
        {
            StringBuilder numSB = new StringBuilder();
            while(str.charAt(i) != '#')
            {   
                numSB.append(str.charAt(i));
                i++;
            }
            int wordSize = Integer.parseInt(numSB.toString());
            if(wordSize > 0)
            {
                String subString = str.substring(i+1, i+1+wordSize);
                i = i + 1 + wordSize;
                list.add(subString);
            }
            else if(wordSize == 0)
            {
                list.add("");
                i+=1;
            }
        }
        return list;
    }
}
