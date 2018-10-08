function addItem() {
    let dropDown = document.getElementById("menu");
    let text= document.getElementById("newItemText").value;
    let value= document.getElementById("newItemValue").value;

    let newOption = document.createElement("option");
    newOption.text=text;
    newOption.value=value;
    dropDown.appendChild(newOption);

    document.getElementById("newItemText").value="";
    document.getElementById("newItemValue").value="";
}