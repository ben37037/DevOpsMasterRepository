let table = document.getElementById("table");

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

    xhr.open('GET', 'http://localhost:8080/Project1/main/allEmployees');
        xhr.send(); 
}

function renderHTML(data) 
{
    table.append("Ripped-off name: " + data.name);
    table.append(document.createElement("br"));

    table.append("Ripped-off id: " + data.id);
    let image = document.createElement("img");
    image.setAttribute("src", data.sprites.front_shiny);
    table.append(image);
    table.append(document.createElement("hr"));
}