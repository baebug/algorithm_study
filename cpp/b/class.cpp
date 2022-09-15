#include <bits/stdc++.h>

using namespace std;

// 붕어빵 틀
class Student {
    // 안적어주면 private 이라서 외부에서 사용 불가
    // 이게 귀찮아서 class 대신 struct 사용한다.
    public:
        // 멤버변수
        int kor, eng, math;     

        // 생성자 (default 값은 뒤에서부터 채워야 한다.)
        Student(int kor = 0, int eng = 0, int math = 0) {
            this->kor = kor;
            this->eng = eng;
            this->math = math;
        }
};

class Position {
    private:
        int x, y;

    public:
        int S;

        Position(int x, int y) {
            this->x = x;
            this->y = y;
            this->S = x+y;
        }

        void set_x(int x) {
            this->x = x;
            this->S = this->x + this->y;
        }
};

struct Spy {
    char code_name;
    int score;

    Spy(char code_name, int score) {
        this->code_name = code_name;
        this->score = score;
    }
    // 이게 있어야 초기값을 넣음
    Spy(){}
};

int main() {
    // new 안쓰는거 주의, 만드는 방법 2개
    Student student1 = Student(90, 80, 90);
    // 이 방법으로 하니까 default 값 받는게 안된다?
    Student student2(90, 80, 90);

    Position p1(3, 4);

    cout << p1.S << endl;

    p1.set_x(10);

    cout << p1.S << endl;

    tuple<int, int, int> t = make_tuple(30, 15, 40);
    int v1, v2, v3;
    tie(v1, ignore, v3) = t;

    cout << v1 << endl;
    cout << v2 << endl;
    cout << v3 << endl;

    pair<int, int> p = make_pair(1, 5);
    cout << p.first << endl;
    cout << p.second << endl;


    // class 만들어서 사용

    char code_name;
    int score;
    Spy spies[5];

    for(int i=0; i<5; i++) {
        cin >> code_name >> score;
        spies[i] = Spy(code_name, score);
    }

    int min_idx = 0;

    for(int i=1; i<5; i++) {
        if (spies[i].score < spies[min_idx].score) {
            min_idx = i;
        }
    }

    cout << spies[min_idx].code_name << " " << spies[min_idx].score;


    // pair 사용

    char name;
    int score;
    pair<char, int> input[5];

    for(int i=0; i<5; i++) {
        cin >> name >> score;
        input[i] = make_pair(name, score);
    }

    int min_idx = 0;

    for(int i=1; i<5; i++) {
        if (input[i].second < input[min_idx].second) {
            min_idx = i;
        }
    }

    cout << input[min_idx].first << " " << input[min_idx].second;


    // 객체 정렬

    #include <iostream>
    #include <string>
    #include <algorithm>

    using namespace std;

    struct Person {
        string name;
        int h, w;

        Person(){}

        Person(string name, int h, int w) {
            this->name = name;
            this->h = h;
            this->w = w;
        }

        void print() {
            cout << name << " " << h << " " << w << endl;
        }

    };

    bool cmp(const Person &p1, const Person &p2) {
        return p1.h < p2.h;
    };


    int main() {
        ios::sync_with_stdio(0);
        cin.tie(0);
        
        int N;
        cin >> N;
        Person input[N];

        for(int i=0; i<N; i++) {
            string name;
            int h, w;
            cin >> name >> h >> w;
            input[i] = Person(name, h, w);    
        }

        sort(input, input+N, cmp);

        for(int i=0; i<N; i++)
            input[i].print();

        return 0;
    }
}