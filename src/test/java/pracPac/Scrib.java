package pracPac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scrib {

	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,6};
		int b[]= {7,8,9,2,325,12};
		int len=a.length+b.length;
		List<Integer> s=new ArrayList<>();
		for(int i=0;i<a.length;i++)
		{
			
			s.add(a[i]);
		}
		for(int i=0;i<b.length;i++)
		{
			
			s.add(b[i]);
		}
		
//		int c[]=new int[len];
//		for(int i=0;i<len;i++)
//		{
//			c[i]=s.get(i);
//		}
//		
//		for(int i=0;i<len;i++)
//		{
//			
//			System.out.print(c[i]+" ");
//		}
//		s.forEach(x -> System.out.print(x+" "));
//		System.out.println();
//		s.stream().sorted().forEach(System.out::println);
		
		List<String> z=Arrays.asList("b12","c10","d15");
		String z1[]= {"b12","c10","d15"};
		Stream.of(z1);
		z.stream().map(x -> x.substring(1)).mapToInt(Integer::parseInt).forEach(System.out::println);
		
		String ss="pankaj";
		String zz="amar";
//		System.out.println(ss.substring(3));
		ss=ss+zz;
		zz=ss.substring(0,ss.length()-zz.length());
		ss=ss.substring(zz.length());
		
		System.out.println("ss "+ss);
		System.out.println("zz "+zz);
		
		
		String m="norendra modi";
		System.out.println(repChar(m, 'o'));
	}
	public static String repChar(String s, char c){
		String x[]=s.split("");
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==c)
			{
				x[i]="";
			}
		}
		String z="";
		for (int i = 0; i < x.length; i++) {
			z=z+x[i];
		}
		return z;
	}
	
	public static String rmChar(String s, char c){
		char x[]=s.toCharArray();
		String z="";
		for (int i = 0; i < x.length; i++) {
			if(x[i]==c)
			{
				continue;
			}
			else
			{
				z=z+x[i];
			}
	}
		return z;

	}
}
