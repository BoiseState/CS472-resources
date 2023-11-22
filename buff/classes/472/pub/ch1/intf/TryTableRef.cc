// g++ -Wall -g -o TryTableRef TryTableRef.cc && ./TryTableRef

#include <iostream>
#include <string>

using namespace std;

#include "Table.h"
#include "HashTable.h"

int main() {
  HashTable<string,int> h;
  Table<string,int>& t=h;
  string k="Hi";
  int d=100;
  t.put(k,d);
  cout << t.get(k) << endl;
  return 0;
}
