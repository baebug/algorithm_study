#include <iostream>

using namespace std;

int main()
{
    // ios::sync_with_stdio(false);
    // cin.tie(nullptr);
    // cout.tie(nullptr);

    int T, a, b;
    scanf("%d", &T);

    for (int t = 1; t <= T; t++) {
        scanf("%d,%d", &a, &b);

        printf("%d\n", a+b);
        
    }    
    return 0;
}