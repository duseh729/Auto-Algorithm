function solution(a, b, c, d) {
    var answer = 0;
//  모두 같은 경우
    if (a==b&&b==c&&c==d){
        return a*1111
//  모두 다른 경우
    }else if (a!=b&&b!=c&&c!=d&&a!=c&&a!=d&&b!=d){
        return Math.min(a,b,c,d)
//  3개만 같은 경우
    }else if ((a==b&&b==c)||(b==c&&c==d)){
        return b!=a ? (10*b+a)**2 : (10*a+d)**2
    }else if ((a==c&&c==d)||(a==b&&b==d)){
        return b!=a ? (10*a+b)**2 : (10*a+c)**2
//  2개씩 같은 경우
    }else if ((a==b&&c==d)||(a==c&&b==d)||(a==d&&b==c)){
        return a==b ? (a+c)*Math.abs(a-c) : a==c ? (a+b)*Math.abs(a-b) : (a+b)*Math.abs(a-b)
    }else{
        console.log('여기')
        return a==b ? c*d : a==c ? b*d : a==d ? b*c : b==d ? a*c : b==c ? a*d : a*b 
    }
    return answer;
}