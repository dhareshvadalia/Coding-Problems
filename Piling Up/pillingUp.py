#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jun  3 02:10:09 2020

@author: dharesh
"""

import collections
import sys

T = int(input())

for i in range(T):
    n = int(input())
    s_len = collections.deque(map(int, input().split()))

    l_Len = sys.maxsize
    ans = 'Yes'

    while len(s_len) > 0:
        if len(s_len) == 1:
            item = s_len.pop()
        else:
            if s_len[0] < s_len[-1]:
                item = s_len.pop()
            else:
                item = s_len.popleft()

        if item > l_Len:
            ans = 'No'
            break
        else:
            l_Len = item

    print(ans)
