package main.java.org.example;

public class DataHashMap<K, V> {


    //class CustomHashMap<K, V> {
    private static final int defaultCapacity = 16;
    private DataList<Entry<K, V>>[] buckets;
    private int size;

    public DataHashMap() {
        buckets = new DataList[defaultCapacity];
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int hash = key.hashCode();
        int index = hash % buckets.length;

        if (buckets[index] == null) {
            buckets[index] = new DataList();
        }

        DataList<Entry<K, V>> bucket = buckets[index];
        for (int i = 0; i < bucket.size(); i++) {
            //for (Entry<K, V> entry : bucket) {
            Entry<K, V> entry = bucket.get(i);
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            //}
        }

        bucket.add(new Entry<>(key, value));
        size++;

        // Resize if needed
        if (size > buckets.length * 0.75) {
            resize();
        }
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % buckets.length;

        DataList<Entry<K, V>> bucket = buckets[index];

        if (bucket != null) {
            //for (Entry<K, V> entry : bucket) {
            for (int i = 0; i < bucket.size(); i++) {
                Entry<K, V> entry = bucket.get(i);
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
                //}
            }
        }

        return null;
    }

    public void resize() {
        int newCapacity = buckets.length * 2;
        DataList<Entry<K, V>>[] newBuckets = new DataList[newCapacity];

        for (int i = 0; i < buckets.length; i++) {
            DataList<Entry<K, V>> bucket = buckets[i];
            if (bucket != null) {
                for (int j = 0; j < bucket.size(); j++) {
                    Entry<K, V> entry = bucket.get(j);
                    int newIndex = entry.getKey().hashCode() % newBuckets.length;
                    if (newBuckets[newIndex] == null) {
                        newBuckets[newIndex] = new DataList<>();
                    }
                    newBuckets[newIndex].add(entry);
                }
            }
        }

        buckets = newBuckets;
    }

    public boolean containsKey(K key) {
        int hash = key.hashCode();
        int index = hash % buckets.length;

        DataList<Entry<K, V>> bucket = buckets[index];

        if (bucket != null) {
            for (int i = 0; i < bucket.size(); i++) {
                Entry<K, V> entry = bucket.get(i);
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }


    }
}

//}
