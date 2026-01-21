// g++ -Wall -g -o Inclusion Inclusion.c++ && ./Inclusion

#include <iostream>

using namespace std;

class A {
public:
  virtual string foo() { return "A"; }
};

class X : public A {
public:
  string foo() { return "X"; }
};

class Y : public A {
public:
  string foo() { return "Y"; }
};

class Z : public Y {
public:
  string foo() { return "Z"; }
};

int main() {
  A* a;
  a=new A; cout << a->foo() << endl;
  a=new X; cout << a->foo() << endl;
  a=new Y; cout << a->foo() << endl;
  a=new Z; cout << a->foo() << endl;
  return 0;
}
