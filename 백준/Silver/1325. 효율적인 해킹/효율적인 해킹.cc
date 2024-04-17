#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <stack>
#include <tuple>
#include <set>
#include <unordered_map>
#include <map>
#include <cmath>
#include <sstream>
using namespace std;

vector<int> adj[10001];
int cnt[10001];
int big = 0;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;
    
    while (m--) {
        int u, v;
        cin >> u >> v;
        adj[v].push_back(u);
    }

    for (int i = 1; i <= n; i++) {
        int visited[10001];
        for (int j = 1; j <= n; j++)
            visited[j] = 0;

        int count = 0;

        queue<int> q;
        q.push(i);
        visited[i] = 1;

        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            count++;

            for (auto nxt : adj[cur]) {
                if (visited[nxt] == 0) {
                    q.push(nxt);
                    visited[nxt] = 1;
                }
            }
        }

        big = max(big, count);
        cnt[i] = count;
    }

    for (int i = 1; i <= n; i++)
        if (cnt[i] == big)
            cout << i << " ";
  
}