빨간 선과 파란 선
---
N개의 정점이 있다.
차례마다 다음을 반복해서 N개의 정점 사이에 간선을 연결하려고 한다.  

먼저 2개의 서로 연결되지 않은 정점 u와 v를 고른다.  
그 이후, u가 포함된 연결 요소의 모든 정점들 각각에서, v가 포함된 연결 요소의 모든 정점들 각각으로 간선을 추가한다.  
간선의 색은 빨간색 혹은 파란색이다.  
k번째 차례에 사용할 색깔이 주어질 때, 정점을 골라서 얻을 수 있는 빨간 간선 개수의 최솟값을 구하여라.  

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>
<ul>
  <li>
    첫 번째 줄에 정점의 수 N이 주어진다.
    <pre>
      <strong>2≤N≤30</strong>
    </pre>
  </li>
  <li>두 번째 줄에 각 차례에 사용할 색깔을 표시하는 N−1개의 수가 공백을 구분으로 주어진다.</li>
  <li>숫자가 0이면 빨간 간선을, 1이면 파란 간선을 사용한다는 뜻이다.</li>
  <li>입력되는 모든 수들은 정수이다.</li>
  <li>문제의 조건을 만족하면서 간선을 연결할 때, 얻을 수 있는 빨간 간선 개수의 최솟값을 출력한다.</li>
	<li>시간 제한: 1초 </li>
</ul>

<p><strong class="example">Example</strong></p>
  
<p><strong>Input</strong></p>
<pre>
  5
  1 1 0 1
</pre>
  
<p><strong>Output</strong></p>
<pre>
 1
</pre>
  
![image](https://github.com/user-attachments/assets/517ca2cb-ec70-414f-b517-663d5b30078c)
