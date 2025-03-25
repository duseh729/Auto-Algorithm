function solution(genres, plays) {
    var answer = [];
    
    const n = genres.length;
    // Map 안에 classic, pop 등 받고 그 안에 인덱스 있는지 하면 될듯
    const genresMap = new Map()
    
    for(let i=0; i<n; i++){
        if(!genresMap.has(genres[i])){
            const map = new Map();
            map.set('count', plays[i])
            map.set('value', [[i, plays[i]]])
            genresMap.set(genres[i], map)
        }else{
            const map = genresMap.get(genres[i])
            map.get('value').push([i, plays[i]])
            map.set('count', map.get('count') + plays[i])
        }
    }
    
    const mapToArray = [...genresMap]
    // console.log(mapToArray)
    
    mapToArray.sort((a, b)=> b[1].get('count') - a[1].get('count'))
    
    for(let i of mapToArray){
        // console.log(i[1].get('value'))
        
        i[1].get('value').sort((a, b)=>b[1]-a[1])
        
        // console.log(i[1].get('value'))
        let m = 2;
        
        if(i[1].get('value').length==1) m = 1
            
        for(let j=0; j<m; j++){
            answer.push(i[1].get('value')[j][0])
            // console.log(i[1].get('value')[j][0])
        }
    }
    return answer;
}