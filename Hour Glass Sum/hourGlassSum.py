#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
@author: dharesh vadalia

"""


import numpy as np

# Complete the hourglassSum function below.
def hourglassSum(arr):
    temp = []
    i = 0
    j =0
    while j < arr.shape[1]-2:
      i=0
      while i < arr.shape[0]-2:
        up = arr[j][i] + arr[j][i+1] + arr[j][i+2]
        cn = arr[j+1][i+1]
        dn = arr[j+2][i] + arr[j+2][i+1] + arr[j+2][i+2]
        temp.append(up+cn+dn)
        i+=1
      j+=1
    print('\nSum of all determeined hour glass in 2D array\n',str(temp))
    return max(temp)

if __name__ == '__main__':

    arr = np.array([[1, 1, 1, 0, 0, 0],
           [0, 1, 0, 0, 0, 0],
           [1, 1, 1, 0, 0, 0],
           [0, 0, 2, 4, 4, 0],
           [0, 0, 0, 2, 0, 0],
           [0, 0, 1, 2, 4, 0]])
    print('Input Array\n',str(arr))

    result = hourglassSum(arr)
    print('Max sum value of Hour Glass calculated is: ',result)
