import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N;
    static Map<Character, Integer> bracketMapper = new HashMap<>();
    static Map<Integer, Pointer> cache = new HashMap<>(); // 각 점수별 최소 Pointer 담음

    // 각 괄호식의 정보를 담는 클래스
    static class Pointer {
        String brackets;
        long point; // dmap 결과값 = dmap(brackets)
        int val;    // 괄호 자체 값 = val(brackets)

        public Pointer(String brackets, int val) {
            this.brackets = brackets;
            this.val = val;
            this.point = dMap(brackets);
        }

        public long dMap(String brackets) {
            long result = 0;
            for (int i = 0; i < brackets.length(); i++) {
                result = result * 10 + bracketMapper.get(brackets.charAt(i));
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        setting();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            Pointer result = run(N);
            sb.append(result.brackets).append("\n");
        }

        System.out.println(sb);
    }

    private static Pointer run(int n) {
        // 이미 해당 n값에 대해 최소 Pointer가 있으면 그 값 리턴
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        // BFS
        // Pointer의 dmap이 작은 순서대로 뽑기
        PriorityQueue<Pointer> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.point));
        Map<Integer, Long> minDmapForVal = new HashMap<>(); // 중복 탐색 방지
        pq.add(new Pointer("()", 1));
        pq.add(new Pointer("{}", 2));
        pq.add(new Pointer("[]", 3));

        // dmap이 가장 작은 값부터 뽑으면서 n에 해당하는 정답이 나올 때까지 BFS
        // 그리고 각 테스트 케이스에 사용하기 위해 결과는 cache에 저장
        while (!pq.isEmpty()) {
            Pointer curr = pq.poll(); 

            // n과 같은 값이 나오면 정답. 리턴
            if (curr.val == n) {
                cache.put(n, curr);
                return curr;
            }

            // 방문 확인
            if (minDmapForVal.containsKey(curr.val) && minDmapForVal.get(curr.val) <= curr.point) {
                continue;
            }

            minDmapForVal.put(curr.val, curr.point);

            // 둘러쌓인 괄호 연산
            if (curr.val * 2 <= n) pq.add(new Pointer("(" + curr.brackets + ")", curr.val * 2));
            if (curr.val * 3 <= n) pq.add(new Pointer("{" + curr.brackets + "}", curr.val * 3));
            if (curr.val * 5 <= n) pq.add(new Pointer("[" + curr.brackets + "]", curr.val * 5));

            // 괄호 추가 연산 앞, 뒤
            // 어떤 게 더 작은 값인지 모르니까 둘 다 해봐야 함
            if (curr.val + 1 <= n) {
                pq.add(new Pointer(curr.brackets + "()", curr.val + 1));
                pq.add(new Pointer("()" + curr.brackets, curr.val + 1));
            }
            if (curr.val + 2 <= n) {
                pq.add(new Pointer(curr.brackets + "{}", curr.val + 2));
                pq.add(new Pointer("{}" + curr.brackets, curr.val + 2));
            }
            if (curr.val + 3 <= n) {
                pq.add(new Pointer(curr.brackets + "[]", curr.val + 3));
                pq.add(new Pointer("[]" + curr.brackets, curr.val + 3));
            }
        }

        return null;
    }

    /**
     * 초기 세팅 메서드
     */
    private static void setting() {
        bracketMapper.put('(', 1);
        bracketMapper.put(')', 2);
        bracketMapper.put('{', 3);
        bracketMapper.put('}', 4);
        bracketMapper.put('[', 5);
        bracketMapper.put(']', 6);

        cache.put(1, new Pointer("()", 1));
        cache.put(2, new Pointer("{}", 2));
        cache.put(3, new Pointer("[]", 3));
    }
}
