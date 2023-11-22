interface Table<Key, Data> {
    Data get(Key key);
    void put(Key key, Data data);
}
