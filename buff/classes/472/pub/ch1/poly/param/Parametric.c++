// g++ -Wall -g -o Parametric Parametric.c++ && ./Parametric

#include <iostream>

using namespace std;

#include "Pair.h"

int main() {
  Pair<string,int> p("Hi",100); // object
  cout << p.toString() << endl;
  return 0;
}
