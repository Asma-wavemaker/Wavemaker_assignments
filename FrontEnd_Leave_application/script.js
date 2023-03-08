
const fetchDataBtn = document.querySelector('#fetchdata')
const result = document.querySelector('#result')
    
    // gets data from API and sets the content of #result div
    const getData = function() {
      result.innerText = 'Loading....'
      fetch('http://localhost:8080/NewLeaveProject/employee/',{
        method: 'GET'
      })

        .then(res => res.json())
        .then(data => {
            console.log(data);
          result.innerText = JSON.stringify(data, null, 2)
        })
        .catch(error => console.log(error))
    }
    
    // add event listener for #fetchdata button
    fetchDataBtn.addEventListener('click', getData)




    
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
        .then(res => res.json())
        .then(data => console.log(data))
        .catch(err => console.log(err));
    })



    // const form = document.getElementById('form');
    // form.addEventListener('submit',function(e){
    //     e.preventDefault();

    //     const prePayload = new FormData(form);
    //     const payload = new URLSearchParams(prePayload);

    //     console.log([...payload]);

    //     fetch('http://localhost:8080/NewLeaveProject/employee',{
    //         method:"POST",
    //         body:payload,
    //     })
    
    // .then(res => res.json())
    // .then(data => console.log(data))
    // .catch(err => console.log(err));
    // })


    // function customdate(){
//     var date_picker = document.getElementById("joining_date").value;
//     console.log(date_picker);
//     alert('Date:'+date_picker+"formatted: "+ changeformat(date_picker));
    
// }
// function changeformat(val){
//     const myArray = val.split("-");

//     let year = myArray[0];
//     let month = myArray[1];
//     let day = myArray[2];

//     let formatted = year+"-"+month+"-"+day;
//     console.log(formatted);
//     return formatted;
// }