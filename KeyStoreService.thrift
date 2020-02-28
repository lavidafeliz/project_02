typedef string Value
typedef string Key
service KeyStoreService {
  bool put(1: Key key,2: Value value)
  Value get(1: Key key)
  bool deletePair(1:Key key)
  bool isPrepopulated()
}