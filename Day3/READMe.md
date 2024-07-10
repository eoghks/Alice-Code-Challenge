문자열 압축 해제
---
엘리스 토끼는 문자열을 직접 압축 해제하려고 합니다.

압축되지 않은 문자열 S가 주어졌을 때, 이 문자열 중 어떤 부분 문자열은 K(Q)와 같이 압축할 수 있습니다. 이것은 Q라는 문자열이 K 번 반복된다는 뜻입니다. K는 한 자릿수의 정수이고, Q는 0자리 이상의 문자열입니다.

예를 들면, 53(8)은 다음과 같이 압축을 해제할 수 있습니다.

53(8) = 5 + 3(8) = 5 + 888 = 5888

압축된 문자열이 주어졌을 때, 이 문자열을 다시 압축을 푸는 프로그램을 작성하세요.  

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>
<ul>
  <li>첫째 줄에 압축된 문자열 S를 입력합니다.</li>
	<li>S의 길이는 최대 50입니다.</li>
	<li>문자열은 (, ), 숫자로만 구성되어 있습니다.</li>
	<li>시간 제한: 1초 </li>
  <li>압축되지 않은 문자열의 길이를 출력합니다.</li>
</ul>

<p><strong class="example">Example1</strong></p>
  
<p><strong>Input</strong></p>
<pre>
  53(8) 
</pre>
  
<p><strong>Output</strong></p>
<pre>
  4
</pre>

<p><strong class="example">Example2</strong></p>
  
<p><strong>Input</strong></p>
<pre>
  11(18(72(7)))
</pre>
  
<p><strong>Output</strong></p>
<pre>
  26 
</pre>
