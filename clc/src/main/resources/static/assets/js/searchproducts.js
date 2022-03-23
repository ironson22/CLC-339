
let searchbtn = document.getElementById("search-btn");
console.log(searchbtn.innerHTML);
function searchForProduct(){
    let searchbar = document.getElementById("query");

    alert("Hi");
    console.log(searchbar.textContent)
}
searchbtn.addEventListener("click", searchForProduct(), true)
