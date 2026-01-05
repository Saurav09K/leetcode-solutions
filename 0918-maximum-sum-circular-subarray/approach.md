The "Pizza Crust" Logic 🍕
Imagine karo ek Pizza ka crust (kinara) hai jo gol (circular) hai. Us crust par alag-alag jagah par Cheese (Positive +) aur Jala hua part (Negative -) hai.

Tumhe Sabse Zyada Cheese khani hai aur Jala hua part avoid karna hai.

Ab tumhare paas 2 options hain:

1. Option A: Seedha Tukda (Normal Kadane)
Agar saara cheese ek hi taraf saath mein hai (beech mein), toh tum seedha wahi tukda utha loge.

Example: [-5, 100, 50, -5]

Tumhe dikha 100, 50 saath mein hain. Tumne utha liya.

Ye humara Normal Max Kadane hai.

2. Option B: Gol Tukda (Wrapping Case)
Agar cheese donon kinaron par hai aur beech mein jala hua part hai?

Example: [50, -20, 50]

Yahan best cheese Left (50) aur Right (50) par hai.

Agar tum seedha uthaoge, toh beech ka -20 bhi aayega (Total 80 banega).

Smart Tareeka: Tum poore Pizza (Total) mein se bas wo beech ka jala hua part (-20) kaat kar phek do.

Formula: Poora Pizza (Total Sum) - Jala Hua Part (Min Subarray)

Total (80) - (-20) = 100. (Yahi toh chahiye tha!).

Isliye Hum "Min" aur "Total" Nikaalte Hain
Circular array mein "Max Subarray jo corner cross kare" dhoondna mushkil hota hai. Lekin "Min Subarray jo beech mein ho" dhoondna aasaan hai (Standard Kadane se).

Toh hum maths ka ulta logic lagate hain:

"Agar mujhe Best Wrapping Part chahiye, toh main Total Sum mein se Worst Middle Part ko minus kar dunga."

Example Trace ([5, -3, 5])
Total Sum: 5 + (-3) + 5 = 7.

Seedha Max (Normal Kadane):

5 -> 5

-3 -> -3 (Chain toot gayi)

5 -> 5

Max So Far = 5. (Lekin ye sahi answer nahi hai, humein 10 chahiye).

Seedha Min (Beech ka Kachra):

Sabse chhota subarray kaunsa hai? -3.

Circular Formula:

Total - Min

7 - (-3) = 7 + 3 = 10.

Final Decision:

Option A (Seedha): 5

Option B (Gol/Total-Min): 10

Winner: 10.

Summary
Hum Total aur Min isliye nikaal rahe hain taaki hum Wrapping wala Max indirectly calculate kar sakein.

Kyunki: Max Wrapping Sum = Total Sum - Min Non-Wrapping Sum.

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        // Variables for Standard Max Kadane
        int currMax = 0;
        int maxSoFar = nums[0]; // Isko Integer.MIN_VALUE mat lena, array[0] lo
        
        // Variables for Standard Min Kadane
        int currMin = 0;
        int minSoFar = nums[0];
        
        for (int x : nums) {
            // 1. Calculate Total Sum
            totalSum += x;
            
            // 2. Standard Max Kadane (Normal Max dhoondo)
            currMax = Math.max(x, currMax + x);
            maxSoFar = Math.max(maxSoFar, currMax);
            
            // 3. Standard Min Kadane (Sabse ganda subarray dhoondo)
            currMin = Math.min(x, currMin + x);
            minSoFar = Math.min(minSoFar, currMin);
        }
        
        // Special Case: Agar sab negative hain (MaxSoFar < 0), toh circular logic mat lagao
        if (maxSoFar < 0) {
            return maxSoFar;
        }
        
        // Final Answer: Ya toh normal max bada hai, ya wrapping wala (Total - Min)
        return Math.max(maxSoFar, totalSum - minSoFar);
    }
}
