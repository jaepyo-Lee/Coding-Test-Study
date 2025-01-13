#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>

using namespace std;

/*
 * 최소거리 찾기 -> bfs
 * : 띄어쓰기 없는 입력값 처리 주의하기!
 */

vector<string> board;
int dist[101][101];
int n, m;

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        string tmp;
        cin >> tmp;
        board.push_back(tmp);
    }

    queue<pair<int, int>> q;
    q.push({0, 0});
    dist[0][0] = 1;

    while(!q.empty()) {
        pair<int, int> tmp = q.front(); q.pop();

        for (int i = 0; i < 4; i++) {
            int lx = tmp.first + dx[i];
            int ly = tmp.second + dy[i];

            if (lx >= 0 && lx < n && ly >= 0 && ly < m) {
                if (board[lx][ly] == '1' && dist[lx][ly] == 0) {
                    q.push({lx, ly});
                    dist[lx][ly] = dist[tmp.first][tmp.second] + 1;
                }
            }
        }
    }

    cout << dist[n-1][m-1];
}
