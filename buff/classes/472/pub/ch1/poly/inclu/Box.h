// -*-C++-*-

#ifndef BOX_H
#define BOX_H

template <class Item>
class Box {
public:
  virtual void put(Item* item)=0;
  virtual Item* get()=0;
};

#endif
