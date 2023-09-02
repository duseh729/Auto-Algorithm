def solution(board, moves):
    n=[]
    for i in moves:
        for j in board:
            if j[i-1] == 0:continue
            else:
                n.append(j[i-1])
                j[i-1]=0
                break
    i=0
    answer=0
    while i < len(n)-1:
        if n[i]==n[i+1]:
            del n[i]
            del n[i]
            answer+=2
            i=0
            continue
        i+=1
    return answer