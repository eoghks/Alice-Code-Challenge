![image](https://github.com/user-attachments/assets/de16eaef-19e9-49b1-a2d1-2a2bf2173a6e)

---
나는 빨간선을 그을때는 항상 가장 적은 vertex를 가진 그래프를 이어주면 된다고 생각하였다. 
그리고 파란선을 그을 때는 가장 많은 vertex을 가진 그래프를 이어주면 된다고 생각하였다. 
그러나, 이전까지 그려진 그래프가 어떤 그래프냐에 따라 결과가 달라질 수 있다는 점을망각하였다.

코드를 보며 해설을 이해보겟다.
<pre>
 List<Integer> v = queue.pollFirst();
  for (int i = 0; i < v.size(); i++) {
      for (int j = i + 1; j < v.size(); j++) {
          List<Integer> u = new ArrayList<>();
          for (int k = 0; k < v.size(); k++) {
              if (k == i) {
                  u.add(v.get(i) + v.get(j));
              } else if (k != j) {
                  u.add(v.get(k));
              }
          }
          Collections.sort(u);
          if (!dp.containsKey(u)) {
              queue.add(u);
              dp.put(u, dp.get(v) + (1 - a[N - v.size()]) * v.get(i) * v.get(j));
          } else {
              dp.put(u, Math.min(dp.get(u), dp.get(v) + (1 - a[N - v.size()]) * v.get(i) * v.get(j)));
          }
      }
  }
</pre>
먼저 첫번째 for(i)문은 현재 존재하는 그래프를 하나씩 선택한다.  
두번째 for문(j)는 i+1로 초기값을 지정하여 이미 이어진 경우를 제외하고 하나의 그래프를 선택한다. 즉 1번 그래프와 2번 그래프는 i가 1일때 이미 그려본 모양이기때문에 제외하기 위해 i=2일때 3부터 비교하게 한것이다.
세번째 for문(k)는 그래프를 그리기 위함이다. k==i인 경우는 단 한번으로 i와 j가 이어진 그래프의 vertex 수를 k!=j인건 그래프가 하나 줄어들기 때문에 하나의 그래프를 삭제하기 위해 존재한다. 그 외에는 자신의 그래프를 그대로 유지하므로 vertex의 수를 그대로 유지해주는것과 같은 이치이다.  
이렇게 그래프를 만들어준다.


sort를 해주는 이유는 그래프의 모양이 같은지 확인하기 위해서이고, 존재하지 않는 모양의 그래프 인 경우 queue에 집어넣어 다음 step을 비교한다.  
이때 dp에 넣는데 (1 - a[N - v.size()]) * v.get(i) * v.get(j)해당 부분은 파란색이면 1이기때문에 항상 값이 0이나온다. 따라서 현재까지 그어진 빨간선 dp.get(v)가 빨간선의 갯수가 된다.  
이미 존재하는 모양인 경우 현재 그어진 빨간 선과 이번에 그려진 그래프를 비교하여 더적은 수의 빨간선을 가지는 경우로 업데이트 해준다.  

queue에 최종적으로 하나의 그래프 [N]이 남게될것이고 이는 pollFisrt로 queue에서 나온뒤 for문을 타지않고 종료되어 queue는 비게되어 해당 코드가 종료된 후 dp.get([N])을 하면 최종 값을 얻을 수 있다.

---
처음에는 해석을 보고 많이 헷갈렷으나 내가 놓친 부분은 전제 조건대로 햇을 경우 최선의 그래프가 그려진다는 착각때문이엿다. 그러나 N이 커질수록 해당 다양한 중간 그래프가 그려지므로 내가 선택한 수가 최선이 아닐 수도 있다. 그래서 모든 그래프를 그려가며 dp와 BFS를 합친 해당 코드가 정답이 되는것이다. 아직 DP와 BFS, DFS를 활용하는데 많이 부족한것 같다. DP문제와 BFS, DFS 문제를 다양하게 풀어보고 생강글 넓히는 과정이 필요해보인다.
