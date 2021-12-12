package model;

public class Funtion {
	
	private String funtion;
	private int leftLimit;
	private int rigthLimit;
	private int[] data;
		
	public Funtion(String word, int left, int rigth) {
		funtion = word;
		leftLimit = left;
		rigthLimit = rigth;
		data = new int[Math.abs(leftLimit) + Math.abs(rigthLimit) + 1];
	}
	
	public void calculateData() {
		char[] word = funtion.toCharArray();
		for(int i=0; i<word.length; i++) {
			if(word[i] == 'x' || word[i] == 'X') {
				calculateVariable(word, i);
			}
		}
	}
	
	private void calculateVariable(char[] word, int i) {
		char[] words = word;
		int accountant = 0;
		for(int j=leftLimit; j<=rigthLimit; j++) {
			words = rewrite(word, i, Integer.toString(j), i+1);
			pastedSymbols(words, accountant);
			accountant++;
		}
	}
	
	private void pastedSymbols(char[] word, int accountant) {
		char[] words = word;
		for(int j=0; j<words.length; j++) {
			if((words[j] == '*' || words[j] == '/') && (words[j+1] == '-')) {
				words = rewriteSymbols(words, j);
			}
		}
		initialNegative(words, accountant);
	}
	
	private char[] rewriteSymbols(char[] word, int i) {
		char[] words = word;
		switch(words[i]) {
		case '*' :
			words = rewriteSymbolsMultiplicationOrDivision(word, i+1);
			break;
		case '/':
			words = rewriteSymbolsMultiplicationOrDivision(word, i+1);
			break;
		}
		return words;
	}
	
	 private char[] rewriteSymbolsMultiplicationOrDivision(char[] word, int i) {
		 char[] words = word;
		 int k = 0;
		 int j = 0;
		 if(word[0] == '-') {
			 words = new char[word.length-2];
			 j = 1;
		 }else {
			 words = new char[word.length];
			 words[0] = '-';
			 k = 1;
		 }
		 while(j<word.length) {
				 if(j==i) {
					 j++;
				 }
				 words[k] = word[j];
				 k++;
				 j++;
		 }
		 return words;
	 }
	 
	 private void initialNegative(char[] word, int accountant) {
		 char[] words = word;
		 boolean negative = false;
		 if(words[0]=='-') {
			words = new char[word.length-1];
			for(int i=1; i<word.length; i++) {
				words[i-1] = word[i];
				negative = true;
			}
		}
		operationExponentiation(words, accountant, negative);
	 }
	 
	 private void operationExponentiation(char[] word, int accountant, boolean initialNegative) {
		 char[] words = word;
		 for(int i=0; i<words.length; i++) {
			if(words[i] == '^') {
				int[] numbers = accountantOperationsNumbers(words, i);
				double exponentPair = numbers[1]%2;
				if(exponentPair == 0 && initialNegative==true) {
					initialNegative = false;  
				} 
				char[] rewireWord = exponentiation(words, numbers);
				words = new char[rewireWord.length];
				words = rewireWord;
			}
	     }
		 operationMultiplication(words, accountant, initialNegative);
	 }
	 
	private char[] exponentiation(char[] word, int[] numbers) {
		int base = numbers[0];
		int exponente = numbers[1];
		String exponentiation = Integer.toString((int) Math.pow(base, exponente)); 
		return rewrite(word, numbers[2], exponentiation, numbers[3]);
	}
		
	private	void operationMultiplication(char[] word, int accountant, boolean initialNegative) {
		char[] words = word;
		for(int i=0; i<words.length; i++) {
			if(words[i] == '*') {
				char[] rewireWord = multiplication(words, i);
				words = new char[rewireWord.length];
				words = rewireWord;				
			}
		}
		operationDivision(words, accountant, initialNegative);
	}
	
	private char[] multiplication(char[] words, int i) {
		int[] numbers = accountantOperationsNumbers(words, i);
		int multiplications = numbers[0]*numbers[1]; 
		String multiplication = Integer.toString(multiplications);
		return rewrite(words, numbers[2], multiplication, numbers[3]);
	}	
	
	private void operationDivision(char[] word, int accountant, boolean initialNegative) {
		char[] words = word;
		for(int i=0; i<words.length; i++) {
			if(words[i] == '/') {
				char[] rewireWord =division(words, i);
				words = new char[rewireWord.length];
				words = rewireWord;
			}
		}
		checkOperation(words, accountant, initialNegative);	
	}
	
	private char[] division(char[] words, int i) {
		String division = "";
		int[] numbers = accountantOperationsNumbers(words, i);
		if(numbers[1] != 0) {
			int divisions = numbers[0]/numbers[1];
			division = Integer.toString(divisions);
		}else {
			int divisions = numbers[0]/1;
			division = Integer.toString(divisions);
		}
		return rewrite(words, numbers[2], division, numbers[3]);
	}
	
