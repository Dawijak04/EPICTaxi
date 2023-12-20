package org.example;

public class DataHashMap<K, V> {

    private static final int defaultCapacity = 16;
    private DataList<Entry<K, V>>[] buckets;
    private int size;

    public DataHashMap() { //constructor
        buckets = new DataList[defaultCapacity];
        size = 0;
    }

    public void put(K key, V value) { //adds a new value to a key
        if (key == null) { //checks if key exists
            throw new IllegalArgumentException("Key cannot be null");
        }

        int hash = key.hashCode(); //gets hash code for the key
        int index = hash % buckets.length; //gets index of bucket for key

        if (buckets[index] == null) { //checks if bucket at that index exists
            buckets[index] = new DataList(); //if not, it creates a new list
        }

        DataList<Entry<K, V>> bucket = buckets[index]; //gets bucket at specified index
        for (int i = 0; i < bucket.size(); i++) { //iterate through entries of bucket
            Entry<K, V> entry = bucket.get(i); //get current entry
            if (entry.getKey().equals(key)) { //checks if key exists
                entry.setValue(value); //if yes, updates value of key
                return;
            }
        }

        bucket.add(new Entry<>(key, value)); //otherwise adds a new entry to the bucket
        size++; //size is increased

        // Resize if needed
        if (size > buckets.length * 0.75) { //if exceeds 75%
            resize();
        }
    }

    public V get(K key) { //gets value of a specific key
        int hash = key.hashCode(); //get hash code for key
        int index = hash % buckets.length; //get index of bucket for that key

        DataList<Entry<K, V>> bucket = buckets[index]; //get bucket at that index

        if (bucket != null) { //if bucket is not empty,
            for (int i = 0; i < bucket.size(); i++) { //iterate through entries
                Entry<K, V> entry = bucket.get(i); //gets current entry
                if (entry.getKey().equals(key)) { //check is key of entry matches specified key
                    return entry.getValue(); //return value of that key
                }
            }
        }

        return null; //if key isnt found, returns null
    }

    public void resize() { //resizes array of buckets
        int newCapacity = buckets.length * 2; //doubles capacity
        DataList<Entry<K, V>>[] newBuckets = new DataList[newCapacity];

        for (int i = 0; i < buckets.length; i++) { //iterates through existing buckets
            DataList<Entry<K, V>> bucket = buckets[i];
            if (bucket != null) { //if current bucket isnt empty
                for (int j = 0; j < bucket.size(); j++) { //iterates through its elements
                    Entry<K, V> entry = bucket.get(j); //gets current entry
                    int newIndex = entry.getKey().hashCode() % newBuckets.length; //get new index for entry in new array
                    if (newBuckets[newIndex] == null) { //if bucket at new index is null
                        newBuckets[newIndex] = new DataList<>(); //create new list
                    }
                    newBuckets[newIndex].add(entry);
                }
            }
        }

        buckets = newBuckets; //replace original array with new array
    }

    public boolean containsKey(K key) { //checks if map contains a specific key
        int hash = key.hashCode(); //gets hash code
        int index = hash % buckets.length; //gets index of the bucket

        DataList<Entry<K, V>> bucket = buckets[index]; //get bucket at that index

        if (bucket != null) { //if bucket isnt null
            for (int i = 0; i < bucket.size(); i++) { //iterate through its entries
                Entry<K, V> entry = bucket.get(i); //gets key
                if (entry.getKey().equals(key)) { //checks if key matches with specified key
                    return true; //if so, returns true
                }
            }
        }

        return false; //else returns false
    }

    private class Entry<K, V> { //represents entry in the map
        private K key; //key of entry
        private V value; //associated value with key

        public Entry(K key, V value) { //constructor to create a new entry
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

