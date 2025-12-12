
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb=new StringBuilder();// use StringBuilder as a Stack
        for(int i=0; i<s.length(); i++)
        {
            if(sb.isEmpty())
            {
                sb.append(s.charAt(i));//add
            }
            else if(!sb.isEmpty())
            {
                if(sb.charAt(sb.length()-1)==s.charAt(i)) // if same remove
                {
                    sb.deleteCharAt(sb.length()-1);
                }
                else
                {
                    sb.append(s.charAt(i)); // if not same add 
                }
            }
        }
        return sb.toString();
    }
}