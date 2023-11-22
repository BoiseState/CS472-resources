// -*-C++-*-

#ifndef BOXPLAIN_H
#define BOXPLAIN_H

#include "Box.h"

template <class Item>
class BoxPlain : public Box<Item> {
public:

  void put(Item* item) {
    this->item=item;
  }

  Item* get() {
    Item* item=this->item;
    this->item=0;
    return item;
  }

private:
  Item* item;
};

#endif
