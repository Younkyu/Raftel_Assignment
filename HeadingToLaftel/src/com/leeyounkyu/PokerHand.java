package com.leeyounkyu;

import java.util.Arrays;

/** 
 * "As 8d Ad 8c 5d"와 같은 형식의 문자열 두개를 받아서, 어느쪽이 이겼는지 체크한다.
 * 먼저 각각의 패의 서열을 체크한 후, 서열이 같은 경우에는 같은 등급내의 서열을 비교한다.
 * @param p1 Player1의 포커패 문자열
 * @param p2 Player2의 포커패 문자열
 * @return 들어간 배열의 연속된 숫자를 문자열로 바꾼 값
 * 사용방법 : 
 * <pre>
 * 		String p1 = "3c 3d Kc 5c Qc";
 *		String p2 = "3c 3a Kc 4c Qc";
 *		PokerHand ph = new PokerHand();
 *		String result = ph.PokerCheck(p1, p2);
 * </pre>
 * 결과값 : Player1 Win!
 * @author Younkyu
 *
 */

public class PokerHand {
	
	String p1Win = "Player 1 win!";
	String p2Win = "Player 2 win!";
	String draw = "Draw!";
	
	
	public String PokerCheck(String p1, String p2) {
		String result = "";
		
		String[] arrP1 = p1.split(" ");
		String[] arrP2 = p2.split(" ");
		
		int gradeP1 = GradeCheck(arrP1);
		int gradeP2 = GradeCheck(arrP2);
		
		if(gradeP1 > gradeP2) {
			result = p1Win;
		}else if(gradeP1 < gradeP2) {
			result = p2Win;
		} else {
			result = CheckDraw(arrP1, arrP2, gradeP1);
		}
		
		return result;
	}
	
	private int GradeCheck(String[] arr) {
			
			if(isRoyalFlush(arr)) {
				return 10;
			} else if(isStraightFlush(arr)) {
				return 9;
			} else if(isFourOfaKind(arr)) {
				return 8;
			} else if(isFullHouse(arr)) {
				return 7;
			} else if(isFlush(arr)) {
				return 6;
			} else if(isStraight(arr)) {
				return 5;
			} else if(isThreeOfaKind(arr)) {
				return 4;
			} else if(isTwoFairs(arr)) {
				return 3;
			} else if(isOneFairs(arr)) {
				return 2;
			} else {
				return 1;
			}
		}
	
	private boolean isRoyalFlush(String[] arr) {
		if(isFlush(arr) && isStraight(arr) && !isBackStraight(arr) && ArrIntConvert(arr)[4] == 14) {
			return true;
		}
		return false;
	}
	
	private boolean isStraightFlush(String[] arr) {
		if(isFlush(arr) && isStraight(arr)) {
			return true;
		}
		return false;
	}
	
	private boolean isFourOfaKind(String[] arr) {
		int[] result = PairCheck(arr);
		if(result[1]==4) {
			return true;
		}
		return false;
	}
	
	private boolean isFullHouse(String[] arr) {
		int[] result = PairCheck(arr);
		if(result[0] == 2 && result[1]==3) {
			return true;
		}
		return false;
	}
	
	private boolean isFlush(String[] input){
		String[] temp = new String[input.length];
		for(int i = 0 ; i < input.length ; i ++) {
			int tpl = input[i].length();
			temp[i] = input[i].substring(tpl-1, tpl);
		}
		if(temp[0].equals(temp[1]) && temp[0].equals(temp[2])
				&& temp[0].equals(temp[3])
				&& temp[0].equals(temp[4])) {
			return true;
		}
		
		return false;
	}
	
	
	private boolean isStraight(String[] arr) {
		int[] ar = ArrIntConvert(arr);
		
		if(ar[0]+1 == ar[1] && ar[1]+1 == ar[2] && ar[2]+1 == ar[3]
				&& (ar[3]+1 == ar[4] || ar[4]-12 == ar[0])) {
			return true;
		}
		return false;
	}
	
	private boolean isBackStraight(String[] arr) {

		int[] ar = ArrIntConvert(arr);
		
		if(ar[0]+1 == ar[1] && ar[1]+1 == ar[2] && ar[2]+1 == ar[3]
				&& ar[4]-12 == ar[0]) {
			return true;
		}
		return false;
	}
	
	
	
	private boolean isThreeOfaKind(String[] arr) {
		int[] result = PairCheck(arr);
		if(result[1]==3) {
			return true;
		}
		return false;
	}
	
	private boolean isTwoFairs(String[] arr) {
		int[] result = PairCheck(arr);
		if(result[0] == 2 && result[1]==2) {
			return true;
		}
		return false;
	}
	
