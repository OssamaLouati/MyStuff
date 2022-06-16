
let foo =true;
var bar ;
var i;
if(foo){
    bar = foo * 2;
    console.log(bar);
}

for(i=0; i<10; i++){
    console.log(i)
}
console.log(bar);
console.log(i);
//L'erreur s'affiche sur i et bar, ils ne sont pas déclarés globalement; ils sont déclarés localement au niveau du if et for, on doit les declare globalement sur le fichier script



/*-----------------------------------------------------------Question 11 ---------------------------------*/



console.log(1)
//console.log("Function is fired now")
console.log(1)
setTimeout(() => {console.log("Callback function is fired now")}, 1000);
console.log(2)
console.log(3)
console.log(4)

//La difference que l'instruction console.log() ne s'éxecutera qu'après le compteur se terminera, dans notre ici c'est 1000 millisecondes




/*----------------------------------------------------------Question 12-------------------------------------*/

function* rangeIterator(start = 0, end = 100, step = 2) {
    for (let i = start; i < end; i += step) {
    yield i;
    }
   }
   var sequence = rangeIterator();
   console.log(sequence.next().value);
   console.log(sequence.next().value);
   console.log(sequence.next().value);
   console.log(sequence.next().value);
   console.log(sequence.next().value);
   console.log(sequence.next().value);
