// -*-C++-*-

#ifndef PAIR_H
#define PAIR_H

#include <string>

using namespace std;

template <class Left, class Rite>
class Pair {
public:
  Pair(Left left, Rite rite);
  Left getLeft();
  Rite getRite();
  void putLeft(Left left);
  void putRite(Rite rite);
  string toString();
private:
  Left left;
  Rite rite;
};

#endif
