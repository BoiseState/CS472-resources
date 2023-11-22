// g++ -g -Wall -o OverrideStatic OverrideStatic.cc

#include <iostream>

using namespace std;

class Foo {
public:
  static virtual void foo()=0;	// illegal
  static virtual void bar() {}	// illegal
};

class NewFoo : public Foo {
public:
  static virtual void foo() { cout << "NewFoo" << endl; }
  static virtual void bar() { cout << "NewBar" << endl; }
};

int main() {
  NewFoo::foo();
}
