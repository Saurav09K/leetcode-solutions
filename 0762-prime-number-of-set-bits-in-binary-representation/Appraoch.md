# 762. Prime Number of Set Bits in Binary Representation

**Difficulty:** Easy  
**Tags:** Bit Manipulation, Math, Java

## 💡 Intuition & Logic

At first glance, this problem seems to require a nested loop to convert numbers to binary, count the `1`s, and then mathematically check if that count is a prime number. However, a closer look at the constraints reveals a massive optimization opportunity:

* The maximum value for `right` is $10^6$.
* In binary, $10^6$ takes at most 20 bits (since $2^{20} = 1,048,576$).
* Therefore, the **maximum possible number of set bits (1s)** for any number in this range is strictly **20**.

Because the maximum count of set bits is so small, we do not need a dynamic `isPrime()` function. We only need to check if the count matches the prime numbers between 2 and 20:
`{2, 3, 5, 7, 11, 13, 17, 19}`

## 🚀 Approach

1. **Loop through the range:** Iterate from `left` to `right` (inclusive).
2. **Count Set Bits instantly:** Instead of manually calculating the binary string, use Java's highly optimized built-in method `Integer.bitCount(n)` to get the number of `1`s in $\mathcal{O}(1)$ time.
3. **Check against hardcoded primes:** Use a `Set` (or a simple `if` condition/boolean array) containing the primes up to 20. If the count of set bits is in this set, it's a valid number.
4. **Count and Return:** Maintain a `result` counter, increment it for valid numbers, and return the final count.

## ⏳ Complexity Analysis

* **Time Complexity:** $\mathcal{O}(N)$ where $N$ is the number of elements in the range `[left, right]`. `Integer.bitCount(n)` and `Set.contains()` both operate in $\mathcal{O}(1)$ time.
* **Space Complexity:** $\mathcal{O}(1)$. The space required to store the hardcoded prime numbers is constant and does not scale with the input size.

## 💻 Java Snippet Reference
```java
// Core logic used in the solution
Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
int count = 0;

for (int i = left; i <= right; i++) {
    int setBits = Integer.bitCount(i);
    if (primes.contains(setBits)) {
        count++;
    }
}
return count;



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Humein ye check nahi karna hai ki wo actual number (jaise 100,000) prime hai ya nahi.
Humein ye check karna hai ki us number ko binary mein convert karne ke baad usme kitne '1' aate hain, kya wo COUNT prime hai?

Ek bade example se samajhte hain:
Maan lo range ke beech mein ek bada number aata hai: 100,000 (Ek lakh).

Number: 100,000

Iska Binary Convert Kiya: 11000011010100000

Isme total '1' (set bits) kitne hain? Dhyan se gino, sirf 6 baar '1' aaya hai.

Ab humein 100,000 ko prime check nahi karna hai. Humein sirf is 6 ko check karna hai. Kya 6 prime number hai? Nahi. Toh ye number humare answer mein count nahi hoga.

Phir hum sirf 19 tak hi check kyun kar rahe hain?
Ab aate hain sabse maximum limit par:

Question ke hisaab se sabse bada number 1,000,000 ho sakta hai.

Jab aap 1,000,000 ko binary mein likhte ho, toh usme maximum 20 digits (bits) hi aate hain.

Agar main koi aisa number le loon jiske binary mein saare ke saare 20 bits '1' hon (yani 11111111111111111111), toh usme total '1' ginkar kitne aayenge? Maximum 20.

Jab humare '1' ka total count kabhi 20 se bada ho hi nahi sakta, toh humein 20 se aage ke prime numbers (jaise 23, 29, ya 999983) check karne ki zaroorat hi nahi hai! Humein bas ye dekhna hai ki jo count aaya hai, kya wo 2, 3, 5, 7, 11, 13, 17, 19 mein se koi ek hai.
