function solution(arr)
{
    return arr.filter((value, idx) => value!=arr[idx+1])
}