package com.leeyounkyu;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

/** 
 * HTML �±װ� ���Ե� ���ڿ��� �޾Ƽ�, ��ü ������ �����´�.
 * ��, �±״� ��� �״�� �����Ѵ�.(�ߺ�/��ø �±� �� <br>���� ó��)
 * @param input ������ϴ� ���ڿ�
 * @return HTML�±״� ������Ų ä�� ���ڿ����� ������ ��
 * ����� : 
 * <pre>
 * 		String input = "The quick <font color=\"brown\">brown <br><i>fox</i><br></font> jumps <font color=\"yellow\">over</font> the <i>lazy</i> dog";
 * 		ReverseWithTag Rwt = new ReverseWithTag();
 *		String result = Rwt.ReverseHtml(input);
 * </pre>
 * ����� : "god <i>yzal</i> eht <font color="yellow">revo</font> spmuj <font color="brown"><br><i>xof</i><br> nworb</font> kciuq ehT"
 * @author Younkyu
 *
 */

public class ReverseWithTag {
	
	public String ReverseHtml(String input) {
		String result = "";
		ArrayList<String> tag = new ArrayList<>();
		ArrayList<String> tag2 = new ArrayList<>();
		String[] temp = input.split("");
		String tagTemp = "";
		boolean flag = true;
		
		// ���� �Ϲ� Text�� ������ �ְ� HTML�±״� �״�εд�. ���� �±׻����� �ؽ�Ʈ�� �±׸� ��� �и��� ArrayList�� �ִ´�.
		for(String c : temp) {
			if(c.equals("<")) {
				flag = false;
				if(!tagTemp.equals("")) {
					tag.add(tagTemp);	
					tagTemp = "";
				}
			}
			if(flag) {
				tagTemp = c + tagTemp;
			}else {
				tagTemp = tagTemp + c;
			}
			
			if(c.equals(">")) {
				flag = true;
				tag.add(tagTemp);
				tagTemp = "";
			}
		}
		// ���� �ڿ� �߰� �ȵ� �ؽ�Ʈ(�±� ���̿� ���� �ʾ� ���� �ʰ� tagTemp�� ���� �ִ�)�� �߰����ش�.
		if(!tagTemp.equals("")) {
			tag.add(tagTemp);
		}
		
		int tSize = tag.size();
		
		//�Ȱ��� ArrayList�� ���� ¦�� �ִ� �±׵��� ���� �ٲ��ְ�, ¦�� ���� �±�(<br>, <p>��)�� �״�� ���д�. 
		tag2.addAll(tag);
		for(int i = 0 ; i < tSize ; i ++) {
			//���� list�� item�� ���� �±����� Ȯ���Ѵ�.
			if(!tag2.get(i).startsWith("</") && tag2.get(i).startsWith("<")) {
				// ���� �±� �̸��� ���ؼ� �ݴ� �±��� �̸��� �����ؼ� �����.
				int tagname = tag2.get(i).indexOf(" ");
				if(tagname == -1) {
					tagname = tag2.get(i).length();
				}
				String tmp = tag2.get(i).substring(0,tagname);
				if(!tmp.endsWith(">")) {
					tmp = tmp + ">";
				}
				String tmp2 = tmp.substring(0,tmp.length()-1);
				int count = 1;
				tmp = tmp.replaceFirst("<", "</");
				//���� ã�� ���� �±� �������� �� �±��� �ݴ� �±װ� �ִ��� ã�� ��, ã�Ҵٸ� ���� ArrayList���� ������ ��ġ�� �ٲ��ְ�, �������� �Ѿ��.
				//���� �±װ� ���� �±׸� �ְ� �ݴ� �±װ� ���� ���(<br>����)���� �ƹ��� ������ ������ �ʴ´�.
				if(i != tSize) {
					for(int j = i+1; j < tSize ; j ++) {
						if(tag2.get(j).startsWith(tmp2)) {
							count++;
						}
						if(tmp.equals(tag2.get(j))) {
							count--;
						}
						if(count == 0) {
							tag.set(j, tag.get(i));
							tag.set(i, tmp);
							count = 1;
							break;
						}
					}	
				}
			}
		}
		
		// ���� ������ ArrayList�� �ڿ������� �Ųٷ� �����ش�.
		for(String s : tag) {
			result = s + result;
		}

		return result;
	}

}