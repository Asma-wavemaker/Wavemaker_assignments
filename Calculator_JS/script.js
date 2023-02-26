let string ="";
let buttons = document.querySelectorAll('.button');
let op1="+-*/%"
let op2="**"
let op3="."
function isop(a){
    if(op1.includes(a) || op2.includes(a) || op3.includes(a))
        return 1;
    return 0;
}
function isoper(a){
    if(op1.includes(a) || op2.includes(a))
        return 1
    return 0;
}
function isdeci(a){
    if(op3.includes(a))
        return 1;
    return 0;
}

Array.from(buttons).forEach((button)=>{
    button.addEventListener('click',(e)=>{
    if(e.target.innerHTML == 'CE'){
        string = string.slice(0,-1);
        console.log(string)
        document.querySelector('input').value = string;
        console.log(string)
    }

    else if(e.target.innerHTML == '='){
        string = eval(string);
        document.querySelector('input').value = string;
        string="";
    }
    else if(e.target.innerHTML == 'C'){
        string=""
        document.querySelector('input').value=string;
    }
    else if(e.target.innerHTML =='+' || e.target.innerHTML =='-' || e.target.innerHTML =='*' || e.target.innerHTML =='/' ||e.target.innerHTML =='%' ||e.target.innerHTML =='**' ||e.target.innerHTML =='.'){
        console.log(string)
        lastele=string.slice(-1);
        console.log(lastele)
        if(isop(lastele))
            return "";
        else{
            string+=e.target.innerHTML;
            document.querySelector('input').value = string;
        }
    }
    else{
    console.log(e.target);
    string+=e.target.innerHTML;
    document.querySelector('input').value = string;
    }
})
})