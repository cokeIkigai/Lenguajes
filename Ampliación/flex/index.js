let contenedor = document.getElementById("contenedor");

let btnJustify = document.getElementById("btn-justify");
let btnAlign = document.getElementById("btn-align");
let btnDirection = document.getElementById("btn-direction");

let justify = ["flexStart", "flexEnd","flexCenter","flexBetween","flexAround","flexEvenly"];
let align = ["stretch","start","end","center","baseline"];
let direction = ["row","rowReverse", "column","columnReverse"];

const crearBotones = (contenedor, opciones, titulo) => {
    let p = document.createElement("p");
    p.textContent = titulo;
    contenedor.appendChild(p);
    
    for (let i = 0; i < opciones.length; i++) {
        let nombreFuncion = opciones[i];
        let btn = document.createElement("button");
        btn.setAttribute("onclick", nombreFuncion + "()"); 
        btn.textContent = nombreFuncion;
        contenedor.appendChild(btn);
    }
    
    // Con MAP
    // opciones.map((nombreFuncion) => {
    //     let btn = document.createElement("button");
    //     btn.setAttribute("onclick", nombreFuncion + "()");
    //     btn.textContent = nombreFuncion;
    //     contenedor.appendChild(btn);
    // })
}

crearBotones(btnJustify, justify, "JUSTIFY-CONTENT");
crearBotones(btnAlign, align, "ALIGN-ITEMS");
crearBotones(btnDirection, direction, "FLEX DIRECTION");


const flexStart = () => contenedor.style.justifyContent ="flex-start";
const flexEnd = () => contenedor.style.justifyContent ="flex-end";
const flexCenter = () => contenedor.style.justifyContent ="center";
const flexBetween = () => contenedor.style.justifyContent ="space-between";
const flexAround = () => contenedor.style.justifyContent ="space-around";
const flexEvenly = () => contenedor.style.justifyContent ="space-evenly";

const stretch = () => contenedor.style.alignItems ="stretch";
const start = () => contenedor.style.alignItems ="flex-start";
const end = () => contenedor.style.alignItems ="flex-end";
const center = () => contenedor.style.alignItems ="center";
const baseline = () => contenedor.style.alignItems ="baseline";

const row = () => contenedor.style.flexDirection ="row";
const rowReverse = () => contenedor.style.flexDirection ="row-reverse";
const column = () => contenedor.style.flexDirection ="column";
const columnReverse = () => contenedor.style.flexDirection ="column-reverse";



