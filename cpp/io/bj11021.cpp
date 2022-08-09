#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int T, a, b;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        cin >> a >> b;

        cout << "Case #" << t << ": " << a+b << '\n';        
    }    
    return 0;
}