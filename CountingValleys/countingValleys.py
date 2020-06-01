# -*- coding: utf-8 -*-
"""

@author Dharesh Vadalia

"""

def countingValleys(n, s):
    vc = 0
    sl = 0
    flag = False
    for i in range(n):
        if sl == 0:
            flag = True
        if s[i] == 'U':
            sl+=1
        if s[i] == 'D':
            sl-=1
        if sl < 0 and flag:
            vc+=1
        flag = False
    return vc

if __name__ == '__main__':

    s = input('Enter string of steps pattern: \n')
    
    n = len(s)

    result = countingValleys(n, s)
    
    print(result)

