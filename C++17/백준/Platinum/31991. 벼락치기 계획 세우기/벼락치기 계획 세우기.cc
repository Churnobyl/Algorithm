#include <bits/stdc++.h>
using namespace std;

const double sc[13] = {0,0.7,1,1.3,1.7,2,2.3,2.7,3,3.3,3.7,4,4.3};
const int INF = 1e9;
const int MAXS = 52000;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n, tot=0;
    cin >> n;
    
    vector<tuple<int,int,vector<pair<int,int>>>> v;
    
    for(int i=0; i<n; i++) {
        int t,c;
        cin >> t >> c;
        tot += c;
        
        map<int,int> m;
        for(int j=0; j<13; j++) {
            int x;
            cin >> x;
            m[x] = max(m[x], j);
        }
        
        vector<pair<int,int>> op;
        int mg = -1;
        for(auto [x,g] : m) {
            if(g > mg) {
                op.push_back({x,g});
                mg = g;
            }
        }
        v.push_back({t,c,op});
    }
    
    sort(v.begin(), v.end());
    
    // dp[score*10] = min time
    vector<int> dp(MAXS, INF);
    dp[0] = 0;
    
    for(auto [t,c,op] : v) {
        vector<int> nd(MAXS, INF);
        
        for(auto [need,g] : op) {
            int pts = (int)(c * sc[g] * 10 + 0.5);
            for(int s=0; s<MAXS; s++) {
                if(dp[s] == INF) continue;
                int nt = dp[s] + need;
                if(nt > t) continue;
                if(s+pts < MAXS)
                    nd[s+pts] = min(nd[s+pts], nt);
            }
        }
        
        dp = nd;
    }
    
    double ans = 0;
    for(int s=0; s<MAXS; s++) {
        if(dp[s] < INF) {
            ans = max(ans, s/10.0/tot);
        }
    }
    
    cout << fixed << setprecision(12) << ans << '\n';
}