	private void checkOperation(char[] word, int accountant, boolean initialNegative) {
		int value = 0;
		int k=0;
		for(int j=0; j<word.length;j++) {
			if(word[j] != '+' && word[j] != '-') 
				k++;
		}
		if(k == word.length) {
			value = Integer.parseInt(new String(word)); 
			if(initialNegative == true) {
				value = value*(-1);
			}
		}else {
			value = sumOrSubtraction(word, initialNegative);
		}
		registerValues(value, accountant);
	}
	
	private int sumOrSubtraction(char[] word, boolean initialNegative) {
		int value = 0;
		for(int i=0; i<word.length;i++) {
			if(word[i] == '+') {
				value = sum(accountantOperationsNumbers(word, i), initialNegative, i);
			}else if(word[i] == '-') {
				value = subtraction(accountantOperationsNumbers(word, i), initialNegative, i);
			}
		}
		return value;
	}
	
	 private int sum(int[] dates, boolean initialNegative, int i) {
		 int  value = 0;
		 int number1 = dates[0];
		 int number2 = dates[1];
			 if(initialNegative == true) {
				 number1 = number1*(-1);
			 }
		 value = number2 + number1;
		 return value;
	 }
	 
	 private int subtraction(int[] dates, boolean initialNegative, int i) {
		 int  value = 0;
		 int number1 = dates[0];
		 int number2 = dates[1];
		 if(initialNegative == true) {
			number1 = number1*(-1);
		 }
		 value = number1 - number2;
		 return value;
	 }
	
	private void registerValues(int value, int accountant){
		data[accountant] = value;		
	}
	
	public char[] rewrite(char[] word, int leftPart, String centerPart, int rigthPart) {
		String words = "";
		char[] left = new char[leftPart];
		char[] rigth = new char[word.length-rigthPart];
		if(leftPart!=0) {
			for(int i=0; i<leftPart; i++) {
				left[i]= word[i];
			}	
		}
		if(rigthPart !=0){
			for(int j=rigthPart; j<word.length; j++) {
				rigth[j-rigthPart] = word[j];
			}
		}
		words = new String(left) + centerPart + new String(rigth); 
		return words.toCharArray();
	}
	
	private int[] accountantOperationsNumbers(char[] words, int i) {
		int[] operationsNumbers = new int[4];
		int[] accountantNumbers = new int[2];
		int accountantA = 0;
		int accountantB = 0;
		for(int s=i+1; s<words.length; s++) {
			if(words[s] != '*' && words[s] != '/' && words[s] != '+' && words[s] != '-' && words[s] != '^') {
				accountantA++;
			}else {
				break;
			}
		}
		for(int s=i-1; s>=0; s--) {
			if(words[s] != '*' && words[s] != '/' && words[s] != '+' && words[s] != '-' && words[s] != '^') {
				accountantB++;
			}else {
				break;
			}
		}
		accountantNumbers[0] = accountantA;
		accountantNumbers[1] = accountantB;
		operationsNumbers = findOperationsNumbers(words, i, accountantNumbers);
		return operationsNumbers;
	}
	
	private int[] findOperationsNumbers(char[] words, int i, int[] accountantNumbers) {
		int[] numbers = new int[4];
		char[] a = new char[accountantNumbers[0]]; 
		char[] b = new char[accountantNumbers[1]];
		int j = i+1;
		int k = 0;
		while(j<words.length) {
			if(words[j] != '*' && words[j] != '/' && words[j] != '+' && words[j] != '-' && words[j] != '^') {
				a[k] = words[j];
			}else {
				break;
			}
			j++;
			k++;
		}
		int p = i-1;
		int r = accountantNumbers[1]-1;
		while(p>=0) {
			if(words[p] != '*' && words[p] != '/' && words[p] != '+' && words[p] != '-' && words[p] != '^') {
				b[r] = words[p];
			}else {
				break;
			}
			if(p==0)
				break;
			if(r==0)
				break;
			p--;
			r--;
		}
		String number1 = new String(b);
		String number2 = new String(a);
		numbers[0] = Integer.parseInt(number1);
		numbers[1] = Integer.parseInt(number2);
		numbers[2] = p;
		numbers[3] = j;
		return numbers;
	}
	
	public int[] getData() {
		return data;
	}
	
	public String getFuntion() {
		return funtion;
	}
	
	public int getLeftLimit() {
		return leftLimit;
	}
	
	public int getRigthLimit() {
		return rigthLimit;
	}

}
