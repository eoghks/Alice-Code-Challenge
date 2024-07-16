![image](https://github.com/user-attachments/assets/a35ca84a-1f79-48ea-a82d-a728611aa39d)

---
일단 내가 생각한 풀이 방식과 큰 차이는 없었다. 그러나, 생각치 못한 부분이 몇개 있어 정답을 맞추지 못하였다. 그리고 효율성이 떨어지는 코드를 짯다. 정답을 보고 왜 그런지 분석해보았다.
<pre>
   Collections.sort(sub);
   for (int i = 1; i < v.size(); i++) {
            if (!now.contains(v.get(i))) {
                long m = v.get(i);
                dfs(res, 0, 0, now, m);
                res.add(v.get(i));
            }
            now.remove(v.get(i));
        }
</pre>
<pre>
  public static void dfs(ArrayList<Long> res, int x, long sum_, ArrayList<Long> now, long m) {
        if (x == res.size()) {
            now.add(sum_ + m);
            return;
        }
        dfs(res, x + 1, sum_, now, m);
        dfs(res, x + 1, sum_ + res.get(x), now, m);
    }
</pre>
먼저 dfs 부터 확인하면  
dfs(res, x + 1, sum_, now, m)는 x번째 원소를 선택하지 않은 경우 만들어지는 수  
dfs(res, x + 1, sum_ + res.get(x), now, m)는 x번째 우너소를 선택한 경우 만들어지는 수이다. 이를 반복하여 x == res.seize()가 되면 모든 원소를 선택하거나 선택하지 않은 경우의 수가 나온다 또한 m은 항상 더해지기 때문에 m 보다 크거나 같은 수만 res에 들어가게된다.
따라서 now에 존재한 다는 것은 이전 원소들로 이루어진 수열의 합으로 이는 원래 수열에 들어가는 수가 아니라는 것을 증명하게된다.
때문에 now에 없으면 res에 추가하면서 now에 현재까지 만들어진 경우의 수를 더해주는 것이다.
이후 now에 포함되면 그 수는 부분 수열의 합 중 하나로 제외한다.(해당 코드가 가능한 이유는 먼저 sort를 했기 때문이다.)


---
Day4와 마찬가지로 결국 DFS문제였다. DFS 관련 문제가 나오면 계속 틀리는것을 보아하니 이번 챌린지가 끝나면 DP, DFS를 집중적으로 공략해야할것 같다. 
지금은 비롯 틀렷다. 그러나, 여기서 기죽지 말고 내가 무엇이 부족한지 깨달앗으면 앞으로 맞출 수 있도록 노력하면 된다. 이번 챌린지를 통해 부족한 부분을 깨닫고 채워나가서 다음 챌린지에서는 모든 문제를 풀 수 잇게 하면된다.
비록 틀린거 더많지만, 학습하다보면 어느 순간 더 잘해질 것이다. 꾸준히 노력하자!!
