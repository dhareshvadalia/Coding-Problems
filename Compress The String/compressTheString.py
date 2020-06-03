#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jun  3 16:04:29 2020

@author: dharesh
"""
import itertools

if __name__ == '__main__':
    string = list(input())
    
    key_func = lambda x: x[0]
    itr = itertools.groupby(string, key_func)
    grp = []
    
    for key,group in itr:
        grp.append(str((len(list(group)),int(key))))

    print(' '.join(grp))