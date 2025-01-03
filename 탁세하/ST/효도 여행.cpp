#include<iostream>
#include<vector>
#include<stack>

/*
* vector<pair<int, char>> v 정의 -> v[u] = {v, road}
* dfs로 탐색
*/

using namespace std;

int N,M;
string str;
vector<vector<pair<int, char>>> vt(5000);
bool vis[5001][5001];

int main(int argc, char** argv)
{
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> N >> M;
    cin >> str;
    
    for (int i = 0; i < N-1; i++) {
        int u,v = 0;
        char c;
        
        cin >> u >> v >> c;
        vt[u].push_back({v, c});
        vt[v].push_back({u, c});
    }

    stack<int> st;
    for (int i = 1; i <= N; i++) {
        string tmp = "";
        st.push(v[i][1].first);
        vis[i][v[i][1].first] = true;
        tmp += v[i][1].second;
        while(!st.empty()) {
            int tmpU = st.top(); st.pop();
            for (int j = 1; j <= N; j++) {
                if (!vis[i][v[i][j].first]) {
                    st.push(v[i][j].first);
                    vis[i][v[i][j].first] = true;
                    tmp += v[i][j].second;
                }
            }
        }
    }

   return 0;
}
