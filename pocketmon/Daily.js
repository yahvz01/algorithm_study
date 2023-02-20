function solution(nums) {
    let selectableCount = Math.floor(nums.length / 2)
    const container = new Set()
    nums.forEach( data => container.add(data) )
    
    return  selectableCount < container.size ? selectableCount : container.size;
}