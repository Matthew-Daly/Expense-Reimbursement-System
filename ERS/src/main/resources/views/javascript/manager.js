
window.onload = async (e) => {
    e.preventDefault();
    //window.onload allows you to give the window itself a callback function that triggers when the window has
    //  fully loaded
   document
        .getElementById('hello');
   document
        .getElementById('custBtn3')
        .addEventListener('click', actualLogout);


    document
        .getElementById("custBtn1").addEventListener("click", getAllReimbs)



    document
        .getElementById("custBtn2").addEventListener("click", getAllPendingReimbs)    


    let response = await fetch('http://localhost:9002/api/user/checksession');

    const user = await response.json();
    let currentUser = user;


    let hello = document.getElementById('hello');

    hello.innerText = "Hello " + currentUser.firstName;

}    




//let actualLogout =
async function actualLogout(eve){
    eve.preventDefault();
    console.log("User logout has been clicked!!!");
    
    window.sessionStorage.getItem('currentUser', null);
    window.location = "/index.html";

}    

function show(){
    var x = document.getElementById("reimbursements-table")
    if (x.style.display == "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}


let getAllReimbs = async function getAllReimbs(){
    const result = await fetch("http://localhost:9002/api/reimbursements");
    let myJson = await result.json();
    console.log(myJson);
    fillTable(myJson, "allReimbs");
}


let getAllPendingReimbs = async function getAllPendingReimbs(){
    const result = await fetch(`http://localhost:9002/api/reimbursements/status/1`);
    let myJson = await result.json();
    console.log(myJson);
    fillTablePending(myJson, "allReimbs")
}


let getFullName = async function getFullName(authorId){
    const result = await fetch(`http://localhost:9002/api/user/name/${authorId}`);
    let fullName = await result.json();
    return fullName;

}


async function fillTable(reimbursments, id){
     let text = "";
     let resolvedAlready = null;
     for (let x = 0; x < reimbursments.length; x++) {
        let date = (new Date(reimbursments[x].submitted).toISOString().slice(0,10));
        let name =  await getFullName(reimbursments[x].author);
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
         text += "<td id='tableData'>" + name + "</td>";
         text += "<td id='tableData'>" + getStatus(reimbursments[x].statusId) + "</td>";
         text += "<td id='tableData'>" + getType(reimbursments[x].typeId) + "</td></tr>";
     }
    document.getElementById(id).innerHTML = text;
}

async function fillTablePending(reimbursments, id){
    let text = "";
    let resolvedAlready = null;
    for (let x = 0; x < reimbursments.length; x++) {
       let date = (new Date(reimbursments[x].submitted).toISOString().slice(0,10));
       let name =  await getFullName(reimbursments[x].author);
       if(reimbursments[x].resolved !== null){
           resolvedAlready = (new Date(reimbursments[x].resolved).toISOString().slice(0,10));
       } else{
           resolvedAlready = "Pennding Review";
       }
        text += `<td>
        <div class="btn-group" role="group" aria-label="Approve/Deny" pressed="no" val=${reimbursments[x].reimbId}>
            <button id="approve" type="button" class="btn btn-success approvedButton">Approve</button>
            <button id="deny" type="button" class="btn btn-danger denyButton">Deny</button>
        </div>
        </td>`;
        text += "<td id='tableData'>" + "</td>";
        text += "<td id='tableData'>" +  reimbursments[x].reimbId + "</td>";
        text += "<td id='tableData'>$" + reimbursments[x].amount + "</td>";
        text += "<td id='tableData'>" + date + "</td>";
        text += "<td id='tableData'>" + resolvedAlready + "</td>";
        text += "<td id='tableData'>" + reimbursments[x].description + "</td>";
        text += "<td id='tableData'>" + name + "</td>";
        text += "<td id='tableData'>" + getStatus(reimbursments[x].statusId) + "</td>";
        text += "<td id='tableData'>" + getType(reimbursments[x].typeId) + "</td></tr>";
        
    }
    document.getElementById(id).innerHTML = text;

    document.querySelectorAll(".approvedButton").forEach((button) => {
        button.addEventListener("click", approve);
    });
 

    document.querySelectorAll(".denyButton").forEach((button) => {
        button.addEventListener("click", deny);
    }); 
}


async function approve(e){

    let reimbId = e.target.parentNode.attributes.val.value;
    let selected = e.target.parentNode.attributes.pressed.value;
    console.log(reimbId);

    let response = await fetch(`http://localhost:9002/api/reimbursements/${reimbId}/2`,{
        method:"PATCH",
        'headers':{
            'Content-Type': 'application/json'
        }
    })

    getAllPendingReimbs();
}

function returnObj(obj){
    
}


async function deny(e){

    let reimbId = e.target.parentNode.attributes.val.value;
    let selected = e.target.parentNode.attributes.pressed.value;
    console.log(reimbId);

    let response = await fetch(`http://localhost:9002/api/reimbursements/${reimbId}/3`,{
        method:"PATCH",
        'headers':{
            'Content-Type': 'application/json'
        }
    })

    getAllPendingReimbs();
}

function returnObj(obj){
    
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
}