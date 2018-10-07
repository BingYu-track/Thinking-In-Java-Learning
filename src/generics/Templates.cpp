//: generics/Templates.cpp
#include <iostream>
using namespace std;

/*
C++的泛型
*/
template<class T> class Manipulator {
  T obj;
public:
  Manipulator(T x) { obj = x; }
  //该方法中使用了泛型对象obj并且能调用f方法，那是因为在C++的编译器将会对obj的实际类型进行检测，
  //换句话说，在C++中是可以获得任何有关泛型参数类型的信息，而在java中就会报错
  void manipulate() { obj.f(); }
};

class HasF {
public:
  void f() { cout << "HasF::f()" << endl; }
};

int main() {
  HasF hf;
  Manipulator<HasF> manipulator(hf);
  manipulator.manipulate();
} /* Output:
HasF::f()
///:~
