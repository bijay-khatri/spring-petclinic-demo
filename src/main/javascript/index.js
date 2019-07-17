import React from "react";
import ReactDOM from 'react-dom';
import { AddVet } from "./components/AddVet";

//TODO: Ugly, but works with thymeleaf, make it better ??
const addVetDiv = document.querySelector('#add-vet');

if(addVetDiv) {
    ReactDOM.render(<AddVet/>, document.querySelector('#add-vet'));
}
