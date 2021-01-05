package ui;

public class Test {
	public static void main(String[] args) {
		String s="15368457E2354Y4645";
		//System.out.println(s.length());
		String[] part=	s.split("(?=Tuan)");
	//	System.out.println(part[1]);
		String file ="C://Accc//HinhAnhXe//Ahcs//hinhanh.png";
    	String[] link=file.split("(?=HinhAnhXe)");
    //	System.out.println(link[1]);
    	
    	String a="c://Accc//HinhAnhXe//Ahcs//hinhanh.png";
    		String b= String.valueOf(a.charAt(1));
    		String c=String.valueOf(a.charAt(0));
			if(b.equalsIgnoreCase(":")&&(c.equalsIgnoreCase("c")||c.equalsIgnoreCase("d")||c.equalsIgnoreCase("e")||c.equalsIgnoreCase("f")||c.equalsIgnoreCase("g"))) {
		//		System.out.println(a);
			}else {
		//		System.out.println("No");
		}
	}
}
