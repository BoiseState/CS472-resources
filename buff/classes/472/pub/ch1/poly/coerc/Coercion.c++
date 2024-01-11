// g++ -Wall -g -o Coercion Coercion.c++ && ./Coercion

#include <iostream>

using namespace std;

class A {
public:
  const char *toString() { return "A"; }
};

class B {
public:
  const char *toString() { return "B"; }
  operator A() { cout << "casting" << endl; A a; return a; }
};

int main() {
  int i=77;
  double d=1.234;
  i=(int)d;                 // explicit
  d=(double)i;              // explicit
  d=i;                      // implicit
  i=d;                      // implicit
  d=static_cast<double>(i); // explicit
  i=static_cast<int>(d);    // explicit
  cout << i << " " << d << endl;

  A a;
  B b;
  a=(A)b;              // explicit
  a=b;                 // implicit
  a=static_cast<A>(b); // explicit
  cout << a.toString() << " " << b.toString() << endl;
  // illegal:
  // b=(B)a;			        // explicit
  // b=a;                 // implicit
  // b=static_cast<B>(a);	// explicit

  A *ap=new A;
  B *bp=new B;
  *ap=(A)*bp;              // explicit
  *ap=*bp;                 // implicit
  *ap=static_cast<A>(*bp); // explicit
  cout << ap->toString() << " " << bp->toString() << endl;

  // illegal:
  // *bp=(B)*ap;                // explicit
  // *bp=*ap;                   // implicit
  // *bp=static_cast<B>(*ap);   // explicit
  // ap=bp;                     // implicit
  // bp=ap;                     // implicit
  // bp=(B*)ap;		              // explicit
  // bp=static_cast<B*>(ap);    // explicit

  return 0;
}
