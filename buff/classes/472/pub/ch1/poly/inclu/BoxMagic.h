// -*-C++-*-

#ifndef BOXMAGIC_H
#define BOXMAGIC_H

#include "Box.h"

template <class Item>
class BoxMagic : public Box<Item> {
public:

  void put(Item* item) {
    this->item=item;
  }

  Item* get() {
    return item;
  }

private:
  Item* item;
};

#endif
