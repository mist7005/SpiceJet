package pracPac;

import java.util.LinkedHashSet;
import java.util.Stack;

public class MaskString {

	public static void main(String[] args) {
		String s="We belong to Russia";
		String mask="Wbos";
		for (int i = 0; i < s.length(); i++) {
			if(!(checkPresent(s.charAt(i),mask)))
			{
				System.out.print(s.charAt(i));
			}
		}
		System.out.println();
		System.out.println(removeMaskCharacters(s,mask));
		System.out.println(removeAdjacentRepeatedCharacters("CDEEAABBCCAE"));
		int ar[]=usingExceptionStringToIntegerArr("76 my name 7263 12");
		System.out.println(ar.length);
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+" ");
		}
		System.out.println();

		largestAndSmallestWord(s);
		firstNonRepeatingCharacter();
		usingArrfirstNonRepeatingCharacter();
	}
	public static boolean checkPresent(Character c,String s)
	{
		String conV=c.toString();

		if(s.contains(conV))
			return true;

		else
			return false;
	}
	static String removeMaskCharacters(String str, String str2){

		int[] array = new int[256];

		int i;

		for(i=0; i<str2.length(); i++){

			array[str2.charAt(i)]++;
			System.out.println(array[str2.charAt(i)]);

		}

		String output="";

		for(i=0; i<str.length(); i++){

			if(array[str.charAt(i)] == 0)

				output+=str.charAt(i);

		}

		return output;

	}
	// Function to remove adjacent characters

	static String removeAdjacentRepeatedCharacters(String str){

		Stack<Character> stack = new Stack<>();

		int i;

		stack.push(str.charAt(0));

		for(i=1; i<str.length(); i++){
			try {
				if(stack.peek() == str.charAt(i))

				{
					stack.pop();
					continue;
				}
			} catch (Exception e) {
			}

			stack.push(str.charAt(i));
			System.out.println(1);
		}
		StringBuffer obj = new StringBuffer();
		while(!stack.isEmpty()){
			obj.append(stack.pop());
		}
		return obj.reverse().toString();
	}

	static boolean checkIfInteger(String s)
	{
		for (int i = 0; i < s.length(); i++) {
			Character c=s.charAt(i);
			if(!Character.isDigit(c))
			{
				return false;
			}
		}
		return true;

	}
	static int[] stringToIntegerArr(String s)
	{

		String str[]=s.split(" ");
		int intArray[]=new int[str.length]; 
		for (int i = 0; i < str.length; i++) {
			if(checkIfInteger(str[i]))
			{
				intArray[i]=Integer.parseInt(str[i]);
			}
			else
				intArray[i]=-1;
		}
		return intArray;	
	}

	static int[] usingExceptionStringToIntegerArr(String s)
	{

		String str[]=s.split(" ");
		int intArray[]=new int[str.length]; 
		for (int i = 0; i < str.length; i++) {
			try
			{
				intArray[i]=Integer.parseInt(str[i]);
			}
			catch (NumberFormatException e) {
				intArray[i]=-1;
			}
		}
		return intArray;

	}

	static void largestAndSmallestWord(String s)
	{
		int maxLength=Integer.MIN_VALUE;
		int minLength=Integer.MAX_VALUE;

		String str[]=s.split(" ");
		String smallest="";
		String largest="";
		for (int i = 0; i < str.length; i++) {
			if(str[i].length()>maxLength)
			{
				smallest=str[i];
				maxLength=str[i].length();
			}

			if(str[i].length()<minLength)
			{
				largest=str[i];
				minLength=str[i].length();
			}
		}

		System.out.println("min length: "+minLength+"-->"+smallest);
		System.out.println("max length: "+maxLength+"-->"+largest);

	}

	// Java Program to Find the First non-repeated Character in a String.
	static void firstNonRepeatingCharacter()
	{
		String x = "Hi this is Marry";
		x=x.replaceAll(" ", "");
		char ch[]=x.toCharArray();
		LinkedHashSet<Character> c=new LinkedHashSet<>();
		for (Character character : ch) {
			c.add(character);
		}
		
		boolean repeated=true;
		for (Character character1 : c) 
		{
			int count=0;
			for (Character character2 : ch) {
				if(character1.equals(character2))
				{
					count++;
				}
			}
			
			if(count==1)
			{
				System.out.println("character:  "+character1);
				repeated=false;
				break;
			}
		}
		if(repeated)
		{
			System.out.println("each character is repeated");
		}

	}
	
	// Java Program to Find the First non-repeated Character in a String.
	static void usingArrfirstNonRepeatingCharacter()
	{
		String x = "HHi Zthis is Marry P";
		int arrayCount[]=new int[256];
		int arrayIndex[]=new int[256];
		
		for (int i = 0; i < x.length(); i++) {
			arrayCount[x.charAt(i)]++;
			arrayIndex[x.charAt(i)]=i;
		}
		
		int index=Integer.MAX_VALUE;
		for (int i = 0; i < 256; i++) {
			if(arrayCount[i]==1 && arrayIndex[i]<index)
			{
					index=arrayIndex[i];
			}
		}
		System.out.println(x.charAt(index));
	}
	
}


