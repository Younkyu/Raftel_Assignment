package com.leeyounkyu;

import java.util.ArrayList;

/** 
 * 숫자배열을 받아서, 연속된 숫자를 문자열로 바꾼다.
 * @param input 얻고자하는 숫자의 배열(순서가 정해져있을 경우)
 * @return 들어간 배열의 연속된 숫자를 문자열로 바꾼 값
 * 사용방법 : 
 * <pre>
 * 		int[] input = {1,3,5,6,7,8,10};
 * 		ReadNumbers readNumbers = new ReadNumbers();
 * 		String result = readNumbers(input);
 * </pre>
 * 결과값 : 1,3,5~8,10
 * @author Younkyu
 *
 */

public class ReadNumbers {
	
	public String ReadNum(int[] input) {
		String result = "";
		int leng = input.length;
		
		//길이가 0일 때 처리
		if(leng == 0) {
			return result;
		}
		
		//맨 처음 값을 먼저 더한다.
		result = result+input[0];
		
		//배열의 길이가 2 이상일 때 실행
		if(leng > 1 ) {
			// 현재 값의 앞뒤를 확인해서 연결되어 있는 값인지, 연결의 중간인건지, 또는 연결의 끝인지를 판단하여 result에 넣는다.
			for(int i = 1 ; i < leng-1 ; i++) {
				if(input[i-1]+1 == input[i]) {
					if(input[i]+1 != input[i+1]) {result = result + "~" + input[i];}
				} else {result = result + "," + input[i];}
			}	
	
			//마지막 값이 연결된 값인지 아닌지를 확인 후 더한다.
			if(input[leng-2]+1 == input[leng-1]) {
				result = result + "~" +  input[leng-1];
			} else {
				result = result + "," +  input[leng-1];
			}
			
		}		
		return result;
	}
}
