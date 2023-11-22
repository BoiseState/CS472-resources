// -*-C++-*-

#ifndef HASHTABLE_H
#define HASHTABLE_H

#include "Table.h"

#include <map>

using namespace std;

template <class Key, class Data>
class HashTable : public Table<Key,Data> {
public:
  Data& get(Key& key) {
    return tab[key];
  }
  void put(Key& key, Data& data) {
    tab[key]=data;
  }
private:
  map<Key,Data> tab;
};

template <class Key, class Data>
Table<Key,Data>::~Table() {}

#endif
