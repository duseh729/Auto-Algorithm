def solution(s):
    answer = True
    n=0
    for i in s:
        if i==')':n-=1
        else:n+=1
        if n<0:return False
    print(n)
    return True if n==0 else False