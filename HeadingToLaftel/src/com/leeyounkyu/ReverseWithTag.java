package com.leeyounkyu;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

/** 
 * HTML 태그가 포함된 문자열을 받아서, 전체 문장을 뒤집는다.
 * 단, 태그는 모두 그대로 적용한다.(중복/중첩 태그 및 <br>까지 처리)
 * @param input 얻고자하는 문자열
 * @return HTML태그는 유지시킨 채로 문자열만을 뒤집은 값
 * 사용방법 : 
 * <pre>
 * 		String input = "The quick <font color=\"brown\">brown <br><i>fox</i><br></font> jumps <font color=\"yellow\">over</font> the <i>lazy</i> dog";
 * 		ReverseWithTag Rwt = new ReverseWithTag();
 *		String result = Rwt.ReverseHtml(input);
 * </pre>
 * 결과값 : "god <i>yzal</i> eht <font color="yellow">revo</font> spmuj <font color="brown"><br><i>xof</i><br> nworb</font> kciuq ehT"
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
		
		// 먼저 일반 Text는 뒤집어 주고 HTML태그는 그대로둔다. 또한 태그사이의 텍스트와 태그를 모두 분리해 ArrayList에 넣는다.
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
		// 제일 뒤에 추가 안된 텍스트(태그 사이에 있지 않아 들어가지 않고 tagTemp에 남아 있는)를 추가해준다.
		if(!tagTemp.equals("")) {
			tag.add(tagTemp);
		}
		
		int tSize = tag.size();
		
		//똑같은 ArrayList를 만들어서 짝이 있는 태그들은 서로 바꿔주고, 짝이 없는 태그(<br>, <p>등)는 그대로 놔둔다. 
		tag2.addAll(tag);
		for(int i = 0 ; i < tSize ; i ++) {
			//현재 list의 item이 여는 태그인지 확인한다.
			if(!tag2.get(i).startsWith("</") && tag2.get(i).startsWith("<")) {
				// 여는 태그 이름을 통해서 닫는 태그의 이름을 유추해서 만든다.
				int tagname = tag2.get(i).indexOf(" ");
				if(tagname == -1) {
					tagname = tag2.get(i).length();
				}
				String tmp = tag2.get(i).substring(0,tagname);
				if(!tmp.endsWith(">")) {
					tmp = tmp + ">";
				}
				tmp = tmp.replaceFirst("<", "</");
				//지금 찾은 여는 태그 다음부터 이 태그의 닫는 태그가 있는지 찾은 후, 찾았다면 원래 ArrayList에서 서로의 위치를 바꿔주고, 다음으로 넘어간다.
				//지금 태그가 여는 태그만 있고 닫는 태그가 없는 경우(<br>같은)에는 아무런 동작을 취하지 않는다.
				if(i != tSize) {
					for(int j = i+1; j < tSize ; j ++) {
						if(tmp.equals(tag2.get(j))) {
							tag.set(j, tag.get(i));
							tag.set(i, tmp);
							continue;
						}
					}	
				}
			}
		}
		
		// 이제 정리한 ArrayList를 뒤에서부터 거꾸로 더해준다.
		for(String s : tag) {
			result = s + result;
		}

		return result;
	}

}