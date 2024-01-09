// g++ -Wall -g -o Overloading Overloading.c++ && ./Overloading

#include <iostream>

using namespace std;

void foo(int i)    { cout<<"foo(int i)"<<endl; }
void foo(double d) { cout<<"foo(double d)"<<endl; }

int main() {
  int i=77;
  double d=1.234;
  foo(i);
  foo(d);
  return 0;
}
