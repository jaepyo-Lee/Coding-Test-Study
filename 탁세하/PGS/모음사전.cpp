#include <iostream>
#include <vector>

using namespace std;

/*
 * 백트래킹으로 해결!! -> 중복조합
*/

string alphabets = "AEIOU";
string newWord;
string ansWord;
bool isDone = false;
int ans = 0;

void backtracking(int depth) {
    if (depth == 5) {
        if (newWord == ansWord) {
            isDone = true;
        }
        return;
    }

    for (int i = 0; i < 5; i++) {
        ansWord += alphabets[i];

        backtracking(depth + 1);
        ansWord.erase(ansWord.end() - 1);
        if (isDone) {
            return;
        }
    }
}


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    string word;
    cin >> word;

    int answer = 0;
    newWord = word;
    int sz = word.size();

    if (sz < 5) {
        for (int i = 0; i < 5 - sz; i++) {
            newWord += 'X';
        }
    }

    backtracking(0);
    answer = ans;

    cout << answer;
    cout << newWord;

    return 0;
}
