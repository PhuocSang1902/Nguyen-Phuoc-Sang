import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import List from "./List/List";
import Hello from "./JSX/JSX";

const name = "Sang";
const name2 = "Nguyen Phuoc Sang";
const fruits = [
    "Apple",
    "Banana",
    "Orange",
    "Apricot",
    "Black rowan",
    "Cranberry"
];

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    // React.createElement("h1", {style: {textAlign: "center"}}, name),

    <div>
        <List/>
        {/*<Hello/>*/}
    </div>
);

