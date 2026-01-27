// g++ -Wall -g -o TryTableRef TryTableRef.cc && ./TryTableRef

#include <iostream>

using namespace std;

#include "HashTable.h"

int main() {
  HashTable<string,int> h;
  // program to an interface!
  // NOT: decltype((h)) t=...
  Table<string,int>& t=h;
  string k="Hi";
  int d=100;
  t.put(k,d);
  cout << t.get(k) << endl;
  return 0;
}
