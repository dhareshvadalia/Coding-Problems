#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Jun  2 13:43:01 2020

@author: dharesh
"""
#### Method 1: Using Array List

def action(word_list):
    unique_words = []
    word_count = []
    for i in range(len(word_list)):
        if word_list[i] not in unique_words:
            unique_words.append(word_list[i])
            word_count.append(str(1))
        else:
            index = word_list.index(word_list[i])
            word_count[index] = str(int(word_count[index])+1)
    return word_count

if __name__ == '__main__':
    print('Using Array List Method\n')
    n = int(input('Enter word count: '))
    word_list = []
    for i in range(n):
        word_list.append(str(input(f'Enter word {i}: ')))

    result = action(word_list)
    print(len(result))
    print(' '.join(result))
    
    
    
#### Method 2: Using Collection
from collections import defaultdict

d = defaultdict(lambda:0)
print('Using Collection Method\n')
for i in range(int(input('Enter word count: '))):
    d[input('Enter word {i}: ')]+=1
print(len(d.items()))
x = list(d.values())
x = [str(i) for i in x]
print(' '.join(x))
