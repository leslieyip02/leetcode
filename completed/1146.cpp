class SnapshotArray {
private:
    int snap_id;
    vector<int> current;
    unordered_set<int> changed;
    vector<map<int, int>> stored;

public:
    SnapshotArray(int length) {
        snap_id = 0;
        current = vector<int>(length, 0);
        changed = unordered_set<int>();
        stored = vector<map<int, int>>(length, map<int, int>());
        for (int i = 0; i < length; i++) {
            stored[i][-1] = 0;
        }
    }
    
    void set(int index, int val) {
        current[index] = val;
        changed.insert(index);
    }
    
    int snap() {
        int id = snap_id;
        for (int index : changed) {
            stored[index][id] = current[index];
        }
        changed.clear();

        snap_id++;
        return id;
    }
    
    int get(int index, int snap_id) {
        return (--stored[index].upper_bound(snap_id))->second;
    }
};

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray* obj = new SnapshotArray(length);
 * obj->set(index,val);
 * int param_2 = obj->snap();
 * int param_3 = obj->get(index,snap_id);
 */
