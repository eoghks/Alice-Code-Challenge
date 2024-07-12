수열 복원
---
양의 정수로 이루어진 수열 a 
1
​
 ,a 
2
​
 ,⋯,a 
n
​
 이 있습니다.

1≤a 
i
​
 ≤10 
5
 
이 수열에서 각 원소를 선택하거나 선택하지 않음으로써 총 2^ 
n
 개의 부분 수열을 만들 수 있고, 만들어진 모든 부분 수열의 합인 2 
n
 개의 정수가 주어졌을 때, 원래의 수열 a 
1
​
 ,a 
2
​
 ,⋯,a 
n
​
 을 구하는 프로그램을 작성하세요.

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>
<ul>
	<li>
    첫째 줄에 정수 n이 주어집니다.
    <pre>
      <strong>1≤n≤15</strong>
    </pre>
  </li>
	<li>
    둘째 줄에 이 수열에서 만들 수 있는 모든 부분 수열의 합인 2 
    n
     개의 정수 s 
    1
    ​
     ,s 
    2
    ​
     ,⋯,s 
    2 
    n
     
    ​
     이 주어집니다.
    <pre>
      <strong>0≤s 
i
​
 ≤n×10 
5</strong>
    </pre>
  </li>
	<li>시간 제한: 1초 </li>
</ul>

<p><strong class="example">Example</strong></p>
  
<p><strong>Input</strong></p>
<pre>
  3
  1 4 7 3 0 6 5 2
</pre>
  
<p><strong>Output</strong></p>
<pre>
  1 2 4
</pre>
