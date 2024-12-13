const arrayPrincipal = [35, 70, 104, 564,35, 48,356]

 
 function myMap (predicate){
    const novo_Array = []
    for(let i = 0; i < this.length; i++){
        const item = this[i]
        novo_Array.push(predicate(item, i, this))
    }
    return novo_Array
}

Array.prototype.myMap = myMap;
const resultado = arrayPrincipal.myMap((item) => item + 1);
console.log(resultado);



function myFilter(predicate){
    const novo_Array2 = []
    for(let i = 0; i < this.length; i++){
       const item = this[i]
        if(predicate(item, i, this)){
            novo_Array2.push(item)
        }
    }
    return novo_Array2
}

Array.prototype.myFilter = myFilter
const resultado2 = arrayPrincipal.myFilter((item) => item > 70)
console.log(resultado2)

function myReduce (callback, valorInicial) {
    let acumulador = valorInicial
    let i = 0

    if(acumulador === undefined){
        acumulador = this[0]
        i = 1
    }

    while (i < this.length) {
        acumulador = callback(acumulador, this[i], i, this)
        i++
    }
    return acumulador
}

Array.prototype.myReduce = myReduce
const soma = arrayPrincipal.myReduce((acc, val) => acc + val, 0)
console.log(soma)


