import re
import json

if __name__ == "__main__":
    """Converts sqaure brackets to curly braces"""
    values = json.loads(input().strip())
    formatted = re.sub("\[{1}", "{ ", json.dumps(values))
    formatted = re.sub("\]{1}", " }", formatted)
    print(formatted)
