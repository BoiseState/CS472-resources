// gcc -o auto -Wall -Wno-unused-variable -Wno-implicit-int auto.c && ./auto

int main() {
  auto a=1.1;
  static float b=2.2;
  auto float c=3.3;
  // static auto d=4.4; // legal in C++
  float e=5.5;
  return 0;
}
