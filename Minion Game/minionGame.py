#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Jun  2 23:39:26 2020

@author: dharesh
"""

def minion_game(string):
    # your code goes here
    stu = 0
    kev = 0
    n = len(string)
    
    for i in range(n):
        if string[i] in ('A', 'E', 'I', 'O', 'U'):
            kev += n - i
        else:
            stu += n - i
    
    if kev > stu:
        print('Kevin ',kev)
    else:         
        print('Staurt ',stu)

if __name__ == '__main__':
    s = input().lower()
    if len(s) > 0 and len(s) < 10**5: 
        minion_game(s)