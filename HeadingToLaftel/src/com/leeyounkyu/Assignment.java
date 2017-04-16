package com.leeyounkyu;

public class Assignment {

	public static void main(String[] args) {
		
		System.out.println("\n-----------1. ReadNumbers-----------\n");
		
		ReadNumbers readNumbers = new ReadNumbers();
		int[] test1 = {};
		int[] test2 = {1};
		int[] test3 = {1, 3};
		int[] test4 = {1, 2, 3};
		int[] test5 = {1, 2, 3, 6, 8, 9, 10};
		int[] test6 = {13, 14, 15, 16, 20, 23, 24, 25, 100};
		int[] test7 = {3, 13, 14, 15, 16, 19, 20, 23, 24, 25, 26, 27, 75, 100};
		int[] test8 = {1, 2, 4};
		
		System.out.println("expect1 = " + "");
		System.out.println("result1 = " + readNumbers.ReadNum(test1));
		System.out.println("\n-------------------------------\n");
		System.out.println("expect2 = " + "1");
		System.out.println("result2 = " + readNumbers.ReadNum(test2));
		System.out.println("\n-------------------------------\n");
		System.out.println("expect3 = " + "1,3");
		System.out.println("result3 = " + readNumbers.ReadNum(test3));
		System.out.println("\n-------------------------------\n");
		System.out.println("expect4 = " + "1~3");
		System.out.println("result4 = " + readNumbers.ReadNum(test4));
		System.out.println("\n-------------------------------\n");
		System.out.println("expect5 = " + "1~3,6,8~10");
		System.out.println("result5 = " + readNumbers.ReadNum(test5));
		System.out.println("\n-------------------------------\n");
		System.out.println("expect6 = " + "13~16,20,23~25,100");
		System.out.println("result6 = " + readNumbers.ReadNum(test6));
		System.out.println("\n-------------------------------\n");
		System.out.println("expect7 = " + "3,13~16,19~20,23~27,75,100");
		System.out.println("result7 = " + readNumbers.ReadNum(test7));
		System.out.println("\n-------------------------------\n");
		System.out.println("expect8 = " + "1~2,4");
		System.out.println("result8 = " + readNumbers.ReadNum(test8));
		
		
		System.out.println("\n-----------2. ReverseWithTag-----------\n");
		
		String input = "The quick <font color=\"brown\">brown <br><i>fox</i><br></font> jumps <font color=\"yellow\">over</font> the <i>lazy</i> dog";
		
		ReverseWithTag Rwt = new ReverseWithTag();
		System.out.println("input = " + input);
		System.out.println("output = " + Rwt.ReverseHtml(input));
		
		
		System.out.println("\n-----------3. PokerHand-----------\n");
		
		String Test1_p1 = "3c 3d Kc 5c Qc"; // 3 Onepair, K , Q , 5
		String Test1_p2 = "3c 3a Kc 4c Qc"; // 3 Onepair, K , Q , 4
		String Test2_p1 = "Ac 2d 3c 4c 5c"; // BackStraight
		String Test2_p2 = "2c 3a 4c 5c 6c"; // 6High_Straight
		String Test3_p1 = "2c 3c Kc 5c Qc"; // Flush, K, Q, 5, 3, 2
		String Test3_p2 = "Tc 3c Kc 4c Qc"; // Flush, K, Q, T, 4, 3
		String Test4_p1 = "5c 5d 5c 5c Qc"; // 5FourOfaKind, Q
		String Test4_p2 = "5c 5a 4c 4c Kc"; // 5,4_TwoPair, K 
		String Test5_p1 = "5c 5d 5c 3c 3c"; // 3,2 FullHouse
		String Test5_p2 = "5c 5a 5c 3d 3c"; // 3,2 FullHouse 
		
		PokerHand ph = new PokerHand();
		System.out.println("Test1 Result = " + ph.PokerCheck(Test1_p1, Test1_p2));
		System.out.println("Test2 Result = " + ph.PokerCheck(Test2_p1, Test2_p2));
		System.out.println("Test3 Result = " + ph.PokerCheck(Test3_p1, Test3_p2));
		System.out.println("Test4 Result = " + ph.PokerCheck(Test4_p1, Test4_p2));
		System.out.println("Test5 Result = " + ph.PokerCheck(Test5_p1, Test5_p2));
		
	}
	

}
