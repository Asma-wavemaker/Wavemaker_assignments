  let data={
    Exercising:'done',
    GoingToBank:'pending',
    BreakFast:'done',
    AttendBirthdayParty:'pending'
  };

  var list = document.querySelector('ul');
  Object.keys(data).forEach((item)=>{
    let li = document.createElement("li");
    li.innerHTML = item;
    list.appendChild(li);
    if(item =="Exercising" || item =="BreakFast")
      li.classList.toggle('checked');
  })
  
  var pendingtag = document.querySelector('#pending');
  var donetag = document.querySelector('#done');
  var counter = document.querySelector('#tasks-no');
  var pending = pendingtag.innerHTML;
  var done= donetag.innerHTML;
  var total= counter.innerHTML;

  function newElement(){
    var li = document.createElement("li");
    var inputValue = document.getElementById("task-text").value;
    var t= document.createTextNode(inputValue);
    li.appendChild(t);
    if(inputValue === ""){
      alert("Add some text");}
    else{
       document.getElementById("tasksLi").appendChild(li);
       total++;
       counter.innerHTML = total;
       pendingtag.innerHTML=total-done;
      }
    document.getElementById("task-text").value = "";
  }
    // Add a "checked" symbol when clicking on a list item
    list.addEventListener('click', function(ev) {
      if (ev.target.tagName === 'LI') {
        ev.target.classList.toggle('checked');
        done = document.querySelectorAll('.checked').length;
        console.log(done);
        donetag.innerHTML = done;
        pendingtag.innerHTML = total - done;
      }
    }, false);
