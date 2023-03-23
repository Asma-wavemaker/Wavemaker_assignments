var emp_id;
var emp_password;
var emp_name;


var logsubmit = document.getElementById('fetchdata');
logsubmit.addEventListener('click',function(){
  emp_id=document.getElementById('logid').value;
  emp_password =document.getElementById('loginpass').value;
  console.log(emp_id);
  localStorage.setItem("emp_id",emp_id);
})




//                 -----Fetching employee details table----

const fetchDataBtn = document.querySelector('#fetchdata')
// const result = document.querySelector('#result')

    
    // gets data from API and sets the content of #result div
    const getData = function() {
      fetch('http://localhost:8080/NewLeaveProject/employee/',{
        method: 'GET'
      })

        .then(res => res.json())
        .then(data => {
          console.log(data);
          // result.innerText = JSON.stringify(data, null, 2)



//                                VALIDATE LOGIN FORM DATA
          data.forEach((repo) => {
            Object.entries(repo).forEach(([key, value]) => {
              if((repo["emp_id"] == emp_id)&&(repo["password"]== emp_password))
              {
                window.location.assign("leave.html");
              }
            });
          });



//        fetching employee name
          empdetailsobj=data;
          data.forEach((repo) => {
            Object.entries(repo).forEach(([key, value]) => {
              if(key == "emp_id" && value ==emp_id){
              console.log(JSON.stringify(repo, null, 2));
              emp_name=repo["first_name"];
              console.log(emp_name);
              localStorage.setItem("emp_name",emp_name);
              
              // console.log(`${key}: ${value}`); 
              }
            });

          });


          //        fetching employee details
          data.forEach((repo) => {
            Object.entries(repo).forEach(([key, value]) => {
              if(key == "emp_id" && value ==emp_id){
              // console.log(JSON.stringify(repo, null, 2));
                  
              }
            });

          });


        })
        .catch(error => console.log(error))
    }
    
    fetchDataBtn.addEventListener('click', getData)






//                          ---- POST SIGN UP FORM DATA ---- 


    const form = document.getElementById('form');

    form.addEventListener('submit',function(e){
        e.preventDefault();
        const formData = new FormData(form);
        let formDataObject = Object.fromEntries(formData.entries());
        let formDataJsonString = JSON.stringify(formDataObject);
        console.log(formDataJsonString);

        fetch('http://localhost:8080/NewLeaveProject/employee',{
            method:"POST",
            headers: {
                "Content-Type": "application/json",
                Accept: "application/json",
               
              },
              body: formDataJsonString
           
        })
        .then(res =>{
          if(res.ok){
            swal("Registration Success!");
            home.style.opacity=1;
            userlogform.style.display="none";
            usersignupform.style.display="none";
          }
          else{
            swal("Registration failed!");
          }
          res.json()
      })
        // .then(data => console.log(data))
        .catch(err => console.log(err));
    })

