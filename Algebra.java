public class Algebra {
	public static void main(String args[]) {

		System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6   
		
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int plusResult = x1; 
		for (int i = 0; i < x2; i++){
			plusResult++;
		}
		for (int i = 0; i > x2; i--){
			plusResult--;
		}
		
		
		return plusResult;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int minusResult = x1; 
		for (int i = 0; i < x2; i++){
			minusResult--;
		}
		for (int i = 0; i > x2; i--){
			minusResult++;
		}
		return minusResult;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int timesResult = 0;
		if (x1 < 0 && x2 < 0) {
			x1 = minus(0, x1);
			x2 = minus(0, x2);
		}
		for (int i = 0; i < x2; i++){
				timesResult = plus(x1 , timesResult);
			}

		return timesResult;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int powResult = x;
		if(x < 0){
			x = minus(0, x);
		}
		for(int i = 1; i < n; i++){
			powResult = times(powResult, x);
		}

		return powResult;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int divResult = 1;
		if (x2 < 0 && x1 > 0) { // if x2 is negative but x1 positive 
			x2 = minus(0, x2);
			while (divResult != x1) {
				if (times(x2, divResult) == x1) {
					return minus(0, divResult);
				}
				if (times(x2, divResult) > x1) {
					return (minus(0,minus(divResult, 1)));
				}
				divResult++;
			}
		}
		if (x1 < 0 && x2 > 0) { // if x1 is negative but x2 positive 
			x1 = minus(0, x1);
			while (divResult != x1) {
				if (times(x2, divResult) == x1) {
					return minus(0, divResult);
				}
				if (times(x2, divResult) > x1) {
					return (minus(0,minus(divResult, 1)));
				}
				divResult++;
			}
		}
		if (x1 < 0 && x2 < 0) {// if x1 is negative and x2 negative 
			x1 = minus(0, x1);
			x2 = minus(0, x2);

			while (divResult != x1) {
				if (times(x2, divResult) == x1) {
					return  divResult;
				}
				if (times(x2, divResult) > x1) {
					return minus(divResult, 1);
				}
				divResult++;
			}
		}
	
		while (divResult != x1) {
			if (times(x2, divResult) == x1) {
				return divResult;
			}
			if (times(x2, divResult) > x1) {
				return (minus(divResult, 1));
			}
			divResult++;
		}
	
		return divResult;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int modResult =div(x1, x2);
		modResult = times(modResult,x2);
		modResult = minus(x1, modResult);

		return modResult;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int newSqrt = 1;
		if (x == 0) {
			return 0;
		}
		while (x != times(newSqrt, newSqrt)) {
			newSqrt++;
			if (x<times(newSqrt, newSqrt)) {
				return minus(newSqrt, 1);
			}
		}
		return newSqrt;
	}	  	  
}