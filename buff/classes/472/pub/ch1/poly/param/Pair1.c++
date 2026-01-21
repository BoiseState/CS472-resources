#include <sstream>

#include "Pair1.h"

using namespace std;

template <class Left, class Rite>
Pair<Left,Rite>::Pair(Left left, Rite rite) {
  putLeft(left);
  putRite(rite);
}

template <class Left, class Rite>
Left Pair<Left,Rite>::getLeft() { return left; }

template <class Left, class Rite>
Rite Pair<Left,Rite>::getRite() { return rite; }

template <class Left, class Rite>
void Pair<Left,Rite>::putLeft(Left left) { this->left=left; }

template <class Left, class Rite>
void Pair<Left,Rite>::putRite(Rite rite) { this->rite=rite; }

template <class Left, class Rite>
string Pair<Left,Rite>::toString() {
  stringstream out;
  out << "<" << getLeft() << "," << getRite() << ">";
  return out.str();
}
