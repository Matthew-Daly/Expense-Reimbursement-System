var currentReimbs = null;
let currentUser = null;

window.onload = async (e) => {
    e.preventDefault();
    //window.onload allows you to give the window itself a callback function that triggers when the window has
    //  fully loaded
    document
        .getElementById('hello')
    document
        .getElementById('custBtn3')
        .addEventListener('click', actualLogout);

    let response = await fetch('http://localhost:9002/api/user/checksession');
    const user = await response.json();
    currentUser = user;


    let hello = document.getElementById('hello');
    hello.innerText = "Hello " + currentUser.firstName;
    

    document
        .getElementById('custBtn1')
        .addEventListener('click', getReimbsById); 

    
}



let getReimbsById = async function getReimbsById(){
    const result = await fetch("http://localhost:9002/api/reimbursements/emp/" + currentUser.userId);
    let myJson = await result.json();
    fillTable(myJson, "allReimbs");
}


function fillTable(reimbursments, id){
    let text = "";
    let resolvedAlready = null;
    for (let x = 0; x < reimbursments.length; x++) {
       let date = (new Date(reimbursments[x].submitted).toISOString().slice(0,10));
    //    let name =  getFullName(reimbursments[x].author);
       if(reimbursments[x].resolved !== null){
           resolvedAlready = (new Date(reimbursments[x].resolved).toISOString().slice(0,10));
       } else{
           resolvedAlready = "Pennding Review";
       }
        text += "<td id='tableData'>" + "</td>";
        text += "<td id='tableData'>" +  reimbursments[x].reimbId + "</td>";
        text += "<td id='tableData'>$" + reimbursments[x].amount + "</td>";
        text += "<td id='tableData'>" + date + "</td>";
        text += "<td id='tableData'>" + resolvedAlready + "</td>";
        text += "<td id='tableData'>" + reimbursments[x].description + "</td>";
        text += "<td id='tableData'>" + getStatus(reimbursments[x].statusId) + "</td>";
        text += "<td id='tableData'>" + getType(reimbursments[x].typeId) + "</td></tr>";
    }
   document.getElementById(id).innerHTML = text;
}





function show(){
    var x = document.getElementById("reimbursements-table")
    if (x.style.display == "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}


function show2(){
    var x = document.getElementById("new-reimb-form")
    if (x.style.display == "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}


let actualLogout =
async function actualLogout(eve){
    eve.preventDefault();
    console.log("User logout has been clicked!!!");

    window.sessionStorage.getItem('currentUser', null);
    window.location = "/index.html";

}


function getStatus(status){
    switch(status){
        case 1:
            return "Pending";
            break;
        case 2:
            return "Approved";
            break;
        case 3:
            return "Denied";
            break; 
        case 4:
            return "Go Away Michael";
            break;       
    }

}

function getType(type){
    switch(type){
        case 1:
            return "Travel";
            break;
        case 2:
            return "Education/Training";
            break;
        case 3:
            return "Supplies";
            break; 
        case 4:
            return "Food";
            break; 
        case 5:
            return "Medical";
            break;
        case 6:
            return "Party Supplies";
            break;  
        case 7:
            return "Miscellaneous";
            break;                        
    }



    let getReimbsById = async function getReimbsById(){
        const result = await fetch("http://localhost:9002/api/reimbursements/emp/" + currentUser.userId);
        let myJson = await result.json();
        fillTable(myJson, "allReimbs");
    }


    
}