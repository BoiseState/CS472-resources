// -*-C++-*-

#ifndef TABLE_H
#define TABLE_H

template <class Key, class Data>
class Table {
public:
  virtual Data& get(Key& key)=0;
  virtual void put(Key& key, Data& data)=0;
  virtual ~Table()=0;
};

#endif
