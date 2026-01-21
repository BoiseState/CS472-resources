// g++ -Wall -g -o Parametric Parametric1.c++ PairStrInt.c++ && ./Parametric

#include <iostream>

using namespace std;

#include "Pair1.h"

int main() {
  Pair<string,int> p("Hi",100);
  cout << p.toString() << endl;
  return 0;
}
