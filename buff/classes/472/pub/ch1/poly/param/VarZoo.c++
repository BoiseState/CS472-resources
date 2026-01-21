// g++ -Wall -g -o VarZoo VarZoo.c++ PairStrInt.c++ && ./VarZoo

// for more autocrazy, see ../../auto.cc (and auto.c)

#include <iostream>

using namespace std;

#include "Pair1.h"		// interface only

int main() {
  Pair<string,int> p("Hi",100);	                        // object
  cout << p.toString() << endl;

  { Pair<string,int>* p=new Pair<string,int>("Hi",100); // pointer
    cout << p->toString() << endl;
    delete p; }

  { auto p=new Pair<string,int>("Hi",100);              // type inference
    cout << p->toString() << endl;
    delete p; }

  { Pair<string,int>& pr=p;	                            // reference
    cout << pr.toString() << endl; }

  { decltype((p)) pr=p;	                                // reference
    cout << pr.toString() << endl; }

  { auto pp=&p;			                                    // pointer
    cout << pp->toString() << endl; }

  { decltype(&p) pp=&p;    	                            // pointer
    cout << pp->toString() << endl; }

  { auto pc=p;			                                    // copy
    cout << pc.toString() << endl; }

  return 0;
}
