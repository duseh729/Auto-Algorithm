import sys
input = sys.stdin.readline

input()

number_arr = list(map(int, input().split(" ")))

sign = list(map(int, input().split(" ")))

# print(number)
# print(sign)

sign_arr = []

sign_dict = {
    0: "+",
    1: "-",
    2: "*",
    3: "/",
}

for index, s in enumerate(sign):
    # print(s, index)
    s_clone = s
    while s_clone>0:
        sign_arr.append(sign_dict[index])
        s_clone-=1

# print(sign_arr)

max_answer = -1000000000
min_answer = 1000000000

visited = [False] * len(sign_arr)

def dfs(sign_arr, visited, value, count, index):
    global max_answer, min_answer

    if count==len(sign_arr):
        max_answer = int(max(max_answer, value))
        min_answer = int(min(min_answer, value))
        return
    
    for i in range(len(sign_arr)):
        if not visited[i]:
            visited[i] = True
            if sign_arr[i]=='+':
                dfs(sign_arr, visited, value + number_arr[index], count+1, index + 1)
            if sign_arr[i]=='-':
                dfs(sign_arr, visited, value - number_arr[index], count+1, index + 1)
            if sign_arr[i]=='*':
                dfs(sign_arr, visited, value * number_arr[index], count+1, index + 1)
            if sign_arr[i]=='/':
                dfs(sign_arr, visited, int(value / number_arr[index]), count+1, index + 1)
            visited[i] = False

dfs(sign_arr, visited, number_arr[0], 0, 1)

print(max_answer)
print(min_answer)