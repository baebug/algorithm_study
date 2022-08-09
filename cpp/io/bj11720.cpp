#include <iostream>
#include <string>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    string num;
    int sum = 0;

    cin >> n;
    cin >> num;
    for (int i = 0; i < n; i++) {
        sum += num[i] - '0';
    }
    cout << sum;

    return 0;
}