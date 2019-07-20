let button = document.getElementById("button");
button.addEventListener("click", getThePicture);

let input = document.getElementById("reimbursementReceiptId");

function getThePicture()
{
    let xhrReqeust = new XMLHttpRequest();

    xhrReqeust.onreadystatechange = function()
    {
        if(this.readyState == 4 & this.status == 200)
        {
            let dataVariable = JSON.parse(xhr.responseText);
            console.log(dataVariable);
            console.log(dataVariable.name);

            renderHTML(dataVariable);
        }
    };
    
    alert(input.innerHTML);
    xhrReqeust.open('GET', input.innerHTML);

    xhrReqeust.send();
}

function renderHTML(dataIn)
{
    let image = document.createElement("img");
    image.setAttribute("src", dataIn.name);
    input.append(image);
    input.append(document.createElement("br"));
    input.append("Ripped off Name: " + dataIn.name);
    input.append(document.createElement("br"));
    input.append("Ripped off id: " + dataIn.id);
    input.append(document.createElement("br"));
    input.append(document.createElement("hr"));
}