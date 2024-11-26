/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		if (str1 == "" || str2 == ""){
			return true;

		}
		
		char ch1, ch2;
        boolean boolAnagram = false;

        for (int i = 0; i < str1.length(); i++) {
            ch1 = str1.charAt(i);
            if ( ch1 <= 64 && ch1 <= 47 && ch1 >= 58 && ch1 >= 32 ) {
                continue;
            }
            for (int j = 0; j < str2.length(); j++) {
                ch2 = str2.charAt(j);

                if ( ch1 == ch2 + 32 || ch1 == ch2 - 32 || ch1 == ch2) {
                    boolAnagram = true;
                    break;
                } else {
                    boolAnagram = false;
                }
            }
            if (!boolAnagram) break;
        }
        return boolAnagram;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "";
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch >= 65 && ch <= 90) {
				ch += 32;
				newStr = newStr + ch;

			} else if (ch >= 97 && ch <= 122) {
				newStr = newStr + ch;

			} else if (ch == 32) {
				newStr = newStr + ch;
			}
		}
		return newStr;		
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		char ch1, ch2;
		String newString = "", smallerString = "";
		int randNum = 0;
		while (str.length() != 0) {
			smallerString = "";
			randNum = (int)(Math.random() * str.length());
			ch1 = str.charAt(randNum);
			if (ch1 == 32) {
				continue;
			}
			if (ch1 >= 65 && ch1 <= 90) {
				ch1 += 32;
			}
			newString = newString + ch1;
			for (int i = 0; i < str.length(); i++) {
				ch2 = str.charAt(i);
				if (ch1 != ch2) {
					smallerString = smallerString + ch2;
				}
			}
			str = smallerString;
		}
		return newString;	
	}
}