	private boolean isOneFairs(String[] arr) {
		int[] result = PairCheck(arr);
		if(result[0] == 2) {
			return true;
		}
		return false;
	}
	
	
	private int[] PairCheck(String[] arr) {
		int[] ar = ArrIntConvert(arr);
		int[] temp = new int[15];
		for(int a : ar) {
			temp[a] = temp[a] +1;
		}
		int[] result = new int[2];
		int count = 0;
		for(int i = 2 ; i < 15 ; i++) {
			if(temp[i] >= 3) {
				result[1] = temp[i];
			}else if (temp[i] == 2) {
				result[count] = 2;
				count = count+1;
			}
		}
		
		return result;
	}
	
	

	
	private String CheckDraw(String[] ArrP1, String[] ArrP2, int grade) {

		int[] p1 = ArrIntConvert(ArrP1);
		int[] p2 = ArrIntConvert(ArrP2);
		String result = "";
		if(grade == 10) {
			result = draw;
		} else if (grade == 9 ) {
			result = CheckInt2(p1,p2);
			if(result.equals(draw)) {
				result = CheckBackStraight(ArrP1,ArrP2);
			}
		} else if (grade == 8) {
			result = CheckInt2(p1,p2);
			if(result.equals(draw)) {
				result = CheckSum(p1,p2);
			}
		} else if (grade == 7) {
			result = CheckInt2(p1,p2);
			if(result.equals(draw)) {
				result = CheckSum(p1,p2);
			}
		} else if (grade == 6) {
			result = HigherIntCompare(p1,p2);
		} else if (grade == 5) {
			result = CheckInt2(p1,p2);
			if(result.equals(draw)) {
				result = CheckBackStraight(ArrP1,ArrP2);
			}
		} else if (grade == 4) {
			result = CheckInt2(p1,p2);
			if(result.equals(draw)) {
				result = HigherIntCompare(p1,p2);
			}
		} else if (grade == 3) {
			result = PairCompare(p1,p2);
			if(result.equals(draw)) {
				result = HigherIntCompare(p1,p2);
			}
		} else if (grade == 2) {
			result = PairCompare(p1,p2);
			if(result.equals(draw)) {
				result = HigherIntCompare(p1,p2);
			}
		} else if (grade == 1) {
			result = HigherIntCompare(p1,p2);
		}
		
		return result;
	}
	
	private String PairCompare(int[] p1, int[] p2) {
		String result = "";
		int[] temp1 = new int[15];
		for(int a : p1) {
			temp1[a] = temp1[a] +1;
		}
		
		int[] temp2 = new int[15];
		for(int a : p2) {
			temp2[a] = temp2[a] +1;
		}
		
		for(int i = 14 ; i >= 0 ; i--) {
			if(temp1[i] == 2 && temp2[i] != 2) {
				return p1Win;
			} else if(temp1[i] != 2 && temp2[i] == 2) {
				return p2Win;
			}
		}
		
		return draw;
	}
	
	private String CheckInt2(int[] p1, int[] p2) {
		String result = "";
		
		if( p1[2] > p2[2]) {
			result = p1Win;
		} else if ( p1[2] < p2[2]) {
			result = p2Win;
		} else {
			result = draw;
		}
		return result;
	}
	
	private String CheckSum(int[] p1, int[] p2) {
		String result = "";
		int a = 0;
		int b = 0;
		
		for(int i : p1) {
			a = a+i;
		}
		
		for(int i : p2) {
			b = b+i;
		}
		
		if(a>b) {
			result = p1Win;
		} else if(a<b) {
			result = p2Win;
		} else {
			result = draw;
		}
		
		return result;
	}
	
	private String CheckBackStraight(String[] a, String[] b) {
		if(isBackStraight(a) && !isBackStraight(b)) {
			return p2Win;
		} else if(!isBackStraight(a) && isBackStraight(b)) {
			return p1Win;
		} else {
			return draw;
		}
	}
	
	
	private String HigherIntCompare(int[] p1, int[] p2) {
		int leng = p1.length;
		for(int i = leng-1 ; i >= 0 ; i --) {
			if(p1[i]>p2[i]) {
				return p1Win;
			} else if(p1[i] < p2[i]) {
				return p2Win;
			}
		}
		
		return draw;
	}
	
	
	
	
	private int[] ArrIntConvert(String[] s) {
		int leng = s.length;
		int[] result = new int[leng];
		for(int i = 0 ; i < leng ; i ++) {
			result[i] = intconvert(s[i]);
		}
		
		Arrays.sort(result);
		
		return result;
	}
	
	
	private int intconvert(String s) {
		String result = s.substring(0, 1);
		
		if(result.equals("T")) {
			result = "10";
		} else if (result.equals("J")) {
			result = "11";
		} else if (result.equals("Q")) {
			result = "12";
		} else if (result.equals("K")) {
			result = "13";
		}  else if (result.equals("A")) {
			result = "14";
		}
		
		int convertResult = Integer.parseInt(result);
		
		return convertResult;
	}
	
	
	
}
