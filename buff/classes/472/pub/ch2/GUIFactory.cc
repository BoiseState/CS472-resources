// g++ -Wall -o GUIFactory GUIFactory.cc && ./GUIFactory

#include <iostream>

using namespace std;

class Label
    { public: virtual void foo()=0; };
class RedLabel : public Label
    { public: virtual void foo() { cout << "red" << endl; } };
class GreenLabel : public Label
    { public: virtual void foo() { cout << "green" << endl; } };

class GUIFactory {
public:
  virtual Label* labelFactoryMethod()=0;
};

template<class T>
class StandardGUIFactory : public GUIFactory {
public:
  Label* labelFactoryMethod() { return new T(); }
};

int main() {
  GUIFactory* guiFactory=new StandardGUIFactory<RedLabel>();
  Label* label=guiFactory->labelFactoryMethod();
  label->foo();
  return 0;
}

