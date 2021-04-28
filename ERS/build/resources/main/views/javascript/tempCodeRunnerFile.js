let getReimbsById = async function getReimbsById(){
    const result = await fetch("http://localhost:9002/api/reimbursements/emp/" + currentUser.userId);
    let myJson = await result.json();
    fillTable(myJson, "allReimbs");
}