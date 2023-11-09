class Solution:
    def removeSubfolders(self, folder):
        parents = set()
        for path in sorted(folder):
            exists = False
            components = path.split("/")
            for i in range(1, len(components)):
                if "/".join(components[:i]) in parents:
                    exists = True
                    break
            if not exists:
                parents.add(path)

        return list(parents)
        

if __name__ == "__main__":
    # folder = [ "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" ]
    folder = [ "/a/b/c", "/a/b/ca", "/a/b/d" ]

    solution = Solution()
    print(solution.removeSubfolders(folder))
