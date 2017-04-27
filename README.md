### **Laftel_Assignment**

**1. Read numbers**

숫자 배열을 받아서, 연속된 숫자를 문자열로 바꿔줍니다.

예시)

	read([]) // “”
	read([1]) // "1"
	read([1, 3]) // "1, 3"
	read([1, 2, 3]) // "1~3"
	read([1, 2, 3, 6, 8, 9, 10]) // "1~3, 6, 8~10"
	read([13, 14, 15, 16, 20, 23, 24, 25, 100]) // "13~16, 20, 23~25, 100"


**2. Reverse with tag**

HTML 태그가 포함된 문자열을 받아서, 전체 문장을 뒤집습니다.
태그는 모두 그대로 적용됩니다.
(중복/중첩 태그 및 <br> 태그까지 처리)

예시)

	원문: The quick <font color="brown">brown</font> fox jumps over the <i>lazy</i> dog
	결과: god <i>yzal</i> eht revo spmuj xof <font color="brown">nworb</font> kciuq ehT

**3. Poker hand**

5개의 카드 표기로 이루어진 문자열 두 개를 받아서, 승/패/무승부를 판별합니다.
양 쪽 플레이어에 같은 카드가 존재 할 수 있습니다.
카드 표기는 한 장의 카드를 두 글자로 표기하며,
공백( )으로 구분된 5장의 카드가 주어집니다.

예시)

	"As 8d Ad 8c 5d", "Qh Qs Jd Kd Jc" : Player 1 win
	"Ks Kc Jd Kd Jc", "Jh Js Jd Kd Jc" : Player 2 win
	"Ad Kh Ac 7h 7d", "Ah Kh Ac 7h 7d" : Draw
