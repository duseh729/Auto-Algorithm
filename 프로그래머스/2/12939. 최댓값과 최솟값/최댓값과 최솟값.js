function solution(s) {
    var answer = '';
    const arr = s.split(' ');
    let min = Number(arr[0]);
    let max = Number(arr[0]);
    
    for(let i of arr){
        if(min>Number(i)){
            min = i;
        }
        if(max<Number(i)){
            max = i;
        }
    }
    return min + " " + max;
}