import java.io.*;
import java.util.*;

public class Main {

    // 빠른 거듭제곱: base^exp mod mod 계산
    static long modExp(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while(exp > 0) {
            if((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // 유클리드 알고리즘을 통한 최대공약수 계산
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 오일러 피 함수 계산
    static long phi(long n) {
        long result = n;
        for(long i = 2; i * i <= n; i++){
            if(n % i == 0) {
                while(n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if(n > 1) {
            result -= result / n;
        }
        return result;
    }

    // n을 소인수 분해하여 (소수, 지수) 쌍을 반환
    static Map<Long, Integer> factorize(long n) {
        Map<Long, Integer> factors = new HashMap<>();
        for(long i = 2; i * i <= n; i++){
            while(n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if(n > 1) {
            factors.put(n, factors.getOrDefault(n, 0) + 1);
        }
        return factors;
    }

    // N! mod mod를 계산 (도중에 0이 나오면 바로 0을 반환)
    static long computeFactorialMod(long N, long mod) {
        long result = 1;
        for (long i = 1; i <= N; i++) {
            result = (result * i) % mod;
            if(result == 0) break;
        }
        // 만약 0이 되었다면, 오일러 정리 적용을 위해 모듈러 값 자체를 사용합니다.
        if(result == 0) result = mod;
        return result;
    }

    // 확장 유클리드 알고리즘 (CRT에 사용)
    static long egcd(long a, long b, long[] xy) {
        if(b == 0) {
            xy[0] = 1;
            xy[1] = 0;
            return a;
        }
        long d = egcd(b, a % b, xy);
        long x = xy[1];
        long y = xy[0] - (a / b) * xy[1];
        xy[0] = x;
        xy[1] = y;
        return d;
    }

    // 모듈러 곱셈 역원 계산 (a와 mod가 서로소일 때)
    static long modInverse(long a, long mod) {
        long[] xy = new long[2];
        long g = egcd(a, mod, xy);
        if(g != 1) return -1; // 역원이 존재하지 않음
        return (xy[0] % mod + mod) % mod;
    }

    public static void main(String[] args) throws Exception {
        // 입력은 BufferedReader를 사용합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            String[] parts = br.readLine().split(" ");
            long A = Long.parseLong(parts[0]);
            long N = Long.parseLong(parts[1]);
            long P = Long.parseLong(parts[2]);
            long ans = 0;

            // 1. A와 P가 서로소인 경우: 오일러 정리를 적용
            if(gcd(A, P) == 1) {
                long phiP = phi(P);
                long exp = computeFactorialMod(N, phiP); // N! mod phi(P)
                ans = modExp(A, exp, P);
            } else {
                // 2. A와 P가 서로소가 아닐 때: P를 소인수 분해하고 각 모듈러에 대해 나머지를 구함
                Map<Long, Integer> factors = factorize(P);
                List<Long> modList = new ArrayList<>();
                List<Long> remList = new ArrayList<>();

                for(Map.Entry<Long, Integer> entry : factors.entrySet()){
                    long p = entry.getKey();
                    int exp_p = entry.getValue();
                    long mod_i = 1;
                    for(int i = 0; i < exp_p; i++) {
                        mod_i *= p;
                    }

                    long rem;
                    // 만약 p가 A의 인수라면
                    if(A % p == 0) {
                        // A에서 p의 지수(v)를 구합니다.
                        int v = 0;
                        long temp = A;
                        while(temp % p == 0) {
                            v++;
                            temp /= p;
                        }
                        // A^(N!)의 p에 대한 지수는 v * N! 입니다.
                        // 작은 exp_p에 대해서는, N이 충분히 크면 v*N! >= exp_p가 되어 결과가 0이 됩니다.
                        // exp_p가 최대 5정도이므로, 간단히 최소 m을 구합니다.
                        int threshold = 1;
                        long fact = 1;
                        // 최소 m satisfying: m! * v >= exp_p
                        while(fact * v < exp_p) {
                            threshold++;
                            fact *= threshold;
                        }
                        if(N >= threshold) {
                            rem = 0;
                        } else {
                            // N이 threshold 미만이면 직접 N!을 계산합니다.
                            long expVal = 1;
                            for (long i = 1; i <= N; i++) {
                                expVal *= i;
                            }
                            rem = modExp(A, expVal, mod_i);
                        }
                    } else {
                        // p가 A의 인수가 아니면, gcd(A, mod_i) == 1이므로 오일러 정리를 적용
                        long phi_i = phi(mod_i);
                        long exp = computeFactorialMod(N, phi_i);
                        rem = modExp(A, exp, mod_i);
                    }
                    modList.add(mod_i);
                    remList.add(rem);
                }

                // 3. 중국인의 나머지 정리(CRT)를 사용하여 각 모듈러에 대한 나머지를 결합
                long M = P;
                ans = 0;
                for(int i = 0; i < modList.size(); i++){
                    long m_i = modList.get(i);
                    long r_i = remList.get(i);
                    long M_i = M / m_i;
                    long inv = modInverse(M_i, m_i);
                    ans = (ans + r_i * M_i % M * inv % M) % M;
                }
            }
            System.out.println("Case #" + t + ": " + ans);
        }
    }
}
