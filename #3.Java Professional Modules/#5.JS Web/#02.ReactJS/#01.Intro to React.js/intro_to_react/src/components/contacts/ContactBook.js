import React from 'react';
import './ContactBook.css';
import Contact from "./Contact";
import ContactDetails from "./ContactDetails";

function App() {
    return (
        <div className="container">
            <header>&#9993; Contact Book</header>
            <div id="book">
                <div id="list">
                    <h1>Contacts</h1>
                    <div className="content">
                       <Contact/>
                       <Contact/>
                       <Contact/>
                    </div>
                </div>
                <div id="details">
                    <h1>Details</h1>
                    <div className="content">
                       <ContactDetails/>
                    </div>
                </div>
            </div>
            <footer>Contact Book SPA &copy; 2017</footer>
        </div>
    );
}

export default App;
