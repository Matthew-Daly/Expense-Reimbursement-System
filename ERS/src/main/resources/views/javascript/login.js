window.onload = function () {
    //window.onload allows you to give the window itself a callback function that triggers when the window has
    //  fully loaded

    document
        .getElementById('loginSubmit')
        .addEventListener('click', actualLogin);
}

function login(eve){
    eve.preventDefault(); //this will stop the form from automatically trying to change the page
    actualLogin();
}

let actualLogin =
async function actualLogin(eve){
    eve.preventDefault();
    console.log("User Submit has been clicked!!!");

    let userId = document.getElementById("userName").value;

    let password = document.getElementById("Password1").value;

    let sendLogin = JSON.stringify({
        "userName" : userId,
        "password" : password
    });

    const responsePayload = await fetch('http://localhost:9002/api/user', {
    method:"POST",
    body:sendLogin
    });

    if(responsePayload.url == "http://localhost:9002/manager.html"){
        window.location = "/manager.html";
    } else if (responsePayload.url == "http://localhost:9002/employee.html"){
        window.location = "/employee.html";
    } else {
        window.location = "/index.html";
    }
}
