class LRUList {
public:
    LRUList() {
        // 1. Create a dummy node
        this->head = new LRUListNode();
        this->tail = new LRUListNode();
        this->head->next = this->tail;
        this->tail->prev = this->head;
        this->size = 0;
    }

    ~LRUList() {
        LRUListNode *current = head->next;
        while (current != tail) {
            LRUListNode *next = current->next;
            delete current;
            current = next;
        }
        delete head;
        delete tail;
    }

    /* Adds a new entry with the given value. */
    void add(int value) {
        // 1. Remove any existing entry if needed
        remove(value);

        // 2. Add a new entry to the list
        LRUListNode *node = new LRUListNode();
        node->value = value;

        node->prev = tail->prev;
        node->next = tail;
        tail->prev->next = node;
        tail->prev = node;

        // 3. Update data structure
        nodeMap[value] = node;
        size++;
    }

    /* Pops the least recently used value. */
    int pop() {
        // 1. Do nothing if empty
        if (size == 0) {
            return -1;
        }

        // 2. Get the least recently used value
        LRUListNode *target = head->next;
        int value = target->value;

        // 3. Remove the least recently used entry
        target->next->prev = head;
        head->next = target->next;

        // 4. Update data structure
        nodeMap.erase(value);
        size--;

        // 5. Release memory
        delete target;

        // 6. Return the value
        return value;
    }

    /* Removes a entry with the given value. */
    void remove(int value) {
        // 1. Do nothing if the value doesn't exist
        if (!nodeMap.contains(value)) {
            return;
        }

        // 2. Join prev with next
        LRUListNode *target= nodeMap[value];
        target->prev->next = target->next;
        target->next->prev = target->prev;

        // 3. Update data structure
        nodeMap.erase(target->value);
        size--;

        // 4. Release memory
        delete target;
    }

    bool empty() {
        return size == 0;
    }

private:
    struct LRUListNode {
        int value;
        LRUListNode *prev;
        LRUListNode *next;
    };

    unordered_map<int, LRUListNode *> nodeMap;
    LRUListNode *head;
    LRUListNode *tail;
    size_t size;
};

class LFUCache {
public:
    LFUCache(int capacity) {
        this->capacity = capacity;
        this->lfuFrequency = 0;
    }

    ~LFUCache() {
        for (auto const &[_, list] : listMap) {
            delete list;
        }
    }
    
    int get(int key) {
        // 1. Return -1 if key doesn't exist
        if (!valueMap.contains(key)) {
            return -1;
        }

        // 2. Increment frequency
        increment(key);

        // 3. Return the value
        return valueMap[key];
    }
    
    void put(int key, int value) {
        // 1. Evict a key if needed
        if (!valueMap.contains(key) && valueMap.size() == capacity) {
            evict();
        }

        // 2. Update data structure
        valueMap[key] = value;

        // 3. Increment frequency
        increment(key);

        // 4. Update lfuFrequency if needed
        lfuFrequency = min(frequencyMap[key], lfuFrequency);
    }

private:
    /* key = key, value = value */
    unordered_map<int, int> valueMap;
    /* key = key, value = frequency */
    unordered_map<int, int> frequencyMap;
    /* key = frequency, value = LRUList of keys */
    unordered_map<int, LRUList *> listMap;

    size_t capacity;
    int lfuFrequency;

    /* Increments usage frequency for the given key. */
    void increment(int key) {
        // 1. Remove the key from its current LRUList if needed
        int currentFrequency = frequencyMap[key];
        if (currentFrequency != 0) {
            listMap[currentFrequency]->remove(key);
        }

        // 2. Increment frequency
        frequencyMap[key]++;

        // 3. Add a new LRUList entry
        if (!listMap.contains(currentFrequency + 1)) {
            listMap[currentFrequency + 1] = new LRUList();
        }
        listMap[currentFrequency + 1]->add(key);

        // 4. Update lfuFrequency if needed
        bool needUpdate = currentFrequency == 0
            || (currentFrequency == lfuFrequency && listMap[currentFrequency]->empty());
        if (needUpdate) {
            lfuFrequency = currentFrequency + 1;
        }
    }

    /* Removes the least frequently used entry. */
    void evict() {
        // 1. Pop the least frequently used key
        LRUList *list = listMap[lfuFrequency];
        int key = list->pop();

        // 2. Update data structure
        valueMap.erase(key);
        frequencyMap.erase(key);
    }
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
