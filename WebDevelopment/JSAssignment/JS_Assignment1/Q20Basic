var array1 = ["a", "b", "c", "d"],
    array2 = [1, 2, 3, 4],
    result = [array1, array2]
        .reduce((r, a) => (a.forEach((a, i) => (r[i] = r[i] || []).push(a)), r), [])
        .reduce((a, b) => a.concat(b));
    
console.log(result);