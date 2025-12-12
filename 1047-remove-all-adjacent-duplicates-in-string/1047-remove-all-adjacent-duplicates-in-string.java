
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
MORE OPTIMISED THAN THE ABOVE

Let's break down the Two Pointer / Array approach. It can be tricky because it does everything "in place" without creating a new stack object.
Think of it like this: You are rewriting the string onto itself.
j (The Scout): This pointer moves forward through the string constantly, reading every character one by one.
i (The Builder): This pointer tracks the end of your "clean" solution. Everything to the left of i is your final answer so far.
The Logic
We treat the array arr (from index 0 to i) as our Stack.
Scan: j looks at a new character.
Compare: We look at the character right before our builder pointer (arr[i-1]). This is the "top" of our stack.
Action:
If they match: We found a duplicate! Instead of adding the new one, we simply move i back one step (i--). This effectively "deletes" the previous character from our result.
If they don't match: We keep the character. We write the character found by j into the position at i, and then move i forward (i++).

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

    class Solution {
    public String removeDuplicates(String s) {
        char[] arr = s.toCharArray(); // working with raw array is faster than StringBuilder
        int i = 0; // 'i' acts as our stack pointer

        for (int j = 0; j < s.length(); j++) {
            // If stack is not empty (i > 0) AND top of stack (arr[i-1]) matches current char (arr[j])
            if (i > 0 && arr[i - 1] == arr[j]) {
                i--; // Pop: just move the pointer back!
            } else {
                arr[i] = arr[j]; // Push: overwrite the character at the current pointer
                i++; // increment pointer
            }
        }
        return new String(arr, 0, i); // Create string from index 0 to i
    }
}
