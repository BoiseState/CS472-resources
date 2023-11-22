// g++ -Wall -g -o Foo Foo.c++ && ./Foo

#include <iostream>

using namespace std;

// 1) A class with any virtual functions ought to have a virtual
// destructor. This allows subclasses to deallocate properly.
class Foo {
public:
  virtual void toString()=0;
  virtual ~Foo()=0;
};

// 2) A class with any of destructor, assignment operator, or copy
// constructor generally needs all three.  This is called "the rule of
// the big three."
// 3) A class's assignment operator and copy constructor should have
// const in the parameter. The const-ness applies to aggregate (sub) objects,
// but not to pointed-at objects.
class SubFoo : Foo {
public:
  SubFoo();
  SubFoo(SubFoo const& sf);
  ~SubFoo();
  SubFoo& operator= (SubFoo const& sf);
  void toString();
private:
  int id;
};

Foo::~Foo() { cout << "Foo destructor" << endl; }

int cnt=0;

SubFoo::SubFoo() {
  cout << "SubFoo constructor" << endl;
  id=++cnt;
}

SubFoo::SubFoo(SubFoo const& sf) {
  cout << "SubFoo copy constructor" << endl;
  id=++cnt;
}

SubFoo::~SubFoo()       { cout << "SubFoo destructor" << endl; }
void SubFoo::toString() { cout << "foo: " << id << endl;}

// 4) A class's assignment operator should return *this as a &.  This
// allows chaining of assignments.
// 5) Assignment operators should make sure that self assignment does
// nothing.
SubFoo& SubFoo::operator= (SubFoo const& sf) {
  cout << "SubFoo assignment operator" << endl;
  this->id=sf.id;
  return *this;
}

int main() {
  SubFoo foo1;
  SubFoo foo2(foo1);
  foo1.toString(); foo2.toString();
  foo1=foo2;
  foo1.toString(); foo2.toString();
  foo1=foo2=foo1;
  foo1.toString(); foo2.toString();
  return 0;
}
