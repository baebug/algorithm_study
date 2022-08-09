#include <iostream>

using namespace std;

int main()
{
    int T, a, b;
    cin >> T;

    for (int t = 1; t <= T; t++)
    {
        cin >> a;
        cin >> b;

        cout << a + b << endl;
    }

    return 0;
}