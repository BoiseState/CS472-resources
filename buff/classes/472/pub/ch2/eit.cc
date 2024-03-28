#include <iostream>
#include <vector>

using namespace std;

int main() {
  vector<int> v={1,2,3,4,5};
  //  vector<int>::iterator p;
  for (auto p=v.begin(); p<v.end(); p++)
    cout << *p << endl;
  return 0;
}
