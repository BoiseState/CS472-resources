// g++ -g -Wall -o AggAcq AggAcq.cc && ./AggAcq

#include <iostream>

using namespace std;

class C {
private: int a[1000];
};

class C1 {
private: C o;  // aggregation
};

class C2 {
private: C *o; // acquaintance
};

class C3 {
private: C &o;              // acquaintance
public:  C3(C &o) : o(o){};
};

int main() {
  C o;
  cout << sizeof(o) << endl;
  C1 o1;
  cout << sizeof(o1) << endl;
  C2 o2;
  cout << sizeof(o2) << endl;
  C3 o3(o);
  cout << sizeof(o3) << endl;
  return 0;
}
