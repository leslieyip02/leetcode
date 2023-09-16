import re
import sys
import json

if __name__ == "__main__":
    """Converts sqaure brackets to curly braces"""
    for line in sys.stdin:
        values = json.loads(line)
        formatted = re.sub("\[{1}", "{ ", json.dumps(values))
        formatted = re.sub("\]{1}", " }", formatted)
        print(formatted)
