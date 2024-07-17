![image](https://github.com/user-attachments/assets/8d63c215-3f8a-4911-9c13-5023c85b0992)

---
일단 업체 측에서 제공한 정답의 경우 하나의 케이스에서 시간 초과가 나서 해당 케이스가 무엇인지에 대해 고민해보았다.
먼저 업체 측에서 제공한 코드는 아래와 같다.
<pre>
  if (K == 10) {
      System.out.println("1023456789");
  } else if (K == 9) {
      System.out.println("102345678");
  }  else {
      while (cnt != K) {
          Arrays.fill(digit, false);
          cnt = 0;
          N = Integer.toString(Integer.parseInt(N) + 1);
          for (int i = 0; i < N.length(); i++) {
              digit[N.charAt(i) - '0'] = true;
          }
          for (int i = 0; i < 10; i++) {
              if (digit[i]) {
                  cnt++;
              }
          }
      }
      System.out.println(N);
  }
</pre>
그래서 나는 하나의 케이스가 N이 1이고 K가 8인 경우라 가정하였다. 그러면 시간 초과가 날 가능성이 존재한다 왜냐하면 1에서부터 1씩 증가하면 계속 정답인지 확인하여야하는데 실제 정답은 10234567로 10234566번을 반복해야하기 때문이다.
최종적으로 나는 else문을 제외한 케이스를 내가 작성했던 코드로 교체한 후 모든 테스트 케이스에 대해 성공하였다. 내가 작성한 코드는 다음과 같다.
<pre>
  if(N.length() < K){
    long result = 1023456789 / (long)Math.pow(10, 10-K);
    System.out.println(result);
  }
</pre>

---
사실 특이 케이스를 잡아내는 코드를 어제 작성했는데 아래 코드를 어떻게 짜야 효율적인지 생각하다 실패하였다. N.length <= K 인 경우만 작성하면 됬엇는데 조금만 더 생각했으면됬다.
이미 앞에서 많은 for문을 도는 케이스를 잡아놧기 때문에 그냥 1씩 증가하면서 확인해도 제한 시간 1초를 안넘길 수 있다는 점을 망각했다.
