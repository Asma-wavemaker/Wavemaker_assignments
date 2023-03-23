var emp_id = localStorage.getItem("emp_id");
console.log(emp_id);
var username = localStorage.getItem("emp_name");
console.log(username);
document.getElementById('username').innerHTML=username;
var emp_details={}

useridautoset = document.getElementById('emp_id');
useridautoset.setAttribute("value",emp_id);





    leaveform=document.getElementById('leaveapplyform');
    mainpage=document.getElementById('mainpage');
    fullpage=document.getElementById('page');
    leaveform.style.display='none';
    function applyLeave(){
        leaveform.style.display='block';
        fullpage.style.opacity=0.1;
        // fullpage.style.filter = "brightness(50%)";
        // body.style.filter = "contrast(50%)";
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

    const monthNames = ["January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"];
    const leavetype=["","Compensatory","Loss of Pay","Personal Time off"];


    var table = document.getElementById('myleaves');
    var lhist = document.getElementById('lhistory');

    function getLeave() {
        table.innerHTML=""
        document.getElementById("main1").style.display = "none";
        document.getElementById("main2").style.display = "none";
        document.getElementById("main3").style.display="block";



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
                const date1 = new Date(repo["from_date"]);
                var fromdate =   monthNames[date1.getMonth()]  +" "+ date1.getDate() +" , " + date1.getFullYear();
                const date2 = new Date(repo["to_date"]);
                var todate =  monthNames[date2.getMonth()]  +" "+ date2.getDate() +" , " + date2.getFullYear();

                var leavetypeval = leavetype[repo["leave_type_id"]]
                  row = `<tr>
                  <td>${leavetypeval}</td>
                  <td>${fromdate}</td>
                  <td>${todate}</td>
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

    function selectElement(id, valueToSelect) {  
      let element = document.getElementById(id);
      element.value = valueToSelect;
    }

    const enableEdit = function(){

      fn.removeAttribute("readonly");
      ln.removeAttribute("readonly");
      em.removeAttribute("readonly");
      des.removeAttribute("readonly");
      gen.removeAttribute("readonly");
      dob.removeAttribute("readonly");
    }


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
            
              if((repo["emp_id"] == emp_id))
              {
                const date = new Date(repo["dob"]);
                var dobMonth;
                if(date.getMonth()<10)
                  dobMonth=0+""+(date.getMonth()+1)
                var d =  date.getFullYear()+"-"+ dobMonth +"-"+ date.getDate() ;
                
                fn.setAttribute("value",repo["first_name"]);
                ln.setAttribute("value",repo["last_name"]);
                em.setAttribute("value",repo["emp_mail"]);
                des.setAttribute("value",repo["designation"]);
                dob.setAttribute("value",d);
                selectElement('gen',repo["gender_id"])
                

              }

              

          });

        })
        .catch(error => console.log(error));
    }

    document.getElementById('close').addEventListener('click',function(){
      leaveform.style.display='none';
        fullpage.style.opacity=1;
    });

  

    //                   --------GET HOLIDAYS LIST--------

    hollist = document.getElementById('holidayslist');
    function getHolidays(){
      fetch('http://localhost:8080/NewLeaveProject/holiday/',{
        method: 'GET'
      })

        .then(res => res.json())
        .then(data => {
          // console.log(data);

          data.forEach((repo) => {
                // var holdate =repo["holiday_date"];
                
                var holday = repo["holiday_day"];
                var festname = repo["holiday"];
                console.log(holdate,holday,festname)
                // console.log(repo);
                const date = new Date(repo["holiday_date"]);
                var holdate =   monthNames[date.getMonth()]  +" "+ date.getDate() +" , " + date.getFullYear();
                // const date2 = new Date(repo["to_date"]);
                // var todate =  monthNames[date2.getMonth()]  +" "+ date2.getDate() +" , " + date2.getFullYear();

                // var leavetypeval = leavetype[repo["leave_type_id"]]
                  row = `<tr>
                  <td>${festname}</td>
                  <td>${holdate}</td>
                  <td>${holday}</td>
                  </tr>`
                  hollist.innerHTML += row;
                
              
          });
          
        })
        .catch(error => console.log(error))

    }
    getHolidays();







    //            -------- Update password

    const checkCurrentPassword = function() {
      cp=document.getElementById('cp').value;
      np=document.getElementById('np').value;
      fetch('http://localhost:8080/NewLeaveProject/employee/',{
            method: 'GET'
      })
        .then(res => res.json())
        .then(data => {
          console.log(data);
          emp_details=data;
          data.forEach((repo) => {
            if(repo["emp_id"] == emp_id  && repo["password"] == cp)
            updatePassword(repo);
          })
        })
  }


const updatePassword = function(empjson){
  console.log(empjson);

  updateEmployeeRow = {
    "dept_id" : empjson["dept_id"],
    "designation" : empjson["designation"],
    "dob":empjson["dob"],
    "emp_id":empjson["emp_id"],
    "emp_mail":empjson["emp_mail"],
    "first_name":empjson["first_name"],
    "gender_id":empjson["gender_id"],
    "joining_date":empjson["joining_date"],
    "last_name":empjson["last_name"],
    "password":np
  }
  console.log(updateEmployeeRow);


  fetch('http://localhost:8080/NewLeaveProject/employee/update',{
    method:"PUT",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json" 
        },
        body: JSON.stringify(updateEmployeeRow)
      })
      .then(res =>{
          if(res.ok){
              alert("success");
          }
          else
              alert("failed");
          res.json()
      })
      .catch(err => console.log(err));
}
    

//                -------------update user details------------------



const getUserDetailsToEdit = function() {
  fetch('http://localhost:8080/NewLeaveProject/employee/',{
        method: 'GET'
  })
    .then(res => res.json())
    .then(data => {
      console.log(data);
      emp_details=data;
      data.forEach((repo) => {
        if(repo["emp_id"] == emp_id )
        updateEmployeeDetails(repo);
      })
    })
}


const updateEmployeeDetails = function(empjson){
  console.log(fn.value);
  console.log(ln.value);
  var designation = des.value;
  var dobirth = dob.value;
  var email= em.value;
  var lname = ln.value;
  var fname = document.getElementById('fn').value;
  console.log(fname)
  var gender = gen.value;

  updateEmpDetails= {
    "dept_id" : empjson["dept_id"],
    "designation" : designation,
    "dob":dobirth,
    "emp_id":emp_id,
    "emp_mail":email,
    "first_name":fname,
    "gender_id":gender,
    "joining_date":empjson["joining_date"],
    "last_name":lname,
    "password":empjson["password"]
  }
  // console.log(Json.stringify(updateEmployeeDetails));


  fetch('http://localhost:8080/NewLeaveProject/employee/update',{
    method:"PUT",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json" 
        },
        body: JSON.stringify(updateEmpDetails)
      })
      .then(res =>{
          if(res.ok){
              alert("success");
          }
          else
              alert("failed");
          res.json()
      })
      .catch(err => console.log(err));
}




//                      -----POST Leave apply data-----

const leave = document.getElementById('leave');

leave.addEventListener('submit',function(e){
    e.preventDefault();
    const formData = new FormData(leave);
    let formDataObject = Object.fromEntries(formData.entries());
    let formDataJsonString = JSON.stringify(formDataObject);
    console.log(formDataJsonString);

    fetch('http://localhost:8080/NewLeaveProject/leave',{
        method:"POST",
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json"
        
        },
        body: formDataJsonString

    
    })
    .then(res =>{
        if(res.ok){
            
          swal({
            title: "Leave applied",
            icon: "success",
            button: "ok",
          });
            leaveform.style.display='none';
            fullpage.style.opacity=1;
            
        }
        else
            alert("failed");
        res.json()
    })
    .then(data => console.log(data))
    .catch(err => console.log(err));
})



// if(repo["gender_id"]==21)
                // gen.setAttribute("value","Female")
                // else if(repo["gender_id"]==22)
                //   gen.setAttribute("value","Male")
                // else
                //   gen.setAttribute("value","Other")