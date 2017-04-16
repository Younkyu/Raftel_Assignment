package com.leeyounkyu;

import java.util.ArrayList;

/** 
 * ���ڹ迭�� �޾Ƽ�, ���ӵ� ���ڸ� ���ڿ��� �ٲ۴�.
 * @param input ������ϴ� ������ �迭(������ ���������� ���)
 * @return �� �迭�� ���ӵ� ���ڸ� ���ڿ��� �ٲ� ��
 * ����� : 
 * <pre>
 * 		int[] input = {1,3,5,6,7,8,10};
 * 		ReadNumbers readNumbers = new ReadNumbers();
 * 		String result = readNumbers(input);
 * </pre>
 * ����� : 1,3,5~8,10
 * @author Younkyu
 *
 */

public class ReadNumbers {
	
	public String ReadNum(int[] input) {
		String result = "";
		int leng = input.length;
		
		//���̰� 0�� �� ó��
		if(leng == 0) {
			return result;
		}
		
		//�� ó�� ���� ���� ���Ѵ�.
		result = result+input[0];
		
		//�迭�� ���̰� 2 �̻��� �� ����
		if(leng > 1 ) {
			// ���� ���� �յڸ� Ȯ���ؼ� ����Ǿ� �ִ� ������, ������ �߰��ΰ���, �Ǵ� ������ �������� �Ǵ��Ͽ� result�� �ִ´�.
			for(int i = 1 ; i < leng-1 ; i++) {
				if(input[i-1]+1 == input[i]) {
					if(input[i]+1 != input[i+1]) {result = result + "~" + input[i];}
				} else {result = result + "," + input[i];}
			}	
	
			//������ ���� ����� ������ �ƴ����� Ȯ�� �� ���Ѵ�.
			if(input[leng-2]+1 == input[leng-1]) {
				result = result + "~" +  input[leng-1];
			} else {
				result = result + "," +  input[leng-1];
			}
			
		}		
		return result;
	}
}
