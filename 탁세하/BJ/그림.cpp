#include<iostream>
#include<queue>
#include<algorithm>

using namespace std;

/*
 * BFS
 * : 방문하지 않은 각 시작점마다 bfs 돌면서 넓이 구하기, mx = max(mx, 현재 넓이)
 */

int n, m;
int board[501][501];
bool vis[501][501];
int mx;     // 최대 그림의 넓이
int cnt;    // 그림의 개수

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
        }
    }

    queue<pair<int, int>> q;

    // board 전체 탐색하면서 그림 시작점 찾기
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (board[i][j] == 1 && !vis[i][j]) {
                // 그림 시작점 찾으면 현재 그림 넓이 area = 0으로 초기화
                int area = 0;

                // q에 시작점 삽입, area++, cnt++
                q.push({i, j});
                vis[i][j] = true;
                area++;
                cnt++;

                // 해당 그림에 대해 bfs 탐색을 통해 넓이 구하기
                while (!q.empty()) {
                    pair<int, int> tmp = q.front(); q.pop();

                    for (int r = 0; r < 4; r++) {
                        int lx = tmp.first + dx[r];
                        int ly = tmp.second + dy[r];

                        if (lx >= 0 && lx < n && ly >= 0 && ly < m) {
                            if (board[lx][ly] == 1 && !vis[lx][ly]) {
                                q.push({lx, ly});
                                vis[lx][ly] = true;
                                area++;
                            }
                        }
                    }
                }

                // 그림의 현재 넒이와 mx 비교
                mx = max(mx, area);
            }
        }
    }

    cout << cnt << '\n' << mx;
}
