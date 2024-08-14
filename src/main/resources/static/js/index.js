const btnSingIn=document.getElementById("sing-in");
const btnSingUp=document.getElementById("sing-up");
const formRegistro=document.querySelector(".register");
const formLogin=document.querySelector(".login")

btnSingIn.addEventListener("click",()=>{
    formLogin.classList.add("hide");
    formRegistro.classList.remove("hide");
})

btnSingUp.addEventListener("click", () =>{
    formRegistro.classList.add("hide");
    formLogin.classList.remove("hide");
})
