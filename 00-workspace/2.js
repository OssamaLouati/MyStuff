/*async function getUsers(){
    let url ='users.json'
    try{
        let res = await fetch(url);

        return await res.json();
    }catch(error){
        console.log(error);
    }
}
async function renderUsers(){
    let users = await getUsers();
    let html='';
    users.forEach(user =>{
        let htmlseg = `<div>
                        <h2>${user.name}</h2>
                        <a href=email:${user.email}>${user.email}</a>

                    </div>`
        html = html+htmlseg;            
    });
    let container = document.querySelector('.container');
    container.innerHTML = html;
}
renderUsers();
*/
// api url
const api_url = 
      "https://api.nasa.gov/planetary/apod?api_key=w1sPY3amYsfNhHuHc2AQIGH2aoJwaQ50eR7H8fqx";
  
// Defining async function
async function getapi(url){
    let response = await fetch(url);
    let data = await response.json();
    console.log(data);
}
// Calling that async function
getapi(api_url);