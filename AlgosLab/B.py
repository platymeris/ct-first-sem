n = int(input())
a_0 = int(input())
k = int(input())
source = []
source.append(a_0)
for i in range(1, n):
    source.append((1103515245 * (source[i - 1]) + 12345) %  (2 ** 31))
print(findOrderStatistic(source, k))
def partition(a, l, r):
    v = a[(l + r) / 2]
    i = l
    j = r
    while (i <= j):
        while (a[i] < v):
           i += 1
        while (a[j] > v):
           j -= 1
        if (i >= j):
            break
        swap(a[i], a[j])
        i += 1
        j -= 1
    return j


def swap (array, x, y):
    temp = array[x]
    array[x] = array[y]
    array[y] = temp
    
def findOrderStatistic(array, k):
    left = 0
    right = len(array)
    while (true):
        mid = partition(array, left, right)
    if (mid == k):
        return array[mid]
    elif (k < mid):
        right = mid
    else:
      left = mid + 1
