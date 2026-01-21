// g++ -Wall -g -o TryBox TryBox.c++ && ./TryBox

#include <iostream>

using namespace std;

#include "BoxMagic.h"
#include "BoxPlain.h"

int main() {
  Box<string>* b;
  string s="stuff";
  
  b=new BoxMagic<string>();
  b->put(&s);
  cout << *(b->get()) << endl;
  cout << *(b->get()) << endl;

  b=new BoxPlain<string>();
  b->put(&s);
  cout << *(b->get()) << endl;
  string* t=b->get();
  cout << (t ? *t : "null") << endl;

  return 0;
}
