class LockingTree {

    int[] parents;
    List<List<Integer>> children;
    int[] locked;

    public LockingTree(int[] parent) {
        int n = parent.length;
        this.parents = parent.clone();
        this.children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        } 
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                continue;
            }
            this.children.get(parent[i]).add(i);
        }

        this.locked = new int[n];
        Arrays.fill(this.locked, -1);
    }
    
    public boolean lock(int num, int user) {
        if (locked[num] != -1) {
            return false;
        }
        locked[num] = user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if (locked[num] != user) {
            return false;
        }
        locked[num] = -1;
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if (locked[num] != -1 || hasLockedAncestor(num)) {
            return false;
        }
        if (unlockDescendents(num)) {
            lock(num, user);
            return true;
        }
        return false;
    }

    private boolean hasLockedAncestor(int num) {
        if (parents[num] == -1) {
            return false;
        }
        return locked[parents[num]] != -1 || hasLockedAncestor(parents[num]);
    }

    private boolean unlockDescendents(int num) {
        boolean isLocked = locked[num] != -1;
        for (int child : children.get(num)) {
            isLocked |= unlockDescendents(child);
        }
        if (isLocked) {
            locked[num] = -1;
        }
        return isLocked;
    }

}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
