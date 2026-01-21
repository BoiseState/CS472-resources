// Instantiate a template class,
// to get a class: Pair<string,int>.

#include <string>

#include "Pair1.c++"

// The C++ FAQ says: "Notice that we #include a .c++ file, not a .h
// file. If that’s confusing, click your heels twice, think of Kansas,
// and repeat after me, 'I will do it anyway even though it's
// confusing.'  You can trust me on this one."

using namespace std;

template class Pair<string,int>;
