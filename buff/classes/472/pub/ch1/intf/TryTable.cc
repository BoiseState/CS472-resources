// g++ -Wall -g -o TryTable TryTable.cc && ./TryTable

#include <iostream>

using namespace std;

#include "HashTable.h"

int main() {
  // program to an interface!
  // NOT: auto t=...
  Table<string,int>* t=new HashTable<string,int>();
  string k="Hi";
  int d=100;
  t->put(k,d);
  cout << t->get(k) << endl;
  delete t;
  return 0;
}
