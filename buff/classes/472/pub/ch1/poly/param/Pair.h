// -*-C++-*-

#ifndef PAIR_H
#define PAIR_H

#include <sstream>
#include <string>

using namespace std;

template <class Left, class Rite>
class Pair {
public:

  Pair(Left left, Rite rite) {
    putLeft(left);
    putRite(rite);
  }

  Left getLeft() { return left; }
  Rite getRite() { return rite; }

  void putLeft(Left left) { this->left=left; }
  void putRite(Rite rite) { this->rite=rite; }

  string toString() {
    stringstream out;
    out << "<" << getLeft() << "," << getRite() << ">";
    return out.str();
  }

private:
  Left left;
  Rite rite;
};

#endif
