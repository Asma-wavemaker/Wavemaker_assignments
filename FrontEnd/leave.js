var emp_id = localStorage.getItem("emp_id");
console.log(emp_id);
var username = localStorage.getItem("emp_name");
console.log(username);
document.getElementById('username').innerHTML=username;



    leaveform=document.getElementById('leaveapplyform');
    mainpage=document.getElementById('mainpage');
    leaveform.style.display='none';
    function applyLeave(){
        leaveform.style.display='block';
        mainpage.style.opacity=0.1;
    }

    //                         ----DATE RESTRICT--
    
    var date = new Date();
    var cdate = date.getDate();
    var month = date.getMonth()+1;
    var year = date.getUTCFullYear();
    if(cdate<10){
        cdate = "0"+cdate;
    }
    if(month<10){
        month = "0"+month;
    }
    var mindate = year+"-"+month+"-"+cdate;
    document.getElementById('from_date').setAttribute('min',mindate);
    // document.getElementById('from_date').setAttribute('value',mindate);
    
    document.getElementById('to_date').setAttribute('min',mindate);
    function setToDate(){
        var from = document.getElementById('from_date');
        console.log(from.value);
        document.getElementById('to_date').setAttribute('min',from.value);

    }



//                            ---- GET LEAVES DATA------


    var table = document.getElementById('myleaves');
    var lhist = document.getElementById('lhistory');


    function getLeave() {
        table.innerHTML=""
        document.getElementById("main1").style.display = "none";
        document.getElementById("main2").style.display = "none";
        document.getElementById("main3").style.display="block";
        // document.getElementById("m3").style.backgroundColor= "#4b56cf";
        // document.getElementById("m2a").style.background= "rgb(249, 241, 230)";
        // document.getElementById("m1a").style.background= "rgb(249, 241, 230)";



      fetch('http://localhost:8080/NewLeaveProject/leave/',{
        method: 'GET'
      })

        .then(res => res.json())
        .then(data => {
          console.log(data);



          data.forEach((repo) => {
            Object.entries(repo).forEach(([key, value]) => {
              if((key=="emp_id" & value == emp_id))
              {
                
                  row = `<tr>
                  <td>${repo["leave_id"]}</td>
                  <td>${repo["from_date"]}</td>
                  <td>${repo["to_date"]}</td>
                  </tr>`
                  table.innerHTML += row;
                  
              
                
                
              }

            });
          });
          

            
        })
        .catch(error => console.log(error))
    }


    document.getElementById("main2").style.display = "none";
    document.getElementById("main3").style.display = "none";



    fn = document.getElementById('fn');
    ln = document.getElementById('ln');
    em = document.getElementById('ema');
    des = document.getElementById('des');
    gen = document.getElementById('gen');
    dob = document.getElementById('dob');


    const profile = function() {

        document.getElementById("main1").style.display = "none";
        document.getElementById("main3").style.display = "none";
        document.getElementById("main2").style.display="block";





    fetch('http://localhost:8080/NewLeaveProject/employee/',{
            method: 'GET'
      })

        .then(res => res.json())
        .then(data => {
          console.log(data);


          data.forEach((repo) => {
            Object.entries(repo).forEach(([key, value]) => {
              if((repo["emp_id"] == emp_id))
              {
                
                fn.setAttribute("value",repo["first_name"]);
                ln.setAttribute("value",repo["last_name"]);
                em.setAttribute("value",repo["emp_mail"]);
                des.setAttribute("value",repo["designation"]);
                dob.setAttribute("value",repo["dob"]);
                  if(repo["gender_id"]==21)
                    gen.setAttribute("value","Female")
                    else if(repo["gender_id"]==22)
                      gen.setAttribute("value","Male")
                    else
                      gen.setAttribute("value","Other")
                
              }

            });
          });

        })
        .catch(error => console.log(error));
    }

    document.getElementById('close').addEventListener('click',function(){
      leaveform.style.display='none';
        mainpage.style.opacity=1;
    });

  

    // http://localhost:8080/NewLeaveProject/holiday



  //   for(var i=0; i<data.length; i++){
              
  //     row = `<tr>
  //     <td>${data[i].emp_id}</td>
  //     <td>${data[i].from_date}</td>
  //     <td>${data[i].to_date}</td>
  //     </tr>`
  //     table.innerHTML += row;
      
  // }