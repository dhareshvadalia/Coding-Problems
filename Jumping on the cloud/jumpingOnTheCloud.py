#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Jun  2 00:20:43 2020

@author: dharesh
"""

# Complete the jumpingOnClouds function below.
def jumpingOnClouds(c):
    n = len(c) 
    if n >= 2  and n <= 100 and (c[0] and c[n]) == 0:
        j_arr = []
        jump = 0
        while jump < n-2:
            
            if c[jump+1] == 0 and c[jump+2] == 1:
                jump+=1
            elif c[jump+1] == 0 and c[jump+2] == 0:
                jump+=2
            elif c[jump+1] == 1 and c[jump+2] == 0:
                jump+=2
            j_arr.append(jump)
        if jump+1 == n-1 and c[jump+1] == 0:
            j_arr.append(jump+1)
    print(str(j_arr))
    return len(j_arr)
                

if __name__ == '__main__':

    c = [0,0,0,0,1,0,0,0,0]
    #sample array inputs: [0,0,1,0,1,0,0,1,0], [0,0,0,0,0,1,0,1,0], [0,1,0,0,1,0,0,0,0]

    result = jumpingOnClouds(c)
    print(result)

