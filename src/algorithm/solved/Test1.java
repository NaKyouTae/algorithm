package algorithm.solved;

import org.junit.Test;

public class Test1 {
	@Test
	public void test() {
		String[] a = {"break3ing news5: ","1A 1circle is round!"};
		String[] b = {"","Fresh fried fish - fish fresh fried"};
		String[] c = {"2Here2 ","is"," out STRING"};
		String[] d = {"123I ","eat;sleep;repeat","321"};
		String[] e = {"I'm ","d3ev5el7op7ver; a3n4d ", "I'm", " s3t1ud3ing co23di42ng t4e3s123t"};
		
		
		convert(a);
		convert(b);
		convert(c);
		convert(d);
		convert(e);
	}
	
	public void convert(String[] input) {
		String str = "";
		String numStr = "";
		
		for(int i = 0; i < input.length; i++) {
			if(input[i].isEmpty()) continue;
			String em = "";

			if(i != 0 && !input[i-1].isEmpty()) {				
				em = (input[i].substring(0, 1) != " " && input[i-1].substring(input[i-1].length()-1, input[i-1].length()) != " ") ? " ":"";
			}
			
			numStr += em + input[i].replaceAll("\\d", "").replaceAll("\\s", " ");
		}
		
		String[] arrStr = numStr.split(" ");

		for(int i = 0; i < arrStr.length; i++) {
			if(arrStr[i].isEmpty()) continue;
			String em = (i != 0) ? " " : "";
			
			if(arrStr[i].contains(";")) {
				String[] cStr = arrStr[i].split(";");
				for(int j = 0; j < cStr.length; j++) {
					String semi = (arrStr[i].contains(cStr[j]+";")) ? ";":"";
					String cEm = (j != 0) ? "" : " ";
					str += cEm + cStr[j].substring(0, 1).toUpperCase() + cStr[j].substring(1, cStr[j].length()) + semi;
				}
			}else {				
				str += em + arrStr[i].substring(0, 1).toUpperCase() + arrStr[i].substring(1, arrStr[i].length());
			}
			
		}
		
		System.out.println(str);
	}
	
}
