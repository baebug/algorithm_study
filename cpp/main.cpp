#include <iostream>
#include <string>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string s;

    cin >> s;
    for (int i = 0; i < s.size(); i++) {
        cout << s[i];
        if (i % 10 == 9) cout << '\n';
    }

    return 0;
}