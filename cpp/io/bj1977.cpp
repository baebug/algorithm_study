#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    int _sum = 0, _min = m;

    for(int i=(int)max((double)1, ceil(sqrt(n))); i*i<=m; i++) {
        _sum += i*i;
        _min = min(_min, i*i);
    }

    if (_sum > 0) {
        cout << _sum << '\n' << _min;
    }
    else cout << -1;

}