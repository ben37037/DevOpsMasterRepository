let table = document.getElementById("reimbList");
table.addEventListener("click", showMyReimbursements);

function showMyReimbursements()
{

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () 
	{
        if (this.readyState == 4 && this.status == 200) 
		{
            let data = JSON.parse(xhr.responseText);
            console.log(data);
            console.log(data.name);

            renderHTML(data);
        }
    }

    xhr.open('GET', 'http://localhost:8080/Project1/main/seeMyReimbursements');
        xhr.send(); 
}

function renderHTML(dataIn) 
{
	table.append("User id: " + dataIn.ersUserId);
	table.append(document.createElement("br"));
    table.append("Username: " + dataIn.ersUserName);
    table.append(document.createElement("br"));
    table.append(document.createElement("hr"));
}