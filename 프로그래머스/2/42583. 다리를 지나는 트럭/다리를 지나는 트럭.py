import queue

def solution(bridge_length, weight, truck_weights):
    answer = 0
    
    q = queue.Queue()
    
    index = 0
    current_weight = 0
    
    while index<len(truck_weights) or not q.empty():
            answer+=1
            
            if not q.empty() and q.queue[0][1] == answer:
                current_weight -= q.get()[0]
            
            # 다음 트럭이 최대 무게를 초과하지 않을 때
            if index < len(truck_weights) and current_weight+truck_weights[index]<=weight:
                q.put([truck_weights[index] ,answer + bridge_length])
                current_weight+=truck_weights[index]
                index+=1
    
    return answer