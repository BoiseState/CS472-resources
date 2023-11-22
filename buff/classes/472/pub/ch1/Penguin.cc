// g++ -g -Wall -o Penguin Penguin.cc && ./Penguin

#include <iostream>

using namespace std;

class Bird {
public:
  virtual void fly()=0;
  virtual void hop()=0;
};

class Penguin : public Bird {
private:
  void fly() { cout << "can't fly" << endl; }
public:
  void hop() { cout << "hop" << endl; }
};

int main() {
  Penguin* p=new Penguin();
  p->hop();
  // p->fly();
  // Bird* b=new Penguin();
  // b->hop();
  // b->fly(); // huh?
}
