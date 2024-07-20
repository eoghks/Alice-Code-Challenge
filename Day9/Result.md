![image](https://github.com/user-attachments/assets/260e765b-f56b-40ae-90ce-56a096ca8734)
---
처음 문제를 접하고 DP아니면 다익스트라 알고리즘을 떠올렷다.
그래서 먼저 Day9_1처럼 DP로 풀어봣으나 45점이 나오고 시간초과가 나오는 케이스가 존재하여 다익스트라 알고리즘을 사용해보았다.
그러나 결과는 동일하게 45점이고 시간초과가 사라졌다. 

---
DP와 다익스트라 알고리즘을 모두 사용하는 문제였다.
먼저 다익스트라 알고리즘을 사용한 실제 거리를 구하는 방식은 내가 짠 코드의 핵심과 같은 이치였다.
그러나, DP를 사용하여 재사용했다는 점이 달랐다. 그렇다면 내가 사용한 DP는 시간 초과가 되었으나, 왜 정답 예시 코드는 괜찮았을까?
정답은 배열이다. 나는 x,y를 생각하고 4차원 배열을 그렸다. 그러나 정답 코드엣더는 y와 x를 통해 하나의 index를 만들었다.
즉 N이 3일때 격자는 최대 3,3을 가진다. 그럼 이는 index로 치환하여 (x)3 * (N)3 + 3(y)여서 12의 index를 가지게 할 수 잇다.
물론 정확하게는 9의 index를 가지는 것이 정답이라 생각할 수 잇으나, index의 규칙을 x * N + y로 가진것 뿐이다.
그리고 index로 치환하기 때문에 해당 점에서 이동할 수 잇는 점을 따로 index로 기억해둔다. 그렇지 않으면 실제로 가는 곳을 정할때 원치 않은 결과를 출력할 수 있다.
예를 들어 2,3에서 갈수 잇는 점을 단순히 +1, -1, +N, -N으로 생각할 경우 실제로 오른쪽으로 이동하지 못하나 index 7은 존재할 수 잇기 때문이다.
  1. index로 치환 하는 코드
  <pre>
    public static int get(int y, int x) {
        return y * N + x;
    }
  </pre>
  2. 움죽일 수 있는 점 구하기
  <pre>
     for (int i = 1; i <= N; i++) {
          for (int j = 1; j <= N; j++) {
              int current = get(i, j);
              for (int k = 0; k < 4; k++) {
                  int y = i + dirY[k];
                  int x = j + dirX[k];
                  if (y < 1 || y > N || x < 1 || x > N) {
                      continue;
                  }
                  int next = get(y, x);
                  v.get(current).add(new Pair(next, A[current] + A[next]));
              }
          }
      }
  </pre>

그러고 나면 이제 dist[j][i]의 의미를 알아보자.
dist[j][i]는 i번째 알파벳 위치에서 j번째 위치로 이동할때 필요한 비용이다. 해닫 부분이 내 코드와 비교했을때 4차원 배열과 2차원배열의 차이이다.
이후 다익스트라 알고리즘을 사용하여 다음과 같은 코드가 존재한다.
<pre>
  int[] start = elice.get(i);
  int now = get(start[0], start[1]);
  dist[now][i] = 0;
  PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.cost));
  pq.add(new Pair(now, 0));

  while (!pq.isEmpty()) {
      Pair p = pq.poll();
      long curDist = p.cost;
      int curIndex = p.index;

      for (Pair next : v.get(curIndex)) {
          if (dist[next.index][i] > curDist + next.cost) {
              dist[next.index][i] = curDist + next.cost;
              pq.add(new Pair(next.index, curDist + next.cost));
          }
      }
  }
</pre>
간단히 코드를 해석하자면 앨리스가 시작하는 위치는 i번째 알파벳의 위치이다. 이후 자신의 위치에서 갈 수 있는 모든 위치의 비용을 구한다. 단 조건문을 통해 현재 비용과 이동 비용의 합이 i에서 다음 위치로 가는 비용의 최솟값 보다 작은 경우 생략하여
무한 루프가 돌지않게 방지한다.

이후 실제 정답을 구하는 코드느 경로가 2개 존재하여 나와 같은 방식으로 2가지 경로의 비용을 구하고 최소값을 출력하였다. 이는 완벽하게 같은 방식이기 때문에 설명을 생략한다.

---
이번에는 사용해야할 알고리즘과 기본적은 골조를 모두 생각해낼 수 있었다. 비록 부족한 부분이 존재하였지만 조금 더 많은 문제를 풀어보면서 생각을 넓히고 경험을 쌓으면 이런 문제도 충분히 해결할 수 있을 것이란 희망을 보았다.
그래도 해당 챌린지를 진행하며, DP문제를 파악하는 능력이 향상한것같다.
