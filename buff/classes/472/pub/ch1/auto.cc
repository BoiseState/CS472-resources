// g++ -o auto -Wall -Wno-unused-variable auto.cc && ./auto

int main() {
  auto a=1.1;
  static float b=2.2;
  // auto float c=3.3; // legal in C
  static auto d=4.4;
  float e=5.5;
  return 0;
}
